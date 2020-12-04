<!DOCTYPE html>
<html>

<head>
	<title>Update Bug</title>
</head>

<body>

	<div id="wrapper">	
		<div id = "header">
			<h2>Bug Tracker</h2>
		</div>
	</div>

	<div id="container">	
		<h3>Update Bug</h3>
		
		<!-- send data to "doGet" method method in servlet -->
		<form action="BugTrackerController" method = "GET">
		
			<input type ="hidden" name = "command" value="UPDATE" />
			
			<input type ="hidden" name = "bugId" value="${THE_BUG.id}" />
			
			<input type ="hidden" name = "created" value="${THE_BUG.created}"/>
			
			<table>
				<tbody>
				
					<tr>
						<td align=right><label>Title:</label></td>				
						<td><input type="text" name = "title" value = "${THE_BUG.title}" maxlength="120" size="50"/>
					</tr>
					
					<tr>
						<td align=right valign="top"><label>Issue:</label></td>				
						<td><textarea rows="4" cols="37" name="issue"/>${THE_BUG.issue}</textarea>
					
					</tr>
					
					<tr>
						<td align=right><label>Reporter:</label></td>				
						<td><input type="text" name = "reporter" value = "${THE_BUG.reporter}"/>
					</tr>
					
					<tr>
						<td align=right><label>Due:</label></td>				
						<td><input type="date" name = "due" value = "${THE_BUG.due}"/>
					</tr>
					
					<tr>
						<td align=right><label>Severity:</label></td>				
						<td><select id="severity" name = "severity">
							<option value="HIGH">HIGH</option>
							<option value="MEDIUM">MEDIUM</option>
							<option value="LOW">LOW</option>
							</select>
					</tr>
					
					<tr>
						<td><label>Status:</label></td>				
						<td><select id="status" name = "status">
							<option value="OPEN">OPEN</option>
							<option value="COMPLETED">COMPLETED</option>
							</select>
					</tr>
					
					<tr>
						<td><label></label></td>				
						<td><input type="submit" value = "Save" class="save"/>
					</tr>
					
				</tbody>
			</table>
		</form>
		
		<!-- go back link -->
		
		<div style="clear:both"></div>
		
		<p>
			<a href = "BugTrackerController">Back to List</a>
		</p>
		
	</div>


</body>

</html>