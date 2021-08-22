package dev.manager.model.dao;

import java.util.List;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import dev.dto.ProductDTO;

public class ManagerDAO {
	
	private Properties prop = new Properties();
	
	public ManagerDAO() {
		try {
			prop.loadFromXML(new FileInputStream("mapper/BR10-query.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/* 전체 재고 목록을 list로 받아 오는 게 맞나? */
	public List<ProductDTO> selectAllProducts(Connection con) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		List<ProductDTO> productList = null;
		
		String query = prop.getProperty("selectAllProducts");
		
		try {
			pstmt = con.prepareStatement(query);
			
			rset = pstmt.executeQuery();
			productList = new ArrayList<>();
			
			while(rset.next()) {
				ProductDTO product = new ProductDTO();
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		return productList;
	}
}
