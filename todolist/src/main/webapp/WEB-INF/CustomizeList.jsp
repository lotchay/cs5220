<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>To Do List</title>
</head>
<body>
	<form action="CustomizeList" method="post">
		<table border="0">
			<c:forEach items="${todoList}" var="entry" varStatus="status">
				<tr>
					<td>${entry.taskName}</td>
					<td>${entry.dateAdded}</td>
					<td><a href="DeleteTask?index=${status.index}">X</a></td>
				</tr>
			</c:forEach>
			<tr>
				<td><input name="taskName" type="text" /></td>
				<td colspan="2"><center><input name="submit" type="submit" value="Add"/></center></td>
			</tr>
		</table>
	</form>
</body>
</html>