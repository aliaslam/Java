
public class DodgeBall {	

	public static void main(String[] args) {
		
		Team t1 = new Team("Lions");
		Player p1 = new Player("Joe", t1.getName());
		Player p2 = new Player("Tina", t1.getName());
		Player p3 = new Player("James", t1.getName());
		Player p4 = new Player("Max", t1.getName());
		Player p5 = new Player("Julie", t1.getName());
		Player p6 = new Player("Mike", t1.getName());
		t1.addPlayer(p1);
		t1.addPlayer(p2);
		t1.addPlayer(p3);
		t1.addPlayer(p4);
		t1.addPlayer(p5);
		t1.addPlayer(p6);
		
		Team t2 = new Team("Tigers");		
		Player p7 = new Player("Bingo", t2.getName());
		Player p8 = new Player("George", t2.getName());
		Player p9 = new Player("Sally", t2.getName());
		Player p10 = new Player("Bobby", t2.getName());
		Player p11 = new Player("Lester", t2.getName());
		Player p12 = new Player("Marge", t2.getName());
		t2.addPlayer(p7);
		t2.addPlayer(p8);
		t2.addPlayer(p9);
		t2.addPlayer(p10);
		t2.addPlayer(p11);
		t2.addPlayer(p12);

		ScoreKeeper sc = ScoreKeeper.getInstance();
		sc.init(t1, t2);
			
		t1.getPlayer("Joe").throwBall(p11); //Joe threw the ball aimed at Lester		
		t1.getPlayer("James").throwBall(p7); // James threw the ball aimed at Bingo
		t2.getPlayer("Lester").caughtBall(p1); //Lester caught the ball
		t2.getPlayer("Bingo").dodgeBall(p3); //Bingo Dodged the ball thrown by James
		t2.getPlayer("Lester").throwBall(p1); //Lester threw the ball aimed at Joe
		t1.getPlayer("Joe").markOut(p11); //Joe got hit by Lester and is now out
		t1.getPlayer("Julie").throwBall(p9); //Julie threw the ball at Sally
		t2.getPlayer("Sally").dodgeBall(p5); //Sally dodged it
		t2.getPlayer("Sally").throwBall(p6); //Sally threw the ball at Mike
		t1.getPlayer("Mike").dodgeBall(p9); //Mike dodged it
		
		sc.printScoreBoard();

	}
	
}
