package com.karthi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.karthi.Repository.LOrderRepository;
import com.karthi.model.LOrder;

@Service
public class LOrderService {
	
	@Autowired
	private LOrderRepository lorderRepository;

	public List<LOrder> findAllOrders() {
		// TODO Auto-generated method stub
		return lorderRepository.findAll();
	}

	public void save(LOrder lorder) {
		lorderRepository.save(lorder);

	}

	public LOrder findOne(Long id) {
		return lorderRepository.findOne(id);
	}
	
	public List<LOrder> findByUserIdOrderByIdDesc(Long userId) {
		return lorderRepository.findByUserIdOrderByIdDesc(userId);
	}

	public List<LOrder> findByUserId(Long id) {

		return lorderRepository.findByUserIdOrderByIdDesc(id);
	}

}
