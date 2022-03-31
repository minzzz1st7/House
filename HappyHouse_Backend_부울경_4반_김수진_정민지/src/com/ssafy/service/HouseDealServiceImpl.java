package com.ssafy.service;

import java.util.List;

import com.ssafy.dao.HouseDealDao;
import com.ssafy.dao.HouseDealDaoImpl;
import com.ssafy.dto.HouseDealDto;

public class HouseDealServiceImpl implements HouseDealService {
	
	private HouseDealDao houseDealDao = HouseDealDaoImpl.getMemberDao();
	
	private static HouseDealService houseService = new HouseDealServiceImpl();
	
	private HouseDealServiceImpl() {}

	public static HouseDealService getHouseService() {
		return houseService;
	}

	@Override
	public List<HouseDealDto> searchByRegion(String si, String gugun, String dong) {
		List<HouseDealDto> dto = houseDealDao.searchByRegion(si,gugun,dong);
		return dto;
	}

	@Override
	public List<HouseDealDto> searchByApt(String aptName) {
		// TODO Auto-generated method stub
		List<HouseDealDto> dto = houseDealDao.searchByApt(aptName);
		return dto;
	}
}
