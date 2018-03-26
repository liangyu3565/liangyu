package com.liangyu.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.liangyu.entity.User;
import com.liangyu.servise.ShoppingCartServise;
import com.liangyu.serviseimpl.ShoppingCartServiseImpl;

/**
 * Servlet implementation class CartDelete
 */
@WebServlet("/view/CartDelete")
public class CartDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartDelete() {
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
		Object o=session.getAttribute("user");
		User user=new User();
		if(o!=null&&o instanceof User) {
			user=(User)o;
		}
		int userid=user.getId();
		String _productid=request.getParameter("product_id");
		int productid=Integer.parseInt(_productid);
		ShoppingCartServise shoppingCartServise=ShoppingCartServiseImpl.getInstance();
		int result=shoppingCartServise.delectCartByProductId(userid, productid);
		PrintWriter pw=response.getWriter();
		pw.write("deleteResult("+result+");");
		
		//request.getRequestDispatcher("ShoppingCartServlet?select=2&pageNo=1&pageSize=5").forward(request, response);
		//request.getRequestDispatcher("");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
