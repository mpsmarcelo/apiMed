package med.voll.apiMed.domain.response;

import med.voll.apiMed.domain.endereco.Endereco;
import med.voll.apiMed.domain.paciente.Paciente;

public record PacienteResponse(
        Long id,
        String nome,
        String email,
        String cpf,
        String telefone,
        Endereco endereco,
        Boolean ativo
) {
    public PacienteResponse(Paciente paciente) {
       this(paciente.getId(),
               paciente.getNome(),
               paciente.getEmail(),
               paciente.getCpf(),
               paciente.getTelefone(),
               paciente.getEndereco(),
               paciente.getAtivo());
    }
}
