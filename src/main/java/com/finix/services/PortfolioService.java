package com.finix.services;

import java.util.List;

import com.finix.dtos.PortfolioDTO;
import com.finix.entities.PortfolioEntity;



public interface PortfolioService {

	public PortfolioDTO add(Long id, PortfolioEntity portfolio);
	public List<PortfolioDTO> findAll();
	public PortfolioDTO findById(Long id);
	public PortfolioDTO update(Long id, PortfolioEntity portfolio);
	public List<PortfolioDTO> findPortfoliosByUserId(Long id);
	public boolean deletePortfolioByID(Long id);
	
}
