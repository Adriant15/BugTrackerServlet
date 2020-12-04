<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<title>Bug Tracker</title>
<link type="text/css" rel="stylesheet" href="css/style.css">

</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>Bug Tracker</h2>
		</div>
	</div>
	<div id="container">
		<div id="content">
			<!-- put new button: Add Student -->
			<input type="button" value="Add New Bug"
				onclick="window.location.href='add-bug-form.jsp'; return false;"
				class="add-bug-button" />
		</div>

		<table>
			<tr>
				<th>Title</th>
				<th>Issue</th>
				<th>Reporter</th>
				<th>Created</th>
				<th>Due</th>
				<th>Severity</th>
				<th>Status</th>
				<th>Action</th>
			</tr>

			<!-- BUG_LIST is returned by servlet file -->
			<c:forEach var="tempBug" items="${BUG_LIST}">

				<!-- set a link for each bug. Defines multiple links with bug id embedded-->
				<!-- Send command to bug tracker controller servlet to load list of bugs from database-->

				<c:url var="loadLink" value="BugTrackerController">
					<c:param name="command" value="LOAD" />
					<c:param name="bugId" value="${tempBug.id}" />
				</c:url>

				<c:url var="deleteLink" value="BugTrackerController">
					<c:param name="command" value="DELETE" />
					<c:param name="bugId" value="${tempBug.id}" />
				</c:url>

				<tr>
					<td>${tempBug.title}</td>
					<td style="width: 500px">${tempBug.issue}</td>
					<td>${tempBug.reporter}</td>
					<td>${tempBug.created}</td>
					<td>${tempBug.due}</td>
					<td>${tempBug.severity}</td>
					<td>${tempBug.status}</td>
					<td><a href="${loadLink}">Update</a> | <a href="${deleteLink}"
						onclick="if (!(confirm('Are you sure you want to delete this bug?'))) return false">Delete</a>
					</td>
				</tr>
			</c:forEach>

		</table>
	</div>

</body>
</html>