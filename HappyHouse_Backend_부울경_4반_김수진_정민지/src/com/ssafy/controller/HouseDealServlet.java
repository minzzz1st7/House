package com.ssafy.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssafy.dto.HouseDealDto;
import com.ssafy.service.HouseDealService;
import com.ssafy.service.HouseDealServiceImpl;

@WebServlet("/houseDeal")
public class HouseDealServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private HouseDealService houseDealService = HouseDealServiceImpl.getHouseService();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String act = request.getParameter("act");
		String path = "/index.jsp";
		System.out.println("act");
		System.out.println(act);
		if("searchByRegion".equals(act)) {
			System.out.println("searchByRegion on");
			path = searchByRegion(request, response);
			request.getRequestDispatcher(path).forward(request, response);
		}

		else if("searchByApt".equals(act)) {
			System.out.println("searchByApt on");
			path = searchByApt(request, response);
			request.getRequestDispatcher(path).forward(request, response);
		}
		else{
			System.out.println("test");
		}
	}

	private String searchByRegion(HttpServletRequest request, HttpServletResponse response) {
		HouseDealDto houseDealDto = new HouseDealDto();
		System.out.println(request.toString());
		String sido = request.getParameter("sido");
		String gugun = request.getParameter("sigugun");
		String dong =  request.getParameter("dong");
		
//		houseDealDto.setDealID(Integer.parseInt(request.getParameter("dealID")));
//		houseDealDto.setLAWD_CD(request.getParameter("LAWD_CD"));
//		houseDealDto.setDEAL_YMD(request.getParameter("DEAL_YMD"));
//		houseDealDto.setBuildYear(request.getParameter("buildYear"));
//		houseDealDto.setDealYear(request.getParameter("dealYear"));
//		houseDealDto.setDong(request.getParameter("dong"));
//		houseDealDto.setAptName(request.getParameter("aptName"));
//		houseDealDto.setDealMonth(request.getParameter("dealMonth"));
//		houseDealDto.setDealDay(request.getParameter("dealDay"));
//		houseDealDto.setArea(request.getParameter("area"));
//		houseDealDto.setRelativeNumber(request.getParameter("relativeNumber"));
		List<HouseDealDto> l = houseDealService.searchByRegion(sido,gugun,dong);

		HttpSession session = request.getSession();
		session.setAttribute("housedealInfo", l);
		
		for(int i=0;i<l.size();++i) {
			System.out.println(l.get(i).toString());
		}
		try {
			return "/findTransaction.jsp";
		}
		catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "아파트 검색 중 문제가 발생했습니다.");
			return "/error/error.jsp";
		}
	}
	
	private String searchByApt(HttpServletRequest request, HttpServletResponse response) {
		HouseDealDto houseDealDto = new HouseDealDto();
		String aptName = request.getParameter("aptName");
//		houseDealDto.setDealID(Integer.parseInt(request.getParameter("dealID")));
//		houseDealDto.setLAWD_CD(request.getParameter("LAWD_CD"));
//		houseDealDto.setDEAL_YMD(request.getParameter("DEAL_YMD"));
//		houseDealDto.se)tBuildYear(request.getParameter("buildYear"));
//		houseDealDto.setDealYear(request.getParameter("dealYear"));
//		houseDealDto.setDong(request.getParameter("dong"));
//		houseDealDto.setAptName(request.getParameter("aptName"));
//		houseDealDto.setDealMonth(request.getParameter("dealMonth"));
//		houseDealDto.setDealDay(request.getParameter("dealDay"));
//		houseDealDto.setArea(request.getParameter("area"));
//		houseDealDto.setRelativeNumber(request.getParameter("relativeNumber"));
		List<HouseDealDto> l = houseDealService.searchByApt(aptName);
		HttpSession session = request.getSession();
		session.setAttribute("housedealInfo", l);
		// 이제 여기서 데이터를 넘겨줘야 한다
		try {
			return "/findTransactionApt.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "아파트 검색 중 문제가 발생했습니다.");
			return "/error/error.jsp";
		}
	}
	
	
//	private String loginOutMember(HttpServletRequest request, HttpServletResponse response) {
//		HttpSession session = request.getSession();
////		session.setAttribute("userInfo", null);
////		session.removeAttribute("userInfo");
//		session.invalidate();
//		return "/index.jsp";
//	}

}
