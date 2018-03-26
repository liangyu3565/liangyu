package com.liangyu.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liangyu.entity.PageModle;
import com.liangyu.entity.Product;
import com.liangyu.serviseimpl.ProductserviseImpl;



/**
 * Servlet implementation class Rservelt
 */
@WebServlet("/behind/ProductReadservelt")
public class ProductReadservelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductReadservelt() {
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
		String pageNo=request.getParameter("pageNo");
		if(pageNo==null||pageNo.equals("")) {
			pageNo="1";
		}
		System.out.println(pageNo);
		ProductserviseImpl readServise=new ProductserviseImpl();
		PageModle<Product> pageModle=readServise.findProductByPage(Integer.parseInt(pageNo), 1);
		
	   
		
	    request.setAttribute("pageModle", pageModle);
	    System.out.println(pageModle);
	    request.getRequestDispatcher("productRead.jsp").forward(request, response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
