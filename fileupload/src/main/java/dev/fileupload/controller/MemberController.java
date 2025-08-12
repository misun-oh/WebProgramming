package dev.fileupload.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import dev.fileupload.dto.MemberDto;
import dev.fileupload.dto.SearchDto;
import dev.fileupload.service.MemberService;

/**
 * 1. 요청을 받는다
 * 		- 컨트롤러에 여러개의 요청 주소를 매핑 할수 있다
 * 2. 요청정보를 수집한다
 * 		- 매개변수에 객체를 받으면 자동으로 수집
 * 3. 화면에 전달할 데이터를 저장한다 
 * 		- Modle (내장객체-request의 영역에 데이터를 저장)
 * 4. redirect/forward를 간편하게 사용
 */
@Controller
public class MemberController {

	@Autowired
	MemberService memberService;


	@GetMapping("/member/register")
	private void register() {
		
	}
	
	@PostMapping("/member/logout")
	private String logout(HttpSession session) {
		// 세션 무효화 처리
		session.invalidate();
		System.out.println("로그아웃");
		
		return "redirect:/member/login"; // 클라이언트(웹브라우저)에게 /member/login 요청을 다시 하라고 전달 
	}
	
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
			return "/main";
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
	@GetMapping("/member/get/{id}")
	private String getUserId(@PathVariable("id") String user_id ) {
		System.out.println("id : " + user_id);
		// TODO Auto-generated method stub
		return "member/main";
	}
	
	@GetMapping("/member/ge/{id}")
	private String getUser111(@PathVariable("id") String user_id ) {
		System.out.println("id : " + user_id);
		// TODO Auto-generated method stub
		return "member/main";
	}
	
	// 계정잠금/해제 처리
	//@GetMapping("/member/accountlock/{user_id}/{account_locked}")
	public String accountlock(Model model, MemberDto member){
		// 파라메터 수집 확인
		System.out.println("member : " + member);
		boolean res = memberService.updateAccountLock(model, member);
		
		if(res) {
			// 성공
			return "redirect:/member/list";
			
		} else {
			// 실패 -> msgbox : msg를 모달로 띄워주고 뒤로가기또는 url로 이동
			// 메세지 처리후 뒤로가기
			return "/common/msgbox";
		}
		// 리스트를 다시 조회 해서 화면에 데이터를 전달할 수 있도록 처리
	}
	
	// 계정 잠금/해제 처리를 fetch를 이용해서 처리
	@GetMapping("/member/accountlock/{user_id}/{account_locked}")
	@ResponseBody
	public Map<String, Boolean> accountlock_fetch(Model model, HttpSession session, MemberDto member){
		if(session.getAttribute("member")!=null) {
			MemberDto loginMember = (MemberDto)session.getAttribute("member");
			if(loginMember.hasRole("ADMIN")) {				
				boolean res = memberService.updateAccountLock(model, member);
				// 계정잠금의 결과를 map에 담아서 화면에 전달
				Map<String, Boolean> map = Map.of("res", res);
				return map;
			} 
		}
		
		// 권한이 없거나 계정잠금에 실패한 경우
		Map<String, Boolean> map = Map.of("res", false);
		return map;
		
		
	}
	
	
	
	@GetMapping("/fetch")
	@ResponseBody // 화면이 아닌 객체를 Json형식 파일(문자열)로 전달 
	private Map<String, String> fetch() {
		//return new MemberDto();
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", "오미자");
		map.put("age", "20");
		
		// 맵을 간단하게 생성하는 방법 - 불변, 10개까지
		Map<String, String> mapOf = Map.of("name", "오미자"
											, "age", "25");
		
		return mapOf;
	}
	
	
}
