package com.zzingobomi.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.zzingobomi.domain.ItemVO;
import com.zzingobomi.domain.PageMaker;
import com.zzingobomi.domain.SearchCriteria;
import com.zzingobomi.service.ItemService;

@Controller
@RequestMapping("/item/*")
public class ItemController {
	
	private static final Logger logger = LoggerFactory.getLogger(ItemController.class);
	
	@Inject
	private ItemService service;
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registerGET(ItemVO item, Model model) throws Exception {
		logger.info("register get ......");
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerPOST(ItemVO item, RedirectAttributes rttr) throws Exception {
		logger.info("register post ......");
		logger.info(item.toString());		
		
		service.regist(item);			
		
		rttr.addFlashAttribute("msg", "SUCCESS");		
		
		return "redirect:/item/listAll";
	}
	
	@RequestMapping(value = "/listAll", method = RequestMethod.GET)
	public void listPage(@ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception {
		logger.info(cri.toString());		
		
		model.addAttribute("list", service.listSearchCriteria(cri));
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.listSearchCount(cri));
		
		model.addAttribute("pageMaker", pageMaker);
	}			
	
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public void read(@RequestParam("idx") int idx, @ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception {

		model.addAttribute(service.read(idx));
	}		
	
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String remove(@RequestParam("idx") int idx, SearchCriteria cri, RedirectAttributes rttr) throws Exception {
		
		service.remove(idx);
		
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("searchType", cri.getSearchType());
		rttr.addAttribute("keyword", cri.getKeyword());
		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:/item/listAll";
	}	
	
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public void modifyPagingGET(@RequestParam("idx") int idx, @ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception {
		
		model.addAttribute(service.read(idx));
	}	
	
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modifyPOST(ItemVO item, SearchCriteria cri, RedirectAttributes rttr) throws Exception {		
		logger.info("mod post ......");
		
		service.modify(item);
		
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("searchType", cri.getSearchType());
		rttr.addAttribute("keyword", cri.getKeyword());
		rttr.addFlashAttribute("msg", "SUCCESS");
		
		return "redirect:/item/listAll";
	}		
}
