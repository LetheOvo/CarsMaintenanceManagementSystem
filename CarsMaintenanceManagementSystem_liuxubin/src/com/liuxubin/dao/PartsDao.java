package com.liuxubin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.liuxubin.Model.Parts;
import com.liuxubin.util.StringUtil;

public class PartsDao {
	/**
	 * 零件名称录入
	 * @param conn
	 * @param parts
	 * @return
	 * @throws Exception
	 */
	public int add(Connection conn,Parts parts)throws Exception{
		String sql="insert into partsinventory values(null,?,?,?)";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1, parts.getPartsId());
		pstmt.setString(2, parts.getPartsNumber());
		pstmt.setString(3, parts.getPartsPrice());
		return pstmt.executeUpdate();
		
	}
	/**
	 * 查询零件名称
	 * @param conn
	 * @param parts
	 * @return
	 * @throws Exception
	 */
	public ResultSet list(Connection conn,Parts  parts)throws Exception{
		StringBuffer sb=new StringBuffer("select*from partsinventory");
		if (StringUtil.isNotEmpty(parts.getPartsId())) {
			sb.append(" and partsId like '%"+parts.getPartsId()+"%'");
		}
		PreparedStatement pstmt=conn.prepareStatement(sb.toString().replaceFirst("and", "where"));
	    return pstmt.executeQuery();
	}
}
