package com.zzingobomi.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zzingobomi.domain.Criteria;
import com.zzingobomi.domain.ReplyVO;
import com.zzingobomi.dto.BadRecordDTO;
import com.zzingobomi.dto.LikeRecordDTO;
import com.zzingobomi.persistence.ItemDAO;
import com.zzingobomi.persistence.ReplyDAO;

@Service
public class ReplyServiceImpl implements ReplyService {
	
	@Inject
	private ReplyDAO replyDAO;
	
	@Inject
	private ItemDAO itemDAO;

	@Transactional
	@Override
	public void addReply(ReplyVO vo) throws Exception {
		replyDAO.create(vo);
		itemDAO.updateReplyCnt(vo.getItemidx(), 1);
	}

	@Override
	public List<ReplyVO> listReply(Integer itemidx, String reqIdEmail) throws Exception {
		
		List<ReplyVO> listReply = replyDAO.list(itemidx);
		
		if(reqIdEmail.equals("")) {				// 비로그인 유저
			// 기본값이 false, false(like, bad) 이므로 아무것도 안함
		} else {
			for (ReplyVO replyVO : listReply) {
				
				LikeRecordDTO likeRecordDTO = replyDAO.getReplyLikeRecordDTO(replyVO.getIdx(), reqIdEmail);
				if(likeRecordDTO == null) {
					replyVO.setLikestate(false);
				} else {
					if(likeRecordDTO.getBlike() == 1) {
						replyVO.setLikestate(true);
					} else {
						replyVO.setLikestate(false);
					}
				}
				
				BadRecordDTO badRecordDTO = replyDAO.getReplyBadRecordDTO(replyVO.getIdx(), reqIdEmail);
				if(badRecordDTO == null) {
					replyVO.setBadstate(false);
				} else {
					if(badRecordDTO.getBbad() == 1) {
						replyVO.setBadstate(true);
					} else {
						replyVO.setBadstate(false);
					}
				}
			}
		}		
		
		return listReply;
	}

	@Override
	public void modifyReply(ReplyVO vo) throws Exception {
		replyDAO.update(vo);
	}

	@Transactional
	@Override
	public void removeReply(Integer idx) throws Exception {
		int itemidx = replyDAO.getItemIdx(idx);
		replyDAO.delete(idx);
		itemDAO.updateReplyCnt(itemidx, -1);
	}

	@Override
	public List<ReplyVO> listReplyPage(Integer itemidx, Criteria cri) throws Exception {
		return replyDAO.listPage(itemidx, cri);
	}

	@Override
	public int count(Integer itemidx) throws Exception {
		return replyDAO.count(itemidx);
	}

	@Override
	public void likeReply(Integer idx, String regIdEmail) throws Exception {
		replyDAO.updateReplyLikeCnt(idx, 1);
		replyDAO.recordReplyLike(idx, regIdEmail, "1");		
	}

	@Override
	public void likeCancelReply(Integer idx, String regIdEmail) throws Exception {
		replyDAO.updateReplyLikeCnt(idx, -1);
		replyDAO.recordReplyLike(idx, regIdEmail, "0");		
	}

	@Override
	public void badReply(Integer idx, String regIdEmail) throws Exception {
		replyDAO.updateReplyBadCnt(idx, 1);
		replyDAO.recordReplyBad(idx, regIdEmail, "1");		
	}

	@Override
	public void badCancelReply(Integer idx, String regIdEmail) throws Exception {
		replyDAO.updateReplyBadCnt(idx, -1);
		replyDAO.recordReplyBad(idx, regIdEmail, "0");		
	}

	@Override
	public ReplyVO readReplyWithState(Integer idx, String regIdEmail) throws Exception {
		ReplyVO replyVO = replyDAO.read(idx);
		
		if(regIdEmail.equals("")) {				// 비로그인 유저
			replyVO.setLikestate(false);
			replyVO.setBadstate(false);
		} else {								// 로그인 유저
			LikeRecordDTO likeRecordDTO = replyDAO.getReplyLikeRecordDTO(replyVO.getIdx(), regIdEmail);
			if(likeRecordDTO == null) {
				replyVO.setLikestate(false);
			} else {
				if(likeRecordDTO.getBlike() == 1) {
					replyVO.setLikestate(true);
				} else {
					replyVO.setLikestate(false);
				}
			}
			
			BadRecordDTO badRecordDTO = replyDAO.getReplyBadRecordDTO(replyVO.getIdx(), regIdEmail);
			if(badRecordDTO == null) {
				replyVO.setBadstate(false);
			} else {
				if(badRecordDTO.getBbad() == 1) {
					replyVO.setBadstate(true);
				} else {
					replyVO.setBadstate(false);
				}
			}
		}
		
		return replyVO;
	}
	
	

	/*
	@Override
	public LikeBadStateDTO getReplyLikeStateAndCount(Integer idx, String regIdEmail) throws Exception {
		
		LikeBadStateDTO stateDTO = new LikeBadStateDTO();
		
		LikeRecordDTO likeRecordDTO = replyDAO.getReplyLikeRecordDTO(idx, regIdEmail);
		if(likeRecordDTO == null) {
			stateDTO.setLikestate("0");
		} else {
			stateDTO.setLikestate(String.valueOf(likeRecordDTO.getBlike()));
		}
		
		ReplyVO vo = replyDAO.read(idx);
		if(vo != null) {
			stateDTO.setLikecount(vo.getLikecnt());
		}
		
		return stateDTO;
	}

	@Override
	public LikeBadStateDTO getReplyBadStateAndCount(Integer idx, String regIdEmail) throws Exception {
		
		LikeBadStateDTO stateDTO = new LikeBadStateDTO();
		
		BadRecordDTO badRecordDTO = replyDAO.getReplyBadRecordDTO(idx, regIdEmail);
		if(badRecordDTO == null) {
			stateDTO.setBadstate("0");
		} else {
			stateDTO.setBadstate(String.valueOf(badRecordDTO.getBbad()));
		}
		
		ReplyVO vo = replyDAO.read(idx);
		if(vo != null) {
			stateDTO.setBadcount(vo.getBadcnt());
		}		
		
		return stateDTO;
	}
	*/
}
