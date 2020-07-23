package io.carwashmanagement.carwashAdmin.model;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class CarWasherModel {
	@Id
	private int id;
	private int cId;
	private String name;
	private String status;
	private float ratings;
	private String reviews;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getcId() {
		return cId;
	}
	public void setcId(int cId) {
		this.cId = cId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public float getRatings() {
		return ratings;
	}
	public void setRatings(float ratings) {
		this.ratings = ratings;
	}
	public String getReviews() {
		return reviews;
	}
	public void setReviews(String reviews) {
		this.reviews = reviews;
	}
	public CarWasherModel(int id, int cId, String name, String status,
			float ratings, String reviews) {
		super();
		this.id = id;
		this.cId = cId;
		this.name = name;
		this.status = status;
		this.ratings = ratings;
		this.reviews = reviews;
	}
	public CarWasherModel() {}
	@Override
	public String toString() {
		return "CarWasherModel [id=" + id + ", cId=" + cId + ", name=" + name
				+ ", status=" + status + ", ratings=" + ratings + ", reviews="
				+ reviews + "]";
	}
	
}
