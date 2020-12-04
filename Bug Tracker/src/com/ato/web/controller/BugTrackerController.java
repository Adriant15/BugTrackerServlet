package com.ato.web.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.ato.web.sqlCommand.AddBug;
import com.ato.web.sqlCommand.DeleteBug;
import com.ato.web.sqlCommand.GetBug;
import com.ato.web.sqlCommand.GetBugList;
import com.ato.web.sqlCommand.SqlCommand;
import com.ato.web.sqlCommand.UpdateBug;

/* @author Adrian To
 * 
 * Set up Tomcat database connection pool with resource injection. Defined in META-INF/context.html.
 * reads command from list-bug.jsp and select corresponding strategy to execute.
 * 
 */

@WebServlet("/BugTrackerController")
public class BugTrackerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Resource(name = "jdbc/bug_tracker")
	private DataSource dataSource;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		SqlCommand sqlCmd = new SqlCommand();	//context for concrete strategy objects
		
		try {
			String theCommand = request.getParameter("command");

			if(theCommand == null) theCommand = "LIST";	
			
			switch(theCommand){
				case "LIST":
					sqlCmd.execute(new GetBugList(request, response, dataSource));
					break;
						
				case "ADD":
					sqlCmd.execute(new AddBug(request, response, dataSource));
					break;
						
				case "LOAD":
					sqlCmd.execute(new GetBug(request, response, dataSource));
					break;
					
				case "UPDATE":
					sqlCmd.execute(new UpdateBug(request, response, dataSource));
					break;
					
				case "DELETE":
					sqlCmd.execute(new DeleteBug(request, response, dataSource));
					break;
					
				default:
					sqlCmd.execute(new GetBugList(request, response, dataSource));
			}
		} catch (Exception exc) {
			throw new ServletException(exc);
		}
	}
}
