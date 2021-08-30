package dev.customer.model.dao;

import static dev.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import dev.dto.GiftDTO;
import dev.dto.InoDTO;
import dev.dto.OrderDTO;
import dev.dto.PayDTO;
import dev.dto.ProductDTO;
import dev.dto.UserDTO;

public class CustomerDAO {
   
   private Properties prop = new Properties();
   
   public CustomerDAO() {
      try {
         prop.loadFromXML(new FileInputStream("mapper/BR10-query.xml"));
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
   
   /* 주문 추가 insertOrder*/
   public int insertOrder(Connection con, OrderDTO order) {
      
      PreparedStatement pstmt = null;
      int result = 0;
      
      String query = prop.getProperty("insertOrder");
         
      try {
             pstmt = con.prepareStatement(query);
             pstmt.setInt(1, order.getOrderSeq());
             pstmt.setInt(2, order.getProductNum());
             pstmt.setString(3, order.getPhoneNum());
             pstmt.setInt(4, order.getOrderNum());
             pstmt.setInt(5, order.getQty());
             pstmt.setString(6, order.getPayment());

             result = pstmt.executeUpdate();
          } catch (SQLException e) {
             e.printStackTrace();
          } finally {
             close(pstmt);
          }
      return result;
   }

   /* 주문 업데이트 updateOrder */
   public int updateOrder(Connection con, int orderNum, String payMent) {
	      
       PreparedStatement pstmt = null;
         int result = 0;
               
         String query = prop.getProperty("updateOrder");
         
         try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1,payMent);
            pstmt.setInt(2, orderNum);

	         result = pstmt.executeUpdate();
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         close(pstmt);
	      }
	      return result;
	}
   
   /* selectOrderByOrderNum */
   public List<OrderDTO> selectOrderByOrderNum(Connection con, int orderNum) {
	      
	      PreparedStatement pstmt = null;
	      ResultSet rset = null;
	      
	      List<OrderDTO> orderList = null;
	      
	      String query = prop.getProperty("selectOrderByOrderNum");
	      
	      try {
	         pstmt = con.prepareStatement(query);
	         pstmt.setInt(1, orderNum);
	         
	         rset = pstmt.executeQuery();
	         
	         orderList = new ArrayList<>();
	         
	         if(rset.next()) {
	            OrderDTO order = new OrderDTO();
	            order.setOrderSeq(rset.getInt("ORDER_SEQ"));
	            order.setProductNum(rset.getInt("PRODUCT_NUM")); 
	            order.setPhoneNum(rset.getString("PHONE_NUM"));
	            order.setOrderNum(rset.getInt("ORDER_NUM"));
	            order.setQty(rset.getInt("QTY"));
	            order.setPayment(rset.getString("PAYMENT"));
	            
	            orderList.add(order);
	         }
	         
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         close(rset);
	         close(pstmt);
	      }
	      return orderList;
	   }
   
 
   /* 결제 추가 insertPay */
   public int insertPay(Connection con, PayDTO pay) {
      
      PreparedStatement pstmt = null;
      int result = 0;
      
      String query = prop.getProperty("insertPay");
         
      try {
             pstmt = con.prepareStatement(query);
             pstmt.setInt(1, pay.getPayNum());
             pstmt.setString(2, pay.getPayTime());
             pstmt.setString(3, pay.getPhoneNum());
             pstmt.setInt(4, pay.getPayTotal());
             pstmt.setInt(5, pay.getPaymentNum());

             result = pstmt.executeUpdate();
          } catch (SQLException e) {
             e.printStackTrace();
          } finally {
             close(pstmt);
          }
      
      return result;
   }
   
   /* 회원 여부 조회 - 포인트 조회 */
   /* 1. 결제할 때 통신사 조회
    * 2. 적립할 때 핸드폰 번호 존재 여부 조회
    * */
   public List<UserDTO> selectAllUsers(Connection con) {
         
         PreparedStatement pstmt = null;
         ResultSet rset = null;
         
         List<UserDTO> userList = null;
         
         String query = prop.getProperty("selectAllUsers");
         
         try {
            pstmt = con.prepareStatement(query);
            rset = pstmt.executeQuery();
            userList = new ArrayList<>();
            
            while(rset.next()) {
               UserDTO user = new UserDTO();
               
               user.setPhoneNum(rset.getString("PHONE_NUM"));
               user.setPoint(rset.getInt("POINT"));
               user.setPhoneCo(rset.getString("PHONE_CO")); 
               userList.add(user);
            }
            
         } catch (SQLException e) {
            e.printStackTrace();
         } finally {
            close(rset);
            close(pstmt);
         }
         return userList;
      }   
   
   /* 포인트 내역 업데이트 (사용, 적립) */
   public int updateUserPoint(Connection con, int phoneNum, int point) {
      
       PreparedStatement pstmt = null;
         int result = 0;
               
         String query = prop.getProperty("updateUserPoint");
         
         try {
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1,point);
            pstmt.setInt(2, phoneNum);

	         result = pstmt.executeUpdate();
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         close(pstmt);
	      }
	      return result;
	}
	
	/* 기프티콘 내역 조회 */
	public List<GiftDTO> selectAllGifts(Connection con) {
	      
	      PreparedStatement pstmt = null;
	      ResultSet rset = null;
	      
	      List<GiftDTO> giftList = null;
	      
	      String query = prop.getProperty("selectAllGifts");
	      
	      try {
	         pstmt = con.prepareStatement(query);
	         rset = pstmt.executeQuery();
	         giftList = new ArrayList<>();
	         
	         while(rset.next()) {
	        	 GiftDTO gift = new GiftDTO();
	            
	        	 gift.setGiftNum(rset.getInt("GIFT_NUM"));
	        	 gift.setGiftUse(rset.getString("GIFT_USE"));
	        	 giftList.add(gift);
	         }
	         
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         close(rset);
	         close(pstmt);
	      }
	      return giftList;
	   }	
	
	/* 기프티콘 내역 업데이트(사용) */
	public int updateGiftUse(Connection con, String giftUse, int giftNum) {
		
		 PreparedStatement pstmt = null;
	      int result = 0;
	            
	      String query = prop.getProperty("updateGiftUse");
	      
	      try {
	         pstmt = con.prepareStatement(query);
	         pstmt.setString(1,giftUse);
	         pstmt.setInt(2,giftNum);
	         
	         result = pstmt.executeUpdate();
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         close(pstmt);
	      }
	      return result;
	}
	
	/* 입출고 내역 조회 */
	public List<InoDTO> selectAllInos(Connection con) {
	      
	      PreparedStatement pstmt = null;
	      ResultSet rset = null;
	      
	      List<InoDTO> inoList = null;
	      
	      String query = prop.getProperty("selectAllInos");
	      
	      try {
	         pstmt = con.prepareStatement(query);
	         rset = pstmt.executeQuery();
	         inoList = new ArrayList<>();
	         
	         while(rset.next()) {
	        	 InoDTO ino = new InoDTO();
	            
	        	 ino.setInoNum(rset.getInt("INO_NUM"));
	        	 ino.setIno(rset.getString("INO"));
	        	 
	        	 inoList.add(ino);
	         }
	         
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         close(rset);
	         close(pstmt);
	      }
	      	return inoList;	   
	      }	
	
	   /* 입출고 내역 추가 */
	   public int insertIno(Connection con, InoDTO ino) {
		      
		      PreparedStatement pstmt = null;
		      int result = 0;
		            
		      String query = prop.getProperty("insertIno");
		      
		      try {
		         pstmt = con.prepareStatement(query);
		         pstmt.setInt(1, ino.getInoNum());
		         pstmt.setString(2, ino.getIno());
		         /* NULL 인 경우 판단하기 */
		         if (ino.getQty() == null) {
		        	 pstmt.setNull(3, Types.INTEGER);
		         } else {        	 
		        	 pstmt.setInt(3, ino.getQty());
		         }
		         pstmt.setInt(4, ino.getProductNum());
		         
		         result = pstmt.executeUpdate();
		      } catch (SQLException e) {
		         e.printStackTrace();
		      } finally {
		         close(pstmt);
		      }
		      return result;
		   }
	
	   /* 주문 내역 전체 조회 selectOrder */
	   public List<OrderDTO> selectOrder(Connection con) {
		   
		   	PreparedStatement pstmt = null;
		    ResultSet rset = null;
		      
		    List<OrderDTO> orderList = null;
		      
		    String query = prop.getProperty("selectOrder");
		    
		    try {
				pstmt = con.prepareStatement(query);
				rset = pstmt.executeQuery();
				orderList = new ArrayList<OrderDTO>();
				
				while(rset.next()) {
					OrderDTO order = new OrderDTO();
					order.setOrderSeq(rset.getInt("ORDER_SEQ"));
					order.setProductNum(rset.getInt("PRODUCT_NUM"));
					order.setPhoneNum(rset.getString("PHONE_NUM"));
					order.setOrderNum(rset.getInt("ORDER_NUM"));
					order.setQty(rset.getInt("QTY"));
					order.setPayment(rset.getString("PAYMENT"));
					
					orderList.add(order);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
		         close(rset);
		         close(pstmt); 
			}
		   return orderList;
	   }
	   

	   public int selectOrderNum(Connection con) {
		   
		   	PreparedStatement pstmt = null;
		    ResultSet rset = null;
		      
		    int orderNum = 0 ;
		      
		    String query = prop.getProperty("selectOrderNum");
		    
		    try {
				pstmt = con.prepareStatement(query);
				rset = pstmt.executeQuery();
				
				while(rset.next()) {

					orderNum = rset.getInt("MAX(ORDER_NUM)") + 1;

				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
		         close(rset);
		         close(pstmt); 
			}
		   return orderNum;
	   }
	   
	   

	   public int selectSeqNum(Connection con) {
		   
		   	PreparedStatement pstmt = null;
		    ResultSet rset = null;
		      
		    int seq = 0 ;
		      
		    String query = prop.getProperty("selectSeqNum");
		    
		    try {
				pstmt = con.prepareStatement(query);
				rset = pstmt.executeQuery();
				
				while(rset.next()) {

					seq = rset.getInt("MAX(A.ORDER_SEQ)") + 1;

				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
		         close(rset);
		         close(pstmt); 
			}
		   return seq;
	   }
}
