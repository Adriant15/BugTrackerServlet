package com.ato.web.sqlCommand;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
* Get all entries from database and return to list-bugs.jsp.
* 
*/

public class GetBugList implements SqlQuery{

	private HttpServletRequest request;
	private HttpServletResponse response;
	private DataSource dataSource;
	
	public GetBugList(HttpServletRequest request, HttpServletResponse response, DataSource dataSource) {
		this.request = request;
		this.response = response;
		this.dataSource = dataSource;
	}
	
	@Override
	public void execute() throws ServletException, IOException{
		List<Bug> bugList = new ArrayList<>();

		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		String sql = "SELECT * FROM bug ORDER BY id";

		try {
			myConn = dataSource.getConnection();
			myStmt = myConn.createStatement();
			myRs = myStmt.executeQuery(sql);

			while (myRs.next()) {
				int id = myRs.getInt("id");
				String title = myRs.getString("title");
				String issue = myRs.getString("issue");
				String reporter = myRs.getString("reporter");
				String created = myRs.getString("created");
				String due = myRs.getString("due");
				
				String severityString = myRs.getString("severity").toUpperCase();
				Severity severity = Severity.valueOf(severityString);
				
				String statusString = myRs.getString("bugStatus").toUpperCase();
				BugStatus status = BugStatus.valueOf(statusString);
				
				Bug tempBug = new Bug(id, title, issue, reporter, created, due, severity, status);
				bugList.add(tempBug);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			CloseConnection.closeDbConnection(myConn, myStmt, myRs);
		}
		
		request.setAttribute("BUG_LIST", bugList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-bugs.jsp");
		dispatcher.forward(request, response);
	}
}
