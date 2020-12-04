<!DOCTYPE html>

<html>

<head>
<title>Add New Bug</title>
</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>Bug Tracker</h2>
		</div>
	</div>

	<div id="container">
		<h3>Add New Bug</h3>

		<!-- send data to "doGet" method method in servlet -->
		<form action="BugTrackerController" method="GET">

			<input type="hidden" name="command" value="ADD" />

			<table>
				<tbody>

					<tr>
						<td align=right><label>Title:</label></td>
						<td><input type="text" name="title" maxlength="120" size="50" />
					</tr>

					<tr>
						<td align=right valign="top"><label>Issue:</label></td>
						<td><textarea rows="4" cols="37" name="issue"
								placeholder="Max 250 characters."></textarea>
					</tr>

					<tr>
						<td align=right><label>Reporter:</label></td>
						<td><input type="text" name="reporter" maxlength="45"
							size="10" />
					</tr>

					<tr>
						<td align=right><label>Due:</label></td>
						<td><input type="date" name="due" maxlength="10" size="10">
					</tr>

					<tr>
						<td align=right><label>Severity:</label></td>
						<td><select id="severity" name="severity">
								<option value="High">High</option>
								<option value="Medium">Medium</option>
								<option value="Low">Low</option>
						</select>
					</tr>

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" />
					</tr>

				</tbody>
			</table>
		</form>

		<!-- go back link -->

		<p>
			<a href="BugTrackerController">Back to List</a>
		</p>
	</div>

</body>

</html>