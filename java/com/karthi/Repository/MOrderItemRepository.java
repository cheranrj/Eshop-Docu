package com.karthi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.karthi.model.MOrderItem;

public interface MOrderItemRepository extends JpaRepository<MOrderItem, Long> {

}
