package com.br.fatecrl.conta.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.br.fatecrl.conta.bean.Conta;

@Service
public class ContaService {
	private static List<Conta> contas = new ArrayList<>();
	
	public ContaService() {
		contaFake();
	}
	
	private void contaFake() {
		Conta conta1 = new Conta(0L);
		conta1.setTitular("Diego");
		conta1.setSaldo(1000.0);
		contas.add(conta1);
	}
	
	public Conta find(Conta conta){
		for (Conta c: contas) {
			if (c.equals(conta)) {
				return c;
			}
		}
		return null;
	}
	
	public Conta find(Long id) {
		return find(new Conta(id));
	}
	
	public List<Conta> findAll() {
		return contas;
	}
	
	
	public void create(Conta conta) {
		conta.setId(conta.generateId());
		contas.add(conta);
	}
	
	public Boolean update(Conta conta) {
		Conta _conta = this.find(conta);
		if (_conta != null) {
			_conta.setAgencia(conta.getAgencia());
			_conta.setNumero(conta.getNumero());
			_conta.setTitular(conta.getTitular());
			_conta.setSaldo(conta.getSaldo());
			return true;
		}
		return false;
	}
	
	public Boolean delete(Long id) {
		Conta _conta = this.find(id);
		if (_conta != null) {
			contas.remove(_conta);
			return true;
		}
		return false;
	}
}
