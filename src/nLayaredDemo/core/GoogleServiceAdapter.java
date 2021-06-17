package nLayaredDemo.core;

import nLayaredDemo.entities.concrets.User;
import nLayaredDemo.jGoogle.jGoogleManager;

public class GoogleServiceAdapter implements GoogleService{

	@Override
	public void register(User user) {
		jGoogleManager jgoogleManager=new jGoogleManager();
		jgoogleManager.register(user);
		
	}

	@Override
	public void logIn(User user) {
		jGoogleManager jgoogleManager=new jGoogleManager();
		jgoogleManager.logIn(user);
		
	}
	

}
