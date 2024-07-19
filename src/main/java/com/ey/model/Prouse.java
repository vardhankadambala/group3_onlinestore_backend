package com.ey.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "prouse1")
public class Prouse {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "user_name")
	private String userName;
	
	@Column(name = "pro_name")
	private String proName;

	@Column(name = "pro_qty")
	private Integer proQty;
	
	@Column(name = "pro_price")
	private Integer proPrice;

	public Prouse() {
		
	}

	public Prouse(long id, String userName, String proName, Integer proQty, Integer proPrice) {
		super();
		this.id = id;
		this.userName = userName;
		this.proName = proName;
		this.proQty = proQty;
		this.proPrice = proPrice;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getProName() {
		return proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}

	public Integer getProQty() {
		return proQty;
	}

	public void setProQty(Integer proQty) {
		this.proQty = proQty;
	}

	public Integer getProPrice() {
		return proPrice;
	}

	public void setProPrice(Integer proPrice) {
		this.proPrice = proPrice;
	}

	
	
}
