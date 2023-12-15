package br.com.romildoamaro.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.romildoamaro.model.entity.Client;
import br.com.romildoamaro.model.repository.ClientRepository;

@RestController
@RequestMapping("/api/clientes")
public class ClientController {

	@Autowired
	private ClientRepository repository;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Client saveClient(@RequestBody Client client) {
		
		return repository.save(client);
	}
}
