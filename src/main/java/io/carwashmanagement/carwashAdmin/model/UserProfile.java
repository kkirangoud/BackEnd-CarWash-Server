package io.carwashmanagement.carwashAdmin.model;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class UserProfile {

	@Id
	private String id;

	private String userId;

	private String FirstName;

	private String emailId;

	private String LastName;

	private Long mobileNum;

	private String status;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public Long getMobileNum() {
		return mobileNum;
	}

	public void setMobileNum(Long mobileNum) {
		this.mobileNum = mobileNum;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public UserProfile(String id, String userId, String firstName,
			String emailId, String lastName, Long mobileNum, String status) {
		super();
		this.id = id;
		this.userId = userId;
		FirstName = firstName;
		this.emailId = emailId;
		LastName = lastName;
		this.mobileNum = mobileNum;
		this.status = status;
	}
	public UserProfile() {}

	@Override
	public String toString() {
		return "UserProfile [id=" + id + ", userId=" + userId + ", FirstName="
				+ FirstName + ", emailId=" + emailId + ", LastName=" + LastName
				+ ", mobileNum=" + mobileNum + ", status=" + status + "]";
	}
	
}
