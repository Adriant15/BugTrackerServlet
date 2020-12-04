package com.ato.web.sqlCommand;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class CloseConnection {
	
	public static void closeDbConnection(Connection myConn, Statement myStmt, ResultSet myRs) {
		try {
			if(myRs != null) myRs.close();
			if(myStmt != null) myStmt.close();
			if(myConn != null) myConn.close();	//put back in connection pool
		}
		catch(Exception exc) {
			exc.printStackTrace();
		}
	}
}
