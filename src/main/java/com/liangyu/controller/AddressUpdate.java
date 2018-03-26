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
 * Servlet implementation class AddressUpdate
 */
@WebServlet("/view/AddressUpdate")
public class AddressUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddressUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		AddressServise addressServise=AddressServiseImpl.getInstance();
		
		
		
		
		
		String _id=request.getParameter("id");
		int id=Integer.parseInt(_id); 
		Address address=addressServise.findAddressById(id);
		
		request.setAttribute("address", address);
		request.getRequestDispatcher("addressUpdate.jsp").forward(request, response);
		
		/*String _user_id=request.getParameter("user_id");
		int user_id=Integer.parseInt(_user_id);
		address.setId(id);
		address.setUser_id(user_id);
		
		address.setReceiver_name(request.getParameter("receiver_name"));
		address.setReceiver_phone(request.getParameter("Receiver_phone"));
		address.setReceiver_mobile(request.getParameter("receiver_mobile"));
		address.setReceiver_province(request.getParameter("receiver_province"));
		address.setReceiver_city(request.getParameter("receiver_city"));
		address.setReceiver_district(request.getParameter("receiver_district"));
		address.setReceiver_address(request.getParameter("receiver_address"));
		address.setReceiver_zip(request.getParameter("receiver_zip"));
		request.setAttribute("address", address);
		request.getRequestDispatcher("").forward(request, response);
		
		
		
		/*String id=request.getParameter("id");
		String user_id=request.getParameter("user_id");
		String Receiver_name=request.getParameter("receiver_name");
		String Receiver_phone=request.getParameter("Receiver_phone");
		String Receiver_mobile=request.getParameter("receiver_mobile");
		String Receiver_province=request.getParameter("receiver_province");
		String Receiver_city=request.getParameter("receiver_city");
		String Receiver_district=request.getParameter("receiver_district");
		String Receiver_address=request.getParameter("receiver_address");
		String Receiver_zip=request.getParameter("receiver_zip");*/
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
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
		AddressServise addressServise=AddressServiseImpl.getInstance();
		addressServise.updateUserAddressByUserid(userid, address);
		request.setAttribute("address", address);
		request.getRequestDispatcher("AddressRead").forward(request, response);
	}

}
