package com.ssafy.dao;

import java.util.List;

import com.ssafy.dto.HouseDealDto;

public interface HouseDealDao {

	List<HouseDealDto> searchByRegion(String si,String gugun, String dong);
	List<HouseDealDto> searchByApt(String aptName);
	
}
