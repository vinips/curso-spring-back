package io.github.vinips.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.vinips.model.Cliente;
import io.github.vinips.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository cReposiroty;
	
	public void salvaCliente (Cliente cliente) {
		validaCliente(cliente);
		this.cReposiroty.persistir(cliente);
		
	}
	
	public void validaCliente(Cliente cliente) {
		
	}
	
	

}
