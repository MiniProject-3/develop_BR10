package dev.views;

import java.util.List;

import dev.dto.PayDTO;
import dev.dto.ProductDTO;

public class ManagerResultView {
	
	public void displayDmlResult(String code) {
		
		switch(code) {
			case"selectFailed" : System.out.println("조회 실패"); break;
			case"updateFailed" : System.out.println("수정 실패"); break;
			case"deleteFailed" : System.out.println("삭제 실패"); break;
			case"insertFailed" : System.out.println("삽입 실패"); break;
			case"insertSuccess" : System.out.println("삽입 성공"); break;
			case"selectSuccess" : System.out.println("조회 성공"); break;
			case"updateSuccess" : System.out.println("수정 성공"); break;
			case"deleteSuccess" : System.out.println("삭제 성공"); break;
			default : System.out.println("알 수 없는 에러 발생"); break;
		}
	}

	/* 질문!!
	 * list에 제네릭이 다른 경우 오버로딩 불가능
	 * 그러면 어떻게,,?
	 *  */
	public void display(List<ProductDTO> list) {
	
			for(ProductDTO p : list) {
				System.out.println(p);
			}
	}
	
	

//	public void display(List<PayDTO> list) {
//	
//			for(PayDTO p : list) {
//				System.out.println(p);
//			}
//	}	

	
	public void display(ProductDTO p) {
		System.out.println(p);
	}
	
	public void display(PayDTO p) {
		System.out.println(p);
	}


}
