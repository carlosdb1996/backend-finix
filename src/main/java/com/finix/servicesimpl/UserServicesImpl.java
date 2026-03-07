package com.finix.servicesimpl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.finix.dtos.UserDTO;
import com.finix.entities.UserEntity;
import com.finix.repositories.UserRepository;
import com.finix.services.UserService;

import jakarta.persistence.EntityNotFoundException;

public class UserServicesImpl implements UserService {
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Override
	public UserDTO addUser(UserEntity user) {
		
		if(user != null) {
				user.setPassword(passwordEncoder.encode(user.getPassword()));
				user.setCreated_at(LocalDateTime.now());
				this.userRepository.save(user);
				return UserDTO.toDTO(user);
		}else {
			throw new NoSuchElementException();
		}
		
		
	}

	@Override
	public List<UserDTO> findAll() {
		
		return this.userRepository.findAll().stream().map(user -> UserDTO.toDTO(user)).collect(Collectors.toList());
	}

	@Override
	public UserDTO findByID(Long id) {
		Optional<UserEntity> user = this.userRepository.findById(id);
		if(user.isPresent()) {
			return UserDTO.toDTO(user.get());
		}else {
			throw new EntityNotFoundException("The user with id " + id + " doesn't exists");
		}
	}

	@Override
	public UserDTO update(Long id, UserEntity user) {
		UserEntity existingUser = this.userRepository.findById(id).orElseThrow();

		if (user.getUsername() != null) {
			existingUser.setUsername(user.getUsername());

		}
		if (user.getEmail() != null) {
			existingUser.setEmail(user.getEmail());
		}

		if (user.getCreated_at() != null) {
			existingUser.setCreated_at(LocalDateTime.now());
		}
		

		this.userRepository.save(existingUser);

		return UserDTO.toDTO(existingUser);
	}

	@Override
	public boolean delete(Long id) {
		Optional<UserEntity> user = this.userRepository.findById(id);
		if (user.isPresent()) {
			this.userRepository.delete(user.get());
			return true;
		}

		return false;
	}

}
