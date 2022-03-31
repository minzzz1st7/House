package com.ssafy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.dto.EnvDto;
import com.ssafy.util.DBUtil;

public class EnvDaoImpl implements EnvDao {

	
	private static EnvDao instance = new EnvDaoImpl();

	public static EnvDao getInstance() {
		return instance;
	}

	DBUtil dbUtil = DBUtil.getInstance();
	
	@Override
	public List<EnvDto> searchAll(String sidogun) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<EnvDto> envList = new ArrayList<EnvDto>();
		try {
			conn = dbUtil.getConnection();
			StringBuffer getEnvs = new StringBuffer();
			getEnvs.append("select * from environ \n");
			getEnvs.append("where sidogunCode = ? \n");
			getEnvs.append("limit 1,10 \n");

			pstmt = conn.prepareStatement(getEnvs.toString());
			pstmt.setString(1, sidogun);
			System.out.println(pstmt.toString());
			rs = pstmt.executeQuery();

			while (rs.next()) {
				EnvDto store = new EnvDto();

				store.setSidogunCode(rs.getString("SidogunCode"));
				store.setDongCode(rs.getString("DongCode"));
				store.setName(rs.getString("name"));
				store.setTypeName(rs.getString("typename"));
				store.setAddress(rs.getString("address"));

				envList.add(store);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbUtil.close(rs, pstmt, conn);
		}

		return envList;
		
	}

}
