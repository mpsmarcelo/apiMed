package med.voll.apiMed.domain.paciente;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import med.voll.apiMed.domain.endereco.Endereco;
import med.voll.apiMed.domain.request.PacienteResquest;
import med.voll.apiMed.domain.request.PacienteUpdateResquest;
import org.hibernate.validator.constraints.br.CPF;

import java.util.Objects;

@Entity
@Table(name = "paciente")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(length = 100)
    private String nome;
    @NotBlank
    @Column(length = 100)
    @Email
    private String email;
    @NotBlank
    @CPF
    @Column(length = 20)
    private String cpf;
    @NotBlank
    @Column(length = 20)
    private String telefone;

    @NonNull
    @Embedded
    Endereco endereco;
    @NonNull
    Boolean ativo;

    public Paciente(PacienteResquest resquest) {
        this.nome = resquest.nome();
        this.email = resquest.email();
        this.cpf = resquest.cpf();
        this.telefone = resquest.telefone();
        this.endereco = resquest.endereco();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void delete() {
        this.ativo = false;
    }

    public void updateInfo(PacienteUpdateResquest resquest) {

        if(Objects.nonNull(resquest.nome())){
            this.nome = resquest.nome();
        }
        if(Objects.nonNull(resquest.email())){
            this.email = resquest.email();
        }
        if(Objects.nonNull(resquest.endereco())){
            this.endereco.updateInfo(resquest.endereco());
        }

    }
}
