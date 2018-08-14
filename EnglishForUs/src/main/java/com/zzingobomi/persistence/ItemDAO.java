package com.zzingobomi.persistence;

import java.util.List;

import com.zzingobomi.domain.Criteria;
import com.zzingobomi.domain.ItemVO;
import com.zzingobomi.domain.SearchCriteria;
import com.zzingobomi.dto.BadRecordDTO;
import com.zzingobomi.dto.LikeRecordDTO;

public interface ItemDAO {
	
	public void create(ItemVO vo) throws Exception;
	
	public ItemVO read(Integer idx) throws Exception;
	
	public void update(ItemVO vo) throws Exception;
	
	public void delete(Integer idx) throws Exception;
	
	public List<ItemVO> myItems(String regIdEmail) throws Exception;
	
	public List<ItemVO> listAll() throws Exception;
	
	public List<ItemVO> listPage(int page) throws Exception;
	
	public List<ItemVO> listCriteria(Criteria cri) throws Exception;
	
	public int countPaging(Criteria cri) throws Exception;
	
	public List<ItemVO> listSearch(SearchCriteria cri) throws Exception;
	
	public int listSearchCount(SearchCriteria cri) throws Exception;
	
	public ItemVO chooseRandomItem() throws Exception;
	
	public void updateReplyCnt(Integer idx, int amount) throws Exception;
	
	public void updateImpressionCnt(Integer idx, int amount) throws Exception;
	
	public void updateLikeCnt(Integer idx, int amount) throws Exception;
	
	public void updateBadCnt(Integer idx, int amount) throws Exception;
	
	public void recordLike(Integer itemIdx, String regIdEmail, String bLike) throws Exception;
	
	public void recordBad(Integer itemIdx, String regIdEmail, String bBad) throws Exception;
	
	public LikeRecordDTO geLikeRecordDTO(Integer itemIdx, String regIdEmail) throws Exception;
	
	public BadRecordDTO geBadRecordDTO(Integer itemIdx, String regIdEmail) throws Exception;
}
