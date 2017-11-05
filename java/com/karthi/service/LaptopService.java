package com.karthi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.karthi.Repository.LaptopRepository;
import com.karthi.model.Book;
import com.karthi.model.Laptop;

@Service
public class LaptopService {

	@Autowired
	private LaptopRepository laptopRepository;
	
	public List<Laptop> findByPriceDesc() {

		return laptopRepository.findByOrderByPriceDesc();
	}

	public List<Laptop> findByPriceAsc() {

		return laptopRepository.findByOrderByPriceAsc();
	}

	public List<Laptop> findByReleasedDateDesc() {

		return laptopRepository.findByOrderByReleasedDateDesc();
	}

	public List<Laptop> findAll() {

		return laptopRepository.findAll();
	}

	public Laptop findOne(Long id) {

		return laptopRepository.findOne(id);
	}
}
