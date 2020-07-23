package io.carwashmanagement.carwashAdmin.model;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CarModelAdmin {
	@Id
	private int carid;
	private String carname;
	private String car_type;
	private String colour;
	private String reg_number;
	private String imageUrl;
	private String status;
	public int getCarid() {
		return carid;
	}
	public void setCarid(int carid) {
		this.carid = carid;
	}
	public String getCarname() {
		return carname;
	}
	public void setCarname(String carname) {
		this.carname = carname;
	}
	public String getCar_type() {
		return car_type;
	}
	public void setCar_type(String car_type) {
		this.car_type = car_type;
	}
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	public String getReg_number() {
		return reg_number;
	}
	public void setReg_number(String reg_number) {
		this.reg_number = reg_number;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public CarModelAdmin(int carid, String carname, String car_type, String colour,
			String reg_number, String imageUrl, String status) {
		super();
		this.carid = carid;
		this.carname = carname;
		this.car_type = car_type;
		this.colour = colour;
		this.reg_number = reg_number;
		this.imageUrl = imageUrl;
		this.status = status;
	}
	public CarModelAdmin() {}
	@Override
	public String toString() {
		return "CarModel [carid=" + carid + ", carname=" + carname
				+ ", car_type=" + car_type + ", colour=" + colour
				+ ", reg_number=" + reg_number + ", imageUrl=" + imageUrl
				+ ", status=" + status + "]";
	}
	
}
