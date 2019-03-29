package com.project.oshop.service;

import java.util.List;

import com.project.oshop.bean.ManageProductsControllerBean;

public interface IProductService {
	
	public void addProducts(ManageProductsControllerBean bean);
	
	public List<ManageProductsControllerBean> getAllProducts();
	
	public List<ManageProductsControllerBean> getProductsByCategory(String category);
	
	public ManageProductsControllerBean getProductsById(int id);
	
	public void updateProduct(ManageProductsControllerBean bean,int id);
	
	public void deleteProduct(int id);
	
	public List<String> getCatogories();
	

}
