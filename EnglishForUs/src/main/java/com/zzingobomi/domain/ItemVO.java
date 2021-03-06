package com.zzingobomi.domain;

import java.util.Date;

public class ItemVO {
	
	private Integer idx;
	private String title_ko;
	private String title_en;
	private String addinfo;
	private Date regdate;
	private String regidemail;
	private String regdisplayname;
	private Integer replycnt;
	private Integer likecnt;
	private Integer badcnt;
	private Integer impressioncnt;
	
	// 요청 유저의 상태값 
	private boolean likestate = false;
	private boolean badstate = false;
	
	public Integer getIdx() {
		return idx;
	}
	public void setIdx(Integer idx) {
		this.idx = idx;
	}
	public String getTitle_ko() {
		return title_ko;
	}
	public void setTitle_ko(String title_ko) {
		this.title_ko = title_ko;
	}
	public String getTitle_en() {
		return title_en;
	}
	public void setTitle_en(String title_en) {
		this.title_en = title_en;
	}
	public String getAddinfo() {
		return addinfo;
	}
	public void setAddinfo(String addinfo) {
		this.addinfo = addinfo;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}	
	public String getRegidemail() {
		return regidemail;
	}
	public void setRegidemail(String regidemail) {
		this.regidemail = regidemail;
	}
	public String getRegdisplayname() {
		return regdisplayname;
	}
	public void setRegdisplayname(String regdisplayname) {
		this.regdisplayname = regdisplayname;
	}
	public Integer getReplycnt() {
		return replycnt;
	}
	public void setReplycnt(Integer replycnt) {
		this.replycnt = replycnt;
	}
	public Integer getLikecnt() {
		return likecnt;
	}
	public void setLikecnt(Integer likecnt) {
		this.likecnt = likecnt;
	}
	public Integer getBadcnt() {
		return badcnt;
	}
	public void setBadcnt(Integer badcnt) {
		this.badcnt = badcnt;
	}
	public Integer getImpressioncnt() {
		return impressioncnt;
	}
	public void setImpressioncnt(Integer impressioncnt) {
		this.impressioncnt = impressioncnt;
	}	
	
	// 요청 유저의 상태값
	public boolean isLikestate() {
		return likestate;
	}
	public void setLikestate(boolean likestate) {
		this.likestate = likestate;
	}
	public boolean isBadstate() {
		return badstate;
	}
	public void setBadstate(boolean badstate) {
		this.badstate = badstate;
	}
	
	@Override
	public String toString() {
		return "ItemVO [idx=" + idx + ", title_ko=" + title_ko + ", title_en=" + title_en + ", addinfo=" + addinfo
				+ ", regdate=" + regdate + ", regidemail=" + regidemail + ", regdisplayname=" + regdisplayname
				+ ", replycnt=" + replycnt + ", likecnt=" + likecnt + ", badcnt=" + badcnt + ", impressioncnt="
				+ impressioncnt + ", likestate=" + likestate + ", badstate=" + badstate + "]";
	}	
}
