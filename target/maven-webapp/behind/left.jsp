<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--  <html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<ul>
<li><a href="Rservelt" target="servelt">类列表</a></li>
<li><a href="ProductReadservelt" target="servelt">商品列表</a></li>

</ul>



</body>
</html>-->

<HTML><HEAD><TITLE>管理页面</TITLE>
<STYLE type=text/css>BODY {
	BACKGROUND: #799ae1; MARGIN: 0px; FONT: 9pt 宋体
}
TABLE {
	BORDER-RIGHT: 0px; BORDER-TOP: 0px; BORDER-LEFT: 0px; BORDER-BOTTOM: 0px
}
TD {
	FONT: 12px 宋体
}
IMG {
	BORDER-RIGHT: 0px; BORDER-TOP: 0px; VERTICAL-ALIGN: bottom; BORDER-LEFT: 0px; BORDER-BOTTOM: 0px
}
A {
	FONT: 12px 宋体; COLOR: #000000; TEXT-DECORATION: none
}
A:hover {
	COLOR: #428eff; TEXT-DECORATION: underline
}
.sec_menu {
	BORDER-RIGHT: white 1px solid; BACKGROUND: #d6dff7; OVERFLOW: hidden; BORDER-LEFT: white 1px solid; BORDER-BOTTOM: white 1px solid
}
.menu_title {
	
}
.menu_title SPAN {
	FONT-WEIGHT: bold; LEFT: 7px; COLOR: #215dc6; POSITION: relative; TOP: 2px
}
.menu_title2 {
	
}
.menu_title2 SPAN {
	FONT-WEIGHT: bold; LEFT: 8px; COLOR: #428eff; POSITION: relative; TOP: 2px
}
</STYLE>

<SCRIPT language=javascript1.2>
function showsubmenu(sid)
{
whichEl = eval("submenu" + sid);
if (whichEl.style.display == "none")
{
eval("submenu" + sid + ".style.display=\"\";");
}
else
{
eval("submenu" + sid + ".style.display=\"none\";");
}
}
</SCRIPT>

<META http-equiv=Content-Type content="text/html; charset=gb2312">
<META content="MSHTML 6.00.2900.2180" name=GENERATOR></HEAD>
<BODY leftMargin=0 topMargin=0 marginwidth="0" marginheight="0">
<TABLE cellSpacing=0 cellPadding=0 width="100%" align=left border=0>
  <TBODY>
  <TR>
    <TD vAlign=top bgColor=#799ae1>
      <TABLE cellSpacing=0 cellPadding=0 width=158 align=center>
        <TBODY>
        <TR>
          <TD vAlign=bottom height=42><IMG height=38 
            src="left.files/title.gif" width=158> </TD></TR></TBODY></TABLE>
      <TABLE cellSpacing=0 cellPadding=0 width=158 align=center>
        <TBODY>
        <TR>
          <TD class=menu_title onMouseOver="this.className='menu_title2';" 
          onmouseout="this.className='menu_title';" background="" 
            height=25><SPAN>

			| <A 
            href="exit.asp" 
            target=_parent><B>退出</B></A></SPAN></TD>
        </TR>
        <TR>
          <TD class=menu_title onMouseOver="this.className='menu_title2';" 
          onmouseout="this.className='menu_title';" background="" 
            height=25>&nbsp;</TD>
</TR>
        </TBODY></TABLE>
	  <TABLE cellSpacing=0 cellPadding=0 width=158 align=center>
        <TBODY>
        <TR>
          <TD class=menu_title id=menuTitle1 
          onmouseover="this.className='menu_title2';" onclick=showsubmenu(0) 
          onmouseout="this.className='menu_title';" 
          background=left.files/admin_left_1.gif 
            height=25></TD>
        </TR>
        <TR>
          <TD id=submenu0>
            <DIV class=sec_menu style="WIDTH: 158px ">
            <TABLE cellSpacing=0 cellPadding=0 width=135 align=center>
              <TBODY>
              <TR>
                <TD height=20><A 
                  href="UserInfo.asp" 
                  target=mainFrame>你的个人资料</A></TD>
              </TR>
               <TR>
                <TD height=20><A 
                  href="UserInfoAlter.asp"
                  target=mainFrame>修改个人资料</A></TD>
              </TR>
               <TR>
                 <TD height=20><a href="UserInfoPassWord.asp" target="mainFrame">修改用户密码</a></TD>
               </TR>
              </TBODY></TABLE>
            </DIV>
            <DIV style="WIDTH: 158px">
            <TABLE cellSpacing=0 cellPadding=0 width=135 align=center>
              <TBODY>
              <TR>
                <TD height=20></TD></TR></TBODY></TABLE></DIV></TD></TR></TBODY></TABLE>
   
	  

      <TABLE cellSpacing=0 cellPadding=0 width=158 align=center>
        <TBODY>
          <TR>
            <TD class=menu_title id=menuTitle1 
          onmouseover="this.className='menu_title2';" onclick=showsubmenu(2) 
          onmouseout="this.className='menu_title';" 
          background=left.files/admin_left_2.gif height=25><SPAN>商品管理</SPAN> </TD>
          </TR>
          <TR>
            <TD id=submenu2><DIV class=sec_menu style="WIDTH: 158px">
                <TABLE cellSpacing=0 cellPadding=0 width=135 align=center>
                  <TBODY>
                    <TR>
                      <TD height=20><a href="Produce.asp" target=mainFrame>商品管理帮助</a></TD>
                    </TR>
                    <TR>
                      <TD height=20><a href="Rservelt" target="servelt">商品浏览|修改</a></TD>
                    </TR>
                    <TR>
                      <TD height=20><a href="AddServlet" target="servelt">商品添加</a></TD>
                    </TR>
                    <TR>
                      <TD height=20><a href="ProduceSearch.asp" target="mainFrame">商品搜索</a></TD>
                    </TR>
                    <TR>
                      <TD height=20><a href="addCategory.asp" target="mainFrame">商品类别|添加</a></TD>
                    </TR>
                  </TBODY>
                </TABLE>
            </DIV>
                <DIV style="WIDTH: 158px">
                  <TABLE cellSpacing=0 cellPadding=0 width=135 align=center>
                    <TBODY>
                      <TR>
                        <TD 
      height=20></TD>
                      </TR>
                    </TBODY>
                  </TABLE>
                </DIV></TD>
          </TR>
        </TBODY>
      </TABLE>
	  
	
	  <TABLE cellSpacing=0 cellPadding=0 width=158 align=center>
        <TBODY>
        <TR>
          <TD class=menu_title id=menuTitle1 
          onmouseover="this.className='menu_title2';" onclick=showsubmenu(1) 
          onmouseout="this.className='menu_title';" 
          background=left.files/admin_left_2.gif height=25><SPAN>员工管理</SPAN> 
          </TD>
        </TR>
        <TR>
          <TD id=submenu1>
            <DIV class=sec_menu style="WIDTH: 158px">
            <TABLE cellSpacing=0 cellPadding=0 width=135 align=center>
              <TBODY>
              <TR>
                <TD height=20><a href="User.asp" target=mainFrame>员工管理帮助</a></TD>
              </TR>
              <TR>
                <TD height=20><a href="UserShow.asp" target="mainFrame">员工显示|修改</a></TD>
              </TR>
              <TR>
                <TD height=20><a href="UserAdd.asp" target="mainFrame">员工添加</a></TD>
              </TR>
              <TR>
                <TD height=20><a href="userSearch.asp" target="mainFrame">员工搜索</a></TD>
              </TR>
              </TBODY></TABLE>
            </DIV>
            <DIV style="WIDTH: 158px">
            <TABLE cellSpacing=0 cellPadding=0 width=135 align=center>
              <TBODY>
              <TR>
                <TD 
      height=20></TD></TR></TBODY></TABLE></DIV></TD></TR></TBODY></TABLE>
	
	  <TABLE cellSpacing=0 cellPadding=0 width=158 align=center>
        <TBODY>
          <TR>
            <TD class=menu_title id=menuTitle1 
          onmouseover="this.className='menu_title2';" onclick=showsubmenu(30) 
          onmouseout="this.className='menu_title';" 
          background=left.files/admin_left_2.gif height=25><SPAN>财务管理</SPAN> </TD>
          </TR>
          <TR>
            <TD id=submenu30>
			 <DIV class=sec_menu style="WIDTH: 158px">
			   <TABLE cellSpacing=0 cellPadding=0 width=135 align=center>
                 <TBODY>
                   <TR>
                     <TD height=20><a href="finance.asp" target=mainFrame>财务管理帮助</a></TD>
                   </TR>
				    <TR>
                     <TD height=20><a href="OrderShow.asp" target=mainFrame>帐单浏览</a></TD>
                   </TR>
                   <TR>
                     <TD height=20><A 
                  href="OrderSearch.asp" 
                  target=mainFrame>帐单查询</A></TD>
                   </TR>
                   <TR>
                     <TD height=20><a href="Report.asp" target="mainFrame">帐单报表</a></TD>
                   </TR>
                 </TBODY>
			     </TABLE>
			 </DIV>
            <DIV style="WIDTH: 158px">
            <TABLE cellSpacing=0 cellPadding=0 width=135 align=center>
              <TBODY>
              <TR>
                <TD 
      height=20></TD></TR></TBODY></TABLE></DIV>
			
			</TD>
          </TR>
        </TBODY>
      </TABLE>
	  
	
      <TABLE cellSpacing=0 cellPadding=0 width=158 align=center>
        <TBODY>
        <TR>
          <TD class=menu_title id=menuTitle1 
          onmouseover="this.className='menu_title2';" 
          onmouseout="this.className='menu_title';" 
          background=left.files/admin_left_9.gif 
          height=25><SPAN></SPAN></TD>
        </TR>
        <TR>
          <TD>
            <DIV class=sec_menu style="WIDTH: 158px">
            <TABLE cellSpacing=0 cellPadding=0 width=135 align=center>
              <TBODY>
              <TR>
                <TD height=20 bgcolor="#D6DFF7" style="LINE-HEIGHT: 150%">
                 </TD></TR></TBODY></TABLE></DIV></TD></TR></TBODY></TABLE></TR></TBODY></TABLE>

	  
				  </BODY></HTML>