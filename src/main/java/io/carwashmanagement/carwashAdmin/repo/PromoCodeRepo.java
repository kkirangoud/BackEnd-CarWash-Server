package io.carwashmanagement.carwashAdmin.repo;

import io.carwashmanagement.carwashAdmin.model.PromoCodeModel;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface PromoCodeRepo extends JpaRepository<PromoCodeModel,String>  {




}
