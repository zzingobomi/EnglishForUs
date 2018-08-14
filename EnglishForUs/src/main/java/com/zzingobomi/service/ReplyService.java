package com.zzingobomi.service;

import java.util.List;

import com.zzingobomi.domain.Criteria;
import com.zzingobomi.domain.ReplyVO;

public interface ReplyService {
	
	public void addReply(ReplyVO vo) throws Exception;
		
	public List<ReplyVO> listReply(Integer itemidx, String reqIdEmail) throws Exception;
		
	public void modifyReply(ReplyVO vo) throws Exception;
		
	public void removeReply(Integer idx) throws Exception;
		
	public List<ReplyVO> listReplyPage(Integer itemidx, Criteria cri) throws Exception;
	
	public int count(Integer itemidx) throws Exception; 
	
	public void likeReply(Integer idx, String regIdEmail) throws Exception;
	
	public void likeCancelReply(Integer idx, String regIdEmail) throws Exception;
	
	public void badReply(Integer idx, String regIdEmail) throws Exception;
	
	public void badCancelReply(Integer idx, String regIdEmail) throws Exception;
	
	public ReplyVO readReplyWithState(Integer idx, String regIdEmail) throws Exception;
	
	//public LikeBadStateDTO getReplyLikeStateAndCount(Integer idx, String regIdEmail) throws Exception;
	
	//public LikeBadStateDTO getReplyBadStateAndCount(Integer idx, String regIdEmail) throws Exception;
}
