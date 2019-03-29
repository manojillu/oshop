package com.project.oshop.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.project.oshop.bean.ManageProductsControllerBean;
import com.project.oshop.data.CategoryData;
import com.project.oshop.data.ProductData;

@Component
@Repository
public class ProductDAOImpl implements IProductDAO{
	
	public ProductDAOImpl() {}
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private List<ManageProductsControllerBean> productList = null;
	private List<ProductData> productDataList=null;
	private List<CategoryData> categoryDataList = null;

	
	public void addProducts(ManageProductsControllerBean bean) {
		try {
			Session currentSession= sessionFactory.getCurrentSession();
			ProductData data = new ProductData(bean.getTitle(),bean.getPrice(),bean.getCategory(),bean.getImageUrl());
			currentSession.saveOrUpdate(data);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void updateProduct(ManageProductsControllerBean bean,int id) {
		try {
			Session session= this.sessionFactory.getCurrentSession();
			ProductData editedProduct = session.get(ProductData.class, bean.getId());
			editedProduct.setTitle(bean.getTitle());
			editedProduct.setPrice(bean.getPrice());
			editedProduct.setCategory(bean.getCategory());
			editedProduct.setImageUrl(bean.getImageUrl());
			session.saveOrUpdate(editedProduct);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	public void deleteProduct(int id) {
		try {
			Session session= this.sessionFactory.getCurrentSession();
			ProductData data = session.get(ProductData.class, id);
			session.delete(data);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}

	@SuppressWarnings("unchecked")
	public List<ManageProductsControllerBean> getAllProducts() {
		Session session= this.sessionFactory.getCurrentSession();
		Query<ProductData> query = session.getNamedQuery("getAllProducts");
		productDataList = query.list();
		if(productDataList != null && !productDataList.isEmpty() ) {
			productList = new ArrayList<ManageProductsControllerBean>();
			 for(ProductData data:productDataList) {
				 ManageProductsControllerBean bean = new ManageProductsControllerBean();
				 bean.setId(data.getId());
				 bean.setTitle(data.getTitle());
				 bean.setPrice(data.getPrice());
				 bean.setCategory(data.getCategory());
				 bean.setImageUrl(data.getImageUrl());
				 this.productList.add(bean);
			 }
		}
		
		return productList;
	}
	
	@SuppressWarnings("unchecked")
	public List<ManageProductsControllerBean> getProductsByCategory(String category) {
		List<ManageProductsControllerBean> productList = null;
		Session session= this.sessionFactory.getCurrentSession();
		Query<ProductData> query = session.getNamedQuery("getProductByCategory");
		query.setParameter("category", category);
		productDataList = query.list();
		if(productDataList != null && !productDataList.isEmpty() ) {
			productList = new ArrayList<ManageProductsControllerBean>();
			 for(ProductData data:productDataList) {
				 ManageProductsControllerBean bean = new ManageProductsControllerBean();
				 bean.setId(data.getId());
				 bean.setTitle(data.getTitle());
				 bean.setPrice(data.getPrice());
				 bean.setCategory(data.getCategory());
				 bean.setImageUrl(data.getImageUrl());
				 productList.add(bean);
			 }
		}
		
		return productList;
	}

	
	@SuppressWarnings("unchecked")
	public ManageProductsControllerBean getProductsById(int id) {
		Session session= this.sessionFactory.getCurrentSession();
		ManageProductsControllerBean bean = new ManageProductsControllerBean();
		Query<ProductData> query = session.getNamedQuery("getProductById");
		query.setParameter("id", id);
		productDataList = query.list();
		if(productDataList != null && !productDataList.isEmpty() ) {
			ProductData data=productDataList.get(0);
			 bean.setId(data.getId());
			 bean.setTitle(data.getTitle());
			 bean.setPrice(data.getPrice());
			 bean.setCategory(data.getCategory());
			 bean.setImageUrl(data.getImageUrl());
		}
		return bean;
	}
	
	@SuppressWarnings("unchecked")
	public List<String> getCatogories() {
		Session session= this.sessionFactory.getCurrentSession();
		List<String> categoryList = null;
		Query<CategoryData> query = session.getNamedQuery("getAllCategories");
		categoryDataList = query.list();
		if(categoryDataList != null && !categoryDataList.isEmpty() ) {
			categoryList = new ArrayList<String>();
			 for(CategoryData data:categoryDataList) {
				 categoryList.add(data.getName());
			 }
		}
		return categoryList;
	}

}
