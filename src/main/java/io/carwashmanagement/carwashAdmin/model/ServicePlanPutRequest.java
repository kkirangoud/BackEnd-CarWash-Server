package io.carwashmanagement.carwashAdmin.model;

public class ServicePlanPutRequest {
	private String spname;
	private Double price;
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
	 * @param spname
	 * @param price
	 */
	public ServicePlanPutRequest(String spname, Double price) {
		super();
		this.spname = spname;
		this.price = price;
	}
	public ServicePlanPutRequest() {}

	@Override
	public String toString() {
		return "ServicePlanPutRequest [spname=" + spname + ", price=" + price
				+ "]";
	}
	
}
