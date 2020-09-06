package com.example.portfolio;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.sortingalgoriths.*;

@Controller
public class NavigationController {
	
	private Sorter newSorter;
	
	@GetMapping("/sortingAlgorithms")
	public String showSortingAlgorithms(boolean refresh, Model model) {
		
		newSorter = Sorter.getInstance();
		model.addAttribute("algoContainer", new AlgorithmContainer());
			
		if(refresh)
		{
			// Generate a new list of bars with random values (heights)
			newSorter.refreshChart();
		}
		
		model.addAttribute("bars", newSorter.getBars());
		
		return "sorting";
	}
	
	@PostMapping("/sortingAlgorithms")
	public String startSorting(@ModelAttribute("algoContainer") AlgorithmContainer algoContainer, Model model)
	{
		newSorter = Sorter.getInstance();
		
		if(algoContainer != null)
		{
			// Sorts based on the chosen sorting method
			switch(algoContainer.getAlgoEnum())
			{
			case BUBBLE: 
				newSorter.bubbleSort();	
				break;
				
			case MERGE:
				
				break;
				
			case QUICK:
				
				break;
				
			default:
				// DO NOTHING
				break;
			}
		}
		model.addAttribute("bars", newSorter.getBars());
		
		return "sorting";
	}
	
	@GetMapping("/error")
	public String showErrorMessage() {
		
		return "error";
	}
	
}
