package com.ssafy.controller;

import java.util.List;

import com.ssafy.dto.HouseDealDto;

public interface HouseDealService {

	List<HouseDealDto> searchByRegion(String si,String gugun, String dong);
	List<HouseDealDto> searchByApt(String aptName);
//	구현해 보세요!!!
//	void updateMember(MemberDto memberDto) throws Exception;
//	void deleteMember(String id) throws Exception;
//	MemberDto infoMember(String id) throws Exception;
	
}
