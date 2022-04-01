package com.ssafy.service;

import java.util.List;

import com.ssafy.dao.StoreDao;
import com.ssafy.dao.StoreDaoImpl;
import com.ssafy.dto.StoreDto;

public class StoreServiceImpl implements StoreService{
	
	private static StoreService instance = new StoreServiceImpl();
	
	public static StoreService getInstance() {
		return instance;
	}
	
	StoreDao storeDao = StoreDaoImpl.getInstance();

	@Override
	public List<StoreDto> searchByCodes(String[] codes, String regionCode) {
		return storeDao.searchByCodes(codes, regionCode);
	}

	@Override
	public List<StoreDto> searchAll(String regionCode) {
		return storeDao.searchAll(regionCode);
	}

}
