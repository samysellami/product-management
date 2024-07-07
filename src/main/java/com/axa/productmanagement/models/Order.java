package com.axa.productmanagement.models;

import java.util.HashSet;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "`order`") // Escaping the table name with backticks
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) // Ignore these properties
public class Order {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String status;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "`user`")
	private User user;

	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Product> products = new HashSet<>();

	public Order() {}
    public Order(String status){
		this.status = status;
    }

	public Long getId() {
	  return id;
	}

	public String getStatus() {
	  return status;
	}

	public Set<Product> getProducts() {
	  return products;
	}

	public User getUser() {
	  return user;
	}

	public void setId(Long id) {
	  this.id = id;
	}

	public void setStatus(String status) {
	  this.status = status;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setProducts(Set<Product> products) {
	  this.products = products;
	}
	
	public void addProduct(Product product) {
		products.add(product);
		product.setOrder(this);
	}

	public void removeProduct(Product product) {
		products.remove(product);
		product.setOrder(null);
	}   


}
