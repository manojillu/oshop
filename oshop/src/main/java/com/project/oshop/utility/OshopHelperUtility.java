package com.project.oshop.utility;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Component;

import com.project.oshop.bean.ManageProductsControllerBean;
import com.project.oshop.bean.ShoppingCartBean;
import com.project.oshop.data.ProductData;
import com.project.oshop.data.ShoppingCartData;

@Component
public class OshopHelperUtility {

	public ShoppingCartData insertCartData(ManageProductsControllerBean bean, ShoppingCartData data,String increaseOrDecrease) {
		if(data!=null) {
			increaseOrDecreaseQuantity(bean, data,increaseOrDecrease);
			return data;
		}
		else {
			ShoppingCartData cartData = new ShoppingCartData();
			ProductData productData = new ProductData();
			cartData.setPrice(bean.getPrice());
			cartData.setQuantity(bean.getQuantity()+1);
			BigDecimal price = this.getPrice(cartData.getQuantity(), bean.getPrice());
			cartData.setUserName(null);
			productData.setId(bean.getId());
			productData.setTitle(bean.getTitle());
			productData.setPrice(price);
			productData.setCategory(bean.getCategory());
			cartData.setProductData(productData);
			return cartData;
		}
	}

	private void increaseOrDecreaseQuantity(ManageProductsControllerBean bean, ShoppingCartData data, String increaseOrDecrease) {
		if("Plus".equalsIgnoreCase(increaseOrDecrease)) {
			data.setQuantity(data.getQuantity()+1);
			BigDecimal price = this.getPrice(data.getQuantity(), bean.getPrice());
			data.setPrice(price);
		}
		else {
			data.setQuantity(data.getQuantity()-1);
			BigDecimal price = this.getPrice(data.getQuantity(), bean.getPrice());
			data.setPrice(price);
		}
	}
	
	public void shoppingCartListToDisplay(List<ShoppingCartData> cartList, List<ShoppingCartBean> productList) {
		for (ShoppingCartData data : cartList) {
			ShoppingCartBean shoppingCartBean= new ShoppingCartBean();
			shoppingCartBean.setId(data.getProductData().getId());
			shoppingCartBean.setTitle(data.getProductData().getTitle());
			shoppingCartBean.setPrice(data.getPrice());
			shoppingCartBean.setImageUrl(data.getProductData().getImageUrl());
			shoppingCartBean.setQuantity(data.getQuantity());
			productList.add(shoppingCartBean);
		}
	}
	
	public BigDecimal getPrice(long quantity,BigDecimal price) {
		return BigDecimal.valueOf(quantity).multiply(price);
	}
}
