package com.project.oshop.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.oshop.bean.ManageProductsControllerBean;
import com.project.oshop.service.ProductServiceImpl;

@Controller
public class ManageProductsController {
	
	@Autowired
	private ProductServiceImpl productServiceImpl;
	
	@RequestMapping(value = "/newProduct", method = RequestMethod.GET)
	public String addProductGetMethod(@ModelAttribute("product") ManageProductsControllerBean bean, Model model) {
		List<String> categoryList = productServiceImpl.getCatogories();
		model.addAttribute("categoryList", categoryList);
		return "newproduct";
		
	}
	
	@RequestMapping(value = "/newProduct/{id}", method = RequestMethod.GET)
	public String getProductByIdGetMethod(@PathVariable("id") int id,Model model,ManageProductsControllerBean bean) {
		bean = productServiceImpl.getProductsById(id);
		model.addAttribute("editproduct", bean);
		return "newproduct";
		
	}
	
	@RequestMapping(value = "/newProduct", method = RequestMethod.POST)
	public String postProduct(Model model,ManageProductsControllerBean	bean,HttpServletRequest request) {
		List<String> categoryList = productServiceImpl.getCatogories();
		model.addAttribute("categoryList", categoryList);
		return "newproduct";
		
	}
	
 	@RequestMapping(value = "/saveProduct", method = RequestMethod.GET)
	public String addProductsgetMethod(Model model,ManageProductsControllerBean bean) {
		List<ManageProductsControllerBean> beanList = productServiceImpl.getAllProducts();
		model.addAttribute("productList", beanList);
		System.out.println("Inside ProductController"+bean);
		return "manageproducts";
		
	}
	
	@RequestMapping(value = "/saveProduct/{id}", method = RequestMethod.GET)
	public String updateProductGetMethod(@PathVariable("id") int id,Model model,ManageProductsControllerBean bean) {
		List<ManageProductsControllerBean> beanList = productServiceImpl.getAllProducts();
		model.addAttribute("productList", beanList);
		return "manageproducts";
		
	}
	
	@RequestMapping(value = "/saveProduct", method = RequestMethod.POST)
	public String addProductsPostMethod(@Valid Model model,ManageProductsControllerBean bean,BindingResult result) {
		productServiceImpl.addProducts(bean);
		List<ManageProductsControllerBean> beanList = productServiceImpl.getAllProducts();
		model.addAttribute("productList", beanList);
		return "manageproducts";
		
	}
	
	@RequestMapping(value = "/saveProduct/{id}", method = RequestMethod.POST)
	public String updateProductPostMethod(@PathVariable("id") int id,Model model,ManageProductsControllerBean bean) {
		productServiceImpl.updateProduct(bean,id);
		List<ManageProductsControllerBean> beanList = productServiceImpl.getAllProducts();
		model.addAttribute("productList", beanList);
		return "manageproducts";
		
	}
	
	@RequestMapping(value = "/deleteProduct/{id}", method = RequestMethod.GET)
	public String deleteProductGetMethod(@PathVariable("id") int id,Model model,ManageProductsControllerBean bean) {
		productServiceImpl.deleteProduct(id);
		List<ManageProductsControllerBean> beanList = productServiceImpl.getAllProducts();
		model.addAttribute("productList", beanList);
		return "manageproducts";
		
	}
		
	@RequestMapping(value = "/deleteProduct/{id}", method = RequestMethod.POST)
	public String deleteProductPostMethod(@PathVariable("id") int id,Model model,ManageProductsControllerBean bean) {
		productServiceImpl.updateProduct(bean,id);
		List<ManageProductsControllerBean> beanList = productServiceImpl.getAllProducts();
		model.addAttribute("productList", beanList);
		return "manageproducts";
		
	}

}
