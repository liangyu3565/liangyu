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
<th>id</th>
<th>用户id</th>
<th>收货人：</th>
<th>手机号：</th>
<th>电话号：</th>
<th>省份：</th>
<th>城市：</th>
<th>区县：</th>
<th>详细地址：</th>
<th>邮编：</th>
<th>创建时间</th>
<th>更新时间</th>
<th colspan=2>操作</th>

</tr>
<c:forEach items="${pageModle.data}" var="address">
<tr>
<td>${address.id}</td>
<td>${address.user_id}</td>
<td>${address.receiver_name}</td>
<td>${address.receiver_phone}</td>
<td>${address.receiver_mobile}</td>
<td>${address.receiver_province}</td>
<td>${address.receiver_city}</td>
<td>${address.receiver_district}</td>
<td>${address.receiver_address}</td>
<td>${address.receiver_zip}</td>
<td>${address.create_time}</td>
<td>${address.update_time}</td>
<td><a href="AddressDelete?id=${address.id}&user_id=${address.user_id}">删除</a></td>
<td><a href="AddressUpdate?id=${address.id}">修改</a></td>

</tr>

</c:forEach>
<tr><a href="addressAdd.jsp">添加</a></tr>
</table>
<c:forEach var="i" begin="1"  end="${pageModle.totalPage}" step="1">
<a href="AddressRead?pageNo=${i}">
${i}</a>
</c:forEach>
</body>
</html>