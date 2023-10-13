package med.voll.apiMed.domain.service;


import med.voll.apiMed.domain.repository.UsuarioRepository;
import med.voll.apiMed.domain.request.UsuarioRequest;
import med.voll.apiMed.domain.usuario.Usuario;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    UsuarioRepository repository;
    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public void create(UsuarioRequest request) {
        repository.save(new Usuario(request));
    }

    public Usuario findByUserLogin(String username) {
        return repository.findByLogin(username);
    }
}
