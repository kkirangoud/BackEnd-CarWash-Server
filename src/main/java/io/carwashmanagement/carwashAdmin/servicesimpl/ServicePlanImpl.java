package io.carwashmanagement.carwashAdmin.servicesimpl;

import io.carwashmanagement.carwashAdmin.model.ServicePlan;
import io.carwashmanagement.carwashAdmin.repo.ServicePlanRepo;
import io.carwashmanagement.carwashAdmin.services.ServicePlanService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class ServicePlanImpl implements ServicePlanService {

	@Autowired
	ServicePlanRepo serviceplanrepo;

	@Override
	public List<ServicePlan> getAllServicePlans() {
		return serviceplanrepo.findAll();
	}

	@Override
	public ServicePlan createServicePlan(ServicePlan serviceplan) {
				
		return serviceplanrepo.save(serviceplan);
	}

}
