package dev.manager.model.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PayDAO {

	private Properties prop = new Properties();
	
	public PayDAO() {
		try {
			prop.loadFromXML(new FileInputStream("mapper/BR10-query.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
