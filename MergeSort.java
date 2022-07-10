package allAlgo;

import java.util.ArrayList;
import java.util.List;

public class MergeSort extends Algorithm {

	public MergeSort(List<Integer> nums) {
		super(nums);
	}

	@Override
	public void sort() {
		mergeSort(0,numSize-1);
	}

	private void mergeSort(int low, int high) {
		if(low>=high)
			return;
		
		int mid=low+(high-low)/2;
		mergeSort(low,mid);
		mergeSort(mid+1,high);
		merge(low,mid,high);
	}

	private void merge(int low, int mid, int high) {
		int lowStart=low;
		int lowEnd=mid;
		int highStart=mid+1;
		int highEnd=high;
		List<Integer> numsTemp=new ArrayList<Integer>();
		
		while(lowStart<=lowEnd && highStart<=highEnd) {
			if(numbers.get(lowStart)<numbers.get(highStart)) {
				numsTemp.add(numbers.get(lowStart));
				lowStart++;
			}
			else {
				numsTemp.add(numbers.get(highStart));
				highStart++;
			}
			updateView(sub, -1, lowStart, highStart);
		}
		
		while(lowStart<=lowEnd) {
			numsTemp.add(numbers.get(lowStart));
			lowStart++;
			updateView(sub, -1, lowStart, highStart);
		}
		
		while(highStart<=highEnd) {
			numsTemp.add(numbers.get(highStart));
			highStart++;
			updateView(sub, -1, lowStart, highStart);
		}
		
		for(int i=low;i<=high;i++) {
			numbers.set(i, numsTemp.get(i-low));
			updateView(sub, i, -1,-1);
		}
			
	}

}
