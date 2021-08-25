package dev.manager.model.dao;

import static dev.common.JDBCTemplate.close;
import static dev.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import dev.dto.PayDTO;
import dev.dto.ProductDTO;

public class daotest {

   public static void main(String[] args) {

      ManagerDAO managerDAO = new ManagerDAO();
      
      Connection con = getConnection();
      
      List<ProductDTO> productList = managerDAO.selectAllProducts(con);
      List<PayDTO> payList = managerDAO.selectAllPays(con);

      close(con);
      
      
      System.out.println(productList);

      
   }

}