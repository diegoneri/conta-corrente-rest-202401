package com.br.fatecrl.conta.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.br.fatecrl.conta.bean.Conta;
import com.br.fatecrl.conta.service.ContaService;

@RestController
@RequestMapping("/contas")
public class ContaController {
	
	@Autowired
	private ContaService service;
	
//	@GetMapping("")
//	public String healthCheck(){
//		return "Estamos no ar!";
//	}
	
	@GetMapping
	public ResponseEntity<List<Conta>> getAll(){
		return ResponseEntity.ok(service.findAll());
	}
	
	//http://localhost:8080/contas/1
	@GetMapping(value = "/{id}")
	public ResponseEntity<Conta> getConta(@PathVariable("id") Long id) {
		Conta conta = service.find(id);
		if (conta != null) {
			return ResponseEntity.ok(conta);
			//HTTP 200 OK
		}
		return ResponseEntity.notFound().build();
	}	
	
	//http://localhost:8080/contas
	@PostMapping
	public ResponseEntity<Conta> post(@RequestBody Conta conta){
		service.create(conta);

		URI location = ServletUriComponentsBuilder
						.fromCurrentRequest()
						.path("/{id}")
						.buildAndExpand(conta.getId())
						.toUri();
		return ResponseEntity.created(location).body(conta);
		//HTTP 201 CREATED
	}
	
	@PutMapping
	public ResponseEntity<Conta> put(@RequestBody Conta conta){
		if (service.update(conta)) {
			return ResponseEntity.ok(conta);
			//return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
//		return service.update(conta)  
//				? ResponseEntity.ok(conta)
//				: ResponseEntity.notFound().build();
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Conta> delete(@PathVariable("id") Long id){
		if (service.delete(id)) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
	
	
}
