package com.liangyu.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.liangyu.entity.Cart;
import com.liangyu.entity.PageModle;
import com.liangyu.exception.CartException;
import com.liangyu.servise.ShoppingCartServise;
import com.liangyu.serviseimpl.ShoppingCartServiseImpl;

/**
 * Servlet implementation class Jscart
 */
@WebServlet("/Jscart")
public class Jscart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Jscart() {
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
		request.getParameter("pageNo");
		System.out.println(request.getParameter("pageNo"));
		ShoppingCartServise shoppingCartServise=ShoppingCartServiseImpl.getInstance();
		PageModle<Cart> cart=shoppingCartServise.findCartByPage(1, request);				
		int result=shoppingCartServise.findCartQuantity(1);
		if(result==0) {
			throw new CartException("购物车为空");
		}
		
		Gson gson=new Gson();
		String result1=gson.toJson(cart);
		PrintWriter pw=response.getWriter();
		pw.write("date("+result1+");");
		pw.write("quantity("+result+")");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
