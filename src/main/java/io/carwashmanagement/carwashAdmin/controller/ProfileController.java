package io.carwashmanagement.carwashAdmin.controller;

import io.carwashmanagement.carwashAdmin.model.MessageResponse;
import io.carwashmanagement.carwashAdmin.model.ProfilePutRequest;
import io.carwashmanagement.carwashAdmin.model.UserProfile;
import io.carwashmanagement.carwashAdmin.repo.UserRepo;
import io.carwashmanagement.carwashAdmin.services.UserService;
import io.swagger.annotations.ApiOperation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


//import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api")
public class ProfileController {

	@Autowired
	private UserRepo userrepo;

	@Autowired
	private UserService userservice;

	@RequestMapping(value = "/profiles", method = RequestMethod.GET)
	public ResponseEntity<List<UserProfile>> getUserProfiles() {
		return new ResponseEntity<>(userrepo.findAll(), HttpStatus.OK);
	}

	@ApiOperation(value = "List all profiles from carwash using id", response = ResponseEntity.class)
	@RequestMapping(value = "/getProfile/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserProfile> getProfileById(
			@PathVariable("id") String id) {
		Optional<UserProfile> response = userrepo.findById(id);
		UserProfile userprofile = response.get();
		String status = userprofile.getStatus();
		if (response.isPresent() && (status.equalsIgnoreCase("ACTIVE"))) {
			return new ResponseEntity<>(response.get(), HttpStatus.OK);
		} else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@ApiOperation(value = "Add one resource to carwash api", response = ResponseEntity.class)
	@RequestMapping(value = "/createProfile", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MessageResponse> createProfile(
			@RequestBody UserProfile userprofile) {

		try {

			if (userrepo.existsByUserId(userprofile.getUserId())) {
				return ResponseEntity.badRequest()
						.body(new MessageResponse(
								"Error: User is already created !"));
			}
			UserProfile response = userservice.createUserProfile(userprofile);
			String id = response.getId();
			String message = id + "  successfully created";
			return new ResponseEntity<>(new MessageResponse(message),
					HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
	}

	@ApiOperation(value = "Delete one resource from carwash", response = ResponseEntity.class)
	@RequestMapping(value = "/deleteprofile/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserProfile> deleteProfileById(
			@PathVariable("id") String id) {
		try {
			Optional<UserProfile> response = userrepo.findById(id);
			String deleteList = response.get().getId();
			userrepo.deleteById(deleteList);
			String message = deleteList + "Successfully deleted profile";
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}

	}

	
	  @RequestMapping(value = "/updateprofile/{id}", method =
	  RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE) public
	  ResponseEntity<UserProfile> updateProfileById( @PathVariable("id") String id, ProfilePutRequest putrequest) {
	  Optional<UserProfile> response = userrepo.findById(id);
	  
	  if (response.isPresent()) {
		  UserProfile userprofile = response.get();
		  
	  userprofile.setFirstName(putrequest.getFirstName());;
	  userprofile.setLastName(putrequest.getLastName());
	  userprofile.setEmailId(putrequest.getEmailId());
	  userprofile.setMobileNum(putrequest.getMobileNum());
	  return new ResponseEntity<>(userrepo.save(userprofile), HttpStatus.OK); } 
	  else
	  return new ResponseEntity<>(HttpStatus.NOT_FOUND); }
	  
	  
}
