package dev.manager.model.dao;

import static dev.common.JDBCTemplate.getConnection;
import static dev.common.JDBCTemplate.close;

import java.util.List;
import java.sql.Connection;

import dev.dto.ProductDTO;

public class daotest {

	public static void main(String[] args) {

		ManagerDAO managerDAO = new ManagerDAO();
		
		Connection con = getConnection();
		
		List<ProductDTO> productList = managerDAO.selectAllProducts(con);
		close(con);
		
		System.out.println(productList);
	}

}
