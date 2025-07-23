package com.board.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

import com.board.dto.MemberDto;
import com.board.service.MemberService;
import com.google.gson.Gson;

@WebServlet("/member/idCheck")
public class IdCheckController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	MemberService service = new MemberService();
    	String id = request.getParameter("id");
    	// 데이터 베이스에 id가 있으면 false 없으면 true
    	boolean res = service.idCheck(id);
    	
    	// response.setContentType("application/json");
    	// Gson : object -> json형식의 문자열로 변환 해주는 라이브러리
    	/*Map<String, Boolean> result = Map.of("idCheck", res);
    	Gson gson = new Gson();
    	gson.toJson(result);*/
    	
    	response.getWriter().append("{\"idCheck\":"+res+"}");
    	
    	
    	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
