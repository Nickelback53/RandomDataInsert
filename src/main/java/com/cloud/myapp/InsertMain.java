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
// ������ ����Ÿ���̽��� URL�� ����
			String url = "jdbc:oracle:thin:@1.1.1.164:1521:" + sid;
// ����
			connection = DriverManager.getConnection(url, id, pass);
			
			
			String[] A = new String[]{"������","�۽Ÿ��","����������", "�������","�����е�","������","Ʃ������Ʈ"};
			String[] B = new String[]{"2009��","2010��","2011��", "2012��","2013��","2014��","2015��","2016��" ,"2017��" ,"2018��"};
			
			
			
			
			
// sql�� ���� ��ų �� �ִ� Statement �ν��Ͻ� ����
			while(i < 100) {
				stmt = connection.createStatement();
				String query = "INSERT INTO FAILURE_CAUSE VALUES ("+i + "," +"'"+A[(int)(Math.random()*7)]+"'"+"," +"'"+B[(int)(Math.random()*10)]+"'"+")";
				
				int result = stmt.executeUpdate(query);
				if (result != 0)
					System.out.println("���Լ���");
				else
					System.out.println("���Խ���");
				
				i++;
			}
			stmt.close();
			connection.close();
			


			
		} catch (Exception e) {
			System.out.println("����:" + e.getMessage());
		}
	}
}