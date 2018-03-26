package com.liangyu.serviseimpl;



import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.liangyu.consts.OrderStatusEnum;
import com.liangyu.dao.ProductDao;
import com.liangyu.dao.ShoppingCartDao;
import com.liangyu.dao.UserOrderDao;
import com.liangyu.dao.UserOrderItemDao;
import com.liangyu.daoimpl.ProductDaoImpl;
import com.liangyu.daoimpl.ProductDaoMyBatis;
import com.liangyu.daoimpl.ShoppingCartMyBatis;
import com.liangyu.daoimpl.UserOrderDaoImpl;
import com.liangyu.daoimpl.UserOrderItemDaoImpl;
import com.liangyu.entity.Cart;
import com.liangyu.entity.PageModle;
import com.liangyu.entity.Product;
import com.liangyu.entity.UserOrder;
import com.liangyu.entity.UserOrderItem;
import com.liangyu.entity.vo.OrderVO;
import com.liangyu.exception.CartException;
import com.liangyu.exception.UserDaoException;
import com.liangyu.exception.UserOrderException;
import com.liangyu.exception.UserOrderItemDaoException;
import com.liangyu.servise.UserOrderServise;



public class UserOrderImpl implements UserOrderServise{
	ProductDao productDao=ProductDaoImpl.getInstance();
	ProductDao productDao1=new ProductDaoMyBatis();
	UserOrderItemDao userOrderItemDao=new UserOrderItemDaoImpl();
	UserOrderDao userOrderDao=new UserOrderDaoImpl();
	ShoppingCartDao shoppingCartDao=new ShoppingCartMyBatis();
	
	public UserOrder createOrder(Integer user_id, HttpServletRequest request) throws UserOrderException {
		// TODO Auto-generated method stub
		
          //地址
		String _shipping_id=request.getParameter("shipping_id");
		if(_shipping_id==null&&_shipping_id.equals(" ")) {
			throw new UserOrderException("地址id传输不正确");
		}
		Integer shipping_id=null;
		try {
			shipping_id=Integer.parseInt(_shipping_id);

		}catch(NumberFormatException e){
			e.printStackTrace();
			throw new UserOrderException("地址id转数字错误");	
		}
		//购物车列表
		List<Cart> carts=shoppingCartDao.findCartListByUserId(user_id);
		
		if(carts.size()==0) {
			throw new UserOrderException("购物车为空");
		}
		//购物车转订单明细
		List<UserOrderItem> userOrderItems=convertCartToUserOrderItems(user_id,carts);
		//订单价格
		BigDecimal totalPriceDecimal=getTotalPrice(userOrderItems); 
		
		 //创建订单
		UserOrder order=creatOrder(user_id,shipping_id,totalPriceDecimal);
		if(order!=null) {
			//订单明细加到数据库
			addOrderItemToDB(order,userOrderItems);
		}
		//减少库存
		for(UserOrderItem userOrderItem:userOrderItems) {
			
			productDao1.reduceProductStock(userOrderItem.getProduct_id(), userOrderItem.getQuantity());			
		}
		
		//删除购物车
		shoppingCartDao.deleteCheckedProductByUserid(user_id);
		
		return null;
		
		
		
	}
	
	public List<UserOrderItem> convertCartToUserOrderItems(Integer user_id,List<Cart> carts){
		
	List<UserOrderItem> list=new ArrayList<UserOrderItem>();
	
	for(Cart cart:carts) {
		UserOrderItem orderItems=new UserOrderItem();
		Product product=productDao.findProductById(cart.getProduct().getId());
		if(product!=null) {
			orderItems.setProduct_id(product.getId());
			orderItems.setProduct_image(product.getMain_image());
			orderItems.setProduct_name(product.getName());
			orderItems.setCurrent_unit_price(product.getPrice());
		orderItems.setQuantity(cart.getQuantity());
		orderItems.setTotal_price(product.getPrice().multiply(new BigDecimal(cart.getQuantity())));
		orderItems.setUser_id(user_id);
		
		list.add(orderItems);
		}
	}
		return list;
	}
	
	private long generateOrderNo() {
		
		return System.currentTimeMillis()+(int)(Math.random()*100);
		
		
	}
	private UserOrder creatOrder(Integer user_id,Integer shipping_id,BigDecimal payment) {
		UserOrder order=new UserOrder();
		order.setOrder_no(generateOrderNo());
		order.setUser_id(user_id);
		order.setShipping_id(shipping_id);
		order.setPayment(payment);
		order.setPayment_type(1);
		order.setPostage(0);
		order.setStatus(OrderStatusEnum.UNPAY.getStatus());
		
		
		int result=userOrderDao.addOrder(order);
		if(result>0) {
			return order;
		}else {
			throw new UserDaoException("订单插入失败");
		}
		

	}
	private BigDecimal getTotalPrice(List<UserOrderItem> orderItems) {
		BigDecimal bigDecimal=new BigDecimal("0");
		for(UserOrderItem orderItem:orderItems) {
			bigDecimal=bigDecimal.add(orderItem.getTotal_price());
		
		}
	
		return bigDecimal;
		
		
	}
	
	
	
	private int addOrderItemToDB(UserOrder order,List<UserOrderItem> orderItems) {
		for(UserOrderItem orderItem:orderItems) {
			orderItem.setOrder_no(order.getOrder_no());
			long stock=productDao1.getProductStock(orderItem.getProduct_id());
	if(stock<orderItem.getQuantity()) {
		
		
		throw new UserOrderItemDaoException("库存不足");
	}
		}
		return userOrderItemDao.addBatch(orderItems);
		
	}

	
	public PageModle<OrderVO> findUserOrderByPage(Integer userid, HttpServletRequest request)
			throws UserOrderException {
		// TODO Auto-generated method stub
		
		String _pageNo=request.getParameter("pageNo");
		String _pageSize=request.getParameter("pageSize");
		int pageNo=0;
		int pageSize=0;
		try {
			 pageNo=Integer.parseInt(_pageNo);
			 pageSize=Integer.parseInt(_pageSize);
	
		}catch(NumberFormatException e) {
			e.printStackTrace();
			throw  new CartException("分页订单查询，必须传入pageNo, pageSize");
		}
		
		//UserOrderDao userOrderDao=new UserOrderDaoImpl(); 
		
		PageModle<UserOrder> pageModle=userOrderDao.findUserOrderByPage(userid, pageNo, pageSize);
		
		PageModle<OrderVO> q=convertUserOrderToOrderVo(pageModle);
	
		return q;
	} 
	
	public PageModle<OrderVO> convertUserOrderToOrderVo(PageModle<UserOrder> pageModle){
		
		PageModle<OrderVO> _pageModle=new PageModle<OrderVO>();
		if(pageModle!=null) {
			List<OrderVO> list=new ArrayList<OrderVO>();
			List<UserOrder> orders=pageModle.getData();
			for(UserOrder order:orders) {
				OrderVO orderVO=new OrderVO();
				orderVO.convertUserOrderToOrderVO(order);
				list.add(orderVO);
				
				
			}
			_pageModle.setTotalPage(pageModle.getTotalPage());
			_pageModle.setData(list);
			
		}
		
		return _pageModle;
	}

	
	public UserOrder findUserOrderDetailByOrderNo(Long orderno) throws UserOrderException {
		// TODO Auto-generated method stub
		return userOrderDao.findUserOrderDetailByOrderNo(orderno);
		
		 
	}

	
	public int updateOrderStatusByOrderNo(HttpServletRequest request) throws UserOrderException {
		// TODO Auto-generated method stub
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
		String _status=request.getParameter("status");
		if(_status==null&&_status.equals(" ")) {
			throw new UserOrderException("状态为空");
		}
		int status=0;
		try {
			status=Integer.parseInt(_status);
		}catch (NumberFormatException e){
			e.printStackTrace();
			throw new UserOrderException("状态转换错误");
		}
		return userOrderDao.updateOrderStatusByOrderNo(orderno, status);
	}

	
	public List<UserOrderItem> findOrderItemByOrderNo(Long orderno) throws UserOrderItemDaoException {
		// TODO Auto-generated method stub
		return userOrderItemDao.findOrderItemByOrderNo(orderno);
		
		
		
		
	}
	
	
}
