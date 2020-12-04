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
* Update entry in database from changes made in update-bug-form.jsp and return to return to list-bugs.jsp page.
* 
*/

public class UpdateBug implements SqlQuery{

	private HttpServletRequest request;
	private HttpServletResponse response;
	private DataSource dataSource;
	
	public UpdateBug(HttpServletRequest request, HttpServletResponse response, DataSource dataSource) {
		this.request = request;
		this.response = response;
		this.dataSource = dataSource;
	}

	@Override
	public void execute() throws ServletException, IOException {
		SqlCommand sqlCmd = new SqlCommand();

		int id = Integer.parseInt(request.getParameter("bugId"));
		String title = request.getParameter("title");
		String issue = request.getParameter("issue");
		String reporter = request.getParameter("reporter");
		String created = request.getParameter("created");
		String due = request.getParameter("due").toString();
		String severity = request.getParameter("severity").toString().toUpperCase();
		String status = request.getParameter("status").toString().toUpperCase();
		
		Connection myConn = null;
		PreparedStatement prepStmt = null;
		
		String sql = "UPDATE bug " 
					+ "SET title=?, issue=?, reporter=?, created=?, "
					+ "due=?, severity=?, bugStatus=? "
					+ "WHERE id=?";
		try {
			myConn = dataSource.getConnection();
			prepStmt = myConn.prepareStatement(sql);
			
			prepStmt.setString(1, title);
			prepStmt.setString(2, issue);
			prepStmt.setString(3, reporter);
			prepStmt.setString(4, created);
			prepStmt.setString(5, due);
			prepStmt.setString(6, severity);
			prepStmt.setString(7, status);
			prepStmt.setInt(8, id);
			prepStmt.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			CloseConnection.closeDbConnection(myConn, prepStmt, null);
		}
		
		sqlCmd.execute(new GetBugList(request, response, dataSource));
	}
}
