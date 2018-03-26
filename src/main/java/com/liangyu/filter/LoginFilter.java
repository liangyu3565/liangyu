package com.liangyu.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.liangyu.entity.User;
import com.liangyu.servise.Servise;
import com.liangyu.serviseimpl.ServiseImpl;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/behindq/*")
public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest _request, ServletResponse _response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		
		// pass the request along the filter chain
		HttpServletRequest request=(HttpServletRequest)_request;
		request.setCharacterEncoding("UTF-8");
		HttpServletResponse response=(HttpServletResponse)_response;
		HttpSession session=request.getSession();
		
		String type=request.getParameter("type");
		if(type!=null&&type.equals("1")) {
			chain.doFilter(request, response);
			return;
		}
		String token=null;
		User user=null;
		Object o=session.getAttribute("token");
		
		if(o!=null&&o instanceof String) {
			 token=(String)o;
		}
		/*Cookie[] cookies=request.getCookies();
		if(cookies!=null) {
		for(Cookie c:cookies) {
			if(c.getName().equals("token")) {
				token=c.getValue();
			    
			}
			
			
		}*/
		if(token!=null) {
			Servise servise=new ServiseImpl();
			  user=servise.findUserByToken(token);
		
		if(user!=null) {
			session.setAttribute("user", user);
			//session.setAttribute("username", user.getUsername());
			//session.setAttribute("password", user.getPassword());
			chain.doFilter(request, response);
		
		}else {
			response.sendRedirect("http://localhost:8080/business/login.jsp");
		}
		}else {
			response.sendRedirect("http://localhost:8080/business/login.jsp");
		}
		
		}
	/*else {
			session.setAttribute("user", user);
			//String username1=(String)session.getAttribute("username");
			//String password1=(String)session.getAttribute("password");
			Servise servise=new ServiseImpl();
			user=servise.doLogin(user.getUsername(), user.getPassword());
		    //user=servise.doLogin(username1, password1);
		    if(user!=null) {
		    	session.setAttribute("user", user);
				//session.setAttribute("username", user.getUsername());
				//session.setAttribute("password", user.getPassword());
				chain.doFilter(request, response);
			
			}else {
				response.sendRedirect("http://localhost:8080/business/login.jsp");
			}
			
		}
		
		
		
		
		
	}*/

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
