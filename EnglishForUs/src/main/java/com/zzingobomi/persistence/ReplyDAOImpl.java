package com.zzingobomi.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.zzingobomi.domain.Criteria;
import com.zzingobomi.domain.ReplyVO;
import com.zzingobomi.dto.BadRecordDTO;
import com.zzingobomi.dto.LikeRecordDTO;

@Repository
public class ReplyDAOImpl implements ReplyDAO {
	
	@Inject
	private SqlSession session;
	
	private static String namespace = "com.zzingobomi.mapper.ReplyMapper";

	@Override
	public List<ReplyVO> list(Integer itemidx) throws Exception {
		return session.selectList(namespace + ".list", itemidx);
	}

	@Override
	public void create(ReplyVO vo) throws Exception {
		session.insert(namespace + ".create", vo);
	}
	
	@Override
	public ReplyVO read(Integer idx) throws Exception {
		return session.selectOne(namespace + ".read", idx);
	}

	@Override
	public void update(ReplyVO vo) throws Exception {
		session.update(namespace + ".update", vo);
	}

	@Override
	public void delete(Integer idx) throws Exception {
		session.delete(namespace + ".delete", idx);
	}

	@Override
	public List<ReplyVO> listPage(Integer itemidx, Criteria cri) throws Exception {

		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("itemidx", itemidx);
		paramMap.put("cri", cri);
		
		return session.selectList(namespace + ".listPage", paramMap);
	}

	@Override
	public int count(Integer itemidx) throws Exception {
		return session.selectOne(namespace + ".count", itemidx);
	}
	
	@Override
	public int getItemIdx(Integer idx) throws Exception {
		return session.selectOne(namespace + ".getItemIdx", idx);
	}

	@Override
	public void updateReplyLikeCnt(Integer idx, int amount) throws Exception {
		
		Map<String, Object> paramMap = new HashMap<>();
		
		paramMap.put("idx", idx);
		paramMap.put("amount", amount);
		
		session.update(namespace + ".updateReplyLikeCnt", paramMap);
	}

	@Override
	public void updateReplyBadCnt(Integer idx, int amount) throws Exception {
		
		Map<String, Object> paramMap = new HashMap<>();
		
		paramMap.put("idx", idx);
		paramMap.put("amount", amount);
		
		session.update(namespace + ".updateReplyBadCnt", paramMap);
	}

	@Override
	public void recordReplyLike(Integer idx, String regIdEmail, String bLike) throws Exception {
		
		Map<String, Object> paramMap = new HashMap<>();
		
		paramMap.put("replyidx", idx);
		paramMap.put("regidemail", regIdEmail);
		paramMap.put("blike", bLike);
		
		session.insert(namespace + ".recordReplyLike", paramMap);
	}

	@Override
	public void recordReplyBad(Integer idx, String regIdEmail, String bBad) throws Exception {

		Map<String, Object> paramMap = new HashMap<>();
		
		paramMap.put("replyidx", idx);
		paramMap.put("regidemail", regIdEmail);
		paramMap.put("bbad", bBad);
		
		session.insert(namespace + ".recordReplyBad", paramMap);	
	}

	@Override
	public LikeRecordDTO getReplyLikeRecordDTO(Integer idx, String regIdEmail) throws Exception {
		
		Map<String, Object> paramMap = new HashMap<>();
		
		paramMap.put("replyidx", idx);
		paramMap.put("regidemail", regIdEmail);		
		
		return session.selectOne(namespace + ".replyLikeSate", paramMap);		
	}

	@Override
	public BadRecordDTO getReplyBadRecordDTO(Integer idx, String regIdEmail) throws Exception {
		
		Map<String, Object> paramMap = new HashMap<>();
		
		paramMap.put("replyidx", idx);
		paramMap.put("regidemail", regIdEmail);		
		
		return session.selectOne(namespace + ".replyBadSate", paramMap);		
	}	
}
