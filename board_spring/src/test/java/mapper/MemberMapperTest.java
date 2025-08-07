package mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import dev.spring.board.config.AppConfig;
import dev.spring.board.mapper.MemberMapper;

@SpringJUnitConfig(AppConfig.class)
public class MemberMapperTest {
	
	@Autowired
	MemberMapper mamberMapper;
	
	@Test
	public void getMember(){
		
		mamberMapper.getMember("100");
		
	}
	
	@Test
	public void getRole(){
		
		mamberMapper.getRole("100");
		
	}
}
