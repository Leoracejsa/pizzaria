package listener;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class TestePhaseListener implements PhaseListener {

	@Override
	public void afterPhase(PhaseEvent event) {

		System.out.println("DEPOIS DA FASE: " + event.getPhaseId());

	}

	@Override
	public void beforePhase(PhaseEvent event) {

		System.out.println("ANTES DA FASE: " + event.getPhaseId());

	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.ANY_PHASE;
	}

}
