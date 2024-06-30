package com.mystory001.domain;

import java.sql.Timestamp;

public class MemberDTO {
	
 	private String id;
 	private String pw;
 	private String name;
 	private Timestamp date;

 	@Override
	public String toString() {
		return "MemberDTO [date=" + date + ", id=" + id + ", name=" + name + ", pw=" + pw + ", toString()="
				+ super.toString() + "]";
	}
 	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
 	
}
