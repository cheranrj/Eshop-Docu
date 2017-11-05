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
@Table(name = "morder_items")
public class MOrderItem {
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "order_id")
	private MOrder morder;

	@Column(name = "quantity")
	private Integer quantity;

	/*@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "book_id")
	private Book book;*/

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "mobile_id")
	private Mobile mobile;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public MOrder getMorder() {
		return morder;
	}

	public void setMorder(MOrder morder) {
		this.morder = morder;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Mobile getMobile() {
		return mobile;
	}

	public void setMobile(Mobile mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "MOrderItem [id=" + id + ", morder=" + morder + ", quantity=" + quantity + ", mobile=" + mobile + "]";
	}

	
	
	
	
	/*@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "lap_id")
	private Laptop lap;*/




}
