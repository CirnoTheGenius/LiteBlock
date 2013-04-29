package com.tenko.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionHolder {
	
	private Connection con;
	
	public ConnectionHolder(String host, String user, String pwd) throws SQLException{
		this.con = DriverManager.getConnection(host, user, pwd);
	}
	
	public void executeStatement(String statement) throws SQLException{
		Statement s = this.con.createStatement();
		ResultSet rs = s.executeQuery(statement);
		while(rs.next()){
			System.out.println(rs.getString(1));
		}
		rs.close();
		s.close();
	}
	
	public void endConnection() throws SQLException {
		this.con.close();
	}
}