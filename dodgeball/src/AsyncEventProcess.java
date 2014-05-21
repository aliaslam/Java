import java.util.ArrayList;


public class AsyncEventProcess implements Runnable {

	ArrayList<GameEventListener> listeners;
	GameEvent e;
	
	public AsyncEventProcess(ArrayList<GameEventListener> listeners, GameEvent gameEvent ){
		this.listeners = listeners;
		this.e = gameEvent;
	}
	
	@Override
	public void run() {
		for (GameEventListener listener : this.listeners) {
			switch (e.getEventType()) {
			case "out":
				listener.gotHit(e);
				break;
			case "catch":
				listener.ballCaught(e);
				break;
			case "throw":
				listener.ballThrown(e);
				break;
			case "dodge":
				listener.ballDodged(e);
				break;
			}
		}
	}

}
