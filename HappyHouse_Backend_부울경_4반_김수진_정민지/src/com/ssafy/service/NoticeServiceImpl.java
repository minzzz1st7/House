package com.ssafy.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.dao.NoticeDao;
import com.ssafy.dao.NoticeDaoImpl;
import com.ssafy.dto.NoticeDto;

public class NoticeServiceImpl implements NoticeService {
	
	private static NoticeService instance = new NoticeServiceImpl();
	private NoticeServiceImpl() {}
	public static NoticeService getInstance(){
		return instance;
	}
	private NoticeDao dao = NoticeDaoImpl.getInstance();

	
	
	@Override
	public void insertNotice(NoticeDto noticedto) throws SQLException {
		dao.insertNotice(noticedto);
	}

	@Override
	public List<NoticeDto> selectAll() throws SQLException {
		return dao.selectAll();
	}
	
	
	@Override
	public NoticeDto serachNotice(String noticeTitle) throws SQLException {
		return dao.serachNotice(noticeTitle);
	}



	
	@Override
	public void modifyNotice(NoticeDto noticedto) throws SQLException {
		dao.modifyNotice(noticedto);
	}

	@Override
	public void deleteNotice(int NoticeID) throws SQLException {
		dao.deleteNotice(NoticeID);
	}
	
	
	@Override
	public NoticeDto searchByID(int noticeID) throws SQLException {
		// TODO Auto-generated method stub
		return dao.searchByID(noticeID);
	}
	
	

	
	
}
