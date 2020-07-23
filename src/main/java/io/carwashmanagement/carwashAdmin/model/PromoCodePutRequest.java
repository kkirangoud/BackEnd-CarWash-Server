package io.carwashmanagement.carwashAdmin.model;


public class PromoCodePutRequest {
	private String promocode;
	private Integer percentage;
	public String getPromocode() {
		return promocode;
	}
	public void setPromocode(String promocode) {
		this.promocode = promocode;
	}
	public Integer getPercentage() {
		return percentage;
	}
	public void setPercentage(Integer percentage) {
		this.percentage = percentage;
	}
	public PromoCodePutRequest(String promocode, Integer percentage) {
		super();
		this.promocode = promocode;
		this.percentage = percentage;
	}
	public PromoCodePutRequest() {}
	@Override
	public String toString() {
		return "PromoCodePutRequest [promocode=" + promocode + ", percentage="
				+ percentage + "]";
	}
	
}
