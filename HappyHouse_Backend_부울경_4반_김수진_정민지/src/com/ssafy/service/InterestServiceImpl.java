package com.ssafy.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.dao.InterestDao;
import com.ssafy.dao.InterestDaoImpl;
import com.ssafy.dto.RegionDto;

public class InterestServiceImpl implements InterestService {
	
	private static InterestService instance = new InterestServiceImpl();
	private InterestServiceImpl() {}
	public static InterestService getInstance(){
		return instance;
	}
	private InterestDao dao = InterestDaoImpl.getInstance();

	
	
	@Override
	public void insertInterest(RegionDto interestDto) throws SQLException {
		dao.insertInterest(interestDto);
	}

	
	@Override
	public void deleteInterest(int interestID) throws SQLException {
		dao.deleteInterest(interestID);
	}
	
	@Override
	public List<RegionDto> searchByUserID(String userid) throws SQLException {
		return dao.searchByUserID(userid);
	}
	
}
