package allAlgo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;



public class ShuffleController implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		List<Integer> nums=MainFrame2.getInstance().generateList();
		MainFrame2.getInstance().setNums(nums);
	}

}
