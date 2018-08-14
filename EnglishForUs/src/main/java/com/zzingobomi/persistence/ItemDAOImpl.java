package com.zzingobomi.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.zzingobomi.domain.Criteria;
import com.zzingobomi.domain.ItemVO;
import com.zzingobomi.domain.SearchCriteria;
import com.zzingobomi.dto.BadRecordDTO;
import com.zzingobomi.dto.LikeRecordDTO;

@Repository
public class ItemDAOImpl implements ItemDAO {
	
	@Inject
	private SqlSession session;
	
	private static String namespace = "com.zzingobomi.mapper.ItemMapper";

	@Override
	public void create(ItemVO vo) throws Exception {		
		session.insert(namespace + ".create", vo);		
	}

	@Override
	public ItemVO read(Integer idx) throws Exception {
		return session.selectOne(namespace + ".read", idx);
	}

	@Override
	public void update(ItemVO vo) throws Exception {
		session.update(namespace + ".update", vo);
	}

	@Override
	public void delete(Integer bno) throws Exception {
		session.delete(namespace + ".delete", bno);
	}	

	@Override
	public List<ItemVO> myItems(String regIdEmail) throws Exception {
		
		Map<String, Object> paramMap = new HashMap<>();
		
		paramMap.put("regidemail", regIdEmail);
		
		return session.selectList(namespace + ".myItems", paramMap);
	}

	@Override
	public List<ItemVO> listAll() throws Exception {
		return session.selectList(namespace + ".listAll");
	}	
	
	@Override
	public List<ItemVO> listPage(int page) throws Exception {		
		if(page <= 0) {
			page = 1;
		}
		
		page = (page - 1) * 10;
		
		return session.selectList(namespace + ".listPage", page);
	}

	@Override
	public List<ItemVO> listCriteria(Criteria cri) throws Exception {
		return session.selectList(namespace + ".listCriteria", cri);
	}
	
	@Override
	public int countPaging(Criteria cri) throws Exception {
		return session.selectOne(namespace + ".countPaging", cri);
	}
	
	@Override
	public List<ItemVO> listSearch(SearchCriteria cri) throws Exception {
		return session.selectList(namespace + ".listSearch", cri);
	}
	
	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		return session.selectOne(namespace + ".listSearchCount", cri);
	}
	
	@Override
	public void updateReplyCnt(Integer idx, int amount) throws Exception {
		
		Map<String, Object> paramMap = new HashMap<>();
		
		paramMap.put("idx", idx);
		paramMap.put("amount", amount);
		
		session.update(namespace + ".updateReplyCnt", paramMap);
		
	}
	
	@Override
	public ItemVO chooseRandomItem() throws Exception {
		return session.selectOne(namespace + ".oneRandomItem");
	}
	
	@Override
	public void updateImpressionCnt(Integer idx, int amount) throws Exception {
		
		Map<String, Object> paramMap = new HashMap<>();
		
		paramMap.put("idx", idx);
		paramMap.put("amount", amount);
		
		session.update(namespace + ".updateImpressionCnt", paramMap);		
	}
	
	@Override
	public void updateLikeCnt(Integer idx, int amount) throws Exception {
		
		Map<String, Object> paramMap = new HashMap<>();
		
		paramMap.put("idx", idx);
		paramMap.put("amount", amount);
		
		session.update(namespace + ".updateLikeCnt", paramMap);		
	}
	
	@Override
	public void updateBadCnt(Integer idx, int amount) throws Exception {
		
		Map<String, Object> paramMap = new HashMap<>();
		
		paramMap.put("idx", idx);
		paramMap.put("amount", amount);
		
		session.update(namespace + ".updateBadCnt", paramMap);		
	}

	@Override
	public void recordLike(Integer itemIdx, String regIdEmail, String bLike) throws Exception {
		
		Map<String, Object> paramMap = new HashMap<>();
		
		paramMap.put("itemidx", itemIdx);
		paramMap.put("regidemail", regIdEmail);
		paramMap.put("blike", bLike);
		
		session.insert(namespace + ".recordLike", paramMap);
	}

	@Override
	public void recordBad(Integer itemIdx, String regIdEmail, String bBad) throws Exception {
		
		Map<String, Object> paramMap = new HashMap<>();
		
		paramMap.put("itemidx", itemIdx);
		paramMap.put("regidemail", regIdEmail);
		paramMap.put("bbad", bBad);
		
		session.insert(namespace + ".recordBad", paramMap);		
	}

	@Override
	public LikeRecordDTO geLikeRecordDTO(Integer itemIdx, String regIdEmail) throws Exception {
		
		Map<String, Object> paramMap = new HashMap<>();
		
		paramMap.put("itemidx", itemIdx);
		paramMap.put("regidemail", regIdEmail);		
		
		return session.selectOne(namespace + ".itemLikeSate", paramMap);		
	}

	@Override
	public BadRecordDTO geBadRecordDTO(Integer itemIdx, String regIdEmail) throws Exception {
		
		Map<String, Object> paramMap = new HashMap<>();
		
		paramMap.put("itemidx", itemIdx);
		paramMap.put("regidemail", regIdEmail);		
		
		return session.selectOne(namespace + ".itemBadSate", paramMap);		
	}	
	
}
