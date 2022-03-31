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

import com.ssafy.dto.EnvDto;
import com.ssafy.dto.StoreDto;
import com.ssafy.service.EnvService;
import com.ssafy.service.EnvServiceImpl;
import com.ssafy.service.StoreService;
import com.ssafy.service.StoreServiceImpl;

@WebServlet("/main")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	StoreService storeService = StoreServiceImpl.getInstance();
	EnvService envService = EnvServiceImpl.getInstance();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String act = request.getParameter("act");
		String cmd = "";
		String path = "";
		if (act.equals("store")) {

			cmd = request.getParameter("cmd");

			if (cmd.equals("mvInterest")) {
				response.sendRedirect("interest.jsp");
			} else if (cmd.equals("mvStore")) {
				path = mvStoreEnv(request, response, cmd);
				if (path != null) {
					request.getRequestDispatcher(path).forward(request, response);
				}
			} else if (cmd.equals("searchStore")) {
				searchByCodes(request, response);
			}
		} else if (act.equals("env")) {
			cmd = request.getParameter("cmd");
			if (cmd.equals("mvEnv")) {
				path = mvStoreEnv(request, response, cmd);
				if (path != null) {
					request.getRequestDispatcher(path).forward(request, response);
				}
			} else if (cmd.equals("searchEnv")) {
				searchEnvAll(request, response);
			}
		}

	}

	private void searchEnvAll(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String regionCode = request.getParameter("regionCode");
		String sidogun = regionCode.substring(0, 5);
		String dong = regionCode.substring(5, 10);

		List<EnvDto> envList = envService.searchAll(sidogun);
		request.setAttribute("regionCode", regionCode);
		request.setAttribute("storeList", envList);

		// list를 JSON 형식으로
		JSONArray jsonArr = new JSONArray();
		for (EnvDto env : envList) {
			JSONObject json = new JSONObject();
			json.put("sidogun", env.getSidogunCode());
			json.put("dong", env.getDongCode());
			json.put("name", env.getName());
			json.put("typename", env.getTypeName());
			json.put("address", env.getAddress());

			jsonArr.add(json);
		}

		// 클라이언트에게 보내기
		response.setCharacterEncoding("utf-8");
		// JSON 형태의String으로
		response.getWriter().print(jsonArr.toJSONString());

	}

	private String mvStoreEnv(HttpServletRequest request, HttpServletResponse response, String cmd) {

		String regionCode = request.getParameter("regionCode");
		if(regionCode != null) {
			String sido = regionCode.substring(0, 2);
			String sigugun = regionCode.substring(2, 5);
			String dong = regionCode.substring(5, 8);

			request.setAttribute("sido", sido);
			request.setAttribute("sigugun", sigugun);
			request.setAttribute("dong", dong);
		}


		if (cmd.equals("mvStore")) {
			return "/store.jsp";
		} else if (cmd.equals("mvEnv")) {
			return "/env.jsp";
		} else {
			return null;
		}
	}

	private void searchByCodes(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String[] checked = request.getParameterValues("checked");
		String regionCode = request.getParameter("regionCode");

		List<StoreDto> storeList = storeService.searchByCodes(checked, regionCode);
		request.setAttribute("regionCode", regionCode);
		request.setAttribute("storeList", storeList);

		// list를 JSON 형식으로
		JSONArray jsonArr = new JSONArray();
		for (StoreDto store : storeList) {
			JSONObject json = new JSONObject();
			json.put("lat", store.getLat());
			json.put("lng", store.getLng());
			json.put("storename", store.getStoreName());
			json.put("storeid", store.getStoreID());
			json.put("address", store.getAddress());

			jsonArr.add(json);
		}

		// 클라이언트에게 보내기
		response.setCharacterEncoding("utf-8");
		// JSON 형태의String으로
		response.getWriter().print(jsonArr.toJSONString());

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
