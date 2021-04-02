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
// 접속할 데이타베이스의 URL을 생성
			String url = "jdbc:oracle:thin:@1.1.1.164:1521:" + sid;
// 접속
			connection = DriverManager.getConnection(url, id, pass);
// sql을 실행 시킬 수 있는 Statement 인스턴스 생성
			stmt = connection.createStatement();
			String query = "DELETE FROM FAILURE_CAUSE WHERE SNO = 2";

			int result = stmt.executeUpdate(query);
			if (result != 0)
				System.out.println("삽입성공");
			else
				System.out.println("삽입실패");
			stmt.close();
			connection.close();
		} catch (Exception e) {
			System.out.println("에러:" + e.getMessage());
		}
	}
}