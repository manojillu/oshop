package com.project.oshop.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class ManageProductsControllerBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ManageProductsControllerBean() {
	};

	public ManageProductsControllerBean(String title, BigDecimal price, String category, String imageUrl, long quantity,
			List<String> categoryList) {
		super();
		this.title = title;
		this.price = price;
		this.category = category;
		this.imageUrl = imageUrl;
		this.quantity = quantity;
		this.categoryList = categoryList;
	}

	private int id;
	private String title;
	private BigDecimal price;
	private String category;
	private String imageUrl;
	private long quantity;
	private List<String> categoryList;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public List<String> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(List<String> categoryList) {
		this.categoryList = categoryList;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

}
