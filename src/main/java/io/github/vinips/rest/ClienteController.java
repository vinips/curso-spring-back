package io.github.vinips.rest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import io.github.vinips.model.entity.Cliente;
import io.github.vinips.model.repository.ClienteRepository;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

	@Autowired
	private ClienteRepository cRepository;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente save(@RequestBody @Valid Cliente cliente) {
		// Salva o cliente que foi enviado via Json e retorna um 201 (Created)
		return cRepository.save(cliente);
	}

	@GetMapping("{id}")
	// Quando não defino o ResponseStatus, se der tudo certo ele retorna 200 (Ok)
	public Cliente findById(@PathVariable Integer id) {
		// Se encontrar o cliente, retorna um ele em Json. Se não encontrar ele retorna
		// um Not_Found.
		return cRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

	@DeleteMapping("{id}")
	// No Content não retornada nada, como é um delete ele não precisa de retorno,
	// por isso se for sucesso ele retorna o void.Type que é um void.
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		// Também serve
		//cRepository.deleteById(id);

		// Se encontrar eu deleto ele e não retorno nada. Se não encontrar o cliente,
		// retorna um Not Found.
		cRepository.findById(id).map(cliente -> {
			cRepository.delete(cliente);
			return Void.TYPE;
		}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	//@PutMapping é utilizado para atualizar completamente um recurso
	@PutMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void update(@PathVariable Integer id, @RequestBody @Valid Cliente updatedClient) {
		cRepository.findById(id).map(clienteFound -> {
			updatedClient.setId(clienteFound.getId());
			return cRepository.save(updatedClient);
		}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

}
