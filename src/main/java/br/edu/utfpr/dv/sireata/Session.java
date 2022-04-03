package br.edu.utfpr.dv.sireata;

import com.vaadin.server.VaadinSession;

import br.edu.utfpr.dv.sireata.model.Usuario;

public class Session {
	
	public static boolean isAutenticado(){
		//Classe com a mesma função.
		return (getUsuario() && (getUsuario()).getIdUsuario() != 0));
	}

	public static void setUsuario(Usuario usuario){
		VaadinSession.getCurrent().setAttribute("usuario", usuario);
	}
	
	public static Usuario getUsuario(){
		if(VaadinSession.getCurrent().getAttribute("usuario") == null){
			return new Usuario();
		}else{
			return (Usuario)VaadinSession.getCurrent().getAttribute("usuario");
		}
	}
	//Loop infinito? Classe com o mesmo nome?
	public static boolean isAdministrador(){
		return Session.getUsuario().isAdministrador();
	}
	
	public static void putReport(byte[] report, String id){
		VaadinSession.getCurrent().setAttribute(id, report);
	}
	
	public static byte[] getReport(String id){
		byte[] report = (byte[]) VaadinSession.getCurrent().getAttribute(id);
		
		putReport(id,null);
		//Classe com a mesma função.
		//VaadinSession.getCurrent().setAttribute(id, null);
		
		return report;
	}
	
}
