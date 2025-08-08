package dev.spring.board.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import dev.spring.board.dto.MemberDto;
import dev.spring.board.dto.SearchDto;
import dev.spring.board.service.MemberService;

@Controller
public class MemberController {


	@Autowired
	MemberService memberService;

	// SearchDto : 페이징및 검색 파라메터 수집
	@GetMapping("/member/list")
	private void getList(Model model, SearchDto search){
		// 리스트 조회 화면에 전달
		memberService.getList(model, search);
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
	@PostMapping(value="/login/loginAction_dto")
	private String loginAction_dto(Model model, HttpSession session, MemberDto member, RedirectAttributes rttr) {
		System.out.println("memberdto =========================== " + member);
		// 로그인 처리
		// 화면전환
		boolean res = memberService.login(model, member);
		
		if(res) {
			session.setAttribute("user_id", member.getUser_id());
			// 세션에 멤버 객체 저장
			session.setAttribute("member", model.getAttribute("member"));
			
			// 로그인 성공
			// 세션에 저장 -> main으로 이동
			//return "redirect:member/main";
			
			// /로 시작 하지 않으면 기존 요청 경로를 포함 ✨주의✨가 필요
			// member/main -> /login/member/main 
			// /member/main -> /member/main
			return "/member/main";
		} else {
			// 로그인 실패
			// 메세지 처리 -> 로그인 페이지로 이동
			// ✨ forward시 요청메서드가 달라지므로 오류가 발생 -> 요청메서드가 달라지는 경우 redirect처리
			
			// session영역에 임시로 데이터를 보관
			// 오류 메세지를 화면에 출력 하기 위해 저장
			rttr.addFlashAttribute("msg", model.getAttribute("msg"));
			// 사용자가 입력한 아이디를 화면에 출력하기 위해 저장
			rttr.addFlashAttribute("user_id", member.getUser_id());
			rttr.addAttribute("msg", model.getAttribute("msg"));
			return "redirect:/member/login";
		}
		
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
