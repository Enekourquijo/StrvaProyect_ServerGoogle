package es.deusto.ingenieria.sd.strava.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IGoogleServer extends Remote  {
	
	public void googleRmi() throws RemoteException;

}
