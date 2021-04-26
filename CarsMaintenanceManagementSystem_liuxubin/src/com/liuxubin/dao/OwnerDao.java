package com.liuxubin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.liuxubin.Model.Owner;

public class OwnerDao {
	public int add(Connection conn,Owner owner)throws Exception {
		String sql="insert into informationmanagement values(null,?,?,?,?)";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, owner.getOwnerName());
		pstmt.setString(2, owner.getVehicleModel());
		pstmt.setString(3, owner.getVehicleRegistration());
		pstmt.setString(4, owner.getContactNumber());
		
		return pstmt.executeUpdate();
		
	}

}
