package com.ssafy.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.dto.RegionDto;

public interface InterestService {
	
	// 관심지역 등록
	void insertInterest(RegionDto interestDto) throws SQLException;
	
	// 관심지역 삭제
	void deleteInterest(int interestID) throws SQLException;
	
	public List<RegionDto> searchByUserID(String userid) throws SQLException;

	
}
