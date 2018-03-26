package com.liangyu.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liangyu.entity.Category;
import com.liangyu.servise.Categoryservise;
import com.liangyu.serviseimpl.CategoryserviseImpl;

/**
 * Servlet implementation class DelectCateServlet
 */
@WebServlet("/behind/DelectCateServlet")
public class DelectCateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelectCateServlet() {
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
		Category category=new Category();
		String _id=request.getParameter("id");
		category.setId(Integer.parseInt(_id));
		System.out.println(_id);
		System.out.println(category);
		Categoryservise categoryservise=new CategoryserviseImpl();
		int result=categoryservise.delectCategory(category);
		if(result>0) {
		request.getRequestDispatcher("Rservelt").forward(request, response);
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
