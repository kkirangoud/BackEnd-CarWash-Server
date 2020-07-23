package io.carwashmanagement.carwashAdmin.repo;

import io.carwashmanagement.carwashAdmin.model.CarModelAdmin;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CarRepo extends JpaRepository<CarModelAdmin, String> {

	/*List<CarModel> findAll();

	Optional<CarModel> findById(int carid);
*/

}
