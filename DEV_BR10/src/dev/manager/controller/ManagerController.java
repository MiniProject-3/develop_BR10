package dev.manager.controller;

import java.util.List;
import java.util.Map;

import dev.dto.ProductDTO;
import dev.manager.model.service.ManagerService;
import dev.views.ManagerResultView;

public class ManagerController {

	private ManagerResultView managerResultView = new ManagerResultView();
	private ManagerService managerService = new ManagerService();

	/* 모든 상품 조회 (재고 조회) */
	public void selectAllProducts() {
		
		List<ProductDTO> productList = managerService.selectAllProducts();
		
		if(!productList.isEmpty())		// 리스트가 비어있지 않은 경우 - 값이 존재하는 경우.
			managerResultView.display(productList);
		else
			managerResultView.displayDmlResult("selectFailed");
	}

	/* 모든 결제 내역 조회 (저널 조회) - 작성 중 */
//	public void selectAllPays() {
//		
//		List<PayDTO> payList = managerService.selectAllPays();
//		
//		if(!payList.isEmpty())		
//			managerResultView.display(payList);
//		else
//			managerResultView.displayDmlResult("selectFailed");
//	}
	
	/* 메뉴 추가 */
	public void registNewProduct(Map<String, String> ansMap) {
	
		ProductDTO productDTO = new ProductDTO();
		
		productDTO.setProductNum(Integer.valueOf(ansMap.get("num")));
		productDTO.setProductName(ansMap.get("name"));
		productDTO.setProductPrice(Integer.valueOf(ansMap.get("price")));
		productDTO.setCategoryCode(Integer.valueOf(ansMap.get("categoryCode")));
		productDTO.setStock(Integer.valueOf(ansMap.get("stock")));
	
		int result = managerService.insertProduct(productDTO);
		
		if (result > 0)
			managerResultView.displayDmlResult("insertSuccess");
		else
			managerResultView.displayDmlResult("insertFailed");

	}

	/* 메뉴 수정 - 가격 */
	public void modifyProductPrice(int productNum, int productPrice) {
		int result = managerService.updateProductPrice(productNum, productPrice);
		
		if (result > 0)
			managerResultView.displayDmlResult("updateSuccess");
		else
			managerResultView.displayDmlResult("updateFailed");
	}
	
	/* 메뉴 수정 - 수량 */
	public void modifyProductStock(int productNum, int stock) {
		int result = managerService.updateProductPrice(productNum, stock);
		
		if (result > 0)
			managerResultView.displayDmlResult("updateSuccess");
		else
			managerResultView.displayDmlResult("updateFailed");
	}
	
	/* 메뉴 수정 - 이름 */
	public void modifyProductName(int productNum, int productName) {
		int result = managerService.updateProductPrice(productNum, productName);
		
		if (result > 0)
			managerResultView.displayDmlResult("updateSuccess");
		else
			managerResultView.displayDmlResult("updateFailed");
	}
	
	/* 메뉴 삭제 */
	public void deleteProduct(int productNum) {
		int result = managerService.deleteProduct(productNum);
		
		if (result > 0)
			managerResultView.displayDmlResult("deleteSuccess");
		else
			managerResultView.displayDmlResult("deleteFailed");
	}

}
