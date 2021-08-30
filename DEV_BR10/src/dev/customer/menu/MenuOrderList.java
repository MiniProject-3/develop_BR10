package dev.customer.menu;

import java.util.ArrayList;
import java.util.List;

import dev.customer.controller.CustomerController;

public class MenuOrderList {
	
<<<<<<< HEAD
	
	public static List orderList = new ArrayList<>();

=======
	// Static 변수로 실행값을 받아올 변수를 항상 존재하게
	public static List orderList = new ArrayList<>();           

>>>>>>> refs/remotes/origin/HS_OD_1.2
	public static int orderSeq = CustomerController.selectSeqNum();
	
}
