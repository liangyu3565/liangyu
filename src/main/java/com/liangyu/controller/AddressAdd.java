package com.liangyu.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.liangyu.entity.Address;
import com.liangyu.entity.User;
import com.liangyu.servise.AddressServise;
import com.liangyu.serviseimpl.AddressServiseImpl;

/**
 * Servlet implementation class AddressAdd
 */
@WebServlet("/view/AddressAdd")
public class AddressAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddressAdd() {
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
		HttpSession session=request.getSession();
		Object o=session.getAttribute("user");
		User user=new User();
		if(o!=null&&o instanceof User) {
			user=(User)o;
		}	
			int userid=user.getId();
		//int userid=(Integer)session.getAttribute("userid");
		Address address=new Address();
		address.setReceiver_name(request.getParameter("receiver_name"));
		address.setReceiver_phone(request.getParameter("receiver_phone"));
		address.setReceiver_mobile(request.getParameter("receiver_mobile"));
		address.setReceiver_province(request.getParameter("receiver_province"));
		address.setReceiver_city(request.getParameter("receiver_city"));
		address.setReceiver_district(request.getParameter("receiver_district"));
		address.setReceiver_address(request.getParameter("receiver_address"));
		address.setReceiver_zip(request.getParameter("receiver_zip"));
		
		
		addressServise.addAddress(userid, address);
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
