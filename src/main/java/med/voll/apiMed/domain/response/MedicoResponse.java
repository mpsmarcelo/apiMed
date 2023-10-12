package med.voll.apiMed.domain.response;

import med.voll.apiMed.domain.endereco.Endereco;
import med.voll.apiMed.domain.medico.Medico;
import med.voll.apiMed.enuns.Especialidade;

public record MedicoResponse(
         Long id,
         String nome,
         String email,
         String crm,
         String telefone,
         Endereco endereco,
         Especialidade especialidade
) {
    public MedicoResponse(Medico medico) {
      this(   medico.getId(),
              medico.getNome(),
              medico.getEmail(),
              medico.getCrm(),
              medico.getTelefone(),
              medico.getEndereco(),
              medico.getEspecialidade()
      );
    }
}
