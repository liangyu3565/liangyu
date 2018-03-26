package com.liangyu.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

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
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/behind/UpdateProductServlet")
public class UpdateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProductServlet() {
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
		List<Category> product=productservise.findAllCategory_id();
		request.setAttribute("product",product);
		System.out.println(product);
		//request.getRequestDispatcher("addcategory.jsp").forward(request, response);
		
		String _id=request.getParameter("id");
		System.out.println(_id);
		//request.setAttribute("id", _id);
		//Category category=new Category();
		Productservise productservise1=new ProductserviseImpl();
		try {
			Product product1=productservise1.findProductById(Integer.parseInt(_id));
			
		if(productservise1!=null) {
			request.setAttribute("Product1", product1);
			request.getRequestDispatcher("updateProduct.jsp").forward(request, response);
		}
		}catch(NumberFormatException e){
			e.printStackTrace();
			
		}
	} 

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		Product product=new Product();
		
		String _id=request.getParameter("id");
		System.out.println("id="+_id);
		product.setId(Integer.parseInt(_id));
		String category_id=request.getParameter("category_id");
		product.setCategory_id(Integer.parseInt(category_id));
		String name=request.getParameter("name");
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
		System.out.println(product);
		Productservise productservise=new ProductserviseImpl();
		int result=productservise.updateProduct(product);
		System.out.println(result);
		request.getRequestDispatcher("ProductReadservelt").forward(request, response);
		
		
	}
	}


