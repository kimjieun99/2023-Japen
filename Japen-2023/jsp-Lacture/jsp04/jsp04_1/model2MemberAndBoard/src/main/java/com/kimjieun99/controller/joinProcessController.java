package com.kimjieun99.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kimjieun99.model.MemberDao;
import com.kimjieun99.model.MemberDto;
import com.kimjieun99.utils.ScriptWriter;


@WebServlet("/member/joinProcess")
public class joinProcessController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public joinProcessController() {
        super();
       
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		MemberDao memberDao = new MemberDao();
		MemberDto memberDto = new MemberDto();
		String address = request.getParameter("userAddr01")+" "+
				request.getParameter("userAddr02")+"/"+
				request.getParameter("userAddr03");
		memberDto.setUserId(request.getParameter("userId"));
		memberDto.setUserPW(request.getParameter("userPW"));
		memberDto.setUserName(request.getParameter("userName"));
		memberDto.setUserEmail(request.getParameter("userEmail"));
		memberDto.setUserHp(request.getParameter("userHp"));
		memberDto.setZipCode(Integer.parseInt(request.getParameter("zipCode")));
		memberDto.setAddress(address);
		int result = memberDao.insertMember(memberDto);
		
		if(result > 0) {
			ScriptWriter.alertAndNext(response, "회원가입이 되었습니다.", "http://www.daum.net");
		} else {
			ScriptWriter.alertAndBack(response, "잠시후 다시 시도해 주세요.");
		}
	}

}
