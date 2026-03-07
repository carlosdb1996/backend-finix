package com.finix.entities;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class UserEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String username;
	private String email;
	private String password;
	private LocalDateTime created_at;

	@JsonManagedReference(value = "user-portfolio") // JsonManaged nos permitirá ver la orderList en el JSON cuando
													// hagamos peticiones GET
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY) // para que solo cargue orders
																						// cuando accedamos a ellos
																						// (mejora el rendimiento).
	private List<PortfolioEntity> portfolios = new ArrayList<PortfolioEntity>();
	
	
	public void addPortfolio(PortfolioEntity portfolio) {
		this.addPortfolio(portfolio);
		portfolio.setUser(this);
	}
	public void removePortfolio(PortfolioEntity portfolio) {
		this.portfolios.remove(portfolio);
		portfolio.setUser(null);
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDateTime getCreated_at() {
		return created_at;
	}

	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}
	public List<PortfolioEntity> getPortfolios() {
		return portfolios;
	}
	public void setPortfolios(List<PortfolioEntity> portfolios) {
		this.portfolios = portfolios;
	}
	
	
	
	
	
}
