package com.ato.web.sqlCommand;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import com.ato.web.model.BugStatus;

/* @author Adrian To
 *
 * Concrete strategy implement of SqlQuery strategy algorithm interface.
 * Reads parameters from add-bug-form.jsp, insert new entry into database and return to list-bugs.jsp page. 
 * 
 */

public class AddBug implements SqlQuery{

	private HttpServletRequest request;
	private HttpServletResponse response;
	private DataSource dataSource;
	
	public AddBug(HttpServletRequest request, HttpServletResponse response, DataSource dataSource) {
		this.request = request;
		this.response = response;
		this.dataSource = dataSource;
	}
	
	@Override
	public void execute() throws ServletException, IOException {
		SqlCommand sqlCmd = new SqlCommand();
		
		String title = request.getParameter("title");
		String issue = request.getParameter("issue");
		String reporter = request.getParameter("reporter");
		String due = request.getParameter("due").toString();
		String severity = request.getParameter("severity").toString().toUpperCase();
		
		Connection myConn = null;
		PreparedStatement prepStmt = null;

		String sql = "INSERT INTO bug" + "(title, issue, reporter, created, due, severity, bugStatus) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?)";

		try {
			myConn = dataSource.getConnection();
			prepStmt = myConn.prepareStatement(sql);
			
			prepStmt.setString(1, title);
			prepStmt.setString(2, issue);
			prepStmt.setString(3, reporter);
			prepStmt.setString(4, java.time.LocalDate.now().toString());
			prepStmt.setString(5, due);
			prepStmt.setString(6, severity);
			prepStmt.setString(7,BugStatus.OPEN.toString());
			prepStmt.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			CloseConnection.closeDbConnection(myConn, prepStmt, null);
		}
		
		sqlCmd.execute(new GetBugList(request, response, dataSource));
	}
}
