package med.voll.apiMp.domain.medico;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import med.voll.apiMp.domain.endereco.Endereco;
import med.voll.apiMp.enuns.Especialidade;
import med.voll.apiMp.domain.request.MedicoRequest;
import med.voll.apiMp.domain.request.MedicoUpdateRequest;

import java.util.Objects;

@Entity
@Table(name = "medico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @NotBlank
   @Column(length = 100)
   private String nome;
   @NotBlank
   @Column(length = 100)
   private String email;

   @NotBlank
   @Column(length = 20)
   private String telefone;
   @NotBlank
   @Column(length = 6)
   private String crm;
   @NonNull
   @Column(length = 100)
   @Enumerated(EnumType.STRING)
   private Especialidade especialidade;
   @NonNull
   @Embedded
   private Endereco endereco;

   @NonNull
   private Boolean ativo;

   public Medico(MedicoRequest request) {
      this.nome = request.nome();
      this.email = request.email();
      this.telefone = request.telefone();
      this.crm = request.crm();
      this.especialidade = request.especialidade();
      this.endereco = new Endereco(request.endereco());
      this.ativo = true;
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

   public String getTelefone() {
      return telefone;
   }

   public String getCrm() {
      return crm;
   }

   public Especialidade getEspecialidade() {
      return especialidade;
   }

   public Endereco getEndereco() {
      return endereco;
   }

   public Boolean getAtivo() {
      return ativo;
   }

   public void updateInfo(MedicoUpdateRequest request) {
       if(Objects.nonNull(request.nome())){
          this.nome = request.nome();
       }
       if(Objects.nonNull(request.telefone())){
          this.telefone = request.telefone();
       }
       if(Objects.nonNull(request.endereco())){
          endereco.updateInfo(request.endereco());
       }

    }

   public void delete() {
      this.ativo = false;
   }
}
