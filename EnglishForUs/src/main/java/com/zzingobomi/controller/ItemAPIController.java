package com.zzingobomi.controller;

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

import com.zzingobomi.domain.ItemVO;
import com.zzingobomi.service.ItemService;

@RestController
@RequestMapping("/itemapi")
public class ItemAPIController {
	
	@Inject
	private ItemService service;	
	
	///
	/// 랜덤 한 문장 가져오기
	///
	@RequestMapping(value = "/onerandomitem", method = RequestMethod.POST)
	public ResponseEntity<ItemVO> getOneItem(@RequestBody Map<String, Object> map) {
		ResponseEntity<ItemVO> entity = null;
		try {
			entity = new ResponseEntity<ItemVO>(service.oneRandomItem(map.get("requestidemail").toString()), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<ItemVO>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	///
	/// 내 문장 리스트 가져오기
	///
	@RequestMapping(value = "/myitems", method = RequestMethod.POST)
	public ResponseEntity<List<ItemVO>> getMyItemList(@RequestBody Map<String, Object> map) {
		ResponseEntity<List<ItemVO>> entity = null;
		try {			
			entity = new ResponseEntity<List<ItemVO>>(service.myItems(map.get("regidemail").toString()), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<List<ItemVO>>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	
	///
	/// 내 문장 추가하기
	///
	@RequestMapping(value = "/oneadditem", method = RequestMethod.POST)
	public ResponseEntity<String> registerOneItem(@RequestBody ItemVO item) {
		ResponseEntity<String> entity = null;
		try {
			service.regist(item);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	///
	/// 내 문장 하나 가져오기
	///
	@RequestMapping(value = "/myitem/{idx}", method = RequestMethod.GET)
	public ResponseEntity<ItemVO> getMyItem(@PathVariable("idx") Integer idx) {
		ResponseEntity<ItemVO> entity = null;
		try {			
			entity = new ResponseEntity<ItemVO>(service.read(idx), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<ItemVO>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}	
	
	///
	/// 내 문장 수정하기
	///	
	@RequestMapping(value = "/myitem/{idx}", method = { RequestMethod.PUT, RequestMethod.PATCH })
	public ResponseEntity<String> myItemModify(@PathVariable("idx") Integer idx, @RequestBody ItemVO itemVO) {
		ResponseEntity<String> entity = null;
		try {
			itemVO.setIdx(idx);
			service.modify(itemVO);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}	
	
	///
	/// 내 문장 삭제하기
	///	
	@RequestMapping(value = "/myitem/{idx}", method = RequestMethod.DELETE)
	public ResponseEntity<String> myItemRemove(@PathVariable("idx") Integer idx) {
		ResponseEntity<String> entity = null;
		try {			
			service.remove(idx);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	///
	/// 좋아요 클릭
	///
	@RequestMapping(value = "/like/{idx}", method = RequestMethod.POST)
	public ResponseEntity<ItemVO> likeItem(@PathVariable("idx") Integer idx, @RequestBody Map<String, Object> likeDTO) {
		ResponseEntity<ItemVO> entity = null;
		try {
			service.likeItem(idx, likeDTO.get("regidemail").toString());
			entity = new ResponseEntity<ItemVO>(service.readItemWithState(idx, likeDTO.get("regidemail").toString()), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<ItemVO>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}	
	
	///
	/// 좋아요 취소 클릭
	///
	@RequestMapping(value = "/like/{idx}", method = RequestMethod.DELETE)
	public ResponseEntity<ItemVO> likeCancelItem(@PathVariable("idx") Integer idx, @RequestBody Map<String, Object> likeDTO) {
		ResponseEntity<ItemVO> entity = null;
		try {
			service.likeCancelItem(idx, likeDTO.get("regidemail").toString());
			entity = new ResponseEntity<ItemVO>(service.readItemWithState(idx, likeDTO.get("regidemail").toString()), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<ItemVO>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	///
	/// 신고하기 클릭
	///
	@RequestMapping(value = "/bad/{idx}", method = RequestMethod.POST)
	public ResponseEntity<ItemVO> badItem(@PathVariable("idx") Integer idx, @RequestBody Map<String, Object> badDTO) {
		ResponseEntity<ItemVO> entity = null;
		try {
			service.badItem(idx, badDTO.get("regidemail").toString());			
			entity = new ResponseEntity<ItemVO>(service.readItemWithState(idx, badDTO.get("regidemail").toString()), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<ItemVO>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	///
	/// 신고하기 취소 클릭
	///
	@RequestMapping(value = "/bad/{idx}", method = RequestMethod.DELETE)
	public ResponseEntity<ItemVO> badCancelItem(@PathVariable("idx") Integer idx, @RequestBody Map<String, Object> badDTO) {
		ResponseEntity<ItemVO> entity = null;
		try {
			service.badCancelItem(idx, badDTO.get("regidemail").toString());						
			entity = new ResponseEntity<ItemVO>(service.readItemWithState(idx, badDTO.get("regidemail").toString()), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<ItemVO>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}	
}
