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
<form action="CartUpdate" method="post">
<table>
<!--<tr>
<td>用户名:</td>
<td><input type="text" name="user_id" readonly="readonly" value="${cart.user.username}"></td>
</tr>-->
<tr>

<td><input type="hidden" name="product_id" readonly="readonly" value="${product_id}" ></td>
</tr>
<tr>
<td>数量：</td>
<td><input type="text" name="quantity" value="${cart.quantity}"></td>
</tr>
<tr>
<td colspan=2><input type="submit" value="修改">
</td>
</tr>
</table>
</form>
</body>
</html>