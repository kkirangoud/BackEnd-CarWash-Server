package io.carwashmanagement.carwashAdmin.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ServicePlan {
	@Id
	private String id;
	private String serviceplanid;
	private String spname;
	private Double price;
	private String status;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getServiceplanid() {
		return serviceplanid;
	}

	public void setServiceplanid(String serviceplanid) {
		this.serviceplanid = serviceplanid;
	}

	public String getSpname() {
		return spname;
	}

	public void setSpname(String spname) {
		this.spname = spname;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	
	/**
	 * @param id
	 * @param serviceplanid
	 * @param spname
	 * @param price
	 * @param status
	 */
	public ServicePlan(String id, String serviceplanid, String spname,
			Double price, String status) {
		super();
		this.id = id;
		this.serviceplanid = serviceplanid;
		this.spname = spname;
		this.price = price;
		this.status = status;
	}

	public ServicePlan() {
	}

	@Override
	public String toString() {
		return "ServicePlan [id=" + id + ", serviceplanid=" + serviceplanid
				+ ", spname=" + spname + ", price=" + price + ", status="
				+ status + "]";
	}

}
