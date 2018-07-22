package com.zzingobomi.persistence;

import java.util.List;

import com.zzingobomi.domain.Criteria;
import com.zzingobomi.domain.ItemVO;
import com.zzingobomi.domain.SearchCriteria;

public interface ItemDAO {
	
	public void create(ItemVO vo) throws Exception;
	
	public ItemVO read(Integer idx) throws Exception;
	
	public void update(ItemVO vo) throws Exception;
	
	public void delete(Integer idx) throws Exception;
	
	public List<ItemVO> listAll() throws Exception;
	
	public List<ItemVO> listPage(int page) throws Exception;
	
	public List<ItemVO> listCriteria(Criteria cri) throws Exception;
	
	public int countPaging(Criteria cri) throws Exception;
	
	public List<ItemVO> listSearch(SearchCriteria cri) throws Exception;
	
	public int listSearchCount(SearchCriteria cri) throws Exception;
	
	public ItemVO chooseRandomItem() throws Exception;
}
