package com.ssafy.dto;

public class NoticeDto {

	
	private int noticeID;
	private String noticeTitle;
	private String noticeContent;
	private String userID;
	private String noticeDate;
	
	

	public NoticeDto() {}


	public NoticeDto(String noticeTitle, String noticeContent, String userID) {
		
		this.noticeTitle = noticeTitle;
		this.noticeContent = noticeContent;
		this.userID = userID;
	}

	public NoticeDto(int noticeID,String noticeTitle, String noticeContent) {
		this.noticeID = noticeID;
		this.noticeTitle = noticeTitle;
		this.noticeContent = noticeContent;
		
	}
	public NoticeDto(int noticeID, String noticeTitle, String noticeContent, String userID, String noticeDate) {	
		this.noticeID = noticeID;
		this.noticeTitle = noticeTitle;
		this.noticeContent = noticeContent;
		this.userID = userID;
		this.noticeDate = noticeDate;
	}
	
	
	public int getNoticeID() {
		return noticeID;
	}
	public void setNoticeID(int noticeID) {
		this.noticeID = noticeID;
	}
	public String getNoticeTitle() {
		return noticeTitle;
	}
	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}
	public String getNoticeContent() {
		return noticeContent;
	}
	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getNoticeDate() {
		return noticeDate;
	}
	public void setNoticeDate(String noticeDate) {
		this.noticeDate = noticeDate;
	}


	@Override
	public String toString() {
		return "NoticeDto [noticeID=" + noticeID + ", noticeTitle=" + noticeTitle + ", noticeContent=" + noticeContent
				+ ", userID=" + userID + ", noticeDate=" + noticeDate + "]";
	}
	
	
	

}
