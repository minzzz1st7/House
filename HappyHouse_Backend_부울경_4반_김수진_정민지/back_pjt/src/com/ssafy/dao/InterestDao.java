package com.ssafy.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.dto.RegionDto;

public interface InterestDao {
	
	// 공지 등록
	void insertInterest(RegionDto interestDto) throws SQLException;

	// 공지삭제
	void deleteInterest(int InterestID) throws SQLException;
	
	// 리스트
	public List<RegionDto> searchByUserID(String userid) throws SQLException;


}
