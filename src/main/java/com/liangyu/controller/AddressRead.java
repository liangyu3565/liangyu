package com.liangyu.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.liangyu.dao.UserAddress;
import com.liangyu.daoimpl.AddressMyBatisDao;
import com.liangyu.entity.Address;
import com.liangyu.entity.Category;
import com.liangyu.entity.PageModle;
import com.liangyu.entity.User;
import com.liangyu.servise.AddressServise;
import com.liangyu.serviseimpl.AddressServiseImpl;

/**
 * Servlet implementation class AddressRead
 */
@WebServlet("/view/AddressRead")
public class AddressRead extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddressRead() {
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
		AddressServise addressServise=AddressServiseImpl.getInstance();
		HttpSession session=request.getSession();
		Object o=session.getAttribute("user");
		User user=new User();
		System.out.println(user+"8888899999");
		if(o!=null&&o instanceof User) {
			user=(User)o;
		}
		//String username=(String)session.getAttribute("username");
		//String password=(String)session.getAttribute("password");
		//if(username!=null&&password!=null) {
		if(user!=null) {
		//int userid=(Integer)session.getAttribute("userid");
			int userid=user.getId();
			
		int pageNo=-1;
		String _pageNo=request.getParameter("pageNo");
		if(_pageNo==null||_pageNo.equals("")) {
			//_pageNo="1";
			 pageNo=1;
		}else {
		 pageNo=Integer.parseInt(_pageNo);
		}
		PageModle<Address> pageModle=addressServise.findUserAddress(pageNo, 1, userid);
		request.setAttribute("pageModle", pageModle);
		request.getRequestDispatcher("AddressRead.jsp").forward(request, response);
	}else {
		response.sendRedirect("http://localhost:8080/business/login.jsp");
	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
