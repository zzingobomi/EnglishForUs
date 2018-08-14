package com.zzingobomi.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.zzingobomi.domain.Criteria;
import com.zzingobomi.domain.ItemVO;
import com.zzingobomi.domain.SearchCriteria;
import com.zzingobomi.dto.BadRecordDTO;
import com.zzingobomi.dto.LikeRecordDTO;
import com.zzingobomi.persistence.ItemDAO;

@Service
public class ItemServiceImpl implements ItemService {
	
	@Inject
	private ItemDAO dao;

	@Override
	public void regist(ItemVO item) throws Exception {		
		dao.create(item);
	}

	@Override
	public ItemVO read(Integer idx) throws Exception {
		return dao.read(idx);
	}

	@Override
	public void modify(ItemVO item) throws Exception {
		dao.update(item);
	}

	@Override
	public void remove(Integer idx) throws Exception {
		dao.delete(idx);
	}

	@Override
	public List<ItemVO> myItems(String regIdEmail) throws Exception {
		return dao.myItems(regIdEmail);
	}

	@Override
	public List<ItemVO> listAll() throws Exception {
		return dao.listAll();
	}	
	
	@Override
	public List<ItemVO> listCriteria(Criteria cri) throws Exception {
		return dao.listCriteria(cri);
	}

	@Override
	public int listCountCriteria(Criteria cri) throws Exception {
		return dao.countPaging(cri);
	}
	
	@Override
	public List<ItemVO> listSearchCriteria(SearchCriteria cri) throws Exception {
		return dao.listSearch(cri);
	}
	
	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		return dao.listSearchCount(cri);
	}
	
	
	
	@Override
	public ItemVO oneRandomItem(String reqIdEmail) throws Exception {
		ItemVO itemVO = dao.chooseRandomItem();
		dao.updateImpressionCnt(itemVO.getIdx(), 1);	
		
		if(reqIdEmail.equals("")) {				// 비로그인 유저
			itemVO.setLikestate(false);
			itemVO.setBadstate(false);
		} else {								// 로그인 유저
			LikeRecordDTO likeRecordDTO = dao.geLikeRecordDTO(itemVO.getIdx(), reqIdEmail);
			if(likeRecordDTO == null) {
				itemVO.setLikestate(false);
			} else {
				if(likeRecordDTO.getBlike() == 1) {
					itemVO.setLikestate(true);
				} else {
					itemVO.setLikestate(false);
				}
			}
			
			BadRecordDTO badRecordDTO = dao.geBadRecordDTO(itemVO.getIdx(), reqIdEmail);
			if(badRecordDTO == null) {
				itemVO.setBadstate(false);
			} else {
				if(badRecordDTO.getBbad() == 1) {
					itemVO.setBadstate(true);
				} else {
					itemVO.setBadstate(false);
				}
			}
		}
		
		return itemVO;
	}
	
	@Override
	public void likeItem(Integer itemIdx, String regIdEmail) throws Exception {
		dao.updateLikeCnt(itemIdx, 1);
		dao.recordLike(itemIdx, regIdEmail, "1");
	}
	
	@Override
	public void likeCancelItem(Integer itemIdx, String regIdEmail) throws Exception {
		dao.updateLikeCnt(itemIdx, -1);
		dao.recordLike(itemIdx, regIdEmail, "0");
	}
	
	@Override
	public void badItem(Integer itemIdx, String regIdEmail) throws Exception {
		dao.updateBadCnt(itemIdx, 1);
		dao.recordBad(itemIdx, regIdEmail, "1");
	}
	
	@Override
	public void badCancelItem(Integer itemIdx, String regIdEmail) throws Exception {		
		dao.updateBadCnt(itemIdx, -1);
		dao.recordBad(itemIdx, regIdEmail, "0");
	}

	@Override
	public ItemVO readItemWithState(Integer itemIdx, String regIdEmail) throws Exception {
		ItemVO itemVO = dao.read(itemIdx);
		
		if(regIdEmail.equals("")) {				// 비로그인 유저
			itemVO.setLikestate(false);
			itemVO.setBadstate(false);
		} else {								// 로그인 유저
			LikeRecordDTO likeRecordDTO = dao.geLikeRecordDTO(itemVO.getIdx(), regIdEmail);
			if(likeRecordDTO == null) {
				itemVO.setLikestate(false);
			} else {
				if(likeRecordDTO.getBlike() == 1) {
					itemVO.setLikestate(true);
				} else {
					itemVO.setLikestate(false);
				}
			}
			
			BadRecordDTO badRecordDTO = dao.geBadRecordDTO(itemVO.getIdx(), regIdEmail);
			if(badRecordDTO == null) {
				itemVO.setBadstate(false);
			} else {
				if(badRecordDTO.getBbad() == 1) {
					itemVO.setBadstate(true);
				} else {
					itemVO.setBadstate(false);
				}
			}
		}
		
		return itemVO;
	}	
}
