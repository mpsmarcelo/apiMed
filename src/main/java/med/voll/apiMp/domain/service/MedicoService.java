package med.voll.apiMp.domain.service;

import med.voll.apiMp.domain.medico.Medico;
import med.voll.apiMp.domain.repository.MedicoRepository;
import med.voll.apiMp.domain.request.MedicoRequest;
import med.voll.apiMp.domain.request.MedicoUpdateRequest;
import med.voll.apiMp.domain.response.MedicoResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MedicoService {
    MedicoRepository repository;
    public MedicoService(MedicoRepository repository) {
        this.repository = repository;
    }
    @Transactional
    public Medico create(MedicoRequest request){
        return repository.save(new Medico(request));
    }
    public Page<MedicoResponse> findAll(Pageable page) {
        return repository.findAll(page).map(MedicoResponse::new);
    }
    public MedicoResponse update(MedicoUpdateRequest request) {
        var medico = repository.getReferenceById(request.id());
        medico.updateInfo(request);
        return new MedicoResponse(medico);
    }
    public void delete(Long id) {
        var medico = repository.getReferenceById(id);
        medico.delete();
    }

    public MedicoResponse findById(Long id) {
        return new MedicoResponse(repository.findById(id).get());
    }
}
