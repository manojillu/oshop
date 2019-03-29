package com.project.oshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.oshop.bean.ManageProductsControllerBean;
import com.project.oshop.dao.ProductDAOImpl;

@Component
@Service
public class ProductServiceImpl implements IProductService{
	
	@Autowired
	private ProductDAOImpl productDAOImpl;

	@Transactional
	public void addProducts(ManageProductsControllerBean bean) {
		productDAOImpl.addProducts(bean);
		
	}
	
	@Transactional
	public void updateProduct(ManageProductsControllerBean bean,int id) {
		productDAOImpl.updateProduct(bean, id);
		
	}

	@Transactional
	public void deleteProduct(int id) {
		productDAOImpl.deleteProduct(id);
		
	}

	@Transactional
	public List<ManageProductsControllerBean> getAllProducts() {
		List<ManageProductsControllerBean> productList = productDAOImpl.getAllProducts();
		return productList;
	}
	
	@Transactional
	public List<ManageProductsControllerBean> getProductsByCategory(String category) {
		List<ManageProductsControllerBean> productList = productDAOImpl.getProductsByCategory(category);
		return productList;
	}

	@Transactional
	public ManageProductsControllerBean getProductsById(int id) {
		ManageProductsControllerBean bean= productDAOImpl.getProductsById(id);
		return bean;
	}

	@Transactional
	public List<String> getCatogories() {
		List<String> categoryList = productDAOImpl.getCatogories();
		return categoryList;
	}

}
