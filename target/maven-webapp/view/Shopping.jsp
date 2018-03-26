<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="ShoppingCartServlet" method="post" >
		<table>
			<tr>
				<td>
					select：
				</td>
				<td>
					<select name="select">
					<option>1</option>
					<option>2</option>
					<option>3</option>
					<option>4</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>
					product_id：
				</td>
				<td>
					<input type="text" name="product_id">
				</td>
			</tr>
			<tr>
				<td>
					quantity：
				</td>
				<td>
					<input type="text" name="quantity">
				</td>
			</tr>
			
			<tr>
				<td colspan=2>
					<input type="submit" value="提交">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>