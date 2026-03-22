package com.finix.entities;

import java.time.LocalDateTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.finix.enums.TransactionType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "transactions")
public class TransactionsEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "portfolio_id", nullable = true)
	@JsonBackReference(value = "portfolio-transaction")
	private PortfolioEntity portfolio;
	
	
	private String assetSymbol;
	
	@Enumerated(EnumType.STRING)
	private TransactionType transactionType;
	
	private double quantity;
	
	private double UnitPrice;
	
	private Date transactionDate;
	
	private LocalDateTime created_at;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PortfolioEntity getPortfolio() {
		return portfolio;
	}

	public void setPortfolio(PortfolioEntity portfolio) {
		this.portfolio = portfolio;
	}

	public String getAssetSymbol() {
		return assetSymbol;
	}

	public void setAssetSymbol(String assetSymbol) {
		this.assetSymbol = assetSymbol;
	}

	public TransactionType getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public double getUnitPrice() {
		return UnitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		UnitPrice = unitPrice;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public LocalDateTime getCreated_at() {
		return created_at;
	}

	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}
	
	
	
	
	

}
