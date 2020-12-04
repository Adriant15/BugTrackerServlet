package com.ato.web.sqlCommand;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/* @author Adrian To
*
* Concrete strategy implement of SqlQuery strategy algorithm interface.
* Delete entry from database based on bug ID and return to list-bugs.jsp page.
* 
*/

public class DeleteBug implements SqlQuery{

	private HttpServletRequest request;
	private HttpServletResponse response;
	private DataSource dataSource;
	
	public DeleteBug(HttpServletRequest request, HttpServletResponse response, DataSource dataSource) {
		this.request = request;
		this.response = response;
		this.dataSource = dataSource;
	}
	
	@Override
	public void execute() throws ServletException, IOException {
		SqlCommand sqlCmd = new SqlCommand();

		int id = Integer.parseInt(request.getParameter("bugId"));
		
		Connection myConn = null;
		PreparedStatement prepStmt = null;
		
		String sql = "DELETE FROM bug WHERE ID=?";

		try {
			myConn = dataSource.getConnection();
			prepStmt = myConn.prepareStatement(sql);
			
			prepStmt.setInt(1, id);
			prepStmt.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			CloseConnection.closeDbConnection(myConn, prepStmt, null);
		}
		
		sqlCmd.execute(new GetBugList(request, response, dataSource));
	}
}
