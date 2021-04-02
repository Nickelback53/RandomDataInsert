package com.cloud.myapp;

import java.sql.Connection;
import java.sql.DriverManager;

public class OracleConnect {
	static final String sid = "ORCL11";
	static final String id = "DEMO_DATA";
	static final String pw = "demo";

	public static void main(String[] args) {
		System.out.println("����Ŭ JDBC ����̹� �ε���...");
		//����Ŭ ����Ÿ���̽� ���� ����
		Connection connection = null;
		try {
				// ������ ����Ÿ���̽��� URL�� �����.
				String url = "jdbc:oracle:thin:@1.1.1.164:1521:" + sid;
				// �����Ѵ�(Login)
				connection = DriverManager.getConnection(url, id, pw);
				System.out.println("���� / �α��� ����");
		}
		catch (Exception e) {
				System.out.println("���� / �α��� ����");
				System.out.println(e.getMessage());
		}

		//������ �����Ѵ�.
		try {
				connection.close();
		} catch (Exception e) {
				System.out.println(e.getMessage());
		}
	}	
}