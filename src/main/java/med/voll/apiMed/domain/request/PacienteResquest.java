package med.voll.apiMed.domain.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.NonNull;
import med.voll.apiMed.domain.endereco.Endereco;

public record PacienteResquest(

        @NotBlank(message = "Nome é obrigatório!")
        String nome,
        @NotBlank(message = "Email é obrigatório!")
        String email,
        @NotBlank(message = "CPF é obrigatório!")
        @Pattern(regexp = "\\d{3}\\.?\\d{3}\\.?\\d{3}\\-?\\d{2}")
        String cpf,
        @NotBlank(message = "Telefone é obrigatório!")
        String telefone,
        @NotNull(message = "Endereço é obrigatório!")
        @Valid Endereco endereco

) {
}
