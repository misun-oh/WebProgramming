package com.board.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.board.service.MemberService;

@WebServlet("/member/delete")
public class MemberDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	MemberService service = new MemberService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		System.out.println("==============" + id);
		if(id != null) {
			int res = service.deleteMember(id);
			
			if(res > 0) {
				// 서비스를 호출해서 사용자 삭제 요청
				// 삭제 성공적으로 되었을때 -> 리스트로 이동
				request.setAttribute("msg", "삭제 되었습니다.");
				request.setAttribute("url", "/member/list");
				request.getRequestDispatcher("/common/msgbox.jsp").forward(request, response);
				System.out.println("test123");
				return;
			}
		}
		System.out.println("test123===============");
		// 삭제 실패 했을때 -> 원래 있던 곳으로()
		request.setAttribute("msg", "삭제중 예외가 발생하였습니다. 관리자에게 문의 해주세요.");
		request.getRequestDispatcher("/common/msgbox.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
