package com.ssafy.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.dto.NoticeDto;

public interface NoticeService {
	
	// 공지 등록
	void insertNotice(NoticeDto noticedto) throws SQLException;
	
	// 공지목록
	List<NoticeDto> selectAll() throws SQLException;
	
	// 공지 검색
	NoticeDto serachNotice(String noticeTitle) throws SQLException;
	
	// 공지수정
	void modifyNotice(NoticeDto noticedto) throws SQLException;
	
	// 공지삭제
	void deleteNotice(int NoticeID) throws SQLException;
	
	// 번호로 상세페이지
	NoticeDto searchByID(int noticeID) throws SQLException;
		
	
}
