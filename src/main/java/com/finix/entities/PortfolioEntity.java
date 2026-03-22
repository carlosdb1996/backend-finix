package com.finix.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "portfolios")
public class PortfolioEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = true)
	@JsonBackReference(value = "user-portfolio")
	private UserEntity user;
	
	@JsonManagedReference(value="portfolio-investment") // JsonManaged nos permitirá ver la orderList en el JSON cuando hagamos peticiones GET
	@OneToMany(mappedBy = "portfolio",
			cascade = CascadeType.ALL,
			fetch = FetchType.LAZY) // para que solo cargue orders cuando accedamos a ellos (mejora el rendimiento).
	private List<InvestmentEntity> investments = new ArrayList<InvestmentEntity>();
	
	@JsonManagedReference(value="portfolio-transaction") // JsonManaged nos permitirá ver la orderList en el JSON cuando hagamos peticiones GET
	@OneToMany(mappedBy = "portfolio",
			cascade = CascadeType.ALL,
			fetch = FetchType.LAZY) // para que solo cargue orders cuando accedamos a ellos (mejora el rendimiento).
	private List<TransactionsEntity> transactions = new ArrayList<TransactionsEntity>();
	
	@Column(name = "name")
	private String portfolioName;
	
	private String currency;
	
	@Column(name = "cash_balance")
	private double cashBalance;
	
	private LocalDateTime created_at;
	
	public void addTransaction(TransactionsEntity transaction) {
		this.transactions.add(transaction);
		transaction.setPortfolio(this);
	}
	
	public void removeTransaction(TransactionsEntity transaction) {
		this.transactions.remove(transaction);
		transaction.setPortfolio(null);
	}
	
	public void addInvestment(InvestmentEntity investment) {
		this.investments.add(investment);
		investment.setPortfolio(this);
	}
	
	public void removeInvestment(InvestmentEntity investment) {
		this.investments.remove(investment);
		investment.setPortfolio(null);
	}
	
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
	public List<InvestmentEntity> getInvestments() {
		return investments;
	}
	public void setInvestments(List<InvestmentEntity> investments) {
		this.investments = investments;
	}
	
	
}
