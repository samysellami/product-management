package com.axa.productmanagement.models;

import java.util.HashSet;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "`user`") // Escaping the table name with backticks
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) // Ignore these properties
public class User {
 	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Embedded
	private Name name;
	private String email;
	private String password;


	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Order> orders = new HashSet<>();

	public User() {}

	public User(Name name, String email, String password) {
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public Name getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}


	public String getPassword() {
	  return password;
	}


	public Set<Order> getOrders() {
	  return orders;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
	  this.password = password;
	}

	public void setOrders(Set<Order> orders) {
	  this.orders = orders;
	}
	
	public void addOrder(Order order) {
		orders.add(order);
		order.setUser(this);
	}

	public void removeOrder(Order order) {
		orders.remove(order);
		order.setUser(null);
	}   
}
