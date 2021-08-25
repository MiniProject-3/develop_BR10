package dev.views;

import java.util.List;

import dev.dto.PayDTO;
import dev.dto.ProductDTO;

public class ManagerResultView {
   
   public String displayDmlResult(String code) {
      
      switch(code) {
         case"selectFailed" : return ("조회 실패");
         case"updateFailed" : return("수정 실패"); 
         case"deleteFailed" : return("삭제 실패"); 
         case"insertFailed" : return("삽입 실패"); 
         case"insertSuccess" : return("삽입 성공"); 
         case"selectSuccess" : return("조회 성공"); 
         case"updateSuccess" : return("수정 성공"); 
         case"deleteSuccess" : return("삭제 성공"); 
         default : return("알 수 없는 에러 발생");
      }
   }

   /* display 함수 사용할 일 있는지 확인!! */
   public void display(List<ProductDTO> list) {
   
         for(ProductDTO p : list) {
            System.out.println(p);
         }
   }
   
   /* 오버로딩이 불가능 -> 메소드 이름 변경 */
   public void displayPay(List<PayDTO> list) {
   
         for(PayDTO p : list) {
            System.out.println(p);
         }
   }   
   
   public void display(ProductDTO p) {
      System.out.println(p);
   }
   
   public void display(PayDTO p) {
      System.out.println(p);
   }


}