package com.example.portfolio;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.sortingalgoriths.Bar;

@Controller
public class NavigationController {
	
	private Bar bars[] = new Bar[100];
	
	@RequestMapping(value = "/sortingAlgorithms", method = { RequestMethod.GET, RequestMethod.POST })
	public String showSortingAlgorithms(boolean refresh, boolean sort, @RequestParam(name="type", required=false, defaultValue="quick") String type, Model model) {
		model.addAttribute("type", type);
		
		// Generate a new list of bars with random values (heights)
		if(refresh)
		{
			System.out.println(refresh);
			
			for(int i = 0; i < bars.length; i++) {
				bars[i] = new Bar();
				bars[i].generateRandomValue(1, 300);
			}
			
			model.addAttribute("bars", bars);
			
			
		}
		
		// Needs to be the real sorting algorithm, now it's only changing the first and the last element at random.
		if(sort)
		{
			model.addAttribute("type", type);
			
			bars[0] = new Bar();
			bars[0].generateRandomValue(1, 300);
			
			bars[99] = new Bar();
			bars[99].generateRandomValue(1, 300);
			
			model.addAttribute("bars", bars);
		}
		
		return "sorting";
	}
	
	@GetMapping("/error")
	public String showErrorMessage() {
		
		return "error";
	}
	
}
