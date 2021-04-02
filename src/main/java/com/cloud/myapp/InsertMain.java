package com.cloud.myapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsertMain {
	static final String sid = "ORCL11";
	static final String id = "DEMO_DATA";
	static final String pass = "demo";

	public static void main(String[] args) {
		Connection connection = null;
		Statement stmt = null;
		try {
// ������ ����Ÿ���̽��� URL�� ����
			String url = "jdbc:oracle:thin:@1.1.1.164:1521:" + sid;
// ����
			connection = DriverManager.getConnection(url, id, pass);
// sql�� ���� ��ų �� �ִ� Statement �ν��Ͻ� ����
			stmt = connection.createStatement();
			String query = "DELETE FROM FAILURE_CAUSE WHERE SNO = 2";

			int result = stmt.executeUpdate(query);
			if (result != 0)
				System.out.println("���Լ���");
			else
				System.out.println("���Խ���");
			stmt.close();
			connection.close();
		} catch (Exception e) {
			System.out.println("����:" + e.getMessage());
		}
	}
}