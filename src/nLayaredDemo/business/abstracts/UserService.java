package nLayaredDemo.business.abstracts;

import nLayaredDemo.entities.concrets.User;

public interface UserService {
	void register(User user);
	void verifyAccount(User user);
	void logIn(String mail,String password);
	void registerWithGoogleAccount(String gmail,String password);
	void logInWithGoogleAccount(String gmail,String password);
    
	
}
