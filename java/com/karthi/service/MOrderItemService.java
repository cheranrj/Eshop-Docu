package com.karthi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.karthi.Repository.MOrderItemRepository;
import com.karthi.model.MOrderItem;

@Service
public class MOrderItemService {

	
	@Autowired
	private MOrderItemRepository morderItemRepository;

	public void save(MOrderItem morderItem) {
		morderItemRepository.save(morderItem);
	}
}
