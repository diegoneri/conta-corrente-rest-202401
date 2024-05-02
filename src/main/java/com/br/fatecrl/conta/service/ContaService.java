package com.br.fatecrl.conta.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.fatecrl.conta.model.Conta;
import com.br.fatecrl.conta.repository.ContaRepository;

@Service
public class ContaService {
	@Autowired
	private ContaRepository repository;

	public ContaService() {
	}

	public Conta find(Long id) {
		Optional<Conta> obj = repository.findById(id);
		return obj.orElse(null);
	}

	public List<Conta> findAll() {
		return repository.findAll();
	}

	public Conta create(Conta conta) {
		repository.save(conta);
		return conta;
	}

	public Boolean update(Conta conta) {
		if (repository.existsById(conta.getId())) {
			repository.save(conta);
			return true;
		}
		return false;
	}

	public Boolean delete(Long id) {
		if (repository.existsById(id)) {
			repository.deleteById(id);
			return true;
		}
		return false;
	}
}
