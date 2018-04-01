package com.crm.vo;

public class CstmrVo {
	private String level;
	private Integer count;
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "CstmrVo [level=" + level + ", count=" + count + "]";
	}
	
}
