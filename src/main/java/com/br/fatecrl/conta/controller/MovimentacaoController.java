package com.br.fatecrl.conta.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.br.fatecrl.conta.dto.MovimentacaoDTO;
import com.br.fatecrl.conta.mapper.MovimentacaoMapper;
import com.br.fatecrl.conta.model.Movimentacao;
import com.br.fatecrl.conta.service.MovimentacaoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/conta/{idConta}/movimentacao")
@Tag(name = "Movimentações", description = "Movimentações de uma movimentacao corrente")
public class MovimentacaoController implements IController<MovimentacaoDTO>{
	@Autowired
	private MovimentacaoService service;
	
	@Autowired
	private MovimentacaoMapper mapper;
	
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
	@Operation(summary = "Retorna a lista de movimentacaos",
		   description = "Obtém uma lista de movimentações por conta")
	public ResponseEntity<List<MovimentacaoDTO>> getAll(@PathVariable("idConta") Integer idConta){
		return ResponseEntity.ok(
									mapper.toDTO(
											service.findByConta(idConta)
									)
								 );
	}
	
	@Override
	@GetMapping(value = "/{id}", produces = "application/json")
	public ResponseEntity<MovimentacaoDTO> get(@PathVariable("id") Long id) {
		Movimentacao movimentacao = service.findById(id);
		if (movimentacao != null) {
			return ResponseEntity.ok(mapper.toDTO(movimentacao));
			//HTTP 200 OK
		}
		return ResponseEntity.notFound().build();
	}	
	
	@PostMapping
	@Operation(summary = "Cria uma movimentacao")
	public ResponseEntity<MovimentacaoDTO> post(@Valid @RequestBody MovimentacaoDTO movimentacaoDTO
										, @PathVariable("idConta") Integer idConta){
		service.saveWithConta(mapper.toEntity(movimentacaoDTO), idConta);

		URI location = ServletUriComponentsBuilder
						.fromCurrentRequest()
						.path("/{id}")
						.buildAndExpand(0)
						.toUri();
		return ResponseEntity.created(location).body(movimentacaoDTO);
	}
	
	@Override
	public ResponseEntity<MovimentacaoDTO> put(@RequestBody MovimentacaoDTO movimentacao){
		throw new UnsupportedOperationException("Operação não suportada");
	}

	@Override
	public ResponseEntity<MovimentacaoDTO> patch(@RequestBody MovimentacaoDTO movimentacao){
		throw new UnsupportedOperationException("Operação não suportada");
	}	
	
	@Override
	@DeleteMapping(value = "/{id}")
	@Operation(summary = "Exclui uma movimentacao")
	public ResponseEntity<MovimentacaoDTO> delete(@PathVariable("id") Long id){
		if (service.delete(id)) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}

	@Override
	public ResponseEntity<List<MovimentacaoDTO>> getAll() {
		throw new UnsupportedOperationException("Operação não suportada");
	}

	@Override
	public ResponseEntity<MovimentacaoDTO> post(MovimentacaoDTO obj) {
		throw new UnsupportedOperationException("Operação não suportada");
	}	
}
