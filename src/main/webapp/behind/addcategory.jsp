<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="AddServlet" method="post">
<table>
 
<tr>
<td>parent_id</td>
<td><select name="parent_id">
<c:forEach items="${category}" var="category">
<option>${category.id}</option>
</c:forEach>

</select>
</td>
</tr>
<tr>
<td>name</td>
<td><input type="text" name="name"></td>
</tr>
<tr>
<td>status</td>
<td><input type="text" name="status"></td>
</tr>
<tr>
<td>sort_order</td>
<td><input type="text" name="sort_order"></td>
</tr>
<tr>
<td colspan=2><input type="submit" value="添加">
</td>
</tr>
</table>
</form>
</body>
</html>