package med.voll.apiMed.domain.endereco;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.apiMed.domain.request.EnderecoRequest;

import java.util.Objects;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {
    @NotBlank
    @Column(length = 100)
    private String logradouro;
    @NotBlank
    @Column(length = 100)
    private String bairro;
    @NotBlank
    @Column(length = 9)
    private String cep;
    @NotBlank
    @Column(length = 100)
    private String cidade;
    @NotBlank
    @Column(length = 2)
    private String uf;
    @NotBlank
    @Column(length = 20)
    private String numero;
    @NotBlank
    @Column(length = 100)
    private String complemento;

    public Endereco(EnderecoRequest endereco) {
        this.logradouro = endereco.logradouro();
        this.bairro = endereco.bairro();
        this.cep = endereco.cep();
        this.cidade = endereco.cidade();
        this.uf = endereco.uf();
        this.numero = endereco.numero();
        this.complemento = endereco.complemento();
    }

    public void updateInfo(EnderecoRequest request) {
        if(Objects.nonNull(request.logradouro())){
            this.logradouro = request.logradouro();
        }
        if(Objects.nonNull(request.logradouro())){
            this.bairro = request.bairro();
        }
        if(Objects.nonNull(request.logradouro())){
            this.cep = request.cep();
        }
        if(Objects.nonNull(request.logradouro())){
            this.uf = request.uf();
        }
        if(Objects.nonNull(request.logradouro())){
            this.numero = request.numero();
        }
        if(Objects.nonNull(request.logradouro())){
            this.complemento = request.complemento();
        }
    }
}
