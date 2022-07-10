package allAlgo;

import java.util.Collections;
import java.util.List;

public class ShellSort extends Algorithm {

	public ShellSort(List<Integer> nums) {
		super(nums);
	}

	
	@Override
	public void sort() {
		for (int interval = numSize / 2; interval > 0; interval /= 2) {
			for(int i=interval;i<numSize;i++) {
				int key=numbers.get(i);
				int j=i-interval;	
				updateView(sub, j, i, -1);
				
				while(j>=0 && numbers.get(j)>key) {
					Collections.swap(numbers,j,j+interval);
					j-=interval;
					updateView(sub,j+interval,i,-1);
				}
			}
		}
	}
	

}
