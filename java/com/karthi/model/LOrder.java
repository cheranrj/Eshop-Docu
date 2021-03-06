package com.karthi.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "lorders")
public class LOrder {
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@Column(name = "total_price")
	private Integer totalPrice;

	@Column(name = "status")
	private String status;

	@Column(name = "paymentmode")
	private String paymentmode;

	@OneToMany(mappedBy = "lorder", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<LOrderItem> orderItems = new ArrayList<>();

	@Column(name = "ordered_date")
	private LocalDateTime orderedDate;

	@Column(name = "cancelled_date")
	private LocalDateTime cancelledDate;

	@Column(name = "delivered_date")
	private LocalDateTime deliveredDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPaymentmode() {
		return paymentmode;
	}

	public void setPaymentmode(String paymentmode) {
		this.paymentmode = paymentmode;
	}

	

	public List<LOrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<LOrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public LocalDateTime getOrderedDate() {
		return orderedDate;
	}

	public void setOrderedDate(LocalDateTime orderedDate) {
		this.orderedDate = orderedDate;
	}

	public LocalDateTime getCancelledDate() {
		return cancelledDate;
	}

	public void setCancelledDate(LocalDateTime cancelledDate) {
		this.cancelledDate = cancelledDate;
	}

	public LocalDateTime getDeliveredDate() {
		return deliveredDate;
	}

	public void setDeliveredDate(LocalDateTime deliveredDate) {
		this.deliveredDate = deliveredDate;
	}

	@Override
	public String toString() {
		return "LOrder [id=" + id + ", user=" + user + ", totalPrice=" + totalPrice + ", status=" + status
				+ ", paymentmode=" + paymentmode + ", orderItems=" + orderItems + ", orderedDate=" + orderedDate
				+ ", cancelledDate=" + cancelledDate + ", deliveredDate=" + deliveredDate + "]";
	}

	
	
	

}
