package allAlgo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import allAlgo.Algorithm;
import allAlgo.InsertionSort;
import allAlgo.MergeSort;
import allAlgo.QuickSort;
import allAlgo.Sort;


public class SortController implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		List<Integer> nums=MainFrame2.getInstance().getNums();
		int speed=MainFrame2.getInstance().getJsSpeed();
		int elements=MainFrame2.getInstance().getJsElements();
		MainFrame2.getInstance().setSpeed(speed);
		MainFrame2.getInstance().setElements(elements);
		MainFrame2.getInstance().generateList();
		
		Algorithm alg=getSelectedAlgorithm(nums);
		MainFrame2.getInstance().setAlg(alg);
		alg.addSubscriber(MainFrame2.getInstance());
		alg.start();
	}
	
	private Algorithm getSelectedAlgorithm(List<Integer> nums) {
		Algorithm alg=null;
		Sort sort=MainFrame2.getInstance().getCmbSort();
		switch(sort) {
			case QuickSort:alg=new QuickSort(nums);break;
			case MergeSort:alg=new MergeSort(nums);break;
			case InsertionSort:alg=new InsertionSort(nums);break;
			case ShellSort:alg=new ShellSort(nums);break;
		}
		return alg;
	}

}
