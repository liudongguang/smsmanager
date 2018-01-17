package com.peony.api.vo.search;

import java.util.Date;

public class SearchMsg {
	private String phone;
	private Date start;
	private Date end;

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public SearchMsg() {
		super();
	}

	public SearchMsg(String phone, Date start, Date end) {
		super();
		this.phone = phone;
		this.start = start;
		this.end = end;
	}

}
