import java.util.EventListener;

public interface GameEventListener extends EventListener {
	public void ballThrown(GameEvent e);
	public void gotHit(GameEvent e);
	public void ballCaught(GameEvent e);
	public void ballDodged(GameEvent e);
}
