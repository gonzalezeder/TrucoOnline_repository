package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Set;

import dtos.JugadorDTO;



public interface TDAManejoDatos extends Remote  {

	/* retorna un Jugador */
	public JugadorDTO obtengoJugador(int nroJugador) throws RemoteException;
	
	/* recibe un Jugador */ 
	public void envioJugador(JugadorDTO jugador)throws RemoteException;
	 
	/* retorna todos los Jugadores */ 
	public Set<JugadorDTO> obtengoJugadores()throws RemoteException;
	
	public int cantidadJugadores() throws RemoteException;
}
