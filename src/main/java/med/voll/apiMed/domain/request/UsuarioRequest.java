package med.voll.apiMed.domain.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record UsuarioRequest(

        @NotBlank(message = "Login é obrigatório!")
        String login,

        @NotBlank(message = "Senha é obrigatória")
        @Pattern(regexp = "\\d{4,8}", message = "Senha deve conter entre 4 e 8 caracteres!")
        String senha
) {
}
