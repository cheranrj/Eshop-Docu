package com.karthi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.karthi.model.LOrderItem;

public interface LOrderItemRepository  extends JpaRepository<LOrderItem, Long> {

}
