package io.carwashmanagement.carwashAdmin.repo;

import io.carwashmanagement.carwashAdmin.model.UserProfile;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;




public interface UserRepo extends JpaRepository<UserProfile,String>{

    Optional<UserProfile> findByUserId(String id);

	boolean existsByUserId(String userid);

	List<UserProfile> existsByStatus(String status);




}
