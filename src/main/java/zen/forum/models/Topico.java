package zen.forum.models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import zen.forum.DTO.DadosAtualizacaoTopico;
import zen.forum.DTO.DadosCadastrarTopico;

@Entity
@Table(name="topicos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true)
	private String titulo;
	
	@Column(unique = true)
	private String mensagem;
	
	private LocalDate data_criacao;
	
	@Enumerated(EnumType.STRING)
	private EstadoTopico status_topico;
	
	private String autor;
	
	private String curso;
	
	public Topico() {
		
	}
	
	public Topico(DadosCadastrarTopico dados) {
		this.titulo = dados.titulo();
		this.mensagem = dados.mensagem();
		this.data_criacao = LocalDate.now();
		this.status_topico = EstadoTopico.valueOf("NAO_RESPONDIDO");
		this.autor = dados.autor();
		this.curso = dados.curso();
	}


	
	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public LocalDate getDataCriacao() {
		return data_criacao;
	}

	public EstadoTopico getEstadoTopico() {
		return status_topico;
	}

	public String getAutor() {
		return autor;
	}

	public String getCurso() {
		return curso;
	}

	public void atualizarInformacoes(@Valid DadosAtualizacaoTopico dados) {
		if(dados.titulo() != null) {
			this.titulo = dados.titulo();	
		}
		if(dados.mensagem() != null) {
			this.titulo = dados.mensagem();	
		}
		if(dados.autor() != null) {
			this.autor = dados.autor();
		}
		if(dados.curso() != null) {
			this.titulo = dados.curso();	
		}
	}

}
