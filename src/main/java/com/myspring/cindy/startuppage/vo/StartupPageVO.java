package com.myspring.cindy.startuppage.vo;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component("startuppagevo")
public class StartupPageVO {
	int no;
	String compid;
	String manuid;
	Date reqquote;
	int Quotestatus;
	String compname;
	String manuname;
	int id;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getCompid() {
		return compid;
	}
	public void setCompid(String compid) {
		this.compid = compid;
	}
	public String getManuid() {
		return manuid;
	}
	public void setManuid(String manuid) {
		this.manuid = manuid;
	}
	public Date getReqquote() {
		return reqquote;
	}
	public void setReqquote(Date reqquote) {
		this.reqquote = reqquote;
	}
	public int getQuotestatus() {
		return Quotestatus;
	}
	public void setQuotestatus(int quotestatus) {
		Quotestatus = quotestatus;
	}
	public String getCompname() {
		return compname;
	}
	public void setCompname(String compname) {
		this.compname = compname;
	}
	public String getManuname() {
		return manuname;
	}
	public void setManuname(String manuname) {
		this.manuname = manuname;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

}
