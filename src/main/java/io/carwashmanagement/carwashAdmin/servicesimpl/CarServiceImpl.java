package io.carwashmanagement.carwashAdmin.servicesimpl;

import io.carwashmanagement.carwashAdmin.model.CarModelAdmin;
import io.carwashmanagement.carwashAdmin.repo.CarRepo;
import io.carwashmanagement.carwashAdmin.services.CarService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CarServiceImpl implements CarService {

	@Autowired
	CarRepo carrepo;

	@Override
	public List<CarModelAdmin> getAllcars() {
		return carrepo.findAll();
	}

}
