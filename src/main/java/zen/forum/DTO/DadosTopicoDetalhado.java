package zen.forum.DTO;

import java.time.LocalDate;

import zen.forum.models.EstadoTopico;

public record DadosTopicoDetalhado(
		String titulo,
		String mensagem,
		LocalDate data_criacao,
		EstadoTopico status_topico,
		String autor,
		String curso) {

}
