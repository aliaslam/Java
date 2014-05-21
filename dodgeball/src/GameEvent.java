import java.util.EventObject;


public class GameEvent extends EventObject {

	private static final long serialVersionUID = 1L;
	private String eventType;
	private String team;
	private String thrower;
	private String target;
	
	public GameEvent(Object source, String eventType, String team, String thrower, String target){
		super(source);
		this.eventType = eventType;
		this.team = team;
		this.thrower = thrower;
		this.target = target;		
	}

	public String getEventType() {
		return eventType;
	}
	
	public String getTeam() {
		return team;
	}
	
	public String getThrower() {
		return thrower;
	}

	public String getTarget() {
		return target;
	}


	
}
