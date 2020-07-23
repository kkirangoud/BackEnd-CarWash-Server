package io.carwashmanagement.carwashAdmin.controller;

import io.carwashmanagement.carwashAdmin.model.AddOnModelAdmin;
import io.carwashmanagement.carwashAdmin.model.AddOnPutRequestAdmin;
import io.carwashmanagement.carwashAdmin.model.MessageResponse;
import io.carwashmanagement.carwashAdmin.repo.AddOnRepo;
import io.carwashmanagement.carwashAdmin.services.AddOnService;
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
public class AddOnController {
	@Autowired
	AddOnRepo addonrepo;

	@Autowired
	AddOnService addonservice;

	@ApiOperation(value = "Get All Add On", response = ResponseEntity.class)
	@RequestMapping(value = "/GetAllAddOnList", method = RequestMethod.GET)
	public ResponseEntity<List<AddOnModelAdmin>> getAllAddOnList() {
		return new ResponseEntity<>(addonrepo.findAll(), HttpStatus.OK);
	}

	@ApiOperation(value = "Add One Add On", response = ResponseEntity.class)
	@RequestMapping(value = "/AddOneAddOnList", method = RequestMethod.POST)
	public ResponseEntity<MessageResponse> addOnOne(
			@RequestBody AddOnModelAdmin addonmodel) {

		if (addonrepo.findById(addonmodel.getAddonid()).isPresent()) {
			return ResponseEntity.badRequest().body(
					new MessageResponse("user is already created"));
		}
		AddOnModelAdmin addonm = addonservice.createAddOnList(addonmodel);
		String id = addonm.getAddonid();
		String message = id + " addon created";
		return new ResponseEntity<>(new MessageResponse(message),
				HttpStatus.CREATED);

	}

	@ApiOperation(value = "Get Add On By Id", response = ResponseEntity.class)
	@RequestMapping(value = "/GetAddOnId/{addonid}", method = RequestMethod.GET)
	public ResponseEntity<AddOnModelAdmin> getAddOnById(@PathVariable String addonid) {
		Optional<AddOnModelAdmin> addresponse = addonrepo.findById(addonid);
		AddOnModelAdmin addonmodel = addresponse.get();
		String status = addonmodel.getStatus();
		if (addresponse.isPresent() && status.equalsIgnoreCase("Active")) {
			return new ResponseEntity<>(addresponse.get(), HttpStatus.CREATED);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@ApiOperation(value = "Edit Add On By Id", response = ResponseEntity.class)
	@RequestMapping(value = "/UpdateAddOnId/{addonid}", method = RequestMethod.PUT)
	public ResponseEntity<AddOnModelAdmin> updateAddOnById(
			@PathVariable String addonid, AddOnPutRequestAdmin addonputrequest) {
		Optional<AddOnModelAdmin> addreponse = addonrepo.findById(addonid);
		if (addreponse.isPresent()) {
			AddOnModelAdmin addonmodel = addreponse.get();
			addonmodel.setName(addonputrequest.getName());
			addonmodel.setPrice(addonputrequest.getPrice());
			return new ResponseEntity<>(addonrepo.save(addonmodel),
					HttpStatus.CREATED);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
	}

}
