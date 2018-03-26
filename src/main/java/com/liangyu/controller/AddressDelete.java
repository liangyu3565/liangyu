package com.liangyu.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.liangyu.entity.User;
import com.liangyu.servise.AddressServise;
import com.liangyu.serviseimpl.AddressServiseImpl;

/**
 * Servlet implementation class AddressDelete
 */
@WebServlet("/view/AddressDelete")
public class AddressDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddressDelete() {
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
		//String _userid=request.getParameter("user_id");
		//int userid=Integer.parseInt(_userid);
		HttpSession session=request.getSession();
		Object o=session.getAttribute("user");
		User user=null;
		int userid=0;
		if(o!=null) {
			if(o instanceof User) {
				
				user=(User) o;
				
			}
			userid=user.getId();
			
			
		}
		
		String _id=request.getParameter("id");
		int id=Integer.parseInt(_id);
		
		 addressServise.delectAddressByUserid(userid, id);
		 request.getRequestDispatcher("AddressRead").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
