package med.voll.apiMp.domain.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.NonNull;

public record PacienteUpdateResquest(

        @NonNull
        Long id,
        @NotBlank
        String nome,
        @NotBlank
        String email,
        @NotBlank
        @Pattern(regexp = "\\d{3}\\.?\\d{3}\\.?\\d{3}\\-?\\d{2}")
        String cpf,
        @NotBlank
        String telefone,
        @NonNull
        @Valid EnderecoRequest endereco

) {
}
