package com.karthi.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.karthi.model.Mobile;

public interface MobileRepository  extends JpaRepository<Mobile, Long> {
	
	public List<Mobile> findByOrderByPriceDesc();

	public List<Mobile> findByOrderByPriceAsc();

	public List<Mobile> findByOrderByReleasedDateDesc();

}
