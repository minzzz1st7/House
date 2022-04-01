package com.ssafy.service;

import java.util.List;

import com.ssafy.dto.StoreDto;

public interface StoreService {
	public List<StoreDto> searchByCodes(String[] codes, String regionCode);
	public List<StoreDto> searchAll( String regionCode);
}
