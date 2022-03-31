package com.ssafy.service;

import java.util.List;

import com.ssafy.dao.EnvDao;
import com.ssafy.dao.EnvDaoImpl;
import com.ssafy.dto.EnvDto;

public class EnvServiceImpl implements EnvService {
	
	private static EnvService instance = new EnvServiceImpl();

	public static EnvService getInstance() {
		return instance;
	}
	
	
	EnvDao envDao = EnvDaoImpl.getInstance();

	@Override
	public List<EnvDto> searchAll(String sidogun) {
		return envDao.searchAll(sidogun);
	}

}
