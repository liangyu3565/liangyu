package com.liangyu.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.liangyu.entity.PageModle;
import com.liangyu.entity.User;
import com.liangyu.entity.UserOrder;
import com.liangyu.entity.UserOrderItem;
import com.liangyu.entity.vo.OrderVO;
import com.liangyu.exception.UserOrderException;
import com.liangyu.servise.UserOrderServise;
import com.liangyu.serviseimpl.UserOrderImpl;

/**
 * Servlet implementation class UserOrder
 */
@WebServlet("/view/UserOrder")
public class Userorder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Userorder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		Object o=session.getAttribute("user");
		User user=null;
        if(o!=null&&o instanceof User) {
        	user=(User)o;
        	
        }
        
        
        
        
        if(user!=null) {
        	
        	String select=request.getParameter("select");
        	if(select==null&&select.equals(" ")) {	
        		throw new UserOrderException("select为空");
        	}
             
        	UserOrderServise userOrderServise=new UserOrderImpl();
        	if(select.equals("1")) {//创建订单
        		userOrderServise.createOrder(user.getId(), request);
        	}else if(select.equals("2")) {//查询
        		
        		PageModle<OrderVO> pageModle=userOrderServise.findUserOrderByPage(user.getId(), request);
        		request.setAttribute("pageModle", pageModle);
        		request.getRequestDispatcher("UserOrderRead.jsp").forward(request, response);
        	}else if(select.equals("3")) {//通过订单号查询详情
        		String _orderno=request.getParameter("orderno");
        		if(_orderno==null&&_orderno.equals(" ")) {
        			throw new UserOrderException("订单号为空");
        		}
        		long orderno=0;
        		try {
        		 orderno=Long.parseLong(_orderno);
        		}catch (NumberFormatException e){
        			e.printStackTrace();
        			throw new UserOrderException("订单号转换错误");
        		}
        		UserOrder userOrder=userOrderServise.findUserOrderDetailByOrderNo(orderno);
        		request.setAttribute("orderno", orderno);
        		request.setAttribute("userOrder", userOrder);
        		request.getRequestDispatcher("ItemRead.jsp").forward(request, response);
        		
        		
        	}else if(select.equals("4")) {//通过订单号修改状态
        		
        		//userOrderServise.updateOrderStatusByOrderNo(request);
        		String _orderno=request.getParameter("orderno");
        		if(_orderno==null&&_orderno.equals(" ")) {
        			throw new UserOrderException("订单号为空");
        		}
        		long orderno=0;
        		try {
        		 orderno=Long.parseLong(_orderno);
        		}catch (NumberFormatException e){
        			e.printStackTrace();
        			throw new UserOrderException("订单号转换错误");
        		}
        		
        		request.setAttribute("orderno", orderno);
        		request.getRequestDispatcher("orderUpdate.jsp").forward(request, response);
        		
        		
        	}else if(select.equals("5")) {
        		String _orderno=request.getParameter("orderno");
        		if(_orderno==null&&_orderno.equals(" ")) {
        			throw new UserOrderException("订单号为空");
        		}
        		long orderno=0;
        		try {
        		 orderno=Long.parseLong(_orderno);
        		}catch (NumberFormatException e){
        			e.printStackTrace();
        			throw new UserOrderException("订单号转换错误");
        		}
        		List<UserOrderItem> userOrder=userOrderServise.findOrderItemByOrderNo(orderno);
        		System.out.println(userOrder+"///////////////////*********************");
        		
        		request.setAttribute("userOrder", userOrder);
        		request.getRequestDispatcher("Item_Product_Read.jsp").forward(request, response);
        		
        		
        	}
  
        }else {
        	
        	response.sendRedirect("http://localhost:8080/business/login.jsp");
        	return;
        	
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
