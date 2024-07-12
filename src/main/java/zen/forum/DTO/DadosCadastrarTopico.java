package zen.forum.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastrarTopico(
		@NotBlank
		String titulo,
		@NotBlank
		String mensagem,
		@NotBlank
		String autor,
		@NotBlank
		String curso) {

}
