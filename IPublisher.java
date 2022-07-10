package allAlgo;

public interface IPublisher {
	void addSubscriber(ISubscriber sub);
	void updateView(ISubscriber sub,int red, int blue,int green);
}
