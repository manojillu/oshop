package com.project.oshop.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.oshop.bean.ManageProductsControllerBean;
import com.project.oshop.service.ProductServiceImpl;
import com.project.oshop.service.ShoppingCartServiceImpl;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@Autowired
	private ProductServiceImpl productServiceImpl;
	@Autowired
	private ShoppingCartServiceImpl shoppingCartServiceImpl;
	private HttpSession session = null;

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = { "/", "/welcome" }, method = RequestMethod.GET)
	public String homegetMethod(Locale locale, Model model, HttpServletRequest request) {
		Long quantity = (long) 0;
		session = request.getSession();
		quantity = shoppingCartServiceImpl.getQuantity();
		if (quantity == null) {
			quantity = (long) 0;
		}
		List<ManageProductsControllerBean> beanList = productServiceImpl.getAllProducts();
		session.setAttribute("productList", beanList);
		session.setAttribute("quantity", quantity);
		model.addAttribute("productList", beanList);
		List<String> categoryList = productServiceImpl.getCatogories();
		model.addAttribute("categoryList", categoryList);
		model.addAttribute("categoryList", categoryList);
		model.addAttribute("quantity", quantity);
		logger.info("Inside HomeController");
		return "home";
	}

	@RequestMapping(value = "/manageProduct", method = RequestMethod.GET)
	public String getManageProduct(Model model) {
		List<ManageProductsControllerBean> beanList = productServiceImpl.getAllProducts();
		model.addAttribute("productList", beanList);
		return "manageproducts";

	}

	@RequestMapping(value = "/manageOrder", method = RequestMethod.GET)
	public String getManageOrder(Model model) {
		return "manageorders";
	}

	@RequestMapping(value = "/myorder", method = RequestMethod.GET)
	public String getMyOrder(Model model) {
		return "myorders";
	}

	@RequestMapping(value = "/getProductsByCategory/{category}", method = RequestMethod.GET)
	public String getProductsByCategory(@PathVariable("category") String category, Model model,
			ManageProductsControllerBean bean, HttpServletRequest request) {
		session = request.getSession();
		Long quantity = (long) 0;
		List<ManageProductsControllerBean> beanList = productServiceImpl.getProductsByCategory(category);
		if (beanList != null && !beanList.isEmpty()) {
			model.addAttribute("productList", beanList);
			model.addAttribute("quantity", "0");
		}
		List<String> categoryList = productServiceImpl.getCatogories();
		model.addAttribute("categoryList", categoryList);
		if (session.getAttribute("quantity") != null) {
			quantity = (Long) session.getAttribute("quantity");
		}
		model.addAttribute("quantity", quantity);
		return "home";
	}

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Locale locale, Model model) {
		logger.info("Welcome HomeController get method", locale);
		return "login";
	}
}
