package com.liangyu.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liangyu.entity.Category;
import com.liangyu.entity.Product;
import com.liangyu.servise.Categoryservise;
import com.liangyu.servise.Productservise;
import com.liangyu.serviseimpl.CategoryserviseImpl;
import com.liangyu.serviseimpl.ProductserviseImpl;

/**
 * Servlet implementation class DelectCateServlet
 */
@WebServlet("/behind/ProductDelectCateServlet")
public class DelectProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelectProductServlet() {
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
		Product product=new Product();
		String _id=request.getParameter("id");
		product.setId(Integer.parseInt(_id));
		System.out.println(_id);
		System.out.println(product);
		Productservise productservise=new ProductserviseImpl();
		int result=productservise.delectProduct(product);
		if(result>0) {
		request.getRequestDispatcher("ProductReadservelt").forward(request, response);
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
