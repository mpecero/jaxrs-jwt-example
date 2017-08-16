package es.infointernet.security;

import java.security.Principal;

import javax.ws.rs.core.SecurityContext;

import es.infointernet.bean.User;

public class MyApplicationSecurityContext implements SecurityContext {
	
	private User usuario;
	private boolean secure;
	
	public MyApplicationSecurityContext(User usuario, boolean secure){
		this.usuario = usuario;
		this.secure = secure;
	}

	@Override
	public String getAuthenticationScheme() {
		return SecurityContext.FORM_AUTH;
	}

	@Override
	public Principal getUserPrincipal() {
		return usuario;
	}

	@Override
	public boolean isSecure() {
		return secure;	
	}

	@Override
	public boolean isUserInRole(String rol) {
		if (usuario.getRoles() != null) {
            return usuario.getRoles().contains(rol);
        }
        return false;
	}

}
