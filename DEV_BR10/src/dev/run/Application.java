package dev.run;

import dev.customer.gui.gui;
import dev.views.ManagerMenu;


public class Application {

	public static void main(String[] args) {

//		gui ordersize = new gui();
//		ordersize.OrderSize();
		
		/* DAO & DTO 테스트 - 유정 */
		new ManagerMenu().displayManagerMenu();
		System.out.println("종료합니다");
	}

}
