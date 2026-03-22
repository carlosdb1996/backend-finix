package com.finix.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finix.entities.InvestmentEntity;

public interface InvestmentRepository extends JpaRepository<InvestmentEntity, Long> {

}
