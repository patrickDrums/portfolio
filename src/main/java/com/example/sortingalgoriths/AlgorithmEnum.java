package com.example.sortingalgoriths;

public enum AlgorithmEnum {

    QUICK("Quick sort"),
    MERGE("Merge sort"),
    BUBBLE("Bubble sort");
    
    private String description;
	
	private AlgorithmEnum(String description)
	{
		this.description = description; 
	}

	public String getDescription() {
		return description;
	}
}
