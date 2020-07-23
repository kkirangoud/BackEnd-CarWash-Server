package io.carwashmanagement.carwashAdmin.repo;

import io.carwashmanagement.carwashAdmin.model.CarWasherModel;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface CarWasherRepo extends JpaRepository<CarWasherModel,String> {


	Optional<CarWasherModel> findById(int cId);
	
}
