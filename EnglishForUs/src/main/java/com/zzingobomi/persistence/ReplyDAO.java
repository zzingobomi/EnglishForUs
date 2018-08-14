package com.zzingobomi.persistence;

import java.util.List;

import com.zzingobomi.domain.Criteria;
import com.zzingobomi.domain.ReplyVO;
import com.zzingobomi.dto.BadRecordDTO;
import com.zzingobomi.dto.LikeRecordDTO;

public interface ReplyDAO {
	
	public List<ReplyVO> list(Integer itemidx) throws Exception;
		
	public void create(ReplyVO vo) throws Exception;
	
	public ReplyVO read(Integer idx) throws Exception;
	
	public void update(ReplyVO vo) throws Exception;
		
	public void delete(Integer idx) throws Exception;	
	
	public List<ReplyVO> listPage(Integer itemidx, Criteria cri) throws Exception;
		
	public int count(Integer itemidx) throws Exception; 
		
	public int getItemIdx(Integer idx) throws Exception;	
	
	public void updateReplyLikeCnt(Integer idx, int amount) throws Exception;
	
	public void updateReplyBadCnt(Integer idx, int amount) throws Exception;
	
	public void recordReplyLike(Integer idx, String regIdEmail, String bLike) throws Exception;
	
	public void recordReplyBad(Integer idx, String regIdEmail, String bBad) throws Exception;
	
	public LikeRecordDTO getReplyLikeRecordDTO(Integer idx, String regIdEmail) throws Exception;
	
	public BadRecordDTO getReplyBadRecordDTO(Integer idx, String regIdEmail) throws Exception;
}
