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
<form action="AddressAdd" method="post">
<table>
<tr>
<td>收货人：</td>
<td><input type="text" name="receiver_name"></td>
</tr>
<tr>
<td>手机号：</td>
<td><input type="text" name="receiver_phone"></td>
</tr>
<tr>
<td>电话号：</td>
<td><input type="text" name="receiver_mobile"></td>
</tr>
<tr>
<td>省份：</td>
<td>
<select name="receiver_province">
<option>北京</option>
<option>天津</option>
</select>


</td>
</tr>
<tr>
<td>城市：</td>
<td>
<select name="receiver_city">
<option>北京市</option>
<option>天津市</option>
</select>
</td>
</tr>
<tr>
<td>区县：</td>
<td>
<select name="receiver_district">
<option>津南区</option>
<option>南开区</option>
</select>



</tr>
<tr>
<td>详细地址：</td>
<td><input type="text" name="receiver_address"></td>
</tr>
<tr>
<td>邮编：</td>
<td><input type="text" name="receiver_zip"></td>
</tr>
<td colspan=2><input type="submit" value="添加">
</td>
</tr>
</table>
</form>
</body>
</html>