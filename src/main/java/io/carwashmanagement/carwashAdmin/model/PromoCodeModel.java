package io.carwashmanagement.carwashAdmin.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PromoCodeModel {
	@Id
	private String promocodeid;
	private String promocode;
	private Integer percentage;
	
	
	public String getPromocodeid() {
		return promocodeid;
	}
	public void setPromocodeid(String promocodeid) {
		this.promocodeid = promocodeid;
	}
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
	public PromoCodeModel(String promocodeid, String promocode,
			Integer percentage) {
		super();
		this.promocodeid = promocodeid;
		this.promocode = promocode;
		this.percentage = percentage;
	}
	@Override
	public String toString() {
		return "PromoCodeModel [promocodeid=" + promocodeid + ", promocode="
				+ promocode + ", percentage=" + percentage + "]";
	}
	
}
