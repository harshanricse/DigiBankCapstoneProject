package com.infyme.InfymeMobileUser.services;

import java.util.List;

import com.infyme.InfymeMobileUser.dtos.LoginDTO;
import com.infyme.InfymeMobileUser.dtos.UserDTO;
import com.infyme.InfymeMobileUser.exceptions.InfymeMobileException;

public interface UserService {
	String createUser(UserDTO userDTO);
	Boolean loginUser(LoginDTO loginDTO) throws InfymeMobileException;
	UserDTO getUserProfile(String userId) throws InfymeMobileException;
	List<UserDTO> showAllUsers() throws InfymeMobileException;
	
}
