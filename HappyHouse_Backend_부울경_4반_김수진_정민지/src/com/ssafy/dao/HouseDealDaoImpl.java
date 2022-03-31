package com.ssafy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.dto.HouseDealDto;
import com.ssafy.util.DBUtil;


public class HouseDealDaoImpl implements HouseDealDao {
	
	private DBUtil dbUtil = DBUtil.getInstance();
	
	private static HouseDealDao memberDao = new HouseDealDaoImpl();
	
	private HouseDealDaoImpl() {}

	public static HouseDealDao getMemberDao() {
		return memberDao;
	}
	
	@Override
	public List<HouseDealDto> searchByRegion(String si, String gugun, String dong) {
      List<HouseDealDto> houseDealDtoList = new ArrayList<HouseDealDto>();
      HouseDealDto houseDealDto = null;
      Connection conn = null;
      PreparedStatement pstmt = null;
      ResultSet rs = null;
      System.out.println("working");
      try {
          conn = dbUtil.getConnection();
          String sql1 = "select sidoName\n";
          sql1 += "from sidocode \n";
          sql1 += "where sidoCode = ?";
          pstmt = conn.prepareStatement(sql1);
          pstmt.setInt(1, Integer.parseInt(si));
          rs = pstmt.executeQuery();
          rs.next();
          String sidoName = rs.getString("sidoName");
          
          System.out.println(sidoName);
          System.out.println(si+gugun);
          
          String sql2 = "select gugunName\n";
          sql2 += "from guguncode \n";
          sql2 += "where sidoCode= ? && gugunCode= ? ;";
          
          rs = null;
          pstmt = null;
          pstmt = conn.prepareStatement(sql2);
          pstmt.setString(1, si);
          pstmt.setString(2, gugun);
          rs = pstmt.executeQuery();
          rs.next();
          String gugunName = rs.getString("gugunName");
          
          System.out.println("gugunName");
          System.out.println(gugunName);
          
          String code = si+gugun;
          System.out.println(code);
          String sql3 = "select dongName\n";
          sql3 += "from dongcode \n";
          sql3 += "where sidogunCode = ?;";
          pstmt = conn.prepareStatement(sql3);
          pstmt.setString(1, code);
          rs = pstmt.executeQuery();
          rs.next();
          String dongName = rs.getString("dongName");
          System.out.println(dongName);
          
          rs = null;
          pstmt = null;
          String sigugun = si+gugun;
          String sql = "select * \n";
          sql += "from housedeal \n";
          sql += "where dong = ? && LAWD_CD= ?";
          pstmt = conn.prepareStatement(sql);
          pstmt.setString(1, dongName);
          pstmt.setString(2, sigugun);

          
          rs = pstmt.executeQuery();
          try {
              while (rs.next()) {
                  houseDealDto = new HouseDealDto();
                  houseDealDto.setDealID(rs.getInt("dealID"));
                  houseDealDto.setDong(rs.getString("dong"));
                  houseDealDto.setDEAL_YMD(rs.getString("DEAL_YMD"));
                  houseDealDto.setDealAmount(rs.getString("dealAmount"));
                  houseDealDto.setDealYear(rs.getString("dealYear"));
                  houseDealDto.setDealMonth(rs.getString("dealMonth"));
                  houseDealDto.setDealDay(rs.getString("dealDay"));
                  houseDealDto.setArea(rs.getString("area"));
                  houseDealDto.setAptName(rs.getString("aptName"));
                  houseDealDto.setBuildYear(rs.getString("buildYear"));
                  houseDealDto.setLAWD_CD(rs.getString("LAWD_CD"));
                  houseDealDto.setFloor(rs.getString("floor"));
                  houseDealDtoList.add(houseDealDto);
              }
          } catch (SQLException e) {
              e.printStackTrace();
          }
      } catch (SQLException e) {
          e.printStackTrace();
      } finally {
    	  dbUtil.close(rs, pstmt, conn);
      }
      return houseDealDtoList;
	}


    @Override
    public List<HouseDealDto> searchByApt(String aptName) {
        List<HouseDealDto> houseDealDtoList = new ArrayList<HouseDealDto>();
        HouseDealDto houseDealDto = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = dbUtil.getConnection();
            String sql = "select * \n";
            sql += "from housedeal \n";
            sql += "where aptName = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, aptName);

            rs = pstmt.executeQuery();
            try {
                while (rs.next()) {
                    houseDealDto = new HouseDealDto();
                    houseDealDto.setDealID(rs.getInt("dealID"));
                    houseDealDto.setLAWD_CD(rs.getString("LAWD_CD"));
                    houseDealDto.setDong(rs.getString("dong"));
                    houseDealDto.setDEAL_YMD(rs.getString("DEAL_YMD"));
                    houseDealDto.setDealAmount(rs.getString("dealAmount"));
                    houseDealDto.setDealYear(rs.getString("dealYear"));
                    houseDealDto.setDealMonth(rs.getString("dealMonth"));
                    houseDealDto.setDealDay(rs.getString("dealDay"));
                    houseDealDto.setArea(rs.getString("area"));
                    houseDealDto.setAptName(rs.getString("aptName"));
                    houseDealDto.setBuildYear(rs.getString("buildYear"));
                    houseDealDto.setLAWD_CD(rs.getString("LAWD_CD"));
                    houseDealDto.setFloor(rs.getString("floor"));

                    houseDealDtoList.add(houseDealDto);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	dbUtil.close(rs, pstmt, conn);
        }
        return houseDealDtoList;
    }

//	@Override
//	public HouseDto login(String id, String pass) throws SQLException {
//		HouseDto memberDto = null;
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		try {
//			conn = dbUtil.getConnection();
//			StringBuilder loginMember = new StringBuilder();
//			loginMember.append("select userid, username \n");
//			loginMember.append("from ssafy_member \n");
//			loginMember.append("where userid = ? and userpwd = ? \n");
//			pstmt = conn.prepareStatement(loginMember.toString());
//			pstmt.setString(1, id);
//			pstmt.setString(2, pass);
//			rs = pstmt.executeQuery();
//			if (rs.next()) {
//				memberDto = new HouseDto();
//				memberDto.setUserId(rs.getString("userid"));
//				memberDto.setUserName(rs.getString("username"));
//			}
//		} finally {
//			dbUtil.close(rs, pstmt, conn);
//		}
//		return memberDto;
//	}



}
