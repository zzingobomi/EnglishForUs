package com.zzingobomi.dto;

import java.util.Date;

public class BadRecordDTO {
	
	private long idx;
	private int itemidx;
	private String regidemail;
	private Date regdate;
	private int bbad;
	
	public long getIdx() {
		return idx;
	}
	public void setIdx(long idx) {
		this.idx = idx;
	}
	public int getItemidx() {
		return itemidx;
	}
	public void setItemidx(int itemidx) {
		this.itemidx = itemidx;
	}
	public String getRegidemail() {
		return regidemail;
	}
	public void setRegidemail(String regidemail) {
		this.regidemail = regidemail;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public int getBbad() {
		return bbad;
	}
	public void setBbad(int bbad) {
		this.bbad = bbad;
	}
	
	@Override
	public String toString() {
		return "BadRecordDTO [idx=" + idx + ", itemidx=" + itemidx + ", regidemail=" + regidemail + ", regdate="
				+ regdate + ", bbad=" + bbad + "]";
	}
}
