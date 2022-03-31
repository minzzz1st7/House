package com.ssafy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.dto.NoticeDto;
import com.ssafy.util.DBUtil;


public  class NoticeDaoImpl implements NoticeDao {

	
	private static NoticeDao instance = new NoticeDaoImpl();
	private NoticeDaoImpl() {}
	public static NoticeDao getInstance() {
		return instance;
	}
	private DBUtil dbUtil = DBUtil.getInstance();
	
	
	// 공지 등록
	@Override
	public void insertNotice(NoticeDto noticedto) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into notice(noticeTitle, noticeContent, UserID) values (?, ?, ?)";
		try {
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, noticedto.getNoticeTitle());
			pstmt.setString(2, noticedto.getNoticeContent());
			pstmt.setString(3, noticedto.getUserID());
			pstmt.executeUpdate();
		} finally {
			dbUtil.close(pstmt, conn);
		}
	}
	
	// 공지 목록
	@Override
	public List<NoticeDto> selectAll() throws SQLException {
		
		List<NoticeDto> noticelist = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from notice";
		
		try {
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				
				NoticeDto notice = new NoticeDto();
			
				
				notice.setNoticeID(rs.getInt("noticeID"));
				notice.setNoticeTitle(rs.getString("noticeTitle"));
				notice.setNoticeContent(rs.getString("noticeContent"));
				notice.setUserID(rs.getString("userID"));
				notice.setNoticeDate(rs.getString("noticeDate"));
				
				noticelist.add(notice);
			}
		} finally {
			dbUtil.close(rs, pstmt, conn);
		}
		return noticelist;
	}
	
	
	// 공지 수정
	@Override
	public void modifyNotice(NoticeDto noticedto) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update notice set noticeTitle = ?, noticeContent = ? where noticeID =?" ;
		try {
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			System.out.println("체크!!"+noticedto);
			pstmt.setString(1, noticedto.getNoticeTitle());
			pstmt.setString(2, noticedto.getNoticeContent());
			pstmt.setInt(3, noticedto.getNoticeID());
			pstmt.executeUpdate();
		} finally {
			dbUtil.close(pstmt, conn);
		}
	}
	
	// 공지 삭제
	@Override
	public void deleteNotice(int NoticeID) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		System.out.println("삭제 아이디   " + NoticeID);
		String sql = "delete from notice where NoticeID = ?";
		try {
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, NoticeID);
			pstmt.executeUpdate();
		} finally {
			dbUtil.close(pstmt, conn);
		}
	}
	
	// 제목으로 공지 검색
	@Override
	public NoticeDto serachNotice(String noticeTitle) throws SQLException {
		NoticeDto noticedto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql =  "select * from notice where noticeTitle = ? ";
		
		try {
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, noticeTitle);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				
				noticedto = new NoticeDto();
				noticedto.setNoticeTitle(rs.getString("noticeTitle"));
				noticedto.setNoticeContent(rs.getString("noticeContent"));
				noticedto.setUserID(rs.getString("usrID"));
				noticedto.setNoticeDate(rs.getString("noticeDate"));
			
				}

			} finally {
				dbUtil.close(rs, pstmt, conn);
		}
		return noticedto;
	}
	
	@Override
	public NoticeDto searchByID(int noticeID) throws SQLException {
		NoticeDto noticedto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql =  "select * from notice where noticeID = ? ";
		
		
		try {
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, noticeID);
			rs = pstmt.executeQuery();
			System.out.println(noticeID+"d");
			
			if (rs.next()) {
				
				noticedto = new NoticeDto();
				noticedto.setNoticeID(rs.getInt("noticeID"));
				noticedto.setNoticeTitle(rs.getString("noticeTitle"));
				noticedto.setNoticeContent(rs.getString("noticeContent"));
				noticedto.setUserID(rs.getString("userID"));
				noticedto.setNoticeDate(rs.getString("noticeDate"));
			
				}

			} finally {
				dbUtil.close(rs, pstmt, conn);
		}
		return noticedto;
	}

}
