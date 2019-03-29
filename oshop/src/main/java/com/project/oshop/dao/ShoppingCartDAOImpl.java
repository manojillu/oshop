package com.project.oshop.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.oshop.bean.ManageProductsControllerBean;
import com.project.oshop.data.ProductData;
import com.project.oshop.data.ShoppingCartData;

@Repository
public class ShoppingCartDAOImpl implements IShoppingCartDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	private List<ShoppingCartData> shoppingCartDataList=null;

	@SuppressWarnings("unchecked")
	public List<ShoppingCartData> getShoppingCartList() {
		Session session = sessionFactory.getCurrentSession();
		Query<ShoppingCartData> shoppingCartList = session.getNamedQuery("getAllShoppingCartData");
		shoppingCartDataList = shoppingCartList.list();
		return shoppingCartDataList;
	}

	@SuppressWarnings("unchecked")
	public Long getQuantity() {
		Session session = sessionFactory.getCurrentSession();
		Query<Long>  shoppingCartList = session.getNamedQuery("getQuantityCount");
		List<Long> quantity = shoppingCartList.list();
		return quantity.get(0);
	}

	@SuppressWarnings("unchecked")
	public void saveShoppingCart(List<ManageProductsControllerBean> shoppingCartList) {
		Session session = sessionFactory.getCurrentSession();
		if(shoppingCartList!=null && !shoppingCartList.isEmpty()) {
			for (ManageProductsControllerBean bean : shoppingCartList) {
				Query<ShoppingCartData> query = session.getNamedQuery("getShoppingCartDataByProductId");
				query.setParameter("id", bean.getId());
				List<ShoppingCartData> updatedCart = (List<ShoppingCartData>) query.list();
				if(updatedCart!=null && !updatedCart.isEmpty()) {
					ShoppingCartData cart= updatedCart.get(0);
					cart.setQuantity(bean.getQuantity());
					ProductData data = session.get(ProductData.class, bean.getId());
					cart.setProductData(data);
					session.saveOrUpdate(cart);
				}
				else {
					ProductData data = session.get(ProductData.class, bean.getId());
					session.saveOrUpdate(new ShoppingCartData(bean.getQuantity(),null,bean.getPrice(),data));
				}
			}
		}
		
	}

	public void deleteCartById(int id) {
		Session session= this.sessionFactory.getCurrentSession();
		ShoppingCartData cartData= session.get(ShoppingCartData.class,id);
		if(cartData!=null) {
			session.delete(cartData);
		}
	}

	@SuppressWarnings("unchecked")
	public ShoppingCartData getShoppingCartDataByProductId(int id) {
		Session session= this.sessionFactory.getCurrentSession();
		Query<ShoppingCartData> query = session.getNamedQuery("getShoppingCartDataByProductId");
		query.setParameter("id", id);
		List<ShoppingCartData> updatedCart = (List<ShoppingCartData>) query.list();
		if(updatedCart!=null && !updatedCart.isEmpty()) {
			ShoppingCartData data = updatedCart.get(0);
			return data;
		}
		else {
			return null;
		}
	}

	public void saveToCart(ShoppingCartData data) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(data);
		
	}

}
