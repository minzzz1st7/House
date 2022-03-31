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

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.ssafy.dto.RegionDto;
import com.ssafy.dto.UserDto;
import com.ssafy.service.InterestService;
import com.ssafy.service.InterestServiceImpl;

@WebServlet("/interest")
public class userInterest extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private InterestService itvc = InterestServiceImpl.getInstance();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String action = request.getParameter("act");
		String dir = null;
		switch(action){
			case "mvAddInterest": response.sendRedirect(request.getContextPath() + "/addInterest.jsp"); break;
			case "insertInterest": 
				dir = insertInterest(request, response); 
				response.sendRedirect(dir);
				break;
			case "deleteInterest": 
				dir = deleteInterest(request, response);
				response.sendRedirect(dir);
				break;
			case "list": searchById(request, response);break;
		}	
	}
	
	private void searchById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String userid = request.getParameter("userid");
		System.out.println(userid);
		try {
			List<RegionDto> list = itvc.searchByUserID(userid);
			if(list==null) {
				request.setAttribute("msg", "관심 지역 목록 불러오기 중 에러가 발생했습니다.");
				request.getRequestDispatcher("/interest.jsp").forward(request, response);
			}else {
				JSONArray jsonArr = new JSONArray();
				for (RegionDto item : list) {
					JSONObject json = new JSONObject();
					String regionCode = item.getSidoCode()+item.getSigugunCode()+item.getDongCode()+"00";
					
					json.put("interestid", item.getInterestId());
					json.put("userid", item.getUserId());					
					json.put("areaname", item.getAreaName());
					json.put("regionCode", regionCode);

					jsonArr.add(json);
				}

				// 클라이언트에게 보내기
				response.setCharacterEncoding("utf-8");
				// JSON 형태의String으로
				response.getWriter().print(jsonArr.toJSONString());

			}
						
		}catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "관심 지역 목록 불러오기 중 에러가 발생했습니다.");
			request.getRequestDispatcher("/interest.jsp").forward(request, response);
		}
		
	}
	
	private String deleteInterest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int interestID = Integer.parseInt(request.getParameter("interestID"));
		System.out.println("공지삭제에서 받아온 id를 찍어줘~~   "+ interestID);
		
		try {
			itvc.deleteInterest(interestID);
			return "interest.jsp";
			} catch (SQLException e) {
			e.printStackTrace();
			return "error/error.jsp";
		}		
	} 

	private String insertInterest(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		UserDto userDto = (UserDto)session.getAttribute("userInfo");
		
		String userId = userDto.getUserId();
		String sidoCode =request.getParameter("sidoCode");
		String sigugunCode =request.getParameter("sigugunCode");
		String dongCode =request.getParameter("dongCode");
		String areaName =request.getParameter("areaName");
		//String userID = request.getParameter("userID");
		RegionDto interestDto = new RegionDto(userId, sidoCode,sigugunCode,dongCode,areaName);
		try {
			itvc.insertInterest(interestDto);
		//	response.setStatus(200);
		//	response.sendRedirect(request.getContextPath()+"/NoticeMain2?act=selectAll");
			return "main?act=store&cmd=mvInterest";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error/error.jsp";
		}
	}
	



}
