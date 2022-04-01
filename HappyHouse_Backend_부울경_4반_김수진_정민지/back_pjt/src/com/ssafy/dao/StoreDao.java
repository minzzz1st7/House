package com.ssafy.dao;

import java.util.List;

import com.ssafy.dto.StoreDto;

public interface StoreDao {
	public List<StoreDto> searchByCodes(String[] codes, String regionCode);
	public List<StoreDto> searchAll( String regionCode);
}