package com.finix.dtos;

import java.time.LocalDateTime;

import com.finix.entities.PortfolioEntity;


public class PortfolioDTO {

	private Long id;

	private String portfolioName;

	private String userName;

	private String currency;

	private double cashBalance;
	private LocalDateTime created_at;

	public static PortfolioDTO toDTO(PortfolioEntity portfolio) {
		PortfolioDTO portfolioDTO = new PortfolioDTO();
		portfolioDTO.setId(portfolio.getId());
		portfolioDTO.setPortfolioName(portfolio.getPortfolioName());
		portfolioDTO.setCreated_at(portfolio.getCreated_at());
		portfolioDTO.setCurrency(portfolio.getCurrency());
		portfolioDTO.setCashBalance(portfolio.getCashBalance());
		portfolioDTO.setUserName(portfolio.getUser().getUsername());
		return portfolioDTO;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
