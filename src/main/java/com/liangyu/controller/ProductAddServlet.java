package com.liangyu.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liangyu.entity.Category;
import com.liangyu.entity.Product;
import com.liangyu.servise.Productservise;
import com.liangyu.serviseimpl.ProductserviseImpl;

/**
 * Servlet implementation class AddServlet
 */
@WebServlet("/behind/ProductAddServlet")
public class ProductAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductAddServlet() {
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
		Productservise productservise=new ProductserviseImpl();
		List<Category> category=productservise.findAllCategory_id();
		request.setAttribute("category",category);
		System.out.println(category);
		request.getRequestDispatcher("addproduct.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//int id, int category_id, String name, String subtitle, String main_image, String sub_image,
		//String detail, BigDecimal price, int stock, int status, Date create_time, Date update_time
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		Product product=new Product();
		String category_id=request.getParameter("category_id");
		product.setCategory_id(Integer.parseInt(category_id));
		String name=request.getParameter("name");
		System.out.println(name);
		product.setName(name);
		String subtitle=request.getParameter("subtitle");
		product.setSubtitle(subtitle);
		String main_image=request.getParameter("main_image");
		product.setMain_image(main_image);
		String sub_image=request.getParameter("sub_image");
		product.setSub_image(sub_image);
		String detail=request.getParameter("detail");
		product.setDetail(detail);
		String price1=request.getParameter("price");
		Double _price=Double.valueOf(price1);
		BigDecimal price=BigDecimal.valueOf( _price);
		product.setPrice(price);
		String stock=request.getParameter("stock");
		product.setStock(Integer.parseInt(stock));
		String status=request.getParameter("status");
		product.setStatus(Integer.parseInt(status));
		
		Productservise productservise=new ProductserviseImpl();
		int result=productservise.addProduct(product);
		System.out.println(result);
		if(result>0) {
			request.getRequestDispatcher("ProductReadservelt").forward(request, response);
		}
		
	}

}
