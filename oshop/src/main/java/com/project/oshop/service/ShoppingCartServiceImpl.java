 package com.project.oshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.oshop.bean.ManageProductsControllerBean;
import com.project.oshop.dao.ShoppingCartDAOImpl;
import com.project.oshop.data.ShoppingCartData;

@Service
public class ShoppingCartServiceImpl implements IShoppingCartService{

	@Autowired
	private ShoppingCartDAOImpl shoppingCartDAOImpl;
	
	@Transactional
	public List<ShoppingCartData> getShoppingCartList() {
		return shoppingCartDAOImpl.getShoppingCartList();
	}

	@Transactional
	public Long getQuantity() {
		return shoppingCartDAOImpl.getQuantity();
	}

	@Transactional
	public void saveShoppingCart(List<ManageProductsControllerBean> shoppingCartList) {
		shoppingCartDAOImpl.saveShoppingCart(shoppingCartList);
		
	}

	@Transactional
	public void deleteCartById(int id) {
		shoppingCartDAOImpl.deleteCartById(id);
		
	}

	@Transactional
	public ShoppingCartData getShoppingCartDataByProductId(int id) {
		// TODO Auto-generated method stub
		return shoppingCartDAOImpl.getShoppingCartDataByProductId(id);
	}

	@Transactional
	public void saveToCart(ShoppingCartData data) {
		shoppingCartDAOImpl.saveToCart(data);
		
	}

}
