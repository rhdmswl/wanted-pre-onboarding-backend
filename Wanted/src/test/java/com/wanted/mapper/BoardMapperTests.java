package com.wanted.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wanted.domain.BoardVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
// Java Config
// @ContextConfiguration(classes = {org.zerock.config.RootConfig.class} )
@Log4j
public class BoardMapperTests {
	@Setter(onMethod_=@Autowired)
	private BoardMapper mapper;
	
	@Test
	public void testGetList() {
		mapper.getList().forEach(board -> log.info(board));
	}
	
	@Test
	public void testInsert() {
		BoardVO board = new BoardVO();
		board.setCompany_id("회사명");
		board.setContent("새로 작성하는 내용");
		board.setPay(100000);
		board.setPosition("모집포지션 ");
		board.setTech("기술");
		
		mapper.insert(board);
		
		log.info(board);
	}
	
	@Test
	public void testRead() {
		BoardVO board = mapper.read(6L);
		
		log.info(board);
	}
	
	@Test
	public void testDelete() {
		log.info("DELETE COUNT: " + mapper.delete(7L));
	}
	
	@Test
	public void testUpdate() {
		BoardVO board = new BoardVO();
		board.setBno(8L);
		board.setCompany_id("수정된 회사명");
		board.setContent("수정된 내용");
		board.setPay(150000);
		board.setPosition("수정된 포지션");
		board.setTech("수정된 기술");
		
		int count = mapper.update(board);
		log.info("UPDATE COUNT: " + count);
		
	}

}
