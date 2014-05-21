

public class DodgeBallEventListener implements GameEventListener {
	
	@Override
	public void ballThrown(GameEvent e) {
		System.out.println("Event:" + " Ball thrown by " + e.getThrower() + ", aimed at " + e.getTarget());	
		ScoreKeeper sc = ScoreKeeper.getInstance();
		sc.updateScore(e);

	}

	@Override
	public void gotHit(GameEvent e) {
		System.out.println("Event: " + e.getTarget() + " Got hit by " + e.getThrower());
		ScoreKeeper sc = ScoreKeeper.getInstance();
		sc.updateScore(e);
	}

	@Override
	public void ballCaught(GameEvent e) {
		System.out.println("Event: " + e.getTarget() + " Caught the ball thrown by " + e.getThrower());		
		ScoreKeeper sc = ScoreKeeper.getInstance();
		sc.updateScore(e);
	}

	@Override
	public void ballDodged(GameEvent e) {
		System.out.println("Event: " + e.getTarget() + " Dodged the ball thrown by " + e.getThrower());
		ScoreKeeper sc = ScoreKeeper.getInstance();
		sc.updateScore(e);
	}

}
