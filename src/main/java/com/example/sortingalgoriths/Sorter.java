package com.example.sortingalgoriths;

public class Sorter {

	private static int amountOfBars = 100;
	private Bar bars[];

	
	private Sorter() {
		
		bars = new Bar[amountOfBars];
	}
	

	private static class SorterHolder {
        private static final Sorter INSTANCE = new Sorter();
    }

    public static Sorter getInstance() {
        return SorterHolder.INSTANCE;
    }
	
	public void refreshChart() {
						
		for(int i = 0; i < bars.length; i++) {
			bars[i] = new Bar();
			bars[i].generateRandomValue(1, 300);
		}
	}
	
	public void bubbleSort()
	{
		int outer, inner;
		
		for(outer = amountOfBars -1; outer > 1; outer--) {
			for(inner = 0; inner < outer; inner++) {
				if (bars[inner].getValue() > bars[inner + 1].getValue())
					swap(inner, outer);
			}
		}
	}
	
	private void swap(int one, int two)
	{
		Bar temp = bars[one];
		bars[one] = bars[two];
		bars[two] = temp;
	}
	
	public Bar[] getBars() {
		
		return bars;
	}
}
