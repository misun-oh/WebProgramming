package com.board.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.board.dto.MemberDto;
import com.board.service.MemberService;

@WebServlet("/member/registerAction")
public class MemberRegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 사용자의 요청 정보를 수집해서 객체 생성
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String name = request.getParameter("name");
		
		MemberDto member = new MemberDto(id, pass, name, "");
		
		MemberService service = new MemberService();
		boolean res = service.insert(member);
		System.out.println("===================="+res);
		if(res) {
			// 입력 성공
			// 메세지 처리 후 리스트 페이지로 이동
			request.setAttribute("msg", "등록 되었습니다.");
			request.setAttribute("url", "/member/list");
			
			request.getRequestDispatcher("/common/msgbox.jsp").forward(request, response);
			
		} else {
			// 입력 실패
			// 메세지 처리 후 뒤로가기
			
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
