package com.finix.dtos;

import java.time.LocalDateTime;

import com.finix.entities.PortfolioEntity;
import com.finix.entities.UserEntity;



public class PortfolioDTO {
	
	private Long id;
	
	private UserEntity user;
	
	private String portfolioName;
	
	private String currency;
	
	private double cashBalance;
	
	public static PortfolioDTO toDTO(PortfolioEntity portfolio) {
		PortfolioDTO portfolioDTO = new PortfolioDTO();
		portfolioDTO.setId(portfolio.getId());
		portfolioDTO.setPortfolioName(portfolio.getPortfolioName());
		portfolioDTO.setCurrency(portfolio.getCurrency());
		portfolioDTO.setCashBalance(portfolio.getCashBalance());
		return portfolioDTO;
	}
	
	
	private LocalDateTime created_at;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public String getPortfolioName() {
		return portfolioName;
	}

	public void setPortfolioName(String portfolioName) {
		this.portfolioName = portfolioName;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public double getCashBalance() {
		return cashBalance;
	}

	public void setCashBalance(double cashBalance) {
		this.cashBalance = cashBalance;
	}

	public LocalDateTime getCreated_at() {
		return created_at;
	}

	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}
	
	
}
