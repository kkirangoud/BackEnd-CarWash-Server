package io.carwashmanagement.carwashAdmin.controller;

import io.carwashmanagement.carwashAdmin.model.MessageResponse;
import io.carwashmanagement.carwashAdmin.model.ServicePlan;
import io.carwashmanagement.carwashAdmin.model.ServicePlanPutRequest;
import io.carwashmanagement.carwashAdmin.repo.ServicePlanRepo;
import io.carwashmanagement.carwashAdmin.services.ServicePlanService;
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
@RequestMapping(value = "/ServicePlanApi")
public class ServicePlanController {

	@Autowired
	ServicePlanService serviceplanservice;
	
	@Autowired
	ServicePlanRepo serviceplanrepo;

	@ApiOperation(value = "Get All Services plan", response = ResponseEntity.class)
	@RequestMapping(value = "/GetAll", method = RequestMethod.GET)
	public ResponseEntity<List<ServicePlan>> getAllServicePlansList() {
		return new ResponseEntity<>(serviceplanservice.getAllServicePlans(),
				HttpStatus.OK);
	}
	@ApiOperation(value = "Get Service Plans By Id", response = ResponseEntity.class)
	@RequestMapping(value="/GetServicePlanById/{id}", method = RequestMethod.GET)
	public ResponseEntity<ServicePlan> getServicePlansById(@PathVariable("id") String id){
		Optional<ServicePlan> sresponse = serviceplanrepo.findAllById(id);
		ServicePlan servplan = sresponse.get();
		String status = servplan.getStatus();
		if(sresponse.isPresent()&&status.equalsIgnoreCase("Active")){
			return new ResponseEntity<>(sresponse.get(), HttpStatus.OK);
		}
		else
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@ApiOperation(value = "Add one ServicePlan", response = ResponseEntity.class)
	@RequestMapping(value = "/AddToList/{serviceplanid}", method = RequestMethod.POST)
	public ResponseEntity<MessageResponse> addOneServicePlan(
			@RequestBody ServicePlan serviceplan) {
		if(serviceplanrepo.findAllById(serviceplan.getId()).isPresent()){
			return ResponseEntity.badRequest().body(
					new MessageResponse("user is already created"));
		}
		ServicePlan splan = serviceplanservice.createServicePlan(serviceplan);
		String id = splan.getServiceplanid();
		String respo = id + "  successfullyCreated";
		return new ResponseEntity<>(new MessageResponse(respo),
				HttpStatus.CREATED);

	}
	@ApiOperation(value = "Edit one ServicePlan", response = ResponseEntity.class)
	@RequestMapping(value = "/UpdateServicePlan/{id}", method = RequestMethod.PUT)
	public ResponseEntity<ServicePlan> updateServicePlan(@PathVariable("id") String id,@RequestBody ServicePlanPutRequest serviceplanputrequest ){
		Optional<ServicePlan> respo = serviceplanrepo.findAllById(id);
		if(respo.isPresent()){
			ServicePlan splan = respo.get();
			splan.setPrice(serviceplanputrequest.getPrice());
			splan.setSpname(serviceplanputrequest.getSpname());
		return new ResponseEntity<>(serviceplanrepo.save(splan), HttpStatus.OK);
		}
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

}
