package com.project.oshop.data;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "products")
@NamedQueries({ @NamedQuery(name = "getAllProducts", query = "from ProductData"),
		@NamedQuery(name = "getProductById", query = "from ProductData where id = :id"),
		@NamedQuery(name = "getProductByCategory", query = "from ProductData where category = :category"), })
public class ProductData {

	public ProductData() {
	};

	public ProductData(String title, BigDecimal price, String category, String imageUrl) {
		super();
		this.title = title;
		this.price = price;
		this.category = category;
		this.imageUrl = imageUrl;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "title")
	private String title;
	@Column(name = "price")
	private BigDecimal price;
	@Column(name = "category")
	private String category;
	@Column(name = "imageurl")
	private String imageUrl;

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

	@Override
	public String toString() {
		return "id=" + id + ", name=" + title + ", country=" + price + ", category" + category + ", imageurl"
				+ imageUrl;
	}

}
