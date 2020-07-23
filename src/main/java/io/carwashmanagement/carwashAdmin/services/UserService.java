package io.carwashmanagement.carwashAdmin.services;

import io.carwashmanagement.carwashAdmin.model.UserProfile;

import java.util.List;


public interface UserService {

	public UserProfile createUserProfile(UserProfile request);

	public List<UserProfile> getActiveCustomService(String status);

}
