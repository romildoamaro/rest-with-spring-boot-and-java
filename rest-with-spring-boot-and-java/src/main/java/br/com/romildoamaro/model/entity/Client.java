package br.com.romildoamaro.model.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false, length = 150)
	private String name;
	
	@Column(nullable = false, length = 11)
	private String cpf;
	
	@Column(name = "created_at")
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate createdAt;
	
	@PrePersist
	public void prePersist() {
		setCreatedAt(LocalDate.now());
	}
}
