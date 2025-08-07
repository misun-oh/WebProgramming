package dev.spring.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import dev.spring.board.HomeController;
import dev.spring.board.config.AppConfig;
import dev.spring.board.dto.MemberDto;
import dev.spring.board.mapper.MemberMapper;

@Service
public class MemberService {

    private final AppConfig appConfig;

    private final HomeController homeController;
	@Autowired
	MemberMapper mapper;

    MemberService(HomeController homeController, AppConfig appConfig) {
        this.homeController = homeController;
        this.appConfig = appConfig;
    }
	
	public void login(Model model){
		MemberDto member = mapper.getMember("100");
		String[] roles = mapper.getRole("100");
		member.setRoles(roles);
		System.out.println("===================" + member);
	}
}
