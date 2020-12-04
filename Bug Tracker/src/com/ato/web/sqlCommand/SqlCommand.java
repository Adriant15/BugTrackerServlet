package com.ato.web.sqlCommand;

import java.io.IOException;

import javax.servlet.ServletException;

/* @author Adrian To
*
* Context class "execute" method takes instance of "SqlQuery" object and call specific overridden execute() method.
* 
*/

public class SqlCommand {
	public void execute(SqlQuery execute) throws ServletException, IOException {
		execute.execute();
	}
}
