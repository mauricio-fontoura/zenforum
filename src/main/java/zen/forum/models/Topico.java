package zen.forum.models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import zen.forum.DTO.DadosCadastrarTopico;


@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {
	
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true)
	private String titulo;
	
	@Column(unique = true)
	private String mensagem;
	
	private LocalDate dataCriacao;
	
	@Enumerated(EnumType.STRING)
	private EstadoTopico estadoTopico;
	
	private String autor;
	
	private String curso;
	
	
	public Topico(DadosCadastrarTopico dados) {
		this.titulo = dados.titulo();
		this.mensagem = dados.mensagem();
		this.autor = dados.autor();
		this.curso = dados.curso();
	}

}
