package br.com.romildoamaro.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.romildoamaro.model.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {
}
