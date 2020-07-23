package io.carwashmanagement.carwashAdmin.controller;

import io.carwashmanagement.carwashAdmin.model.MessageResponse;
import io.carwashmanagement.carwashAdmin.model.PromoCodeModel;
import io.carwashmanagement.carwashAdmin.model.PromoCodePutRequest;
import io.carwashmanagement.carwashAdmin.repo.PromoCodeRepo;
import io.carwashmanagement.carwashAdmin.services.PromoCodeService;
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
@RequestMapping(value = "/PromoCodes")
public class PromoCodeController {
	
	@Autowired
	PromoCodeRepo promocoderepo;
	
	@Autowired
	PromoCodeService promocodeservice;
		
	
	@ApiOperation(value = "Get All PromoCodes plan", response = ResponseEntity.class)
	@RequestMapping(value = "/GetAll", method = RequestMethod.GET)
	public ResponseEntity<List<PromoCodeModel>> getAllPromoCodes(){
		return new ResponseEntity<>(promocoderepo.findAll(), HttpStatus.OK);
	}
	
	@ApiOperation(value = "Add PromoCodes plan", response = ResponseEntity.class)
	@RequestMapping(value = "/AddPromoCode", method = RequestMethod.POST)
	public ResponseEntity<MessageResponse> addPromoCode(@RequestBody PromoCodeModel promocodemodel){
		//Optional<PromoCodeModel> promorespo = promocoderepo.findAllById(promocodemodel.getPromocodeid());
		Optional<PromoCodeModel> promorespo =	promocoderepo.findById(promocodemodel.getPromocode());
			if(promorespo.isPresent()){
				return ResponseEntity.badRequest().body(new MessageResponse("already promocode is available"));
			}
			PromoCodeModel promocode = 	promocodeservice.createPromoCode();
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@ApiOperation(value = "Edit PromoCodes plan", response = ResponseEntity.class)
	@RequestMapping(value = "/UpdatePromoCode/{promocodeid}", method = RequestMethod.PUT)
	public ResponseEntity<PromoCodeModel> updatePromoCode(@PathVariable("promocodeid") String promocodeid, PromoCodePutRequest promocodeputrequest){
		Optional<PromoCodeModel> promorespo = promocoderepo.findById(promocodeid);
		if(promorespo.isPresent()){
			PromoCodeModel  promocodemod = promorespo.get();
			promocodemod.setPromocode(promocodeputrequest.getPromocode());
			promocodemod.setPercentage(promocodeputrequest.getPercentage());
			return new ResponseEntity<>(promocoderepo.save(promocodemod), HttpStatus.CREATED);
		}else
		return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
	}
}
