<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="ProductAddServlet" method="post">
<table>
 
<tr>
<td>category_id</td>
<td><select name="category_id">
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
<td>subtitle</td>
<td><input type="text" name="subtitle"></td>
</tr>
<tr>
<td>main_image</td>
<td><input type="text" name="main_image"></td>
</tr>
<tr>
<td>sub_image</td>
<td><input type="text" name="sub_image"></td>
</tr>
<tr>
<td>detail</td>
<td><input type="text" name="detail"></td>
</tr>
<tr>
<td>price</td>
<td><input type="text" name="price"></td>
</tr>
<tr>
<td>stock</td>
<td><input type="text" name="stock"></td>
</tr>
<tr>
<td>status</td>
<td><input type="text" name="status"></td>
</tr>
<td colspan=2><input type="submit" value="添加">
</td>
</tr>
</table>
</form>
</body>
</html>