package com.zzingobomi.service;

import java.util.List;

import com.zzingobomi.domain.Criteria;
import com.zzingobomi.domain.ItemVO;
import com.zzingobomi.domain.SearchCriteria;

public interface ItemService {
	
	public void regist(ItemVO item) throws Exception;
	
	public ItemVO read(Integer idx) throws Exception;
	
	public void modify(ItemVO item) throws Exception;
	
	public void remove(Integer idx) throws Exception;
	
	public List<ItemVO> myItems(String regIdEmail) throws Exception;
	
	public List<ItemVO> listAll() throws Exception;
	
	public List<ItemVO> listCriteria(Criteria cri) throws Exception;
	
	public int listCountCriteria(Criteria cri) throws Exception;
	
	public List<ItemVO> listSearchCriteria(SearchCriteria cri) throws Exception;
	
	public int listSearchCount(SearchCriteria cri) throws Exception;
	
	public ItemVO oneRandomItem(String reqIdEmail) throws Exception;
	
	public void likeItem(Integer itemIdx, String regIdEmail) throws Exception;
	
	public void likeCancelItem(Integer itemIdx, String regIdEmail) throws Exception;
	
	public void badItem(Integer itemIdx, String regIdEmail) throws Exception;
	
	public void badCancelItem(Integer itemIdx, String regIdEmail) throws Exception;
	
	public ItemVO readItemWithState(Integer itemIdx, String regIdEmail) throws Exception;
}
