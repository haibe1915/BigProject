package allAlgo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import allAlgo.Algorithm;


public class StopController implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Algorithm alg=MainFrame2.getInstance().getAlg();
		MainFrame2.getInstance().setViewControls(true);
		alg.stop();
	}

}
