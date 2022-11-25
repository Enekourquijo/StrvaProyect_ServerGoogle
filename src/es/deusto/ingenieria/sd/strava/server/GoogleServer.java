package es.deusto.ingenieria.sd.strava.server;

import java.rmi.Naming;

import es.deusto.ingenieria.sd.strava.remote.GoogleService;
import es.deusto.ingenieria.sd.strava.remote.IGoogleServer;

public class GoogleServer {

	public static void main(String[] args) {
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}

		String name = "//" + args[0] + ":" + args[1] + "/" + args[2];		
		
		try {
			IGoogleServer remoteObject = GoogleService.getInstance();			
			Naming.rebind(name, remoteObject);
			System.out.println(" * Currency Exchange Server '" + name + "' started!!");
		} catch (Exception ex) {
			System.out.println(" # Currency Exchange Server: " + ex.getMessage());
			ex.printStackTrace();
		}

	}
}