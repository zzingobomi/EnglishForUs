package com.zzingobomi.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zzingobomi.domain.Criteria;
import com.zzingobomi.domain.PageMaker;
import com.zzingobomi.domain.ReplyVO;
import com.zzingobomi.service.ReplyService;

@RestController
@RequestMapping("/replies")
public class ReplyController {
	
	@Inject
	private ReplyService service;
	
	///
	/// 댓글 달기
	///
	@RequestMapping(value="", method = RequestMethod.POST)
	public ResponseEntity<String> register(@RequestBody ReplyVO vo) {
		
		ResponseEntity<String> entity = null;
		try {
			service.addReply(vo);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	///
	/// 해당 아이템 댓글 가져오기
	///
	@RequestMapping(value="/all/{itemidx}", method = RequestMethod.POST)
	public ResponseEntity<List<ReplyVO>> list(@PathVariable("itemidx") Integer itemidx, @RequestBody Map<String, Object> map) {
		
		ResponseEntity<List<ReplyVO>> entity = null;
		try {			
			entity = new ResponseEntity<>(service.listReply(itemidx, map.get("requestidemail").toString()), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	///
	/// 댓글 수정
	///
	@RequestMapping(value="/{idx}", method = { RequestMethod.PUT, RequestMethod.PATCH })
	public ResponseEntity<String> update(@PathVariable("idx") Integer idx, @RequestBody ReplyVO vo) {
		
		ResponseEntity<String> entity = null;
		try {	
			vo.setIdx(idx);
			service.modifyReply(vo);
			
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	///
	/// 댓글 삭제
	///
	@RequestMapping(value="/{idx}", method = RequestMethod.DELETE)
	public ResponseEntity<String> remove(@PathVariable("idx") Integer idx) {
		
		ResponseEntity<String> entity = null;
		try {				
			service.removeReply(idx);			
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	///
	/// 댓글 페이지(현재 안쓰임)
	///
	@RequestMapping(value="/{itemidx}/{page}", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> listPage(@PathVariable("itemidx") Integer itemidx, @PathVariable("page") Integer page) {
		
		ResponseEntity<Map<String, Object>> entity = null;
		try {			
			Criteria cri = new Criteria();
			cri.setPage(page);
			
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(cri);
			
			Map<String, Object> map = new HashMap<String, Object>();
			List<ReplyVO> list = service.listReplyPage(itemidx, cri);
			
			map.put("list", list);
			
			int replyCount = service.count(itemidx);
			pageMaker.setTotalCount(replyCount);
			
			map.put("pageMaker", pageMaker);
			
			entity = new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	///////////////////////////////////////////////// Like, Bad ////////////////////////////////////////////////////////
	
	///
	/// 댓글 좋아요 클릭
	///
	@RequestMapping(value = "/like/{idx}", method = RequestMethod.POST)
	public ResponseEntity<ReplyVO> likeItem(@PathVariable("idx") Integer idx, @RequestBody Map<String, Object> likeDTO) {
		ResponseEntity<ReplyVO> entity = null;
		try {
			service.likeReply(idx, likeDTO.get("regidemail").toString());
			entity = new ResponseEntity<ReplyVO>(service.readReplyWithState(idx, likeDTO.get("regidemail").toString()), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<ReplyVO>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}	
	
	///
	/// 댓글 좋아요 취소 클릭
	///
	@RequestMapping(value = "/like/{idx}", method = RequestMethod.DELETE)
	public ResponseEntity<ReplyVO> likeCancelItem(@PathVariable("idx") Integer idx, @RequestBody Map<String, Object> likeDTO) {
		ResponseEntity<ReplyVO> entity = null;
		try {
			service.likeCancelReply(idx, likeDTO.get("regidemail").toString());
			entity = new ResponseEntity<ReplyVO>(service.readReplyWithState(idx, likeDTO.get("regidemail").toString()), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<ReplyVO>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	///
	/// 댓글 신고하기 클릭
	///
	@RequestMapping(value = "/bad/{idx}", method = RequestMethod.POST)
	public ResponseEntity<ReplyVO> badItem(@PathVariable("idx") Integer idx, @RequestBody Map<String, Object> badDTO) {
		ResponseEntity<ReplyVO> entity = null;
		try {
			service.badReply(idx, badDTO.get("regidemail").toString());			
			entity = new ResponseEntity<ReplyVO>(service.readReplyWithState(idx, badDTO.get("regidemail").toString()), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<ReplyVO>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	///
	/// 댓글 신고하기 취소 클릭
	///
	@RequestMapping(value = "/bad/{idx}", method = RequestMethod.DELETE)
	public ResponseEntity<ReplyVO> badCancelItem(@PathVariable("idx") Integer idx, @RequestBody Map<String, Object> badDTO) {
		ResponseEntity<ReplyVO> entity = null;
		try {
			service.badCancelReply(idx, badDTO.get("regidemail").toString());						
			entity = new ResponseEntity<ReplyVO>(service.readReplyWithState(idx, badDTO.get("regidemail").toString()), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<ReplyVO>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}	
}
