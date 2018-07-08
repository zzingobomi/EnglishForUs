package com.zzingobomi.service;

import java.util.List;

import com.zzingobomi.domain.ItemVO;

public interface ItemService {
	
	public void regist(ItemVO item) throws Exception;
	
	public ItemVO read(Integer idx) throws Exception;
	
	public void modify(ItemVO item) throws Exception;
	
	public void remove(Integer idx) throws Exception;
	
	public List<ItemVO> listAll() throws Exception;
	
	//public List<BoardVO> listCriteria(Criteria cri) throws Exception;
	
	//public int listCountCriteria(Criteria cri) throws Exception;
	
	//public List<BoardVO> listSearchCriteria(SearchCriteria cri) throws Exception;
	
	//public int listSearchCount(SearchCriteria cri) throws Exception;
	
	public ItemVO oneRandomItem() throws Exception;

}
