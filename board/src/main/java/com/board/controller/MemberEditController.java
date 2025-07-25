package com.board.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.board.dto.MemberDto;
import com.board.service.MemberService;

@WebServlet("/member/edit.do")
public class MemberEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberService service = new MemberService();
		String id = request.getParameter("id");
		System.out.println("id : " + id);
		if(id != null) {
			MemberDto member = service.getMember(id);
			if(member != null) {
				request.setAttribute("member", member);
				request.getRequestDispatcher("/member/edit.jsp").forward(request, response);
				return;
			}
		}
		
		request.setAttribute("msg", "사용자 정보를 확인할 수 없습니다.");
		request.getRequestDispatcher("/common/msgbox.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberService service = new MemberService();
		
		
		System.out.println("pass" + request.getParameter("pass"));
		System.out.println("id" + request.getParameter("id"));
		
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		
		// 요청정보를 수집해서 member객체를 생성
		MemberDto member = new MemberDto(id, pass, "", "");
		int res = service.updateMember(member);
		
		if(res > 0) {
			// 수정 되었습니다. -> 상세페이지로 이동
			request.setAttribute("msg", "수정 되었습니다.");
			request.setAttribute("url", "/member/view.do?id="+id);
		} else {
			// 수정중 예외사항이 발생 했습니다. -> 뒤로가기
			request.setAttribute("msg", "수정중 예외가 발생 되었습니다. 관리자 에게 문의해주세요.");
		}
		request.getRequestDispatcher("/common/msgbox.jsp").forward(request, response);
	}

}
