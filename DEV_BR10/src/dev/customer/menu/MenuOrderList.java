package dev.customer.menu;

import java.util.ArrayList;
import java.util.List;

import dev.customer.controller.CustomerController;

public class MenuOrderList {
	
	
	public static List orderList = new ArrayList<>();

	public static int orderSeq = CustomerController.selectSeqNum();
	
}
