package com.br.fatecrl.conta.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.fatecrl.conta.model.PessoaJuridica;
import com.br.fatecrl.conta.repository.PessoaJuridicaRepository;

@Service
public class PessoaJuridicaService extends AbstractService<PessoaJuridica> {
	private PessoaJuridicaRepository repository;

	public PessoaJuridicaService(PessoaJuridicaRepository repository) {
		super(repository);
	}
	
	@Autowired
	public void setRepository(PessoaJuridicaRepository repository) {
		this.repository = repository;
	}
	
	public PessoaJuridicaRepository getRepository() {
		return repository;
	}
	
}