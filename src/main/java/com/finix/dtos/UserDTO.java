package com.finix.dtos;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.finix.entities.PortfolioEntity;
import com.finix.entities.UserEntity;

public class UserDTO {
	private Long id;
	private String username;
	private String email;
	
	@JsonIgnore
	private String password;
	
	private LocalDateTime created_at;
	private List<PortfolioDTO> portfolios = new ArrayList<PortfolioDTO>();
	
	public static UserDTO toDTO(UserEntity user) {
		UserDTO userDto = new UserDTO();
		userDto.setId(user.getId());
		userDto.setUsername(user.getUsername());
		userDto.setEmail(user.getEmail());
		userDto.setPassword(user.getPassword());
		userDto.setCreated_at(user.getCreated_at());
		
		List<PortfolioDTO> portfoliosDTO = new ArrayList<PortfolioDTO>();
		for (PortfolioEntity portfolio : user.getPortfolios()) {
			portfoliosDTO.add(PortfolioDTO.toDTO(portfolio));
		}
		userDto.setPortfolios(portfoliosDTO);
		
		return userDto;
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
	public List<PortfolioDTO> getPortfolios() {
		return portfolios;
	}
	public void setPortfolios(List<PortfolioDTO> portfolios) {
		this.portfolios = portfolios;
	}
	
	
}
