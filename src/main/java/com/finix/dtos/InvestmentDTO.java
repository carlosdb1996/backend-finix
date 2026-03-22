package com.finix.dtos;

import com.finix.entities.InvestmentEntity;

public class InvestmentDTO {

	private String assetSymbol;

	private double totalQuantity;

	private double averagePrice;
	
	private String portfolioId;
	
	

	public InvestmentDTO(String assetSymbol, double totalQuantity, double averagePrice, String portfolioId) {
		super();
		this.assetSymbol = assetSymbol;
		this.totalQuantity = totalQuantity;
		this.averagePrice = averagePrice;
		this.portfolioId = portfolioId;
	}
	public InvestmentDTO() {
		
	}
	
	
	public static InvestmentDTO toDto(InvestmentEntity investment) {
		
		InvestmentDTO investmentDTO = new InvestmentDTO();
		investmentDTO.setAssetSymbol(investment.getAssetSymbol());
		investmentDTO.setTotalQuantity(investment.getTotalQuantity());
		investmentDTO.setAveragePrice(investment.getAveragePrice());
		investmentDTO.setPortfolioId(investment.getPortfolio().getId().toString());
		
		return investmentDTO;
	}

	public String getAssetSymbol() {
		return assetSymbol;
	}

	public void setAssetSymbol(String assetSymbol) {
		this.assetSymbol = assetSymbol;
	}

	public double getTotalQuantity() {
		return totalQuantity;
	}

	public void setTotalQuantity(double totalQuantity) {
		this.totalQuantity = totalQuantity;
	}

	public double getAveragePrice() {
		return averagePrice;
	}

	public void setAveragePrice(double averagePrice) {
		this.averagePrice = averagePrice;
	}

	public String getPortfolioId() {
		return portfolioId;
	}

	public void setPortfolioId(String portfolioId) {
		this.portfolioId = portfolioId;
	}
	
	
}
