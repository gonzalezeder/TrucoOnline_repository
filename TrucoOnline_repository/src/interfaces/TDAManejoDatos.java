//prueba
package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Set;

import dtos.JugadorDTO;

public interface TDAManejoDatos extends Remote {
	
	public final static String LOOKUPNAME = "//localhost/GestionJugadores";

	/* retorna un Jugador */
	public JugadorDTO obtengoJugador(int nroJugador) throws RemoteException;

	/* recibe un Jugador */
	public void envioJugador(JugadorDTO jugador) throws RemoteException;

	/* retorna todos los Jugadores */
	public Set<JugadorDTO> obtengoJugadores() throws RemoteException;

	public int cantidadJugadores() throws RemoteException;

	public boolean validarLogin(String usuario, String password)
			throws RemoteException;

	public boolean validteApodo(String apodo) throws RemoteException;;

	public boolean validteMail(String mail) throws RemoteException;;
}
