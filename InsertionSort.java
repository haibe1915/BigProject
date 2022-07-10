package allAlgo;

import java.util.Collections;
import java.util.List;

public class InsertionSort extends Algorithm {

	public InsertionSort(List<Integer> nums) {
		super(nums);
	}

	@Override
	public void sort() {
		for(int i=1;i<numSize;i++) {
			int key=numbers.get(i);
			int j=i-1;
			updateView(sub, j+1, i, -1);
			
			while(j>=0 && numbers.get(j)>key)
			{
				Collections.swap(numbers, j, j+1);
				j--;
				updateView(sub, j+1, i, -1);
			}
		}
	}

}
