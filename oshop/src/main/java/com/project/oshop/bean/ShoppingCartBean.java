package com.project.oshop.bean;

import java.io.Serializable;
import java.math.BigDecimal;

import com.project.oshop.data.ProductData;

public class ShoppingCartBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ShoppingCartBean() {
	}

	public ShoppingCartBean(long quantity, String userName, BigDecimal price, ProductData productData, int id,
			String title, String category, String imageUrl) {
		super();
		this.quantity = quantity;
		this.userName = userName;
		this.price = price;
		this.productData = productData;
		this.id = id;
		this.title = title;
		this.category = category;
		this.imageUrl = imageUrl;
	}

	private long quantity;
	private String userName;
	private BigDecimal price;
	private ProductData productData;
	private int id;
	private String title;
	private String category;
	private String imageUrl;

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public ProductData getProductData() {
		return productData;
	}

	public void setProductData(ProductData productData) {
		this.productData = productData;
	}

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

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

}
