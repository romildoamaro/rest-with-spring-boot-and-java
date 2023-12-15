package br.com.romildoamaro.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.romildoamaro.model.entity.Service;

public interface ServiceRepository extends JpaRepository<Service, Integer> {
}
