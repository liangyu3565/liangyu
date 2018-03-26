package com.liangyu.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.liangyu.dao.ShoppingCartDao;
import com.liangyu.daoimpl.ShoppingCartDaoImpl;
import com.liangyu.entity.Cart;
import com.liangyu.entity.PageModle;
import com.liangyu.entity.User;
import com.liangyu.entity.vo.CartVO;
import com.liangyu.exception.CartException;
import com.liangyu.servise.ShoppingCartServise;
import com.liangyu.serviseimpl.ShoppingCartServiseImpl;

/**
 * Servlet implementation class ShoppingCartServlet
 */
@WebServlet("/view/ShoppingCartServlet")
public class ShoppingCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShoppingCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String callback=request.getParameter("callback");
		HttpSession session=request.getSession();
		//Object username=session.getAttribute("username");
		//Object password=session.getAttribute("password");
		Object o=session.getAttribute("user");
		User user=null;
		if(o!=null&&o instanceof User) {
			user=(User)o;
		}
		
		if(user!=null) {
			
			
		
			
			int userid=user.getId();
			//if(username!=null&&password!=null) {
			//Object user_id=session.getAttribute("userid");
			//

			//int userid=(Integer)user_id;
			String select=request.getParameter("select");
			
			String  _product_id=request.getParameter("product_id");
			PrintWriter pw=response.getWriter();
			int  productid=0;
			if(_product_id!=null) {
				productid=Integer.parseInt(_product_id);
			}
			
			if(select==null) {
				throw new CartException("获取select错误");
			}else {
				
			
				ShoppingCartServise shoppingCartServise=ShoppingCartServiseImpl.getInstance();
			
			if(select.equals("1")) {
				//���
				addProductToCart( request, response,shoppingCartServise,userid);
				//request.getRequestDispatcher("ShoppingCartServlet?select=2&pageNo=1&pageSize=5").forward(request, response);
			}else if(select.equals("2")) {
				//�鿴
				CartVO vo=new CartVO();
				vo.setErrno(CartVO.CART_SUCCESS);
				
				
				PageModle<Cart> cart=shoppingCartServise.findCartByPage(userid, request);				
				vo.setPageModle(cart);
				
				int result=shoppingCartServise.findCartQuantity(userid);
				if(result==0) {
					throw new CartException("购物车为空");
				}
				
				Gson gson=new Gson();
				String result1=gson.toJson(vo);
				pw.write(callback+"("+result1+");");
				pw.write("quantity("+result+");");
				
				//request.setAttribute("pageModle", cart);
				//request.setAttribute("result",result);
				//request.getRequestDispatcher("CartRead.jsp").forward(request, response);
			}else if(select.equals("3")) {
				//ȫѡ
				int result=shoppingCartServise.checkOrUncheckedProduct(userid, -1, 1);
				pw.write("checked("+result+");");
				//request.getRequestDispatcher("ShoppingCartServlet?select=2&pageNo=1&pageSize=5").forward(request, response);
				
			}else if(select.equals("4")) {
				//ȫ��ѡ
			
				int result=shoppingCartServise.checkOrUncheckedProduct(userid, -1, 0);
				pw.write("unchecked("+result+");");
				//request.getRequestDispatcher("ShoppingCartServlet?select=2&pageNo=1&pageSize=5").forward(request, response);
				
			}else if(select.equals("5")) {
				//��ѡ
				int result=shoppingCartServise.checkOrUncheckedProduct(userid, productid, 1);
				//request.getRequestDispatcher("ShoppingCartServlet?select=2&pageNo=1&pageSize=5").forward(request, response);
				pw.write("check("+result+");");
			}else if(select.equals("6")) {
				//ȫ��ѡ
				int result=shoppingCartServise.checkOrUncheckedProduct(userid, productid, 0);
				//request.getRequestDispatcher("ShoppingCartServlet?select=2&pageNo=1&pageSize=5").forward(request, response);
				pw.write("check("+result+");");
			}
			
			}
		}
			
			
		else {
			CartVO vo=new CartVO();
			vo.setErrno(CartVO.CART_UNLOGIN);
			vo.setMessage("未登录，请登录");
			Gson gson=new Gson();
			String json=gson.toJson(vo);
			response.getWriter().write(callback+"("+json+");");
			
			
			
			
			//response.sendRedirect("http://localhost:8080/business/login.jsp");
		}
		
		
			
		
		
	}
	
	public void addProductToCart(HttpServletRequest request, HttpServletResponse response,ShoppingCartServise shoppingCartServise,Integer userid) {
		
	
	shoppingCartServise.addCartByUserIdAndProductId(userid, request);
	
		
	}

}
