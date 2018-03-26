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
<form action="StatusUpdate" method="post">
<table>
<!--<tr>
<td>订单号:</td>
<td><input type="text" name="user_id" readonly="readonly" value="${cart.user.username}"></td>
</tr>-->
<tr>

<td><input type="hidden" name="orderno" readonly="readonly" value="${orderno}" ></td>
</tr>
<tr>
<td>状态：</td>
<td>
<select name="status" value="请选择">
<option name="status" value="0">取消订单</option>
<option name="status" value="10">未支付</option>
<option name="status" value="20">已支付</option>
<option name="status" value="40">已发货</option>
<option name="status" value="50">交易成功</option>
<option name="status" value="60">交易关闭</option>
</select>
</td>
</tr>
<tr>
<td colspan=2><input type="submit" value="修改">
</td>
</tr>
</table>
</form>
</body>
</html>