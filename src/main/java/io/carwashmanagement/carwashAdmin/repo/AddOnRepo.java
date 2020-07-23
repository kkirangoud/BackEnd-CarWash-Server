package io.carwashmanagement.carwashAdmin.repo;

import io.carwashmanagement.carwashAdmin.model.AddOnModelAdmin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AddOnRepo extends JpaRepository<AddOnModelAdmin,String>{

}
