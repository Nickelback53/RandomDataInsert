package com.cloud.myapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsertMain {
	static final String sid = "ORCL11";
	static final String id = "DEMO_DATA";
	static final String pass = "demo";
	

	public static void main(String[] args) {
		int i = 2;
		Connection connection = null;
		Statement stmt = null;
		try {
// 접속할 데이타베이스의 URL을 생성
			String url = "jdbc:oracle:thin:@1.1.1.164:1521:" + sid;
// 접속
			connection = DriverManager.getConnection(url, id, pass);
			
			
			String[] A = new String[]{"계전기","송신모듈","수신측레일", "전원모듈","절연패드","정류기","튜닝유니트"};
			String[] B = new String[]{"2009년","2010년","2011년", "2012년","2013년","2014년","2015년","2016년" ,"2017년" ,"2018년"};
			
			
			
			
			
// sql을 실행 시킬 수 있는 Statement 인스턴스 생성
			while(i < 100) {
				stmt = connection.createStatement();
				String query = "INSERT INTO FAILURE_CAUSE VALUES ("+i + "," +"'"+A[(int)(Math.random()*7)]+"'"+"," +"'"+B[(int)(Math.random()*10)]+"'"+")";
				
				int result = stmt.executeUpdate(query);
				if (result != 0)
					System.out.println("삽입성공");
				else
					System.out.println("삽입실패");
				
				i++;
			}
			stmt.close();
			connection.close();
			


			
		} catch (Exception e) {
			System.out.println("에러:" + e.getMessage());
		}
	}
}