package net.javaguides.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import javax.persistence.ForeignKey;

@Entity
@Table(name = "products")

public class Products {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "productname", nullable = false, length=255)
	private String productname;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "categoryid", nullable = false, foreignKey = @ForeignKey(name = "fk_product_category"))
	private Category categoryid;

	@Column(name = "avatar",nullable = false, length=255)
	private String avatar;
	
	@Column(name = "trash",nullable = true)
	private Integer trash;

	@Column(name = "status",nullable = true)
	private Integer status;

	
	public Products() {
		
	}

	
	
	public Products(String productname, Category categoryid, String avatar, Integer trash, Integer status) {
		this.productname = productname;
		this.categoryid = categoryid;
		this.avatar = avatar;
		this.trash = trash;
		this.status = status;
	}



	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getProductname() {
		return productname;
	}


	public void setProductname(String productname) {
		this.productname = productname;
	}


	public Category getCategoryid() {
		return categoryid;
	}


	public void setCategoryid(Category categoryid) {
		this.categoryid = categoryid;
	}


	public String getAvatar() {
		return avatar;
	}


	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}


	public Integer getTrash() {
		return trash;
	}


	public void setTrash(Integer trash) {
		this.trash = trash;
	}


	public Integer getStatus() {
		return status;
	}


	public void setStatus(Integer status) {
		this.status = status;
	}


	
}
