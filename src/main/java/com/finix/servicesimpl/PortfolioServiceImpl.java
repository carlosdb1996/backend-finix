package com.finix.servicesimpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.finix.dtos.PortfolioDTO;
import com.finix.entities.PortfolioEntity;
import com.finix.entities.UserEntity;
import com.finix.repositories.PortfolioRepository;
import com.finix.repositories.UserRepository;
import com.finix.services.PortfolioService;

import jakarta.persistence.EntityNotFoundException;

public class PortfolioServiceImpl implements PortfolioService{
	
	UserRepository userRepository;
	
	PortfolioRepository portfolioRepository;

	@Override
	public PortfolioDTO add(Long id, PortfolioEntity portfolio) {
		Optional<UserEntity> user = this.userRepository.findById(id);
		if(user.isPresent()) {
			this.portfolioRepository.save(portfolio);
			user.get().addPortfolio(portfolio);
			portfolio.setUser(user.get());
			this.portfolioRepository.save(portfolio);
			return PortfolioDTO.toDTO(portfolio);
		}
		throw new EntityNotFoundException();
	}

	@Override
	public List<PortfolioDTO> findAll() {
		
		return this.portfolioRepository.findAll().stream().map(portfolio -> PortfolioDTO.toDTO(portfolio)).collect(Collectors.toList());
	}

	@Override
	public PortfolioDTO findById(Long id) {
		
		Optional<PortfolioEntity> portfolio = this.portfolioRepository.findById(id);
		if (portfolio.isEmpty()) {
			throw new EntityNotFoundException();
		}

		return PortfolioDTO.toDTO(portfolio.get());
	}

	@Override
	public PortfolioDTO update(Long id, PortfolioEntity portfolio) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PortfolioDTO> findPortfoliosByUserId(Long id) {
		Optional<UserEntity> user = this.userRepository.findById(id);
		if (user.isPresent()) {
			return user.get().getPortfolios().stream().map(portfolio -> PortfolioDTO.toDTO(portfolio))
					.collect(Collectors.toList());
		} else {
			throw new EntityNotFoundException();
		}
	}

	@Override
	public boolean deletePortfolioByID(Long id) {
		Optional<PortfolioEntity> porftolio = this.portfolioRepository.findById(id);
		if (porftolio.isPresent()) {
			this.portfolioRepository.delete(porftolio.get());
			return true;
		} else {
			return false;
		}
	}

}
