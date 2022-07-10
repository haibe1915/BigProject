package allAlgo;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;



public class SpeedController implements ChangeListener {

	@Override
	public void stateChanged(ChangeEvent arg0) {
		int speed=MainFrame2.getInstance().getJsSpeed();
		MainFrame2.getInstance().setSpeed(speed);
	}

}
