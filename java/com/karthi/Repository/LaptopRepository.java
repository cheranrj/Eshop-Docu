package com.karthi.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.karthi.model.Laptop;

public interface LaptopRepository extends JpaRepository<Laptop, Long> {

	public List<Laptop> findByOrderByPriceDesc();

	public List<Laptop> findByOrderByPriceAsc();

	public List<Laptop> findByOrderByReleasedDateDesc();

}
