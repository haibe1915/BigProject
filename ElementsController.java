package allAlgo;

import java.util.List;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;



public class ElementsController implements ChangeListener {

	@Override
	public void stateChanged(ChangeEvent arg0) {
		int elements=MainFrame2.getInstance().getJsElements();
		MainFrame2.getInstance().setElements(elements);
		List<Integer> nums=MainFrame2.getInstance().generateList();
		MainFrame2.getInstance().setNums(nums);
	}

}
