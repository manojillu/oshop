package com.project.oshop.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.oshop.bean.ManageProductsControllerBean;
import com.project.oshop.bean.ShoppingCartBean;
import com.project.oshop.data.ShoppingCartData;
import com.project.oshop.service.ProductServiceImpl;
import com.project.oshop.service.ShoppingCartServiceImpl;
import com.project.oshop.utility.OshopHelperUtility;

@Controller
public class ShoppingCartController {

	private static final Logger logger = LoggerFactory.getLogger(ShoppingCartController.class);
	Map<Integer, ManageProductsControllerBean> shoppingCartMap = new HashMap<Integer, ManageProductsControllerBean>();

	@Autowired
	private ShoppingCartServiceImpl shoppingCartServiceImpl;
	@Autowired
	private ProductServiceImpl productServiceImpl;
	@Autowired
	private OshopHelperUtility oshopHelperUtility;

	Long quantity = (long) 0;

	@RequestMapping(value = "/addingShoppingcart/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Long shoppingCartGetMethod(@PathVariable("id") int id, Model model, HttpServletRequest request) {
		ManageProductsControllerBean bean = productServiceImpl.getProductsById(id);
		ShoppingCartData data = shoppingCartServiceImpl.getShoppingCartDataByProductId(id);
		ShoppingCartData insertData = oshopHelperUtility.insertCartData(bean, data,"Plus");
		shoppingCartServiceImpl.saveToCart(insertData);
		quantity = shoppingCartServiceImpl.getQuantity();
		return quantity;
	}
	
	@RequestMapping(value = "/reducingShoppingcart/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Long reducingShoppingCart(@PathVariable("id") int id, Model model, HttpServletRequest request) {
		ManageProductsControllerBean bean = productServiceImpl.getProductsById(id);
		ShoppingCartData data = shoppingCartServiceImpl.getShoppingCartDataByProductId(id);
		ShoppingCartData insertData = oshopHelperUtility.insertCartData(bean, data,"Minus");
		shoppingCartServiceImpl.saveToCart(insertData);
		quantity = shoppingCartServiceImpl.getQuantity();
		return quantity;
	}

	@RequestMapping(value = "/deletecart/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Long deleteCart(@PathVariable("id") int id, Model model, HttpServletRequest request) {
		logger.debug("Deleted Id"+id);
		ShoppingCartData data = shoppingCartServiceImpl.getShoppingCartDataByProductId(id);
		shoppingCartServiceImpl.deleteCartById(data.getId());
		return (long) id;
	}

	@RequestMapping(value = "/shoppingcart", method = RequestMethod.GET)
	public String shoppingCartPostMethod(Model model, ManageProductsControllerBean bean, HttpServletRequest request) {
		quantity = shoppingCartServiceImpl.getQuantity();
		if (quantity == null) {
			quantity = (long) 0;
		}
		List<ShoppingCartData> cartList = shoppingCartServiceImpl.getShoppingCartList();
		List<ShoppingCartBean> productList = new ArrayList<ShoppingCartBean>();
		oshopHelperUtility.shoppingCartListToDisplay(cartList, productList);
		if (cartList != null && !cartList.isEmpty()) {
			model.addAttribute("productList", productList);
		}
		model.addAttribute("quantity", quantity);
		return "shoppingcart";
	}

}
