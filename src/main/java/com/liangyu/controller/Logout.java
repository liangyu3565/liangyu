package com.liangyu.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.liangyu.consts.Const;
import com.liangyu.entity.User;
import com.liangyu.servise.Servise;
import com.liangyu.serviseimpl.ServiseImpl;

/**
 * Servlet implementation class Logout
 */
@WebServlet("/behind/Logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Logout() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session=request.getSession();
		
		//session.removeAttribute(Const.CURRENTPSAAWORD);
		//int userid=(int)session.getAttribute("id");
		Object o=session.getAttribute("user");
		User user=null;
		int userid=0;
		if(o!=null) {
			if(o instanceof User) {
				user=(User)o;
			}
			userid=user.getId();
			
		}
		Servise servise=new ServiseImpl();
		 servise.delectTokenByUserId(userid);
		 //session.removeAttribute("id");
		 session.removeAttribute("user");
		Cookie[] cookies=request.getCookies();
		if(cookies!=null) {
		for(Cookie c:cookies) {
			if(c.getName().equals("token")) {;
				Cookie c1=new Cookie(c.getName(),c.getValue());
				c1.setMaxAge(0);
				c1.setPath("/business");
				response.addCookie(c1);
				
			     
			    
			}
			
			
		}
		
		}
		
		
		response.getWriter().print("<script>top.location.href=\"http://localhost:8080/business/login.jsp\"</script>");;
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
