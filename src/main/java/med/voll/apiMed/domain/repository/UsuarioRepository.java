package med.voll.apiMed.domain.repository;

import med.voll.apiMed.domain.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
    Usuario findByLogin(String login);
}
