import java.util.ArrayList;

public class Player {

	String name, team;
	Boolean active;
	private ArrayList<GameEventListener> ge;
	GameEventListener listener;


	public Player(String name, String team) {
		this.name = name;
		this.team = team;
		active = true;
		ge = new ArrayList<GameEventListener>();
		listener = new DodgeBallEventListener();
		addListener(listener);
	}

	public synchronized void addListener(GameEventListener listener) {
		if (!ge.contains(listener)) {
			ge.add(listener);
		}
	}

	public synchronized void removeListener(GameEventListener listener) {
		if (ge.contains(listener)) {
			ge.remove(listener);
		}
	}

	@SuppressWarnings("unchecked")
	private synchronized void processEvent(GameEvent e) {

		ArrayList<GameEventListener> listeners = new ArrayList<GameEventListener>();

		synchronized (this) {
			if (ge.size() == 0)
				return;
			listeners = (ArrayList<GameEventListener>) ge.clone();
			
			AsyncEventProcess asyncEventProc = new AsyncEventProcess(listeners, e);
			asyncEventProc.run();
		}		
	}

	public String getName() {
		return this.name;
	}
	
	public String getTeam(){
		return team;
	}

	private Boolean isOut() {
		return this.active;
	}

	public void markOut(Player target) {
		this.active = false;
		processEvent(new GameEvent(this, "out", target.getTeam(), name, target.getName()));

	}

	public void caughtBall(Player target) {
		processEvent(new GameEvent(this, "catch", target.getTeam(), name, target.getName()));
	}

	public void throwBall(Player target) {
		processEvent(new GameEvent(this, "throw", target.getTeam(), name, target.getName()));

	}

	public void dodgeBall(Player target) {
		processEvent(new GameEvent(this, "dodge", target.getTeam(), name, target.getName()));
	}
}
