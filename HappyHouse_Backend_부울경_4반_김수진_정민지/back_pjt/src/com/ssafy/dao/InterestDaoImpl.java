package com.ssafy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.dto.RegionDto;
import com.ssafy.util.DBUtil;


public  class InterestDaoImpl implements InterestDao {

	
	private static InterestDao instance = new InterestDaoImpl();
	private InterestDaoImpl() {}
	public static InterestDao getInstance() {
		return instance;
	}
	private DBUtil dbUtil = DBUtil.getInstance();
	
	
	// 공지 등록
	@Override
	public void insertInterest(RegionDto interestDto) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into userInterest(userId, sidoCode, sigugunCode,dongCode,areaName) values (?, ?, ?,?,?)";
		try {
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			// id는 자동으로 등록
			pstmt.setString(1, interestDto.getUserId());
			pstmt.setString(2, interestDto.getSidoCode());
			pstmt.setString(3, interestDto.getSigugunCode());
			pstmt.setString(4, interestDto.getDongCode());
			pstmt.setString(5, interestDto.getAreaName());
			System.out.println(pstmt);
			pstmt.executeUpdate();
		} finally {
			dbUtil.close(pstmt, conn);
		}
	}
	
	// 공지 삭제
	@Override
	public void deleteInterest(int InterestID) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		System.out.println("삭제 아이디   " + InterestID);
		String sql = "delete from userInterest where interestId = ?";
		try {
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, InterestID);
			pstmt.executeUpdate();
		} finally {
			dbUtil.close(pstmt, conn);
		}
	}
	
	@Override
	public List<RegionDto> searchByUserID(String userid) throws SQLException {
		List<RegionDto> list = new ArrayList<RegionDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dbUtil.getConnection();
			StringBuilder listRegion = new StringBuilder();
			listRegion.append("select * from userInterest \n");
			listRegion.append("where userid = ? ");
			
			pstmt = conn.prepareStatement(listRegion.toString());
			pstmt.setString(1,userid);
			System.out.println(pstmt.toString());
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				RegionDto regionDto = new RegionDto();
				regionDto.setInterestId(rs.getInt("InterestId"));
				regionDto.setUserId(rs.getString("userid"));
				regionDto.setSidoCode(rs.getString("SidoCode"));
				regionDto.setSigugunCode(rs.getString("SigugunCode"));
				regionDto.setDongCode(rs.getString("DongCode"));
				regionDto.setAreaName(rs.getString("AreaName"));
				
				list.add(regionDto);
			}
		} finally {
			dbUtil.close(rs, pstmt, conn);
		}
		return list;
	}

}
