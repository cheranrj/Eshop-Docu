package com.karthi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "lorder_items")
public class LOrderItem {
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "order_id")
	private LOrder lorder;

	@Column(name = "quantity")
	private Integer quantity;


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "lap_id")
	private Laptop laptop;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public LOrder getLorder() {
		return lorder;
	}


	public void setLorder(LOrder lorder) {
		this.lorder = lorder;
	}


	public Integer getQuantity() {
		return quantity;
	}


	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}


	public Laptop getLaptop() {
		return laptop;
	}


	public void setLaptop(Laptop laptop) {
		this.laptop = laptop;
	}


	@Override
	public String toString() {
		return "LOrderItem [id=" + id + ", lorder=" + lorder + ", quantity=" + quantity + ", laptop=" + laptop + "]";
	}
	
	
}
