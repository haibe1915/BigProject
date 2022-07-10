package allAlgo;

import java.util.Collections;
import java.util.List;



public class QuickSort extends Algorithm {

	public QuickSort(List<Integer> nums) {
		super(nums);
	}

	@Override
	public void sort() {
		quickSort(0,numSize-1);
	}
	
	private void quickSort(int low,int high) {
		if(low>=high)
			return;
		
		int pivot=partition(low,high);
		quickSort(low,pivot);
		quickSort(pivot+1,high);
	}
	
	private int partition(int low,int high) {
		int pivot=low;
		for(int i=low+1;i<=high;i++) {
			if(numbers.get(i)<numbers.get(low))
				Collections.swap(numbers, ++pivot, i);
			updateView(sub,i,low,pivot);
		}
		Collections.swap(numbers, pivot, low);
		updateView(sub,-1,pivot,-1);
		
		return pivot;
	}

}
