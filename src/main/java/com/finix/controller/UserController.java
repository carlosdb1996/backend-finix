package com.finix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finix.constants.URLConstantsFinix;
import com.finix.dtos.UserDTO;
import com.finix.entities.UserEntity;
import com.finix.services.UserService;


@RestController
@RequestMapping(URLConstantsFinix.URL_BASE + "/users")
public class UserController {

	@Autowired
	UserService userService;
	
	@PostMapping
	public ResponseEntity<?> addUser(@RequestBody UserEntity user){
		return ResponseEntity.ok(this.userService.addUser(user));
	}
	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll() {
		return ResponseEntity.ok(this.userService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserDTO> findByID(@PathVariable Long id) {
		return ResponseEntity.ok(this.userService.findByID(id));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<UserDTO> updatedByID(@PathVariable Long id, @RequestBody UserEntity user) {
		return ResponseEntity.ok(this.userService.update(id, user));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		boolean isEliminated = this.userService.delete(id);
		if(isEliminated) {
			return  ResponseEntity.ok("The user with id " + id  + " was eliminated sucessfully");
		}else {
			return  ResponseEntity.ok("The user with id " + id  + " not found");
		}
	}
}
