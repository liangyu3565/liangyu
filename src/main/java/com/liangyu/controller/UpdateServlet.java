package com.liangyu.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liangyu.entity.Category;
import com.liangyu.servise.Categoryservise;
import com.liangyu.serviseimpl.CategoryserviseImpl;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/behind/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
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
		Categoryservise categoryservise=new CategoryserviseImpl();
		List<Category> category=categoryservise.findAllParent_id();
		request.setAttribute("category",category);
		System.out.println(category);
		//request.getRequestDispatcher("addcategory.jsp").forward(request, response);
		
		String _id=request.getParameter("id");
		//System.out.println(_id);
		//request.setAttribute("id", _id);
		//Category category=new Category();
		Categoryservise categoryservise1=new CategoryserviseImpl();
		try {
			Category category1=categoryservise1.findCategoryById(Integer.parseInt(_id));
			System.out.println(category1);
		if(categoryservise1!=null) {
			request.setAttribute("Category", category1);
			request.getRequestDispatcher("update.jsp").forward(request, response);
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
		Category category=new Category();
		
		String _id=request.getParameter("id");
		System.out.println("id="+_id);
		category.setId(Integer.parseInt(_id));
		String parent_id=request.getParameter("parent_id");
		category.setParent_id(Integer.parseInt(parent_id));
		String name=request.getParameter("name");
		category.setName(name);
		String status=request.getParameter("status");
		category.setStatus(Integer.parseInt(status));
		String sort_order=request.getParameter("sort_order");
		category.setSort_order(Integer.parseInt(sort_order));
		System.out.println(category);
		Categoryservise categoryservise=new CategoryserviseImpl();
		int result=categoryservise.updateCategory(category);
		
		request.getRequestDispatcher("Rservelt").forward(request, response);
		
		
	}
	}


