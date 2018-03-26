package com.liangyu.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liangyu.entity.Category;
import com.liangyu.entity.PageModle;
import com.liangyu.serviseimpl.CategoryserviseImpl;



/**
 * Servlet implementation class Rservelt
 */
@WebServlet("/behind/Rservelt")
public class Rservelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Rservelt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//int pageno = 1;
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String pageNo=request.getParameter("pageNo");
		if(pageNo==null||pageNo.equals("")) {
			pageNo="1";
		}
		System.out.println(pageNo);
		CategoryserviseImpl readServise=new CategoryserviseImpl();
		PageModle<Category> pageModle=readServise.findCategoryByPage(Integer.parseInt(pageNo), 1);
		
	    //List<Category> list=readServise.SreadAll();
		
	    request.setAttribute("pageModle", pageModle);
	    request.getRequestDispatcher("read.jsp").forward(request, response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
