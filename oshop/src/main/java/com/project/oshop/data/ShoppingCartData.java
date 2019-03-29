package com.project.oshop.data;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "shoppingcart")
@NamedQueries({ @NamedQuery(name = "getAllShoppingCartData", query = "from ShoppingCartData"),
		@NamedQuery(name = "getShoppingCartDataByProductId", query = "from ShoppingCartData cart where cart.productData.id = :id"),
		@NamedQuery(name = "getQuantityCount", query = "select sum(quantity) from ShoppingCartData"), })
public class ShoppingCartData {

	public ShoppingCartData() {
	}

	public ShoppingCartData(long quantity, String userName, BigDecimal price, ProductData productData) {
		super();
		this.quantity = quantity;
		this.userName = userName;
		this.price = price;
		this.productData = productData;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "shoppingcart_id")
	private int id;
	@Column(name = "quantity")
	private long quantity;
	@Column(name = "username")
	private String userName;
	@Column(name = "price")
	private BigDecimal price;
	@OneToOne
	@JoinColumn(name = "id")
	private ProductData productData;

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

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

}
