package com.cloud.myapp;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class ConnectionTest {
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String URL	= "jdbc:oracle:thin:@1.1.1.164:1521:ORCL11";
	private static final String USER =	"DEMO_DATA";
	private static final String PW	= "demo";
	
	
	@Test
	public void testConnection() throws Exception{
		Class.forName(DRIVER);
		try(Connection con = 
								DriverManager.getConnection(URL, USER, PW)){
					System.out.println(con);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	



}
