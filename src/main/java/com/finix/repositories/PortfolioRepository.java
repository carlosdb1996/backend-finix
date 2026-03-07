package com.finix.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finix.entities.PortfolioEntity;

public interface PortfolioRepository extends JpaRepository<PortfolioEntity, Long> {

}
