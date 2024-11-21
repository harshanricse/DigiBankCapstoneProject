package com.infyme.InfymeMobileUser.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infyme.InfymeMobileUser.entities.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	Optional<User> findByuserId(String userId);
	
}
