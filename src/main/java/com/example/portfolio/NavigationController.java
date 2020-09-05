package com.example.portfolio;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.sortingalgoriths.*;

@Controller
public class NavigationController {
	
	private Sorter newSorter;
	
	@RequestMapping(value = "/sortingAlgorithms", method = { RequestMethod.GET, RequestMethod.POST })
	public String showSortingAlgorithms(boolean refresh, boolean sort, @RequestParam(name="type", required=false, defaultValue="quick") String type, Model model) {
		model.addAttribute("type", type);
		
		newSorter = Sorter.getInstance();
		
		if(refresh)
		{
			// Generate a new list of bars with random values (heights)
			newSorter.refreshChart();
		}
		
		// Sorts based on the chosen sorting method
		if(sort)
		{	
			newSorter.bubbleSort();	
		}
		
		model.addAttribute("bars", newSorter.getBars());
		
		return "sorting";
	}
	
	@GetMapping("/error")
	public String showErrorMessage() {
		
		return "error";
	}
	
}
