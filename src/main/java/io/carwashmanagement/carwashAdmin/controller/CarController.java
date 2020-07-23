package io.carwashmanagement.carwashAdmin.controller;

import io.carwashmanagement.carwashAdmin.model.CarModelAdmin;
import io.carwashmanagement.carwashAdmin.repo.CarRepo;
import io.carwashmanagement.carwashAdmin.services.CarService;
import io.swagger.annotations.ApiOperation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CarController {

	@Autowired
	CarService carservice;
	
	@Autowired
	CarRepo carrepo;

	
	@ApiOperation(value = "Get All Cars Details", response = ResponseEntity.class)
	@RequestMapping(value = "/GetAllCars", method = RequestMethod.GET)
	public ResponseEntity<List<CarModelAdmin>> getAllCars() {
		return new ResponseEntity<>(carservice.getAllcars(), HttpStatus.OK);
	}
	
	@ApiOperation(value = "Add Car to List ", response = ResponseEntity.class)
	@RequestMapping(value = "/AddOneCar", method = RequestMethod.POST)
	public ResponseEntity<CarModelAdmin> addOneCar(@RequestBody CarModelAdmin carmodel ){
		return new ResponseEntity<>(carrepo.save(carmodel),HttpStatus.OK);
	}
	
	/*@ApiOperation(value = "Get Car by Status ", response = ResponseEntity.class)
	@RequestMapping(value = "/GetCarByStatus/{carid}", method = RequestMethod.GET)
	public ResponseEntity<CarModel> getCarByStatus(@PathVariable int carid){
		Optional<CarModel> carresponse = carrepo.findById(carid);
		CarModel carres=carresponse.get();
		String status = carres.getStatus();
		if(carresponse.isPresent()&& (status.equalsIgnoreCase("Active"))){
			return new ResponseEntity<>(carresponse.get(), HttpStatus.OK);
		}
		else
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}*/
}
