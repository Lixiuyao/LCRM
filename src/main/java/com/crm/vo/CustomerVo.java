package com.crm.vo;

public class CustomerVo {
	private Integer id;
	private String name;
	private Integer totalprice;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(Integer totalprice) {
		this.totalprice = totalprice;
	}
	@Override
	public String toString() {
		return "CustomerVo [id=" + id + ", name=" + name + ", totalprice=" + totalprice + "]";
	}
	
}
