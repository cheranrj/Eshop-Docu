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

import com.karthi.model.Laptop;
import com.karthi.model.Mobile;
import com.karthi.service.LaptopService;

@Controller
@RequestMapping("laptop")
public class LaptopController {
	
	private static final Logger LOGGER = Logger.getLogger(LaptopController.class);

	@Autowired
	private LaptopService laptopService;
	
	@GetMapping
	public String list(@RequestParam(value = "price", required = false) String priceFilter,
			@RequestParam(value = "releasedDate", required = false) String releasedDateFilter, HttpSession session) {

		LOGGER.info("List of Laptops");

		List<Laptop> laptop = null;

		if (priceFilter != null) {
			if (priceFilter.equals("desc")) {
				laptop = laptopService.findByPriceDesc();
			} else if (priceFilter.equals("asc")) {
				laptop = laptopService.findByPriceAsc();
			}
		} else if (releasedDateFilter != null) {
			if (releasedDateFilter.equals("desc")) {
				laptop = laptopService.findByReleasedDateDesc();
			}
		} else {
			laptop = laptopService.findAll();
			
		}
		System.out.println(laptop);
		session.setAttribute("laptop", laptop);
		return "laptop/list";

	}
	
	@GetMapping("/{id}")
	public String viewDetials(@PathVariable("id") Long id, HttpSession session, ModelMap modelMap) {
		Laptop laptop = laptopService.findOne(id);
		modelMap.addAttribute("SELECTED_Laptop", laptop);
		// session.setAttribute("SELECTED_BOOK", id);
		return "laptop/show";
	}
}
