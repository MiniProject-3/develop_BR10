package dev.manager.model.dao;

import static dev.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import dev.dto.PayDTO;
import dev.dto.ProductDTO;
import dev.dto.SalesProductDTO;

public class ManagerDAO {
   
   private Properties prop = new Properties();
   
   public ManagerDAO() {
      try {
         prop.loadFromXML(new FileInputStream("mapper/BR10-query.xml"));
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
   
   /* 판매량 조회 selectAllSalesProducts -- 작성중*/
   
   
   /* 재고 조회 selectAllProducts */
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
            
            product.setProductNum(rset.getInt("PRODUCT_NUM"));
            product.setProductName(rset.getString("PRODUCT_NAME")); 
              product.setProductPrice(rset.getInt("PRODUCT_PRICE"));
              product.setCategoryCode(rset.getInt("CATEGORY_CODE"));
              product.setStock(rset.getInt("STOCK"));
              
              productList.add(product);
         }
         
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         close(rset);
         close(pstmt);
      }
      
      return productList;
   }
   
   /* 결제내역(저널) 조회 selectAllPays */
   public List<PayDTO> selectAllPays(Connection con) {
      
      PreparedStatement pstmt = null;
      ResultSet rset = null;
      
      List<PayDTO> payList = null;
      
      String query = prop.getProperty("selectAllPays");
      
      try {
         pstmt = con.prepareStatement(query);
         rset = pstmt.executeQuery();
         payList = new ArrayList<>();
         
         while(rset.next()) {
            PayDTO pay = new PayDTO();
            
            pay.setPayNum(rset.getInt("PAY_NUM"));
            pay.setPayTime(rset.getString("PAY_TIME"));
            pay.setPhoneNum(rset.getString("PHONE_NUM"));
            pay.setPayTotal(rset.getInt("PAY_TOTAL"));
            pay.setPaymentNum(rset.getInt("PAYMENT_NUM"));
          
            payList.add(pay);
         }
         
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         close(rset);
         close(pstmt);
      }
      return payList;
   }
   /* 메뉴 관리 */
   /* 메뉴 추가 insertProduct */
   public int insertProduct(Connection con, ProductDTO product) {
      
      PreparedStatement pstmt = null;
      int result = 0;
            
      String query = prop.getProperty("insertProduct");
      
      try {
         pstmt = con.prepareStatement(query);
         pstmt.setInt(1, product.getProductNum());
         pstmt.setString(2, product.getProductName());
         pstmt.setInt(3, product.getProductPrice());
         pstmt.setInt(4, product.getCategoryCode());
         pstmt.setInt(5, product.getStock());

         result = pstmt.executeUpdate();
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         close(pstmt);
      }
      

      return result;
   }
   
   /* 가격 수정 updateProductPrice */
   public int updateProductPrice(Connection con, int productNum, int productPrice) {
      
      PreparedStatement pstmt = null;
      int result = 0;
            
      String query = prop.getProperty("updateProductPrice");
      
      try {
         pstmt = con.prepareStatement(query);
         pstmt.setInt(1,productPrice);
         pstmt.setInt(2, productNum);

         result = pstmt.executeUpdate();
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         close(pstmt);
      }
      return result;
   }
   
   /* 수량 수정 updateProductStock */
   public int updateProductStock(Connection con, int productNum, int productStock) {
      
      PreparedStatement pstmt = null;
      int result = 0;
            
      String query = prop.getProperty("updateProductStock");
      
      try {
         pstmt = con.prepareStatement(query);
         pstmt.setInt(1,productStock);
         pstmt.setInt(2, productNum);

         result = pstmt.executeUpdate();
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         close(pstmt);
      }
      return result;
   }
   
   /* 이름 수정 updateProductName */
   public int updateProductName(Connection con, int productNum, int productName) {
      
      PreparedStatement pstmt = null;
      int result = 0;
            
      String query = prop.getProperty("updateProductName");
      
      try {
         pstmt = con.prepareStatement(query);
         pstmt.setInt(1,productName);
         pstmt.setInt(2, productNum);

         result = pstmt.executeUpdate();
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         close(pstmt);
      }
      return result;
   }
   
   /* 메뉴 삭제 deleteProduct */
   public int deleteProduct(Connection con, int productNum) {
      
      PreparedStatement pstmt = null;
      int result = 0;
            
      String query = prop.getProperty("deleteProduct");
      
      try {
         pstmt = con.prepareStatement(query);
         pstmt.setInt(1,productNum);

         result = pstmt.executeUpdate();
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         close(pstmt);
      }
      return result;
   }
}