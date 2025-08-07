package dev.spring.board.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import dev.spring.board.HomeController;
import dev.spring.board.dto.MemberDto;

@Controller
public class MemberController {

    private final HomeController homeController;

    MemberController(HomeController homeController) {
        this.homeController = homeController;
    }
	
	//값이 하나인 경우 value= 생략가능 (기본값)
	@GetMapping("/member/login")
	private void login() {
		// 반환값이 없는경우 요청 경로에 해당하는 jsp를 반환
	}
	
	// 요청경로와 페이지경로가 다른경우
	// 반환타입을 String으로 하고, jsp파일의 경로를 반환
	@PostMapping(value="/login/loginAction")
	private String loginAction(HttpSession session, String user_id, String user_pw) {
		System.out.println("user_id : " + user_id);
		System.out.println("user_pw : " + user_pw);
		session.setAttribute("user_id", user_id);

		return "member/main";
	}
	
	// 요청경로와 페이지경로가 다른경우
	// 반환타입을 String으로 하고, jsp파일의 경로를 반환
	// Model : 화면에 데이터를 전달!!
	@GetMapping(value="/login/loginAction_dto")
	private String loginAction_dto(MemberDto member, Model model) {
		// DTO객체의 필드명과 파라메터의 name속성의 값이 일치 해야 됨
		// 객체에 자동 수집
		System.out.println(member);
		
		model.addAttribute("member", member);
		
		return "member/main";
	}
	
	//  PathVariable : 요청경로로부터 파라메터를 수집
	// 변수이름과 파라메터 이름이 같은경우 @PathVariable
	// 변수이름과 파라메터 이름이 다른경우 @PathVariable("id")
	@GetMapping("/member/{id}")
	private String getUserId(@PathVariable("id") String user_id ) {
		System.out.println("id : " + user_id);
		// TODO Auto-generated method stub
		return "member/main";
	}
}
