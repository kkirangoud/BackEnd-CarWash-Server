package io.carwashmanagement.carwashAdmin.services;

import io.carwashmanagement.carwashAdmin.model.ServicePlan;

import java.util.List;


public interface ServicePlanService {
	public List<ServicePlan> getAllServicePlans();

	public ServicePlan createServicePlan(ServicePlan serviceplan);

}
