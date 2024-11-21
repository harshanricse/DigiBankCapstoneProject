package com.infyme.InfymeMobileUser.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.infyme.InfymeMobileUser.dtos.LoginDTO;
import com.infyme.InfymeMobileUser.dtos.UserDTO;
import com.infyme.InfymeMobileUser.exceptions.InfymeMobileException;
import com.infyme.InfymeMobileUser.services.UserService;

@RestController
@RequestMapping("/users")
public class UserApi {
	@Autowired
	UserService userService;
	@PostMapping
	public ResponseEntity<String> createUser(@RequestBody UserDTO userDTO){
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(userDTO));		
	}
	
	
	@PostMapping(value = "/login")
	public ResponseEntity<Boolean> loginUser(@RequestBody LoginDTO loginDTO) throws InfymeMobileException{		
		return ResponseEntity.status(HttpStatus.OK).body(userService.loginUser(loginDTO));
		
	}
	@GetMapping("/{userId}")
	public ResponseEntity<UserDTO> getUserProfile(@PathVariable("userId") String userId) throws InfymeMobileException{		
		return ResponseEntity.status(HttpStatus.OK).body(userService.getUserProfile(userId));	
	}
	@GetMapping("/all")
	public ResponseEntity<List<UserDTO>> showAllusers() throws InfymeMobileException{
		return ResponseEntity.status(HttpStatus.OK).body(userService.showAllUsers());		
	}

}
