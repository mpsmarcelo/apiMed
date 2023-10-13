package med.voll.apiMed.controller;


import jakarta.validation.Valid;
import med.voll.apiMed.domain.request.UsuarioRequest;
import med.voll.apiMed.domain.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

    @Autowired
    UsuarioService service;
    @PostMapping
    public void create(@RequestBody @Valid UsuarioRequest request){
        service.create(request);

    }
}
