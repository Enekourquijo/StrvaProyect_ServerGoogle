package es.deusto.ingenieria.sd.strava.remote;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class GoogleService extends UnicastRemoteObject implements IGoogleServer {
	private static final long serialVersionUID = 1L;
	private Map<String, String> mapaService;
	
	//Attribute for the Singleton pattern
	public static GoogleService instance;
			
	private GoogleService() throws RemoteException {
		super();
		mapaService = new HashMap<>();
		mapaService.put("1@gmail.com", "12345");
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

	public boolean login(String mail, String contr) throws RemoteException{
		System.out.println("Este es el rmi de google!");
		if(mapaService.containsKey(mail)) {
			return contr.equals(mapaService.get(mail));
		}
		return false;
	}
}