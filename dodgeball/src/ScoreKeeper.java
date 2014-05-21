import java.util.HashMap;
import java.util.Map.Entry;

public class ScoreKeeper {
	
	
	private static ScoreKeeper instance = null;
	HashMap<String, TeamStats> teamStats;
	HashMap<String, PlayerStats> playerStats;

	protected ScoreKeeper() {
	}

	public static ScoreKeeper getInstance() {
		if (instance == null) {
			instance = new ScoreKeeper();
		}
		return instance;
	}

	public void init(Team t1, Team t2){
		
		teamStats = new HashMap<String, TeamStats>();
		teamStats.put(t1.getName(), new TeamStats(t1.getName()));
		teamStats.put(t2.getName(), new TeamStats(t2.getName()));
		
		playerStats = new HashMap<String, PlayerStats>();		
		
		for(String p: t1.getAllPlayersNames()){
		    System.out.println("Adding Player: " + p);

			playerStats.put(p, new PlayerStats(p));
		}		
		
		for(String p: t2.getAllPlayersNames()){
		    System.out.println("Adding Player: " + p);

			playerStats.put(p, new PlayerStats(p));
		}

	}
	
	public void updateScore(GameEvent e){
				
		try{
			switch (e.getEventType()) {
			case "out":
				playerStats.get(e.getThrower()).addOut();
				teamStats.get(e.getTeam()).addOut();
				break;
			case "catch":
				playerStats.get(e.getThrower()).addCatch();
				teamStats.get(e.getTeam()).addCatch();
				break;
			case "throw":
				playerStats.get(e.getThrower()).addThrow();
				teamStats.get(e.getTeam()).addThrow();
				break;
			case "dodge":
				playerStats.get(e.getThrower()).addDodge();
				teamStats.get(e.getTeam()).addDodge();	
				break;
			}
		}
		catch(NullPointerException npe){
		    System.out.println("Couldn't find Player or team!");
		}
				
	}
	
	public void printScoreBoard(){
		
		//Team Stats
		for (Entry<String, TeamStats> entry : teamStats.entrySet()) {
			int totalThrows = entry.getValue().totalThrows;
		    int totalCatches = entry.getValue().totalCatches;
		    int totalDodges = entry.getValue().totalDodges;
		    int totalOuts = entry.getValue().totalOuts;
		    System.out.print("\n[ " + entry.getKey() + " ] ");
		    System.out.println("Throws:" + totalThrows + " Catches:" + totalCatches + " Dodges:" + totalDodges + " Outs:" + totalOuts + "\n");
		}
		
		//Player Stats
		for (Entry<String, PlayerStats> entry : playerStats.entrySet()) {
			int totalThrows = entry.getValue().totalThrows;
		    int totalCatches = entry.getValue().totalCatches;
		    int totalDodges = entry.getValue().totalDodges;
		    int totalOuts = entry.getValue().totalOuts;
		    System.out.print(entry.getKey() + " >> ");
		    System.out.println("Throws:" + totalThrows + " Catches:" + totalCatches + " Dodges:" + totalDodges + " Outs:" + totalOuts + "\n");
		}
	}

}
