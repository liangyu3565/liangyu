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
<th>商品类别</th>
<th>商品名</th>
<th>商品副标题</th>
<th>商品图</th>
<th>商品副图</th>
<th>详情</th>
<th>价格</th>
<th colspan=2>操作</th>
</tr>
<c:forEach items="${userOrder}" var="product1">
<tr>
<td>${product1.product.category_id}</td>
<td>${product1.product.name}</td>
<td>${product1.product.subtitle}</td>
<td>${product1.product.main_image}</td>
<td>${product1.product.sub_image}</td>
<td>${product1.product.detail}</td>
<td>${product1.product.price}</td>


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