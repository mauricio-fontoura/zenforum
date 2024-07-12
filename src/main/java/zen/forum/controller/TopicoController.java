package zen.forum.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import zen.forum.DTO.DadosCadastrarTopico;

@RestController
@RequestMapping("/topicos")
public class TopicoController {
	
	@PostMapping
	public void Cadastrar (@RequestBody DadosCadastrarTopico dados) {
		
		System.out.println(dados);
	}
}
