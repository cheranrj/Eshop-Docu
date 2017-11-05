package com.karthi.controller;

import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.karthi.model.LOrder;

import com.karthi.model.User;
import com.karthi.service.LOrderService;
import com.karthi.service.UserService;

@Controller
@RequestMapping("lorders")
public class LOrderController {
	
	@Autowired
	private LOrderService lorderService;
	
	@Autowired
	UserService userService;
	
	private static final Logger LOGGER = Logger.getLogger(LOrderController.class);
	
	
	@GetMapping("/l")
	public String llists(ModelMap modelMap, HttpSession session) {

		List<LOrder> list = lorderService.findAllOrders();
		/*System.out.println("orders:" + list.size());
		for (LOrder lorder : list) {
			System.out.println(lorder);
		}*/

		modelMap.addAttribute("ORDERS_LIST", list);

		return "order/llist";

	}
	
	@GetMapping("/lcart")
	public String lcart() {

		return "order/lcart";
	}
	
	
	@PostMapping("/lsave")
	public String msave(@RequestParam("total_amount") Integer tamnt, @RequestParam("paymentmode") String payamnt,
			HttpSession session) {
		LOrder orderCart = (LOrder) session.getAttribute("MY_CART_ITEMS");
		User user = userService.findByEmail((String) session.getAttribute("logid"));

		if (orderCart != null && orderCart.getOrderItems().size() > 0) {

			System.out.println("user details" + user);

			orderCart.setUser(user);
			orderCart.setTotalPrice(tamnt);
			orderCart.setPaymentmode(payamnt);

			lorderService.save(orderCart);
			session.removeAttribute("MY_CART_ITEMS");

		}
		return "redirect:../lorders/lmyorders";

	}

	@GetMapping("/lmyorders")
	public String llist(ModelMap modelMap, HttpSession session) {
		User user = userService.findByEmail((String) session.getAttribute("logid"));
		Long id = user.getId();
		List<LOrder> list = lorderService.findByUserId(id);
		LOGGER.info("inn");
		/*System.out.println("orders:" + list.size());*/
		/*for (LOrder lorder : list) {
			System.out.println(lorder);

		}*/
		LOGGER.info("inn2");
		modelMap.addAttribute("ORDERS_LIST", list);
		return "order/llist";

	}

	@GetMapping("/lupdateStatus")
	public String lupdateStatus(@RequestParam("id") Long orderId, @RequestParam("status") String status) {
		LOrder lorder = lorderService.findOne(orderId);
		if ("CANCELLED".equals(status)) {
			lorder.setCancelledDate(LocalDateTime.now());
		} else if ("DELIVERED".equals(status)) {
			lorder.setDeliveredDate(LocalDateTime.now());
		}

		lorder.setStatus(status);
		lorderService.save(lorder);
		return "redirect:../lorders/l";
	}

}
