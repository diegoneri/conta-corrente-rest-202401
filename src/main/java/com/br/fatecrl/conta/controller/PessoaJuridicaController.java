package com.br.fatecrl.conta.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.br.fatecrl.conta.model.PessoaJuridica;
import com.br.fatecrl.conta.service.PessoaJuridicaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/pessoaJuridica")
@Tag(name = "Pessoa Jurídica", description = "Gerenciar pessoa jurídica")
public class PessoaJuridicaController implements IController<PessoaJuridica>{
	@Autowired
	private PessoaJuridicaService service;
	
	@Override
	@GetMapping(produces = "application/json")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200"
					   , description = "Resultado com sucesso"
					   , content = {@Content(mediaType = "application/json")}
			),
			@ApiResponse(responseCode = "500"
			           , description = "Erro interno do servidor"
			           , content = {@Content(mediaType = "application/json")} 
			)
	})
	@Operation(summary = "Retorna a lista de pessoas jurídica")
	public ResponseEntity<List<PessoaJuridica>> getAll(){
		return ResponseEntity.ok(service.findAll());
	}
	
	@Override
	@GetMapping(value = "/{id}", produces = "application/json")
	@Operation(summary = "Obtém uma pessoa jurídica"
			 , description = "Dado um id, retorna a pessoa jurídica associada.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200"
					   , description = "Resultado com sucesso"
					   , content = {@Content(mediaType = "application/json")}
			),
			@ApiResponse(responseCode = "500"
	           , description = "Erro interno do servidor"
	           , content = {@Content(mediaType = "application/json")} 
	        ),
			@ApiResponse(responseCode = "404"
	           , description = "Cliente não encontrado"
	           , content = {@Content(mediaType = "application/json")} 
			)
	})	
	public ResponseEntity<PessoaJuridica> get(@PathVariable("id") Long id) {
		PessoaJuridica pessoaJuridica = service.findById(id);
		if (pessoaJuridica != null) {
			return ResponseEntity.ok(pessoaJuridica);
		}
		return ResponseEntity.notFound().build();
	}	
	
	@Override
	@PostMapping
	@Operation(summary = "Cria uma pessoa jurídica")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201"
					   , description = "Cliente criado com sucesso"
					   , content = {@Content(mediaType = "application/json")}
			),
			@ApiResponse(responseCode = "500"
	           , description = "Erro interno do servidor"
	           , content = {@Content(mediaType = "application/json")} 
	        )
	})		
	public ResponseEntity<PessoaJuridica> post(@RequestBody PessoaJuridica pessoaJuridica){
		service.create(pessoaJuridica);

		URI location = ServletUriComponentsBuilder
						.fromCurrentRequest()
						.path("/{id}")
						.buildAndExpand(pessoaJuridica.getId())
						.toUri();
		return ResponseEntity.created(location).body(pessoaJuridica);
	}
	
	@Override
	@PutMapping
	@Operation(summary = "Atualiza uma pessoa jurídica"
			 , description = "Atualização por completo de uma pessoa jurídica.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200"
					   , description = "Resultado com sucesso"
					   , content = {@Content(mediaType = "application/json")}
			),
			@ApiResponse(responseCode = "500"
	           , description = "Erro interno do servidor"
	           , content = {@Content(mediaType = "application/json")} 
	        ),
			@ApiResponse(responseCode = "404"
	           , description = "Cliente não encontrado"
	           , content = {@Content(mediaType = "application/json")} 
			)
	})
	public ResponseEntity<PessoaJuridica> put(@RequestBody PessoaJuridica pessoaJuridica){
		if (service.update(pessoaJuridica)) {
			return ResponseEntity.ok(pessoaJuridica);
		}
		return ResponseEntity.notFound().build();
	}

	@Override
	@PatchMapping
	@Operation(summary = "Atualiza uma pessoa jurídica"
	 , description = "Atualização parcial de uma pessoa jurídica.")
	@ApiResponses(value = {
		@ApiResponse(responseCode = "200"
				   , description = "Resultado com sucesso"
				   , content = {@Content(mediaType = "application/json")}
		),
		@ApiResponse(responseCode = "500"
	      , description = "Erro interno do servidor"
	      , content = {@Content(mediaType = "application/json")} 
	   ),
		@ApiResponse(responseCode = "404"
	      , description = "Cliente não encontrado"
	      , content = {@Content(mediaType = "application/json")} 
		)
	})	
	public ResponseEntity<PessoaJuridica> patch(@RequestBody PessoaJuridica pessoaJuridica){
		if (service.update(pessoaJuridica)) {
			return ResponseEntity.ok(pessoaJuridica);
		}
		return ResponseEntity.notFound().build();
	}	
	
	@Override
	@DeleteMapping(value = "/{id}")
	@Operation(summary = "Exclui uma pessoa jurídica")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200"
					   , description = "Resultado com sucesso"
					   , content = {@Content(mediaType = "application/json")}
			),
			@ApiResponse(responseCode = "500"
		      , description = "Erro interno do servidor"
		      , content = {@Content(mediaType = "application/json")} 
		   ),
			@ApiResponse(responseCode = "404"
		      , description = "Cliente não encontrado"
		      , content = {@Content(mediaType = "application/json")} 
			)
		})	
	public ResponseEntity<PessoaJuridica> delete(@PathVariable("id") Long id){
		if (service.delete(id)) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}	
}
