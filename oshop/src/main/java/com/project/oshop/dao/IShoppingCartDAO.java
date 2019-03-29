package com.project.oshop.dao;

import java.util.List;

import com.project.oshop.bean.ManageProductsControllerBean;
import com.project.oshop.data.ShoppingCartData;

public interface IShoppingCartDAO {
	
	public void saveShoppingCart(List<ManageProductsControllerBean> shoppingCartList);
	
	public void saveToCart(ShoppingCartData data);

	public List<ShoppingCartData> getShoppingCartList();
	
	public ShoppingCartData getShoppingCartDataByProductId(int id);

	public Long getQuantity();
	
	public void deleteCartById(int id);

}
