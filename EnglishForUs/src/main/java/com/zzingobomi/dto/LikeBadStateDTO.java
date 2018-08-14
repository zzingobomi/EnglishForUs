package com.zzingobomi.dto;

public class LikeBadStateDTO {
	
	private String likestate;
	private int likecount;
	private String badstate;
	private int badcount;
	
	public String getLikestate() {
		return likestate;
	}
	public void setLikestate(String likestate) {
		this.likestate = likestate;
	}
	public int getLikecount() {
		return likecount;
	}
	public void setLikecount(int likecount) {
		this.likecount = likecount;
	}
	public String getBadstate() {
		return badstate;
	}
	public void setBadstate(String badstate) {
		this.badstate = badstate;
	}
	public int getBadcount() {
		return badcount;
	}
	public void setBadcount(int badcount) {
		this.badcount = badcount;
	}
	
	@Override
	public String toString() {
		return "LikeBadStateDTO [likestate=" + likestate + ", likecount=" + likecount + ", badstate=" + badstate
				+ ", badcount=" + badcount + "]";
	}
	
}
