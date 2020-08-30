package com.example.sortingalgoriths;

import java.util.Random;

public class Bar {
	
	private int value;
	
	public Bar() {
		value = 0;
	}

	public int getValue() {
		return value;
	}

	public void generateRandomValue(int low, int high)
	{	
		Random r = new Random();
		value = r.nextInt(100) + 1; 
	}
	
}
