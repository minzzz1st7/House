package com.ssafy.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssafy.dto.NoticeDto;
import com.ssafy.dto.UserDto;
import com.ssafy.service.NoticeService;
import com.ssafy.service.NoticeServiceImpl;

@WebServlet("/NoticeMain2")
public class NoticeMain extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private NoticeService nsvc = NoticeServiceImpl.getInstance();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String action = request.getParameter("act");
		System.out.println("action을 찍어줘 ~~ : "+ action);
		
		switch(action){
			case "mvNotice": System.out.println("공지사항");response.sendRedirect(request.getContextPath() + "/notice.jsp"); break;
			case "mvAddNotice": selectAll(request, response); break;
			case "selectAll": selectAll(request, response); break;
			case "Noticeinsert": Noticeinsert(request, response); break;
			case "NoticeinsertForm": response.sendRedirect(request.getContextPath()+"/addNotice.jsp"); break;
			case "view": searchByID(request, response); break;
			case "Noticeupdate": searchByID(request, response); break; 
			case "Noticedelete": Noticedelete(request, response); break;
		}	
	}		
	private void Noticedelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int noticeID = Integer.parseInt(request.getParameter("noticeID"));
		System.out.println("공지삭제에서 받아온 id를 찍어줘~~   "+ noticeID);
		
		try {
			nsvc.deleteNotice(noticeID);
			} catch (SQLException e) {
			e.printStackTrace();
		}		
	} 

	
		
	
	private void searchByID(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String noticeID = request.getParameter("noticeID");
		String updateId = request.getParameter("noticeUpdateID");
		if(updateId == null){
		try{
			NoticeDto nview = nsvc.searchByID(Integer.parseInt(noticeID));
			System.out.println("nview를 출력하세요   :  " + nview);
			request.setAttribute("nview", nview);
			request.getRequestDispatcher("/notice.jsp").forward(request, response);
		}catch(Exception e){
			e.printStackTrace();
			//response.sendRedirect(request.getContextPath()+"/error/500.jsp");
		}	
		}else{
		
			String noticeTitle =request.getParameter("noticeTitle");
			String noticeContent =request.getParameter("noticeContent");
			//String userID = request.getParameter("userID");
			NoticeDto noticeDto = new NoticeDto(Integer.parseInt(updateId),noticeTitle, noticeContent);
			
			try {
				nsvc.modifyNotice(noticeDto);
				//response.sendRedirect(request.getContextPath()+"/NoticeMain?act=selectAll");
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	} 
	
	

	private void Noticeinsert(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		HttpSession session = request.getSession();
	      UserDto userdto = (UserDto) session.getAttribute("userInfo");
	      String userID = userdto.getUserId();
		
		
		String noticeTitle =request.getParameter("noticeTitle");
		String noticeContent =request.getParameter("noticeContent");
//		String userID = request.getParameter("userID");
		NoticeDto noticeDto = new NoticeDto(noticeTitle, noticeContent, userID);
		System.out.println("insert main 들어왔니~~~~");
		try {
			nsvc.insertNotice(noticeDto);
		//	response.setStatus(200);
		//	response.sendRedirect(request.getContextPath()+"/NoticeMain2?act=selectAll");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

	private void selectAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("메인에서 리스트메소드까지는 왔어욥!!");
			
		
		try {
			List<NoticeDto> nlist = nsvc.selectAll();
			System.out.println("nlist     " +nlist);

			request.setAttribute("nlist", nlist);
			request.getRequestDispatcher("/notice.jsp").forward(request, response);

			
		} catch (SQLException e) {
			e.printStackTrace();
			//response.sendRedirect(request.getContextPath()+"/error/500.jsp");
		}
		
		
	}


}
