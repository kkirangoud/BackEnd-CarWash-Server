package io.carwashmanagement.carwashAdmin.servicesimpl;

import io.carwashmanagement.carwashAdmin.model.UserProfile;
import io.carwashmanagement.carwashAdmin.repo.UserRepo;
import io.carwashmanagement.carwashAdmin.services.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userrepo;

	public UserProfile createUserProfile(UserProfile request) {
		String status = "ACTIVE";
		request.setStatus(status);

		return userrepo.save(request);

	}

	public List<UserProfile> getActiveCustomService(String status) {
		return userrepo.existsByStatus(status);
	}

}
