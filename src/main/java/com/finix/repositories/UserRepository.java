package com.finix.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finix.entities.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
