package com.finix.servicesimpl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finix.dtos.PortfolioDTO;
import com.finix.entities.PortfolioEntity;
import com.finix.entities.UserEntity;
import com.finix.repositories.PortfolioRepository;
import com.finix.repositories.UserRepository;
import com.finix.services.PortfolioService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PortfolioServiceImpl implements PortfolioService{
	@Autowired
	UserRepository userRepository;
	@Autowired
	PortfolioRepository portfolioRepository;

	@Override
	public PortfolioDTO add(Long id, PortfolioEntity portfolio) {
		Optional<UserEntity> user = this.userRepository.findById(id);
		if(user.isPresent()) {
			portfolio.setCreated_at(LocalDateTime.now());
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
	    PortfolioEntity existingPortfolio = this.portfolioRepository.findById(id)
	            .orElseThrow(() -> new EntityNotFoundException("The portfolio with id " + id + " doesn't exist"));

	    if (portfolio.getPortfolioName() != null) {
	        existingPortfolio.setPortfolioName(portfolio.getPortfolioName());
	    }

	    if (portfolio.getCurrency() != null) {
	        existingPortfolio.setCurrency(portfolio.getCurrency());
	    }

	    if (portfolio.getCashBalance() != 0) {
	        existingPortfolio.setCashBalance(portfolio.getCashBalance());
	    }

	    if (portfolio.getUser() != null) {
	        existingPortfolio.setUser(portfolio.getUser());
	    }

	    PortfolioEntity savedPortfolio = this.portfolioRepository.save(existingPortfolio);

	    return PortfolioDTO.toDTO(savedPortfolio);
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
