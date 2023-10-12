package med.voll.apiMp.controller;

import jakarta.validation.Valid;
import med.voll.apiMp.domain.paciente.Paciente;
import med.voll.apiMp.domain.request.PacienteResquest;
import med.voll.apiMp.domain.request.PacienteUpdateResquest;
import med.voll.apiMp.domain.response.PacienteResponse;
import med.voll.apiMp.domain.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping(value = "pacientes")
public class PacienteController {

    @Autowired
    PacienteService pacienteService;

    @PostMapping
    ResponseEntity<Paciente> create(@RequestBody @Valid PacienteResquest resquest, UriComponentsBuilder uriBuilder){
        var paciente = pacienteService.create(resquest);
        var uri = uriBuilder.path("/pacientes/{id}").buildAndExpand(paciente.getId());
        return  ResponseEntity.created(uri.toUri()).body(paciente);
    }

    @GetMapping
    ResponseEntity<Page<PacienteResponse>> findAll(Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(pacienteService.findAll(pageable));
    }

    @PutMapping
    @Transactional
    public  ResponseEntity<PacienteResponse> update(@RequestBody PacienteUpdateResquest resquest){
        return ResponseEntity.ok().body(pacienteService.update(resquest));

    }

    @DeleteMapping(value = "/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable("id") Long id){
        pacienteService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/{id}")
    @Transactional
    public ResponseEntity<PacienteResponse> findById(@PathVariable("id") Long id){
        return ResponseEntity.ok().body(pacienteService.findById(id));
    }
}
