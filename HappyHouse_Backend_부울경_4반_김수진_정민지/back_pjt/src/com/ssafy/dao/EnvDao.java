package com.ssafy.dao;

import java.util.List;

import com.ssafy.dto.EnvDto;


public interface EnvDao {
	public List<EnvDto> searchAll(String sidogun);
}
