package es.deusto.ingenieria.sd.strava.remote;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class GoogleService extends UnicastRemoteObject implements IGoogleServer {
	private static final long serialVersionUID = 1L;

	
	//Attribute for the Singleton pattern
	public static GoogleService instance;
			
	private GoogleService() throws RemoteException {
		super();
	}
	
	public static GoogleService getInstance() {
		if (instance == null) {
			try {
				instance = new GoogleService();
			} catch(Exception ex) {
				System.err.println("  # Error initializing service(): " + ex.getMessage());
			}
		}
		
		return instance;
	}

	public void googleRmi() throws RemoteException{
		System.out.println("Este es el rmi de google!");
	}
}