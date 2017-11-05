package com.karthi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.karthi.model.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
