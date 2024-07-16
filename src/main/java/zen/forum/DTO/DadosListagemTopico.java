package zen.forum.DTO;

import java.time.LocalDate;

import zen.forum.models.EstadoTopico;
import zen.forum.models.Topico;

public record DadosListagemTopico(
			Long id,
			String titulo,
			String mensagem,
			LocalDate datacriacao,
			EstadoTopico status,
			String autor,
			String curso
			) {
	public DadosListagemTopico (Topico topico) {
		this(topico.getId(), topico.getTitulo(),topico.getMensagem(),topico.getDataCriacao(),
				topico.getEstadoTopico(),topico.getAutor(),topico.getCurso());
	}
}
