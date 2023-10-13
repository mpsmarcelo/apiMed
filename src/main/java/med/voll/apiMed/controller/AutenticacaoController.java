package med.voll.apiMed.controller;

import med.voll.apiMed.domain.request.AutenticacaoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {


    @Autowired
    AuthenticationManager authenticationManager;
    @PostMapping
    public ResponseEntity<Object> autenticar(@RequestBody AutenticacaoRequest auth){
        var token = new  UsernamePasswordAuthenticationToken(auth.login(),auth.senha());
        var authentication = authenticationManager.authenticate(token);
        return ResponseEntity.ok().build();
    }

}
