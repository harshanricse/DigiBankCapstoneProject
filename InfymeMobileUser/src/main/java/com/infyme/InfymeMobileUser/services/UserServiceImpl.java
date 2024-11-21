package com.infyme.InfymeMobileUser.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infyme.InfymeMobileUser.dtos.LoginDTO;
import com.infyme.InfymeMobileUser.dtos.UserDTO;
import com.infyme.InfymeMobileUser.entities.User;
import com.infyme.InfymeMobileUser.exceptions.InfymeMobileException;
import com.infyme.InfymeMobileUser.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepository;
	@Autowired
	private ModelMapper modelMapper;
	/*
	 * This method is used to create a new user. invoke the save() method of Repository and return mobile number.
	 * Handle Exceptions if any. Before saving the user you can also check whether the user is already present or not
	 */
	public String createUser(UserDTO userDTO) {
		System.out.println("Debug createUser"+userDTO);
		Optional<User> userOptional = userRepository.findById(userDTO.getMobileNumber());		
		if(userOptional.isEmpty()) {			
			User user = modelMapper.map(userDTO, User.class);
			System.out.println(user);
			userRepository.save(user);
		}
		return "User is successfully created";
	}

	/*
	 * This method is used to log in with an existing mobile number and password.
	 * invoke findById() method of Repository. if the mobile number is available, then compare passwords and return the result otherwise
	 * throw InfymeMobileException with the message AUTHENTICATION_FAILED
	 */
	@Override
	public Boolean loginUser(LoginDTO loginDTO) throws InfymeMobileException{
		Optional<User> userOptional = userRepository.findById(loginDTO.getMobileNumber());
		if(userOptional.isPresent() && userOptional.get().getPassword().equals(loginDTO.getPassword())) {
			return true;
		}
		throw new InfymeMobileException("AUTHENTICATION_FAILED");
	}

	/*
	 * This method is used to send UserDTO for a given user id.
	 * invoke findById() method of Repository.
	 * If the user is available, then send userDTO otherwise throw InfymeMobileException with the message USERID_NOT_FOUND
	 */
	public UserDTO getUserProfile(String userId) throws InfymeMobileException{
		Optional<User> userOptional = userRepository.findByuserId(userId);
		if(userOptional.isPresent()) {			
			UserDTO userDTO = modelMapper.map(userOptional.get(), UserDTO.class);
			System.out.println(userDTO);
			return userDTO;
		}
		throw new InfymeMobileException("USERID_NOT_FOUND");		
	}

	/*
	 * This method is used to send a list of all UserDTOs. Invoke findAll() method of Repository.
	 * If no users are found in the database throw InfyMeMobileException with the message NO_USERS_FOUND
	 */
	public List<UserDTO> showAllUsers() throws InfymeMobileException{
		// TODO Auto-generated method stub
		List<User> users = userRepository.findAll();
		List<UserDTO> userdtolist = new ArrayList<>();
		if(users.size()==0) {
			throw new InfymeMobileException("NO_USERS_FOUND");
		}
		else {
			for(User user: users) {
				userdtolist.add(modelMapper.map(user, UserDTO.class));
			}
		}
		return userdtolist;
	}

}
