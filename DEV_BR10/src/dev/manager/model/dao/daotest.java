package dev.manager.model.dao;

import static dev.common.JDBCTemplate.close;
import static dev.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import dev.customer.model.dao.CustomerDAO;
import dev.dto.OrderDTO;
import dev.dto.PayDTO;
import dev.dto.ProductDTO;
import dev.dto.UserDTO;

public class daotest {

   public static void main(String[] args) {

      ManagerDAO managerDAO = new ManagerDAO();
      CustomerDAO customerDAO = new CustomerDAO();
      
      Connection con = getConnection();
      
      List<ProductDTO> productList = managerDAO.selectAllProducts(con);
      List<PayDTO> payList = managerDAO.selectAllPays(con);
      List<UserDTO> userList = customerDAO.selectAllUsers(con);
      

//      OrderDTO orderDTO = new OrderDTO();
//      orderDTO.setOrderNum(0);
      
//      customerDAO.insertOrder(con, null);
      close(con);
      
      System.out.println(userList);
//      System.out.println(productList);
//      System.out.println(payList);
      
      /* */
      
   }

}