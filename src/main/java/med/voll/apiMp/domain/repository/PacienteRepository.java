package med.voll.apiMp.domain.repository;

import med.voll.apiMp.domain.paciente.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface PacienteRepository extends JpaRepository<Paciente,Long> {
}
