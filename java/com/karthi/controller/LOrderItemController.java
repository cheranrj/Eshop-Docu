package com.karthi.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.karthi.model.LOrder;
import com.karthi.model.LOrderItem;
import com.karthi.model.Laptop;

import com.karthi.model.User;
import com.karthi.service.LaptopService;

@Controller
@RequestMapping("lorderItems")
public class LOrderItemController {
	
	private static final Logger LOGGER = Logger.getLogger(LOrderItemController.class);
	
	@Autowired
	LaptopService laptopService;
	
	
	@PostMapping("/laddToCart")

	public String laddToCart(@RequestParam("laptop_id") Long laptopId, @RequestParam("mqty") Integer qty,
			HttpSession session) {

		User user = (User) session.getAttribute("LOGGED_IN_USER");

		LOrder lorder = (LOrder) session.getAttribute("MY_CART_ITEMS");

		// create order
		if (lorder == null) {
			System.out.println("creating order");
			lorder = new LOrder();
			
			LOGGER.info("in l");

			lorder.setUser(user);
			lorder.setTotalPrice(0);
			lorder.setStatus("ORDERED");
		}

		// store orderItems

		List<LOrderItem> lorderItems = lorder.getOrderItems();

		LOGGER.info("in lll");
		// If already the item is added to cart, then add the quantity

		boolean ifItemExists = false;
		for (LOrderItem item : lorderItems) {

			if (item.getLaptop().getId().equals(laptopId)) {
				System.out.println("Adding the quantity");
				int totalQuantity = item.getQuantity() + qty;
				item.setQuantity(totalQuantity);
				ifItemExists = true;
			}
		}

		// If item not exists, create new Item
		if (!ifItemExists) {

			System.out.println("Creating new Item");
			LOrderItem orderItem = new LOrderItem();
			orderItem.setLorder(lorder);   
			
			System.out.println(laptopId);

			Laptop laptop = laptopService.findOne(laptopId);

			orderItem.setLaptop(laptop);
			orderItem.setQuantity(qty);
			lorderItems.add(orderItem);
			LOGGER.info("came");
		}


		lorder.setOrderItems(lorderItems);
		
		LOGGER.info("cameee1");
		
		
		
		LOGGER.info("cameee2");

		session.setAttribute("MY_CART_ITEMS", lorder);
		LOGGER.info("cameee3");

		return "redirect:../lorders/lcart";
	}
	
	
	@GetMapping("/lremove")
	public String mremoveItemFromCart(@RequestParam("id") Integer id, HttpSession session) {

		System.out.println("Item Removed from Card:" + id);
		LOrder lorder = (LOrder) session.getAttribute("MY_CART_ITEMS");

		if (lorder != null && lorder.getOrderItems().size() > 0) {
			List<LOrderItem> lorderItems = lorder.getOrderItems();
			LOrderItem itemSelected = lorderItems.get(id);
			lorderItems.remove(itemSelected);
			lorder.setOrderItems(lorderItems);
			session.setAttribute("MY_CART_ITEMS", lorder);
		}

		return "redirect:../lorders/lcart";

	}

}
