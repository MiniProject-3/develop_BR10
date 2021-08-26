package dev.manager.controller;

import java.util.List;
import java.util.Map;

import dev.dto.PayDTO;
import dev.dto.ProductDTO;
import dev.manager.model.service.ManagerService;
import dev.views.ManagerResultView;

public class ManagerController {

   private ManagerResultView managerResultView = new ManagerResultView();
   private ManagerService managerService = new ManagerService();

<<<<<<< HEAD
	/* 모든 상품 조회 (재고 조회) */
	public List<ProductDTO> selectAllProducts() {
		
		List<ProductDTO> productList = managerService.selectAllProducts();
		
		if(!productList.isEmpty()) {		// 리스트가 비어있지 않은 경우 - 값이 존재하는 경우.
//			managerResultView.display(productList);
			return productList;
		} else {							// 리스트가 비어있는 경우
//			managerResultView.displayDmlResult("selectFailed");
			return null;
		}
	}
=======
   /* 모든 상품 조회 (재고 조회) */
   public Object selectAllProducts() {
      
      List<ProductDTO> productList = managerService.selectAllProducts();
      
      if(!productList.isEmpty()) {      // 리스트가 비어있지 않은 경우 - 값이 존재하는 경우.
//         managerResultView.display(productList);
         return productList;
      } else {                     // 리스트가 비어있는 경우
         return managerResultView.displayDmlResult("selectFailed");
      }
   }
>>>>>>> refs/remotes/origin/SM_MG_0.0

<<<<<<< HEAD
	/* 모든 결제 내역 조회 (저널 조회) */
	public List<PayDTO> selectAllPays() {
		
		List<PayDTO> payList = managerService.selectAllPays();
		
		if(!payList.isEmpty())	{	
//			managerResultView.displayPay(payList);
			return payList;
		}
		else {
//			return managerResultView.displayDmlResult("selectFailed");
			return null;
		}
	}
	
	/* 메뉴 추가 */
	public String registNewProduct(Map<String, String> ansMap) {
	
		ProductDTO productDTO = new ProductDTO();
		
		productDTO.setProductNum(Integer.valueOf(ansMap.get("num")));
		productDTO.setProductName(ansMap.get("name"));
		productDTO.setProductPrice(Integer.valueOf(ansMap.get("price")));
		productDTO.setCategoryCode(Integer.valueOf(ansMap.get("categoryCode")));
		productDTO.setStock(Integer.valueOf(ansMap.get("stock")));
	
		int result = managerService.insertProduct(productDTO);
		
		if (result > 0) {
			return managerResultView.displayDmlResult("insertSuccess");
		}else {
			return managerResultView.displayDmlResult("insertFailed");
		}
	}

	/* 메뉴 수정 - 가격 */
	public String modifyProductPrice(int productNum, int productPrice) {
		int result = managerService.updateProductPrice(productNum, productPrice);
		
		if (result > 0) {
			return managerResultView.displayDmlResult("updateSuccess");
		}else {
			return managerResultView.displayDmlResult("updateFailed");
		}
	}
	
	/* 메뉴 수정 - 수량 */
	public String modifyProductStock(int productNum, int stock) {
		int result = managerService.updateProductPrice(productNum, stock);
		
		if (result > 0) {
			return managerResultView.displayDmlResult("updateSuccess");
		}else {
			return managerResultView.displayDmlResult("updateFailed");
		}
	}
	
	/* 메뉴 수정 - 이름 */
	public String modifyProductName(int productNum, int productName) {
		int result = managerService.updateProductPrice(productNum, productName);
		
		if (result > 0) {
			return managerResultView.displayDmlResult("updateSuccess");
		}
		else {
			return managerResultView.displayDmlResult("updateFailed");
		}
	}
	
	/* 메뉴 삭제 */
	public String deleteProduct(int productNum) {
		int result = managerService.deleteProduct(productNum);
		
		if (result > 0) {
			return managerResultView.displayDmlResult("deleteSuccess");
		}
		else {
			return managerResultView.displayDmlResult("deleteFailed");
		}
	}
}
=======
   /* 모든 결제 내역 조회 (저널 조회) */
   public List<PayDTO> selectAllPays() {
      
      List<PayDTO> payList = managerService.selectAllPays();
      
      if(!payList.isEmpty())   {   
//         managerResultView.displayPay(payList);
         return payList;
      }
      else {
         return null;
      }
   }
   
   /* 메뉴 추가 */
   public String registNewProduct(Map<String, String> ansMap) {
   
      ProductDTO productDTO = new ProductDTO();
      
      productDTO.setProductNum(Integer.valueOf(ansMap.get("num")));
      productDTO.setProductName(ansMap.get("name"));
      productDTO.setProductPrice(Integer.valueOf(ansMap.get("price")));
      productDTO.setCategoryCode(Integer.valueOf(ansMap.get("categoryCode")));
      productDTO.setStock(Integer.valueOf(ansMap.get("stock")));
   
      int result = managerService.insertProduct(productDTO);
      
      if (result > 0) {
         return managerResultView.displayDmlResult("insertSuccess");
      }else {
         return managerResultView.displayDmlResult("insertFailed");
      }
   }

   /* 메뉴 수정 - 가격 */
   public String modifyProductPrice(int productNum, int productPrice) {
      int result = managerService.updateProductPrice(productNum, productPrice);
      
      if (result > 0) {
         return managerResultView.displayDmlResult("updateSuccess");
      }else {
         return managerResultView.displayDmlResult("updateFailed");
      }
   }
   
   /* 메뉴 수정 - 수량 */
   public String modifyProductStock(int productNum, int stock) {
      int result = managerService.updateProductPrice(productNum, stock);
      
      if (result > 0) {
         return managerResultView.displayDmlResult("updateSuccess");
      }else {
         return managerResultView.displayDmlResult("updateFailed");
      }
   }
   
   /* 메뉴 수정 - 이름 */
   public String modifyProductName(int productNum, int productName) {
      int result = managerService.updateProductPrice(productNum, productName);
      
      if (result > 0) {
         return managerResultView.displayDmlResult("updateSuccess");
      }
      else {
         return managerResultView.displayDmlResult("updateFailed");
      }
   }
   
   /* 메뉴 삭제 */
   public String deleteProduct(int productNum) {
      int result = managerService.deleteProduct(productNum);
      
      if (result > 0) {
         return managerResultView.displayDmlResult("deleteSuccess");
      }
      else {
         return managerResultView.displayDmlResult("deleteFailed");
      }
   }
}
>>>>>>> refs/remotes/origin/SM_MG_0.0
