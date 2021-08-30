package dev.dto;

import java.io.Serializable;

public class InoDTO implements Serializable{

   /**
    * 
    */
   private static final long serialVersionUID = -1406855883046105817L;

   private int inoNum;      // 입출고 번호
   private String ino;      // 입출고
   private Integer qty;   	// 수량
   private int productNum;  // 상품번호
   
   public InoDTO() {
   }

   public InoDTO(int inoNum, String ino, Integer qty, int productNum) {
      this.inoNum = inoNum;
      this.ino = ino;
      this.qty = qty;
      this.productNum = productNum;
   }

   public int getInoNum() {
      return inoNum;
   }

   public void setInoNum(int inoNum) {
      this.inoNum = inoNum;
   }

   public String getIno() {
      return ino;
   }

   public void setIno(String ino) {
      this.ino = ino;
   }

   public Integer getQty() {
      return qty;
   }

   public void setQty(Integer qty) {
      this.qty = qty;
   }

   public int getProductNum() {
      return productNum;
   }

   public void setProductNum(int productNum) {
      this.productNum = productNum;
   }

   public static long getSerialversionuid() {
      return serialVersionUID;
   }

   @Override
   public String toString() {
      return "InoDTO [inoNum=" + inoNum + ", ino=" + ino + ", qty=" + qty + ", productNum=" + productNum + "]";
   }
}