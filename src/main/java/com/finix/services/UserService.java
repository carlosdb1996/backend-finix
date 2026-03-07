package com.finix.services;

import java.util.List;

import com.finix.dtos.UserDTO;
import com.finix.entities.UserEntity;

public interface UserService {
	
	public UserDTO addUser(UserEntity user);
	public List<UserDTO> findAll();
	public UserDTO findByID(Long id);
	public UserDTO update(Long id, UserEntity user);
	public boolean delete(Long id);
	
	
}
