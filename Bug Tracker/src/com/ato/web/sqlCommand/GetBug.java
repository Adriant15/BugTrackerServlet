package com.ato.web.sqlCommand;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.ato.web.model.Bug;
import com.ato.web.model.BugStatus;
import com.ato.web.model.Severity;

/* @author Adrian To
*
* Concrete strategy implement of SqlQuery strategy algorithm interface.
* Get entry from database based on bug ID and return to update-bug-form.jsp page to prefill form.
* 
*/

public class GetBug implements SqlQuery{

	private HttpServletRequest request;
	private HttpServletResponse response;
	private DataSource dataSource;
	
	public GetBug(HttpServletRequest request, HttpServletResponse response, DataSource dataSource) {
		this.request = request;
		this.response = response;
		this.dataSource = dataSource;
	}
	
	@Override
	public void execute() throws ServletException, IOException {
		Bug bug = null;
		
		int bugId = Integer.parseInt(request.getParameter("bugId"));
		
		Connection myConn = null;
		PreparedStatement prepStmt = null;
		ResultSet myRs = null;
		String sql = "SELECT * FROM bug WHERE ID=?";

		try {
			myConn = dataSource.getConnection();
			prepStmt = myConn.prepareStatement(sql);
			prepStmt.setInt(1, bugId);
			myRs = prepStmt.executeQuery();

			while (myRs.next()) {
				String title = myRs.getString("title");
				String issue = myRs.getString("issue");
				String reporter = myRs.getString("reporter");
				String created = myRs.getString("created");
				String due = myRs.getString("due");
				
				String severityString = myRs.getString("severity").toUpperCase();
				Severity severity = Severity.valueOf(severityString);
				
				String statusString = myRs.getString("bugStatus").toUpperCase();
				BugStatus status = BugStatus.valueOf(statusString);
				
				bug = new Bug(bugId, title, issue, reporter, created, due, severity, status);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			CloseConnection.closeDbConnection(myConn, prepStmt, myRs);
		}

		request.setAttribute("THE_BUG", bug);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("update-bug-form.jsp");
		dispatcher.forward(request, response);
	}
}
