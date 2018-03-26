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
<form action="UpdateProductServlet" method="post">
<table>
 <input type="hidden" name="id" value="${Product1.id}">
 
<tr>
<td>category_id</td>
<td><select name="category_id">
<c:forEach items="${product}" var="product">
<option>${product.id}</option>
</c:forEach>
</select>

</tr>
<tr>
<td>name</td>
<td><input type="text" name="name" value="${Product1.name}"></td>
</tr>
<tr>
<td>subtitle</td>
<td><input type="text" name="subtitle" value="${Product1.subtitle}"></td>
</tr>
<tr>
<td>main_image</td>
<td><input type="text" name="main_image" value="${Product1.main_image}"></td>
</tr>
<tr>
<td>sub_image</td>
<td><input type="text" name="sub_image" value="${Product1.sub_image}"></td>
</tr>
<tr>
<td>detail</td>
<td><input type="text" name="detail" value="${Product1.detail}"></td>
</tr>
<tr>
<td>price</td>
<td><input type="text" name="price" value="${Product1.price}"></td>
</tr>
<tr>
<td>stock</td>
<td><input type="text" name="stock" value="${Product1.stock}"></td>
</tr>
<tr>
<td>status</td>
<td><input type="text" name="status"  value="${Product1.status}"></td>
</tr>

<tr>
<td colspan=2><input type="submit" value="修改">
</td>
</tr>
</table>
</form>
</body>
</html>