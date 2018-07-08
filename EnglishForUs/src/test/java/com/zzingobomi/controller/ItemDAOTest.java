package com.zzingobomi.controller;

import javax.inject.Inject;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zzingobomi.persistence.ItemDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class ItemDAOTest {
	
	@Inject
	private ItemDAO dao;
	
	private static Logger logger = LoggerFactory.getLogger(ItemDAOTest.class);
	
	/*
	@Test
	public void testCreate() throws Exception {
		
		ItemVO item = new ItemVO();
		item.setTitle_ko("테스트3");
		item.setTitle_en("test3");	
		item.setAddinfo("테스트추가정보3");
		dao.create(item);
	}
	*/
	
	/*
	@Test
	public void testRead() throws Exception {
		logger.info(dao.read(1).toString());
	}
	*/
	
	/*
	@Test
	public void testUpdate() throws Exception {
		
		ItemVO item = new ItemVO();
		item.setIdx(1);
		item.setTitle_ko("테스트1 수정");
		item.setTitle_en("test1 update");
		item.setAddinfo("테스트1 추가정보 수정");
		dao.update(item);
	}
	*/
	
	/*
	@Test
	public void testDelete() throws Exception {
		dao.delete(3);
	}
	*/
	
	/*
	@Test
	public void testListPage() throws Exception {
		int page = 3;
		
		List<BoardVO> list = dao.listPage(page);
		
		for(BoardVO boardVO : list) {
			logger.info(boardVO.getBno() + ":" + boardVO.getTitle());
		}
	}
	*/
	
	/*
	@Test
	public void testListCriteria() throws Exception {
		Criteria cri = new Criteria();
		cri.setPage(2);
		cri.setPerPageNum(20);
		
		List<BoardVO> list = dao.listCriteria(cri);
		
		for(BoardVO boardVO : list) {
			logger.info(boardVO.getBno() + ":" + boardVO.getTitle());
		}
	}
	*/
	
	/*
	@Test
	public void testURI() throws Exception {
		UriComponents uriComponents = UriComponentsBuilder.newInstance()
				.path("/board/read")
				.queryParam("bno", 12)
				.queryParam("perPageNum", 20)
				.build();
		
		logger.info(uriComponents.toString());
				
	}
	*/
	
	/*
	@Test
	public void testDynamic1() throws Exception {
		SearchCriteria cri = new SearchCriteria();
		cri.setPage(1);
		cri.setKeyword("1");
		cri.setSearchType("t");
		
		logger.info("==================================");
		
		List<BoardVO> list = dao.listSearch(cri);
		
		for(BoardVO boardVO : list) {
			logger.info(boardVO.getBno() + ": " + boardVO.getTitle());
		}
		
		logger.info("==================================");
		
		logger.info("COUNT: " + dao.listSearchCount(cri));		
	}
	*/
}
