package br.com.romildoamaro.rest;

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

import br.com.romildoamaro.model.entity.Client;
import br.com.romildoamaro.model.repository.ClientRepository;

@RestController
@RequestMapping("/api/clientes")
public class ClientController {

	@Autowired
	private ClientRepository repository;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Client createClient(@RequestBody @Valid Client client) {
		
		return repository.save(client);
	}
	
	@GetMapping("{id}")
	public Client findClientById(@PathVariable("id") Integer id) {
		
		return repository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteClient(@PathVariable Integer id) {
		
		repository.findById(id).map(client -> {
			repository.delete(client);
			return client;
		})
		.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	@PutMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updateClient(@PathVariable Integer id, 
			@RequestBody @Valid Client updatedClient) {
		
		repository.findById(id)
		.map(client -> {
			updatedClient.setId(client.getId());
			return repository.save(updatedClient);
		}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
}
