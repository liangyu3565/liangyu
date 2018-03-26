package com.liangyu.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.liangyu.consts.Const;
import com.liangyu.entity.User;
import com.liangyu.entity.vo.LoginVO;
import com.liangyu.servise.Servise;
import com.liangyu.serviseimpl.ServiseImpl;
import com.liangyu.utils.MD5Utils;

/**
 * Servlet implementation class Servelt
 */
@WebServlet("/view/Login")
public class LoginViewServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginViewServelt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String callback=request.getParameter("callback");
		Servise servise=new ServiseImpl();
		HttpSession session=request.getSession();
		
		String token=null;
		//String _username=null;
		//String _password=null;
		Cookie[] cookies=request.getCookies();
		
		
		
		
		
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		if(password!=null) {
			password=MD5Utils.GetMD5Code(password);
		}
		// Servise _servise=new ServiseImpl();
		 User user=servise.doLogin(username, password);
		 
		 
		 
	
		 if(user!=null) {
			 session.setAttribute("user", user);
			 //session.setAttribute(Const.CURRENTUSERNAME, user.getUsername());
			 //session.setAttribute(Const.CURRENTPSAAWORD, user.getPassword());
			 //session.setAttribute("userid", user.getId());
			 token=MD5Utils.GetMD5Code(user.getUsername()+user.getPassword());
			 
			 session.setAttribute("token", token);
			
			 int result=servise.updateTokenByUserId(user.getId(),token);
			
				if(request.getParameter("on")!=null) {
					
			 token=MD5Utils.GetMD5Code(user.getUsername()+user.getPassword());
			 session.setAttribute("token", token);
			 Cookie token_cookie=new Cookie("token",token);
			 token_cookie.setMaxAge(7*24*3600);
			 token_cookie.setPath("/business");
			 response.addCookie(token_cookie);
				
			 servise.findByUserNameAndPsssword(user.getUsername(), user.getPassword());
			 servise.updateTokenByUserId(user.getId(),token);
				}
			 
			 
			 
			/* Cookie username_cookie=new Cookie("username",user.getUsername());
			 Cookie password_cookie=new Cookie("password",user.getPassword());
			 username_cookie.setMaxAge(7*24*3600);
			 password_cookie.setMaxAge(7*24*3600);
			 username_cookie.setPath("/business");
			 password_cookie.setPath("/business");
			 response.addCookie(username_cookie);
			 response.addCookie(password_cookie);*/
			 //request.getRequestDispatcher("behind/frameSet.jsp?type=1").forward(request, response);
				
				LoginVO vo=new LoginVO();
				vo.setErrno(LoginVO.LOGIN_SUCC);
				vo.setUser(user);
				
				Gson gson=new Gson();
				String json=gson.toJson(vo);
				
				response.getWriter().write(callback+"("+json+")");
		 }else {
			 LoginVO vo=new LoginVO();
				vo.setErrno(LoginVO.LOGIN_FAIL);
				vo.setMessage("登录失败");
				
				Gson gson=new Gson();
				String json=gson.toJson(vo);
				
				response.getWriter().write(callback+"("+json+")");
			 //request.getRequestDispatcher("behind/file.jsp").forward(request, response);
		 }
	}

}
