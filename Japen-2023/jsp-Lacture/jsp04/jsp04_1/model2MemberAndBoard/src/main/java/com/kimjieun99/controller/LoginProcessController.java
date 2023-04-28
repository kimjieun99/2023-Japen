package com.kimjieun99.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kimjieun99.model.MemberDao;
import com.kimjieun99.model.MemberDto;
import com.kimjieun99.utils.ScriptWriter;


@WebServlet("/member/LoginProcess")
public class LoginProcessController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public LoginProcessController() {
        super();
        
    }


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setCharacterEncoding("UTF-8");
	String userId = request.getParameter("userId");
	String userPW = request.getParameter("userPW");
	
	MemberDao memberDao = new MemberDao();
	MemberDto loggedMember = memberDao.getLoggedMember(userId, userPW);
	HttpSession session = request.getSession();
	if(loggedMember!=null) {
		session.setAttribute("loggedID", loggedMember.getUserId());
		session.setAttribute("loggedName", loggedMember.getUserName());
	    session.setAttribute("loggedMember", loggedMember);
	    ScriptWriter.alertAndNext(response, loggedMember.getUserName()+"님 반갑습니다.", "../index/");
	}
	}

}
