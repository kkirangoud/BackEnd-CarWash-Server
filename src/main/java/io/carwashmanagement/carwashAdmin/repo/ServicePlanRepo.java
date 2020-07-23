package io.carwashmanagement.carwashAdmin.repo;

import io.carwashmanagement.carwashAdmin.model.ServicePlan;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


public interface ServicePlanRepo extends JpaRepository<ServicePlan,String> {



	Optional<ServicePlan> findById(String serviceplanid);


	Optional<ServicePlan> findAllById(String id);


}
