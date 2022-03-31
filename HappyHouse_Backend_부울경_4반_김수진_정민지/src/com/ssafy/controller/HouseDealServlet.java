package com.ssafy.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

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
			//request.getRequestDispatcher(path).forward(request, response);
		}

		else if("searchByApt".equals(act)) {
			System.out.println("searchByApt on");
			path = searchByApt(request, response);
//			request.getRequestDispatcher(path).forward(request, response);
		}
		
		else if("goPage".equals(act)){			path = "/findTransaction.jsp";
			request.getRequestDispatcher(path).forward(request, response);
		}
		
		else if("goPageApt".equals(act)){
			path = "/findTransactionApt.jsp";
			request.getRequestDispatcher(path).forward(request, response);
		}
	}
	

	private String searchByRegion(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HouseDealDto houseDealDto = new HouseDealDto();
		System.out.println(request.toString());
		String sido = request.getParameter("sido");
		String gugun = request.getParameter("sigugun");
		String dong =  request.getParameter("dong");

		System.out.println("시도동");
		System.out.println(sido);
		System.out.println(gugun);
		System.out.println(dong);
			
		
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
		System.out.println("데이터 수");
		System.out.println(l.size());
//		HttpSession session = request.getSession();
//		session.setAttribute("housedealInfo", l);
		// list를 JSON 형식으로
		JSONArray jsonArr = new JSONArray();
		for (HouseDealDto hdDto : l) {
			JSONObject json = new JSONObject();
			json.put("dong", hdDto.getDong());
			json.put("aptName", hdDto.getAptName());
			json.put("jibun", hdDto.getJiBun());
			json.put("dealAmount", hdDto.getDealAmount());
			json.put("aptName", hdDto.getAptName());
			json.put("area", hdDto.getArea());
			json.put("roadName", hdDto.getRoadName());
			json.put("bunCode", hdDto.getBunCode());
			json.put("buBunCode", hdDto.getBuBunCode());
			json.put("guGunCode", hdDto.getGuGunCode());
			jsonArr.add(json);
		}

		// 클라이언트에게 보내기
		response.setCharacterEncoding("utf-8");
		// JSON 형태의String으로
		try {
			response.getWriter().print(jsonArr.toJSONString());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
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
		System.out.println("1");
		System.out.println("aptName");
		System.out.println(aptName);
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

//		HttpSession session = request.getSession();
//		session.setAttribute("housedealInfo", l);
		// list를 JSON 형식으로
		JSONArray jsonArr = new JSONArray();
		for (HouseDealDto hdDto : l) {
			JSONObject json = new JSONObject();
			json.put("dong", hdDto.getDong());
			json.put("aptName", hdDto.getAptName());
			json.put("jibun", hdDto.getJiBun());
			json.put("dealAmount", hdDto.getDealAmount());
			json.put("aptName", hdDto.getAptName());
			json.put("area", hdDto.getArea());
			json.put("roadName", hdDto.getRoadName());
			json.put("bunCode", hdDto.getBunCode());
			json.put("buBunCode", hdDto.getBuBunCode());
			json.put("guGunCode", hdDto.getGuGunCode());
			jsonArr.add(json);
			System.out.println(json);
		}
		// 클라이언트에게 보내기
		response.setCharacterEncoding("utf-8");
		// JSON 형태의String으로
		try {
			response.getWriter().print(jsonArr.toJSONString());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			
			System.out.print("response get writer error");
			e1.printStackTrace();
			
			
		}

		try {
			return "/findTransactionApt.jsp";
		}
		catch (Exception e) {
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
