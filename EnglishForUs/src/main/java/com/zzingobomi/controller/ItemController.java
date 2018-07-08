package com.zzingobomi.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.zzingobomi.domain.ItemVO;
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
	public void listAll(Model model) throws Exception {
		logger.info("show all list...................");
		
		model.addAttribute("list", service.listAll());
	}
	
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public void read(@RequestParam("idx") int idx, Model model) throws Exception {

		model.addAttribute(service.read(idx));
	}	
	
	/*
	@RequestMapping(value = "/readPage", method = RequestMethod.GET)
	public void read(@RequestParam("idx") int idx, @ModelAttribute("cri") Criteria cri, Model model) throws Exception {

		model.addAttribute(service.read(bno));
	}
	*/	
	
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String remove(@RequestParam("idx") int idx, RedirectAttributes rttr) throws Exception {
		
		service.remove(idx);
		
		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:/item/listAll";
	}
	
	/*
	@RequestMapping(value = "/removePage", method = RequestMethod.POST)
	public String remove(@RequestParam("bno") int bno, Criteria cri, RedirectAttributes rttr) throws Exception {
		
		service.remove(bno);
		
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:/board/listPage";
	}
	*/
	
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public void modifyGET(@RequestParam("idx")int idx, Model model) throws Exception {
		
		model.addAttribute(service.read(idx));
	}
	
	/*
	@RequestMapping(value = "/modifyPage", method = RequestMethod.GET)
	public void modifyPagingGET(@RequestParam("bno") int bno, @ModelAttribute("cri") Criteria cri, Model model) throws Exception {
		
		model.addAttribute(service.read(bno));
	}
	*/
	
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modifyPOST(ItemVO item, RedirectAttributes rttr) throws Exception {		
		logger.info("mod post ......");
		
		service.modify(item);
		rttr.addFlashAttribute("msg", "SUCCESS");
		
		return "redirect:/item/listAll";
	}
	
	/*
	@RequestMapping(value = "/modifyPage", method = RequestMethod.POST)
	public String modifyPagingPOST(BoardVO board, Criteria cri,	RedirectAttributes rttr) throws Exception {		
		logger.info("mod post ......");
		
		service.modify(board);
		
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addFlashAttribute("msg", "SUCCESS");
		
		return "redirect:/board/listPage";
	}
	*/
	
	/*
	@RequestMapping(value = "/listCri", method = RequestMethod.GET)
	public void listAll(Criteria cri, Model model) throws Exception {
		logger.info("show list Page with Criteria ...................");
		
		model.addAttribute("list", service.listCriteria(cri));
	}
	
	@RequestMapping(value = "/listPage", method = RequestMethod.GET)
	public void listPage(Criteria cri, Model model) throws Exception {
		logger.info(cri.toString());		
		
		model.addAttribute("list", service.listCriteria(cri));
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.listCountCriteria(cri));
		
		model.addAttribute("pageMaker", pageMaker);
	}
	*/
}
