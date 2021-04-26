package com.liuxubin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.liuxubin.Model.Client;
import com.liuxubin.util.StringUtil;


public class ClientDao {
/**
 * 客户信息录入类
 * @param conn
 * @param client
 * @return
 * @throws Exception
 */
	public int add(Connection conn,Client client)throws Exception{
		String sql="insert into information values(null,?,?,?,?,?)";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1,client.getClientName());
		pstmt.setString(2,client.getGender());
		pstmt.setString(3,client.getIDNumber());
		pstmt.setString(4,client.getPhoneNumber());
		pstmt.setString(5,client.getHomeAddress());
		
		return pstmt.executeUpdate();
		
	}
	/**
	 * 查询客户信息类别集合
	 * @param conn
	 * @param client
	 * @return
	 * @throws Exception
	 */
	public ResultSet list(Connection conn,Client client)throws Exception{
		StringBuffer sb=new StringBuffer("select*from information");
		if(StringUtil.isNotEmpty(client.getClientName())){
			sb.append(" and ClientName like '%"+client.getClientName()+"%'");			
		}
		PreparedStatement pstmt = conn.prepareStatement(sb.toString().replaceFirst("and", "where"));
		
		return pstmt.executeQuery();
	}
}
