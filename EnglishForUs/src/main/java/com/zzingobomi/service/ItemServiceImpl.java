package com.zzingobomi.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.zzingobomi.domain.Criteria;
import com.zzingobomi.domain.ItemVO;
import com.zzingobomi.domain.SearchCriteria;
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
	public ItemVO oneRandomItem() throws Exception {
		return dao.chooseRandomItem();
	}
}
