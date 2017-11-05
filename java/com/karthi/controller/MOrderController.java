package com.karthi.controller;

import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.karthi.model.MOrder;

import com.karthi.model.User;
import com.karthi.service.MOrderService;
import com.karthi.service.UserService;

@Controller
@RequestMapping("morders")
public class MOrderController {
	
	@Autowired
	private MOrderService morderService;
	
	@Autowired
	UserService userService;
	
	@GetMapping("/m")
	public String mlists(ModelMap modelMap, HttpSession session) {

		List<MOrder> list = morderService.findAllOrders();
		System.out.println("orders:" + list.size());
		for (MOrder morder : list) {
			System.out.println(morder);
		}

		modelMap.addAttribute("ORDERS_LIST", list);

		return "order/mlist";

	}
	
	@GetMapping("/mcart")
	public String mcart() {

		return "order/mcart";
	}
	
	
	@PostMapping("/msave")
	public String msave(@RequestParam("total_amount") Integer tamnt, @RequestParam("paymentmode") String payamnt,
			HttpSession session) {
		MOrder orderCart = (MOrder) session.getAttribute("MY_CART_ITEMS");
		User user = userService.findByEmail((String) session.getAttribute("logid"));

		if (orderCart != null && orderCart.getOrderItems().size() > 0) {

			System.out.println("user details" + user);

			orderCart.setUser(user);
			orderCart.setTotalPrice(tamnt);
			orderCart.setPaymentmode(payamnt);

			morderService.save(orderCart);
			session.removeAttribute("MY_CART_ITEMS");

		}
		return "redirect:../morders/mmyorders";

	}

	@GetMapping("/mmyorders")
	public String mlist(ModelMap modelMap, HttpSession session) {
		User user = userService.findByEmail((String) session.getAttribute("logid"));
		Long id = user.getId();
		
		System.out.println(id);
		List<MOrder> list = morderService.findByUserId(id);
		System.out.println("orders:" + list.size());
		for (MOrder order : list) {
			System.out.println(order);

		}
		modelMap.addAttribute("ORDERS_LIST", list);
		return "order/mlist";

	}

	@GetMapping("/mupdateStatus")
	public String mupdateStatus(@RequestParam("id") Long orderId, @RequestParam("status") String status) {
		MOrder morder = morderService.findOne(orderId);
		if ("CANCELLED".equals(status)) {
			morder.setCancelledDate(LocalDateTime.now());
		} else if ("DELIVERED".equals(status)) {
			morder.setDeliveredDate(LocalDateTime.now());
		}

		morder.setStatus(status);
		morderService.save(morder);
		return "redirect:../morders/m";
	}


}
