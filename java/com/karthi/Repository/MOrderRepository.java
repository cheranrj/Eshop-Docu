package com.karthi.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.karthi.model.MOrder;

public interface MOrderRepository extends JpaRepository<MOrder, Long>{

	List<MOrder> findByUserIdOrderByIdDesc(Long userId);
	
	

}
