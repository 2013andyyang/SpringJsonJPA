package com.springformmvc;

import java.util.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import model.*;

@Controller
@RequestMapping("/")
public class SupplierCoffeeController {
	List<Coffee> coffees = new ArrayList<>();

	@RequestMapping(value = "/supplier", method = RequestMethod.GET)
	public String getSupplierView() {
		return "Supplier";
	}

	@RequestMapping(value = "/addSupplier", method = RequestMethod.POST)
	public ModelAndView addSupplier(@RequestBody Supplier sup, ModelMap map) {
		map.addAttribute("sups", sup);
		return new ModelAndView("ShowSupplier");

	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String getFirstView() {
		return "Home";
	}

	@RequestMapping(value = "/addOrder", method = RequestMethod.POST)
	public ModelAndView addOrder(@RequestBody Coffee cof, ModelMap map) {
		Supplier sup = cof.getSupplier();
		coffees.add(cof);
		map.addAttribute("coffees", coffees);
		map.addAttribute("sups", sup);
		return new ModelAndView("ShowCoffee");

	}
}
