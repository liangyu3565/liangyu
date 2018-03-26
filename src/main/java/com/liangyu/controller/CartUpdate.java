package com.liangyu.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.liangyu.entity.Cart;
import com.liangyu.entity.User;
import com.liangyu.servise.ShoppingCartServise;
import com.liangyu.serviseimpl.ShoppingCartServiseImpl;

/**
 * Servlet implementation class CartUpdate
 */
@WebServlet("/view/CartUpdate")
public class CartUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartUpdate() {
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
		
		
		String _product_id=request.getParameter("product_id");
		int productid=Integer.parseInt(_product_id);
		
		ShoppingCartServise shoppingCartServise=ShoppingCartServiseImpl.getInstance();
		Cart cart=shoppingCartServise.findCartByUserIdAndProductId(userid, productid);
		
		//request.getParameter("quantity");
		request.setAttribute("cart", cart);
		request.setAttribute("product_id", productid);
		
		request.getRequestDispatcher("cartUpdate.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		//String _user_id=request.getParameter("user_id");
		//int userid=Integer.parseInt(_user_id);
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
		String _product_id=request.getParameter("product_id");
		int productid=Integer.parseInt(_product_id);
		String _quantity=request.getParameter("quantity");
		int quantity=Integer.parseInt(_quantity);
		
		
		
		ShoppingCartServise shoppingCartServise=ShoppingCartServiseImpl.getInstance();
		shoppingCartServise.updateCartByUserIdAndProductId(userid, productid, quantity);
		request.getRequestDispatcher("ShoppingCartServlet?select=2&pageNo=1&pageSize=5").forward(request, response);
	}

}
