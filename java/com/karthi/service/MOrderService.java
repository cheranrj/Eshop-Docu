package com.karthi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.karthi.Repository.MOrderRepository;
import com.karthi.model.MOrder;
import com.karthi.model.Order;

@Service
public class MOrderService {
	
	@Autowired
	private MOrderRepository morderRepository;

	public List<MOrder> findAllOrders() {
		// TODO Auto-generated method stub
		return morderRepository.findAll();
	}

	public void save(MOrder morder) {
		morderRepository.save(morder);

	}

	public MOrder findOne(Long id) {
		return morderRepository.findOne(id);
	}
	
	public List<MOrder> findByUserIdOrderByIdDesc(Long userId) {
		return morderRepository.findByUserIdOrderByIdDesc(userId);
	}

	public List<MOrder> findByUserId(Long id) {

		return morderRepository.findByUserIdOrderByIdDesc(id);
	}

	

}
