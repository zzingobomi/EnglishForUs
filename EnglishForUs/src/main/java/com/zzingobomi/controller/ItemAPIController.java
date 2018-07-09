package com.zzingobomi.controller;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	
	@RequestMapping(value = "/onerandomitem", method = RequestMethod.GET)
	public ResponseEntity<ItemVO> getOneItem() {
		ResponseEntity<ItemVO> entity = null;
		try {			
			entity = new ResponseEntity<ItemVO>(service.oneRandomItem(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<ItemVO>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}

}
