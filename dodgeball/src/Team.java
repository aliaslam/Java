import java.util.HashMap;


public class Team {

	String name;
	HashMap<String, Player> players = new HashMap<String, Player>();

	public Team(String name){
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void addPlayer(Player p){
		players.put(p.getName(), p);
	}
	
	public void removePlayer(Player p){
		
	}
	
	public Player getPlayer(String name){
		return players.get(name);
	}
	
	public HashMap<String, Player> getAllPlayers(){
		return players;
	}
	
	public String[] getAllPlayersNames(){
		return players.keySet().toArray(new String[0]); 
	}
	
}
