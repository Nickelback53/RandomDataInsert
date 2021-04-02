package com.cloud.myapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectMain {
	static final String sid = "ORCL11";
	static final String id = "DEMO_DATA";
	static final String pass = "demo";

	public static void main(String[] args) {
		Connection connection = null;
		Statement stmt = null;
		ResultSet rs = null;
		String query = "SELECT * FROM FAILURE_CAUSE";

	try {
			// ������ ����Ÿ���̽��� URL�� ����
			String url = "jdbc:oracle:thin:@1.1.1.164:1521:" + sid;
			// ����
			connection = DriverManager.getConnection(url, id, pass);
			// sql�� ���� ��ų �� �ִ� Statement �ν��Ͻ� ����
			stmt = connection.createStatement();
			// select ������ �����Ű�� �� ����� rs�� ����
			rs = stmt.executeQuery(query);
			// �����Ͱ� �ִٸ�
			if (rs.next()) {
							do {
							// ù��° �÷��� ���� ������ �������� �ι�° �÷��� ���� ���ڿ��� �����ͼ� ���
									System.out.println(rs.getInt(1) + ":" + rs.getString(2));
							} while (rs.next());
			}
			// �о�� �����Ͱ� ���ٸ�
			else {
				System.out.println("���� �����Ͱ� �����ϴ�.");
			}

			rs.close();
			stmt.close();
			connection.close();
		} catch (Exception e) {
			System.out.println("����:" + e.getMessage());
		}
	}	
}