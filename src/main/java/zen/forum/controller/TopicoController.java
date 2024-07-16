package zen.forum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import zen.forum.DTO.DadosAtualizacaoTopico;
import zen.forum.DTO.DadosCadastrarTopico;
import zen.forum.DTO.DadosListagemTopico;
import zen.forum.models.Topico;
import zen.forum.repository.TopicoRepository;

@RestController
@RequestMapping("/topicos")
public class TopicoController {
	
	@Autowired
	private TopicoRepository repositorio;
	
	@PostMapping
	@Transactional
	public void Cadastrar (@RequestBody @Valid DadosCadastrarTopico dados) {
		System.out.println(dados);
		repositorio.save(new Topico(dados));
		
	}
	
	// Funcionalidade não esta funcionando como deveria voltar e concluir o projeto
	@GetMapping
	public Page<DadosListagemTopico> Listar( Pageable paginacao) {
		return repositorio.findAll(paginacao).map(DadosListagemTopico::new);
	}
	
	@PutMapping
	@Transactional
	public void atualizar(@RequestBody @Valid DadosAtualizacaoTopico dados) {
		Topico topico = repositorio.getReferenceById(dados.id());
		topico.atualizarInformacoes(dados);
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public void excluir(@PathVariable Long id ) {
		repositorio.deleteById(id);
	}
}
