package dev.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import dev.spring_prj.config.AppConfig;
import dev.spring_prj.dto.BoardDto;
import dev.spring_prj.dto.SearchDto;
import dev.spring_prj.mapper.BoardMapper;
import lombok.extern.log4j.Log4j2;

@SpringJUnitConfig(AppConfig.class)
@Log4j2
public class BoardMapperTest {

	@Autowired
	BoardMapper mapper;
	
	//@Test
	public void test() {
		List<BoardDto> list = mapper.getList(1,10);
		System.out.println(list);
		System.out.println(list.size() + "건");
		//검증용 메서드
		assertEquals(2051, list.size());
	}
	
	//@Test
	public void test1() {
		List<BoardDto> list = mapper.getList1(1,10);
		System.out.println(list);
		System.out.println(list.size() + "건");
		//검증용 메서드
		assertEquals(2051, list.size());
	}
	
	@Test
	public void test2() {
		List<BoardDto> list = mapper.getPagedList(new SearchDto());
		System.out.println(list);
		System.out.println(list.size() + "건");
		//검증용 메서드
		assertEquals(10, list.size());
	}
	@Test
	public void test_searchBoard() {
		log.info("로그 출력 테스트");
		List<BoardDto> list = mapper.searchBoard(new SearchDto());
		System.out.println(list);
		System.out.println(list.size() + "건");
		//검증용 메서드
		assertEquals(10, list.size());
	}
	
	@Test
	public void get_test() {
		BoardDto board = mapper.get(473);
		System.out.println(board.getTitle());
		assertNotNull(board);
	}
}
