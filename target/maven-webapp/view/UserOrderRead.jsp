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
<h1>订单列表</h1>
<table>
<tr>
<th>订单编号</th>
<th>下单用户</th>
<th>地址</th>
<th>订单总价</th>
<th>支付方式</th>
<th>邮费</th>
<th>订单状态</th>
<th>创建时间</th>
<th>更新时间</th>
<th colspan=2>用户操作</th>

</tr>
<c:forEach items="${pageModle.data}" var="order">
<tr>
<td>${order.order_no}</td>
<td>${order.user.username}</td>
<td>${order.shipping_id}</td>
<td>${order.payment}</td>
<td>${order.payment_type}</td>
<td>${order.postage}</td>
<td>${order.status}</td>
<td>${order.create_time}</td>
<td>${order.update_time}</td>


<td><a href="UserOrder?select=4&orderno=${order.order_no}">修改</a></td>
<td><a href="UserOrder?select=3&orderno=${order.order_no}">查看详情</a></td>
</tr>

</c:forEach>

</table>
<c:forEach var="i" begin="1"  end="${pageModle.totalPage}" step="1">
<a href="UserOrder?pageNo=${i}&pageSize=3&select=2">
${i}</a>
</c:forEach>


</body>
</html>