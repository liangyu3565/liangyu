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

<!-- //item.product_name product_name,item.product_image product_image,item.quantity quantity,item.total_price total_price,item.item_id item_id -->
<tr>
<th>商品名</th>
<th>商品图</th>
<th>数量</th>
<th>价格</th>
<th colspan=2>操作</th>

</tr>
<c:forEach items="${userOrder.orderItems}" var="userOrder1">
<tr>
<td>${userOrder1.product_name}</td>
<td>${userOrder1.product_image}</td>
<td>${userOrder1.quantity}</td>
<td>${userOrder1.total_price}</td>
<td><a href="UserOrder?orderno=${orderno}&select=5">查看商品</a></td>


</tr>

</c:forEach>

</table>
<c:forEach var="i" begin="1"  end="${pageModle.totalPage}" step="1">
<a href="ShoppingCartServlet?pageNo=${i}&pageSize=10">
${i}</a>
</c:forEach>


</body>
</html>