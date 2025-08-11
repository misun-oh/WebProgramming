package mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import dev.fileupload.config.AppConfig;
import dev.fileupload.dto.BoardDto;
import dev.fileupload.dto.SearchDto;
import dev.fileupload.mapper.BoardMapper;
import lombok.extern.log4j.Log4j2;

@SpringJUnitConfig(AppConfig.class)
@Log4j2
public class BoardMapperTest {

	@Autowired
	BoardMapper mapper;
	
	@Test
	public void test() {
		// pageNo, amount를 파라메터로 전달
		List<BoardDto> list = mapper.getList(1, 10);
		System.out.println(list);
		System.out.println(list.size() + "건");
		//검증용 메서드
		assertEquals(10, list.size());
	}
	
	@Test
	@DisplayName("SearchDto를 매개변수로 사용")
	public void test_getPagedList() {
		SearchDto search = new SearchDto();
		//search.setPageNo(0);
		
		// pageNo, amount를 파라메터로 전달
		List<BoardDto> list = mapper.getPagedList(search);
		System.out.println(list);
		System.out.println(list.size() + "건");
		
		//검증용 메서드
		assertEquals(10, list.size());
	}
	
	@Test
	@DisplayName("if/foreach 테스트")
	public void test_getSearchedList() {
		SearchDto search = new SearchDto();
		// 검색어 설정
		search.setSearchField("title/content");
		search.setSearchWord("오류");
		List<BoardDto> list = mapper.getSearchedList(search);
		System.out.println(list);
		
	}
	
	
	@Test
	public void get_test() {
		BoardDto board = mapper.get(473);
		System.out.println(board.getTitle());
		assertNotNull(board);
	}
	
	@Test
	public void sql_test() {
		String sql = "select * from board "
						+ "where num=#{num}";
		System.out.println(sql);
	}
}
