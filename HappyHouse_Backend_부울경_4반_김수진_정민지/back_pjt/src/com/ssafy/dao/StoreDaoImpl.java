package com.ssafy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.ssafy.dto.StoreDto;
import com.ssafy.util.DBUtil;

public class StoreDaoImpl implements StoreDao {

	private static StoreDao instance = new StoreDaoImpl();

	public static StoreDao getInstance() {
		return instance;
	}

	DBUtil dbUtil = DBUtil.getInstance();

	@Override
	public List<StoreDto> searchByCodes(String[] codes, String regionCode) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String codeList = Arrays.toString(codes);
		codeList = codeList.replace('[', '(');
		codeList = codeList.replace(']', ')');

		System.out.println(codeList);
		List<StoreDto> storeList = new ArrayList<StoreDto>();
		try {
			conn = dbUtil.getConnection();
			StringBuffer getStores = new StringBuffer();
			getStores.append("select storeId, storename, address, lng, lat from gangwonstore \n");
			getStores.append("where regionCode = ? \n");
			getStores.append("and typeMainCode in \n");
			getStores.append(codeList);

			pstmt = conn.prepareStatement(getStores.toString());
			pstmt.setString(1, regionCode);
			System.out.println(pstmt.toString());
			rs = pstmt.executeQuery();

			while (rs.next()) {
				StoreDto store = new StoreDto();

				store.setStoreID(rs.getString("storeId"));
				store.setStoreName(rs.getString("storename"));
				store.setAddress(rs.getString("address"));
				store.setLng(rs.getString("lng"));
				store.setLat(rs.getString("lat"));

				storeList.add(store);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbUtil.close(rs, pstmt, conn);
		}

		return storeList;
	}

	@Override
	public List<StoreDto> searchAll(String regionCode) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<StoreDto> storeList = new ArrayList<StoreDto>();
		try {
			conn = dbUtil.getConnection();
			StringBuffer getStores = new StringBuffer();
			getStores.append("select storeId, storename, address, lng, lat from gangwonstore \n");
			getStores.append("where regionCode = ? \n");


			pstmt = conn.prepareStatement(getStores.toString());
			pstmt.setString(1, regionCode);
			System.out.println(pstmt.toString());
			rs = pstmt.executeQuery();

			while (rs.next()) {
				StoreDto store = new StoreDto();

				store.setStoreID(rs.getString("storeId"));
				store.setStoreName(rs.getString("storename"));
				store.setAddress(rs.getString("address"));
				store.setLng(rs.getString("lng"));
				store.setLat(rs.getString("lat"));

				storeList.add(store);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbUtil.close(rs, pstmt, conn);
		}

		return storeList;
	}

}
