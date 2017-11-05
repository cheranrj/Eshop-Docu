package com.karthi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.karthi.Repository.MobileRepository;
import com.karthi.model.Mobile;

@Service
public class MobileService {
	
	@Autowired
	private MobileRepository mobileRepository;

	public List<Mobile> findByPriceDesc() {

		return mobileRepository.findByOrderByPriceDesc();
	}

	public List<Mobile> findByPriceAsc() {

		return mobileRepository.findByOrderByPriceAsc();
	}

	public List<Mobile> findByReleasedDateDesc() {

		return mobileRepository.findByOrderByReleasedDateDesc();
	}

	public List<Mobile> findAll() {

		return mobileRepository.findAll();
	}

	public Mobile findOne(Long id) {

		return mobileRepository.findOne(id);
	}

}
