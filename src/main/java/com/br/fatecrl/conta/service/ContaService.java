package com.br.fatecrl.conta.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.fatecrl.conta.model.Conta;
import com.br.fatecrl.conta.repository.ContaRepository;

@Service
public class ContaService implements IService<Conta> {
	@Autowired
	private ContaRepository repository;

	public ContaService() {
	}

	@Override
	public Conta findById(Long id) {
		Optional<Conta> obj = repository.findById(id);
		return obj.orElse(null);
	}

	@Override
	public List<Conta> findAll() {
		return repository.findAll();
	}

	@Override
	public Conta create(Conta conta) {
		repository.save(conta);
		return conta;
	}

	@Override
	public boolean update(Conta conta) {
		if (repository.existsById(conta.getId())) {
			repository.save(conta);
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(Long id) {
		if (repository.existsById(id)) {
			repository.deleteById(id);
			return true;
		}
		return false;
	}
}
