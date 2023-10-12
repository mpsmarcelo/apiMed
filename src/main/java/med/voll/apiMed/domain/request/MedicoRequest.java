package med.voll.apiMed.domain.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.apiMed.enuns.Especialidade;

public record MedicoRequest(
        @NotBlank(message = "Nome é obrigatório!")
        String nome,
        @NotBlank(message = "Email é obrigatório!")
        @Email
        String email,
        @NotBlank(message = "Telefone é obrigatório!")
        String telefone,
        @NotBlank(message = "CRM é obrigatório!")
        @Pattern(regexp = "\\d{4,6}")
        String crm,
        @NotNull(message = "Especialidade é obrigatório!")
        Especialidade especialidade,
        @NotNull(message = "Endereço é obrigatório!")
        @Valid
        EnderecoRequest endereco

) {
}
