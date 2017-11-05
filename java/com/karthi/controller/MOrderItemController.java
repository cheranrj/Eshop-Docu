package com.karthi.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.karthi.model.MOrder;
import com.karthi.model.MOrderItem;
import com.karthi.model.Mobile;

import com.karthi.model.User;
import com.karthi.service.MobileService;

@Controller
@RequestMapping("morderItems")
public class MOrderItemController {
	
	@Autowired
	MobileService mobileService;
	
	
	@PostMapping("/maddToCart")

	public String maddToCart(@RequestParam("mobile_id") Long mobileId, @RequestParam("mqty") Integer qty,
			HttpSession session) {

		User user = (User) session.getAttribute("LOGGED_IN_USER");

		MOrder morder = (MOrder) session.getAttribute("MY_CART_ITEMS");

		// create order
		if (morder == null) {
			System.out.println("creating order");
			morder = new MOrder();

			morder.setUser(user);
			morder.setTotalPrice(0);
			morder.setStatus("ORDERED");
		}

		// store orderItems

		List<MOrderItem> morderItems = morder.getOrderItems();

		// If already the item is added to cart, then add the quantity

		boolean ifItemExists = false;
		for (MOrderItem item : morderItems) {

			if (item.getMobile().getId().equals(mobileId)) {
				System.out.println("Adding the quantity");
				int totalQuantity = item.getQuantity() + qty;
				item.setQuantity(totalQuantity);
				ifItemExists = true;
			}
		}

		// If item not exists, create new Item
		if (!ifItemExists) {

			System.out.println("Creating new Item");
			MOrderItem orderItem = new MOrderItem();
			orderItem.setMorder(morder);   

			Mobile mobile = mobileService.findOne(mobileId);

			orderItem.setMobile(mobile);
			orderItem.setQuantity(qty);
			morderItems.add(orderItem);
		}

		morder.setOrderItems(morderItems);

		session.setAttribute("MY_CART_ITEMS", morder);

		return "redirect:../morders/mcart";
	}
	
	
	@GetMapping("/mremove")
	public String mremoveItemFromCart(@RequestParam("id") Integer id, HttpSession session) {

		System.out.println("Item Removed from Card:" + id);
		MOrder morder = (MOrder) session.getAttribute("MY_CART_ITEMS");

		if (morder != null && morder.getOrderItems().size() > 0) {
			List<MOrderItem> morderItems = morder.getOrderItems();
			MOrderItem itemSelected = morderItems.get(id);
			morderItems.remove(itemSelected);
			morder.setOrderItems(morderItems);
			session.setAttribute("MY_CART_ITEMS", morder);
		}

		return "redirect:../morders/mcart";

	}

}
