
public class PlayerStats extends TeamStats {
	
	boolean out;
	
	public PlayerStats(String name){
		super(name);
		this.out = false;
	}
	
	public void markOut(){
		this.out = true;
	}
}
