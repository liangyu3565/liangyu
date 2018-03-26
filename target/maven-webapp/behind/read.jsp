<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<body>

  <table width="1052" border=0 align=center cellpadding=2 cellspacing=1 bordercolor="#799AE1" class=tableBorder>
    <tbody>
      <tr>
        <th align=center colspan=16 style="height: 23px">商品管理</th>
      </tr>
      <tr bgcolor="#DEE5FA">
        <td colspan="16" align="center" class=txlrow>&nbsp;</td>
      </tr>
      <tr align="center" bgcolor="#799AE1">
        <td  align="center" class="txlHeaderBackgroundAlternate">编号</td>
        <td  align="center" class=txlHeaderBackgroundAlternate>父类编号</td>
        <td  align="center" class=txlHeaderBackgroundAlternate>名字</td>
        <td  align="center" class=txlHeaderBackgroundAlternate>状态</td>
        <td  align="center" class=txlHeaderBackgroundAlternate>创建时间</td>
        <td  align="center" class=txlHeaderBackgroundAlternate>更新时间</td>
        <td  align="center" class=txlHeaderBackgroundAlternate>sort_order</td>
        <td  align="center" colspan=3 class=txlHeaderBackgroundAlternate>操作</td>
      </tr>
      <c:forEach items="${pageModle.data}" var="list">
      <tr bgcolor="#DEE5FA">
        <td align="center" class="txlrow">${list.id}</td>
        <td align=center class=txlrow>${list.parent_id}</td>
        <td align=center class=txlrow>${list.name}</td>
       <td align=center class=txlrow>${list.status}</td> 
        <td align=center class=txlrow>${list.create_time}</td>
        <td align=center class=txlrow>${list.update_time}</td>
        <td align=center class=txlrow>${list.sort_order}</td>
        <td align=center class=txlrow><a href="UpdateServlet?id=${list.id}">修改</a></td>
        <td align=center class=txlrow><a href="DelectCateServlet?id=${list.id}">删除</a></td>
        <td align=center class=txlrow><a href="AddServlet">添加</a></td>
      </tr>
    </c:forEach>
   
     
      </tbody></table>
		<c:forEach var="i" begin="1"  end="${pageModle.totalPage}" step="1">
		<a href="Rservelt?pageNo=${i}">
		${i}</a>
		</c:forEach>


</BODY>
  </HTML>