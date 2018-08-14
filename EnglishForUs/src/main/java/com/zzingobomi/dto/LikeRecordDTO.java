package com.zzingobomi.dto;

import java.util.Date;

public class LikeRecordDTO {
	
	private long idx;
	private int itemidx;
	private String regidemail;
	private Date regdate;
	private int blike;
	
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
	public int getBlike() {
		return blike;
	}
	public void setBlike(int blike) {
		this.blike = blike;
	}
	
	@Override
	public String toString() {
		return "LikeRecordDTO [idx=" + idx + ", itemidx=" + itemidx + ", regidemail=" + regidemail + ", regdate="
				+ regdate + ", blike=" + blike + "]";
	}
}
