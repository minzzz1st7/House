package com.ssafy.dto;

public class HouseDealDto {

	private int dealID;
	private String LAWD_CD;
	private String DEAL_YMD;
	private String dealAmount;
	private String buildYear;
	private String dealYear;
	private String dong;
	private String aptName;
	private String dealMonth;
	private String dealDay;
	private String area;
	private String relativeNumber;
	private String roadName;
	private String jiBun;
	private String bunCode;
	private String buBunCode;
	private String guGunCode;
	public String getBunCode() {
		return bunCode;
	}
	public void setBunCode(String bunCode) {
		this.bunCode = bunCode;
	}
	public String getBuBunCode() {
		return buBunCode;
	}
	public void setBuBunCode(String buBunCode) {
		this.buBunCode = buBunCode;
	}
	public String getGuGunCode() {
		return guGunCode;
	}
	public void setGuGunCode(String guGunCode) {
		this.guGunCode = guGunCode;
	}

    public String getRoadName() {
		return roadName;
	}
	public void setRoadName(String roadName) {
		this.roadName = roadName;
	}
	public String getJiBun() {
		return jiBun;
	}
	public void setJiBun(String jiBun) {
		this.jiBun = jiBun;
	}
	@Override
	public String toString() {
		return "HouseDealDto [dealID=" + dealID + ", LAWD_CD=" + LAWD_CD + ", DEAL_YMD=" + DEAL_YMD + ", dealAmount="
				+ dealAmount + ", buildYear=" + buildYear + ", dealYear=" + dealYear + ", dong=" + dong + ", aptName="
				+ aptName + ", dealMonth=" + dealMonth + ", dealDay=" + dealDay + ", area=" + area + ", relativeNumber="
				+ relativeNumber + ", roadName=" + roadName + ", jiBun=" + jiBun + ", bunCode=" + bunCode
				+ ", buBunCode=" + buBunCode + ", guGunCode=" + guGunCode + ", floor=" + floor + "]";
	}
	private String floor;
	public int getDealID() {
		return dealID;
	}
	public void setDealID(int dealID) {
		this.dealID = dealID;
	}
	public String getLAWD_CD() {
		return LAWD_CD;
	}
	public void setLAWD_CD(String lAWD_CD) {
		LAWD_CD = lAWD_CD;
	}
	public String getDEAL_YMD() {
		return DEAL_YMD;
	}
	public void setDEAL_YMD(String dEAL_YMD) {
		DEAL_YMD = dEAL_YMD;
	}
	public String getDealAmount() {
		return dealAmount;
	}
	public void setDealAmount(String dealAmount) {
		this.dealAmount = dealAmount;
	}
	public String getBuildYear() {
		return buildYear;
	}
	public void setBuildYear(String buildYear) {
		this.buildYear = buildYear;
	}
	public String getDealYear() {
		return dealYear;
	}
	public void setDealYear(String dealYear) {
		this.dealYear = dealYear;
	}
	public String getDong() {
		return dong;
	}
	public void setDong(String dong) {
		this.dong = dong;
	}
	public String getAptName() {
		return aptName;
	}
	public void setAptName(String aptName) {
		this.aptName = aptName;
	}
	public String getDealMonth() {
		return dealMonth;
	}
	public void setDealMonth(String dealMonth) {
		this.dealMonth = dealMonth;
	}
	public String getDealDay() {
		return dealDay;
	}
	public void setDealDay(String dealDay) {
		this.dealDay = dealDay;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getRelativeNumber() {
		return relativeNumber;
	}
	public void setRelativeNumber(String relativeNumber) {
		this.relativeNumber = relativeNumber;
	}
	public String getFloor() {
		return floor;
	}
	public void setFloor(String floor) {
		this.floor = floor;
	}
	

}
