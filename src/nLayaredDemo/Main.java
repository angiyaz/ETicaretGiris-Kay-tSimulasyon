package nLayaredDemo;

import nLayaredDemo.business.abstracts.UserService;
import nLayaredDemo.business.concrets.UserManager;
import nLayaredDemo.core.GoogleServiceAdapter;
import nLayaredDemo.dataAccess.concrets.HibernateUserDao;
import nLayaredDemo.entities.concrets.User;

public class Main {

	public static void main(String[] args) {
		User user1=new User("Aslan", "Kaplan","azf@gmail.com","a454534sa");
		UserService userService=new UserManager(new HibernateUserDao(),new GoogleServiceAdapter());
		userService.register(user1);
		userService.verifyAccount(user1);
		userService.logIn("azf@gmail.com", "a454534sa");
		System.out.println("*******************************************");
		User user2=new User("aLÝ", "TEDn","az@gmail.com","a454534sa");
		userService.register(user2);
		userService.verifyAccount(user1);
		userService.logIn("azf@gmail.com", "a454534sa");
		System.out.println("********************************************");
		userService.registerWithGoogleAccount("badba@gmail.com","13123");
		userService.logInWithGoogleAccount("badba@gmail.com", "13123");
	
		

	}

}
