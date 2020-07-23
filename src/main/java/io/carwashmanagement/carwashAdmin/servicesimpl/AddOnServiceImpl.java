package io.carwashmanagement.carwashAdmin.servicesimpl;

import io.carwashmanagement.carwashAdmin.model.AddOnModelAdmin;
import io.carwashmanagement.carwashAdmin.repo.AddOnRepo;
import io.carwashmanagement.carwashAdmin.services.AddOnService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class AddOnServiceImpl implements AddOnService {
	
	@Autowired
	AddOnRepo addonrepo;

	@Override
	public AddOnModelAdmin createAddOnList(AddOnModelAdmin addonmodel) {
		// TODO Auto-generated method stub
		return addonrepo.save(addonmodel);
	}

}
