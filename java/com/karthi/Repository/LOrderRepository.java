package com.karthi.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.karthi.model.LOrder;

public interface LOrderRepository extends JpaRepository<LOrder, Long>{

	List<LOrder> findByUserIdOrderByIdDesc(Long userId);

}
