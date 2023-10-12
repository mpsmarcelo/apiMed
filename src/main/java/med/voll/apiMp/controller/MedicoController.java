package med.voll.apiMp.controller;

import jakarta.validation.Valid;
import med.voll.apiMp.domain.medico.Medico;
import med.voll.apiMp.domain.request.MedicoRequest;
import med.voll.apiMp.domain.request.MedicoUpdateRequest;
import med.voll.apiMp.domain.response.MedicoResponse;
import med.voll.apiMp.domain.service.MedicoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping(value = "medicos")
public class MedicoController {

    MedicoService medicoService;
    public MedicoController(MedicoService medicoService) {
        this.medicoService = medicoService;
    }

    @PostMapping
    public ResponseEntity<Medico> create(@RequestBody @Valid MedicoRequest request, UriComponentsBuilder uriBuilder){
        var medico = medicoService.create(request);
        var uri = uriBuilder.path("/medicos/{id}").buildAndExpand(medico.getId());
        return ResponseEntity.created(uri.toUri()).body(medico);
    }

    @GetMapping
    public ResponseEntity<Page<MedicoResponse>> findAll(@PageableDefault(size = 10, sort = {"nome"}) Pageable page){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(medicoService.findAll(page));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<MedicoResponse> findById(@PathVariable("id") Long id){
        return ResponseEntity.ok().body(medicoService.findById(id));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<MedicoResponse> update(@RequestBody MedicoUpdateRequest request){
         return ResponseEntity.status(HttpStatus.OK).body(medicoService.update(request));
    }

    @DeleteMapping(value = "/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable("id") Long id){
        medicoService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
