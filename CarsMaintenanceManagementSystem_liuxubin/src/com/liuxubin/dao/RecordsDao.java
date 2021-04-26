package com.liuxubin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.liuxubin.Model.Records;

public class RecordsDao {

	public int add(Connection conn,Records records)throws Exception{
		String sql="insert into records values(null,?,?,?,?,?)";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, records.getPlateNumber());
		pstmt.setString(2, records.getPartsId());
		pstmt.setString(3, records.getUseNumber());
		pstmt.setString(4, records.getRepairNumber());
		pstmt.setString(5, records.getRepairTime());
		return pstmt.executeUpdate();
		
	}
}
