package med.voll.apiMp.domain.service;

import lombok.NonNull;
import med.voll.apiMp.domain.paciente.Paciente;
import med.voll.apiMp.domain.repository.PacienteRepository;
import med.voll.apiMp.domain.request.PacienteResquest;
import med.voll.apiMp.domain.request.PacienteUpdateResquest;
import med.voll.apiMp.domain.response.PacienteResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PacienteService {

    @Autowired
    PacienteRepository repository;

    public PacienteService(PacienteRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Paciente create(PacienteResquest resquest) {
        return repository.save(new Paciente(resquest));
    }

    public Page<PacienteResponse> findAll(Pageable pageable) {
        return repository.findAll(pageable).map(PacienteResponse::new);
    }

    public void delete(Long id) {
        var paciente = repository.getReferenceById(id);
        paciente.delete();
    }

    public PacienteResponse update(PacienteUpdateResquest resquest) {
        var paciente = repository.getReferenceById(resquest.id());
        paciente.updateInfo(resquest);
        return new PacienteResponse(paciente);
    }

    @NonNull
    public PacienteResponse findById(Long id) {
      return new PacienteResponse(repository.findById(id).get());
    }
}
