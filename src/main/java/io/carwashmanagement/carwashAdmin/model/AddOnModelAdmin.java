package io.carwashmanagement.carwashAdmin.model;

import javax.persistence.Entity;
import javax.persistence.Id;


//@Data
@Entity
public class AddOnModelAdmin {
	@Id
	private String addonid;
	private String name;
	private Double price;
	private String status;
	public String getAddonid() {
		return addonid;
	}
	public void setAddonid(String addonid) {
		this.addonid = addonid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public AddOnModelAdmin(String addonid, String name, Double price, String status) {
		super();
		this.addonid = addonid;
		this.name = name;
		this.price = price;
		this.status = status;
	}
	public AddOnModelAdmin() {}
	@Override
	public String toString() {
		return "AddOnModel [addonid=" + addonid + ", name=" + name + ", price="
				+ price + ", status=" + status + "]";
	}
	
}
