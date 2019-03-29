package com.project.oshop.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="categories")
@NamedQueries({
    @NamedQuery(name = "getAllCategories", query = "from CategoryData"),
})
public class CategoryData {
	
	public CategoryData() {}
	
	
	
	public CategoryData(String name) {
		super();
		this.name = name;
	}



	@Id
	@Column(name="id")
	private int id;
	@Column(name="name")
	private String name;
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}
	
	

}
