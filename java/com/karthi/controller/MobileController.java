package com.karthi.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.karthi.model.Book;
import com.karthi.model.Mobile;
import com.karthi.service.MobileService;

@Controller
@RequestMapping("mobile")
public class MobileController {
	
	private static final Logger LOGGER = Logger.getLogger(MobileController.class);
	
	@Autowired
	private MobileService mobileService;

	@GetMapping
	public String  list(@RequestParam(value = "price", required = false) String priceFilter,
			@RequestParam(value = "releasedDate", required = false) String releasedDateFilter, HttpSession session) {

		LOGGER.info("List of Mobiles");

		List<Mobile> mobiles = null;

		if (priceFilter != null) {
			if (priceFilter.equals("desc")) {
				mobiles = mobileService.findByPriceDesc();
			} else if (priceFilter.equals("asc")) {
				mobiles = mobileService.findByPriceAsc();
			}
		} else if (releasedDateFilter != null) {
			if (releasedDateFilter.equals("desc")) {
				mobiles = mobileService.findByReleasedDateDesc();
			}
		} else {
			mobiles = mobileService.findAll();
			
		}
		System.out.println(mobiles);
		session.setAttribute("mobiles", mobiles);
		return "mobile/list";

	}
	
	@GetMapping("/{id}")
	public String viewDetials(@PathVariable("id") Long id, HttpSession session, ModelMap modelMap) {
		Mobile mobile = mobileService.findOne(id);
		modelMap.addAttribute("SELECTED_Mobile", mobile);
		// session.setAttribute("SELECTED_BOOK", id);
		return "mobile/show";
	}

}
