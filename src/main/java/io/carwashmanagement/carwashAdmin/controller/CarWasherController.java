package io.carwashmanagement.carwashAdmin.controller;

import io.carwashmanagement.carwashAdmin.model.CarWasherModel;
import io.carwashmanagement.carwashAdmin.repo.CarWasherRepo;
import io.swagger.annotations.ApiOperation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping(value="/carApi")
public class CarWasherController {
	@Autowired
	CarWasherRepo carwasherrepo;
	
	@ApiOperation(value = "Get All CarWasherDetails", response = ResponseEntity.class)
	@RequestMapping(value = "/washerDetails", method = RequestMethod.GET)
	public ResponseEntity<List<CarWasherModel>> getAllWashers(){
		return new ResponseEntity<>(carwasherrepo.findAll(), HttpStatus.OK);
	}
	
	@ApiOperation(value = "Add one CarWasher to carwash api", response = ResponseEntity.class)
	@RequestMapping(value = "/AddCarWasher", method = RequestMethod.POST)
	public ResponseEntity<CarWasherModel> createWasher(@RequestBody CarWasherModel carwasher){
		return new ResponseEntity<>(carwasherrepo.save(carwasher), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/GetCarWasherById/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> getCarWasherById(@PathVariable int id){
		Optional<CarWasherModel> washerresponse = carwasherrepo.findById(id);
		CarWasherModel carwasher=washerresponse.get();
		String status = carwasher.getStatus();
		if(washerresponse.isPresent()&& (status.equalsIgnoreCase("Active"))){
			return new ResponseEntity<>(washerresponse.get(), HttpStatus.OK);
		}
		else
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
