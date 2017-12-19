package listener;

import javax.el.ELContext;
import javax.el.ELResolver;
import javax.faces.application.FacesMessage;
import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import controle.bean.LoginMB;

public class LoginCheckPhaseListener implements PhaseListener {


	@Override
	public void afterPhase(PhaseEvent event) {

		FacesContext contexto = FacesContext.getCurrentInstance();
		ELResolver resolver = contexto.getApplication().getELResolver();
		ELContext elContexto = contexto.getELContext();

		LoginMB loginMB = (LoginMB) resolver.getValue(elContexto, null, "loginMB");
		
		boolean estaAutenticado = false;
		
		if (loginMB != null)
		{
			if (loginMB.isConectado())
				estaAutenticado = true;
		}
		
		boolean estaNoLogin = false;
		if (contexto.getViewRoot().getViewId().lastIndexOf("login") > -1)
			estaNoLogin = true;
		
		if (!estaAutenticado && !estaNoLogin)
		{
			String mensagem = contexto.getApplication().evaluateExpressionGet(contexto, "#{msgs.msgExpirado}",
					String.class);
			FacesMessage msg = new FacesMessage(mensagem);
			contexto.addMessage(null, msg);
			
			NavigationHandler handler = contexto.getApplication().getNavigationHandler();
			handler.handleNavigation(contexto, null, "login.jsf");
		}
		
	}

	@Override
	public void beforePhase(PhaseEvent event) {

	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}

}
