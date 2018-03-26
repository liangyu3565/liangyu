<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
<tr>
<td>
<a href="ShoppingCartServlet?select=2&pageNo=1&pageSize=5">
购物车

</a>
</td>
<td>
<a  href="ShoppingCartServlet?select=3">全选</a>
</td>
<td>
<a  href="ShoppingCartServlet?select=4">取消全选</a>
</td>
<td>共${result}件商品</td>
<td>
<a  href="UserOrder?select=1&shipping_id=13">结算</a>
</td>
</tr>
<tr>
<th>id</th>
<th>用户名</th>
<th>商品名</th>
<th>quantity</th>
<th>checked</th>
<th>create_time</th>
<th>update_time</th>
<th colspan=2>操作</th>

</tr>
<c:forEach items="${pageModle.data}" var="cart">
<tr>
<td>${cart.id}</td>
<td>${cart.user.username}</td>
<td>${cart.product.name}</td>
<td>${cart.quantity}</td>
<td>${cart.checked}</td>
<td>${cart.create_time}</td>
<td>${cart.update_time}</td>
<td><a href="CartDelete?product_id=${cart.product.id}">删除</a></td>
<td><a href="CartUpdate?product_id=${cart.product.id}">修改</a></td>
<td><a href="ShoppingCartServlet?select=5&product_id=${cart.product.id}">勾选</a></td>
<td><a href="ShoppingCartServlet?select=6&product_id=${cart.product.id}">取消勾选</a></td>

</tr>

</c:forEach>
<tr><a href="Shopping.jsp">添加</a></tr>

</table>
<c:forEach var="i" begin="1"  end="${pageModle.totalPage}" step="1">
<a href="ShoppingCartServlet?pageNo=${i}&pageSize=10">
${i}</a>
</c:forEach>


</body>
</html>