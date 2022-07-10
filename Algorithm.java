package allAlgo;

import java.util.List;

import allAlgo.IPublisher;
import allAlgo.ISubscriber;


public abstract class Algorithm extends Thread implements IPublisher {
	protected List<Integer> numbers;
	protected int numSize;
	protected ISubscriber sub;
	
	public Algorithm(List<Integer> nums) {
		this.numbers = nums;
		this.numSize=nums.size();
	}

	@Override
	public void run() {
		sub.setViewControls(false);		
		sort();		
		sub.setViewControls(true);
	}
	
	public abstract void sort();
	
	@Override
	public void addSubscriber(ISubscriber sub) {
		this.sub=sub;
	}
	
	@Override
	public void updateView(ISubscriber sub,int red,int blue,int green) {
		sub.update(red,blue,green);
	}
}
