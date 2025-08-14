package mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import dev.fileupload.config.AppConfig;
import dev.fileupload.dto.MemberDto;
import dev.fileupload.dto.SearchDto;
import dev.fileupload.mapper.MemberMapper;
import lombok.extern.log4j.Log4j2;


// 1. 설정파일에 문제가 있는경우 - 스프링컨테이너(IOC)컨테이너 생성 실패
// 2. @Test어노테이션이 없는경우
// 3. public void 가 아닌경우
// 4. test 경로가 아닌경우 (main에 테스트 코드 작성시 실행이 안됨!)
@SpringJUnitConfig(AppConfig.class)
@Log4j2
public class MemberMapperTest {
	
	@Autowired
	MemberMapper mapper;
	
	@Test
	public void addRole() {
		int res = mapper.addRole("1000", "1");
		assertEquals(1, res);
	}
	
	@Test
	public void updateMember() {
		MemberDto member = new MemberDto();
		member.setUser_id("1000");
		member.setEmail("a@b.c");
		member.setPassword("1234");
		member.setPhone_number("01022223333");
		int res = mapper.updateMember(member);
		assertEquals(1, res);
	}
	
	@Test
	public void insertRole() {
		MemberDto member = new MemberDto();
		member.setUser_id("1111");
		mapper.insertRole(member);
	}
	
	@Test
	public void insertMember() {
		
		// 데이터 준비
		MemberDto member = new MemberDto();
		member.setUser_id("1000");
		member.setPassword("1234");
		member.setUsername("오미자2");
		member.setEmail("a@b.c");
		member.setPhone_number("01000001111");
		log.info(member);
		System.out.println(member);
		
		// DB 입력
		int res = mapper.insertMember(member);
		
		assertEquals(1, res);
	}
	
	
	@Test
	public void updateAccountLock() {
		MemberDto member = new MemberDto();
		member.setUser_id("100");
		member.setAccount_locked("Y");
		int res = mapper.updateAccountLock(member);
		assertEquals(1, res);
	}
	
	@Test
	public void getRoles() {
		MemberDto member = new MemberDto();
		member.setUser_id("100");
		String[] roles = mapper.getRoles(member);
		// 리스트로 변환후 contains메서드를 이용해서 있는지 확인
		boolean res = Arrays.asList(roles).contains("ADMIN");
		
		assertTrue(res);
	}
	
	@Test
	public void update_fail_count_reset() {
		MemberDto member = new MemberDto();
		member.setUser_id("100");
		mapper.update_fail_count_reset(member);
	}
	
	@Test
	public void login(){
		
		MemberDto member = new MemberDto();
		member.setUser_id("100");
		member.setPassword("1234");
		
		MemberDto loginMember = mapper.login(member);
		
		assertNotNull(loginMember);
		assertEquals("오미자", loginMember.getUsername());
	}
	
	@Test
	public void login_fail(){
		
		MemberDto member = new MemberDto();
		member.setUser_id("1");
		member.setPassword("1234");
		
		MemberDto loginMember = mapper.login(member);
		// 사용자가 없는경우 null 을 반환
		assertNull(loginMember);
		//assertEquals("오미자", loginMember.getUsername());
	}
	
	@Test
	public void updateFailCount(){
		MemberDto member = new MemberDto();
		member.setUser_id("100");
		
		// 메서드의 실행결과
		int res = mapper.update_fail_count(member);
		
		// 검증 (실제메서드의 실행 결과와 예상하는 결과)
		assertEquals(1, res);
	}
	
	@Test
	public void getList() {
		List<MemberDto> list = mapper.getList(new SearchDto());
		assertNotNull(list);
	}
	
	@Test	
	public void checkId() {
		MemberDto member = new MemberDto();
		member.setUser_id("100");
		
		int res = mapper.checkId(member);
		assertEquals(1, res);
	}
	
	@Test
	public void test() {
		String[] strArr = {"a", "b", "c", "d"};
		Boolean res = Arrays.asList(strArr).contains("a");
		System.out.println(res);
	}
	
	
	
}
