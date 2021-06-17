package nLayaredDemo.business.concrets;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import nLayaredDemo.business.abstracts.UserService;
import nLayaredDemo.core.GoogleService;
import nLayaredDemo.dataAccess.abstracts.UserDao;
import nLayaredDemo.entities.concrets.User;

public class UserManager implements UserService{
	private User user;
	private UserDao userDao;
	private GoogleService googleService;
	
	public UserManager(UserDao userDao,GoogleService googleService) {
		this.userDao = userDao;
		this.googleService=googleService;
	}

	@Override
	public void register(User user) {
		if(user.getPassword().length()<6) {
			System.out.println("Þifre en az 6 karakterden oluþmalý");
			return;
		}
		
		String regex = "^(.+)@(.+)(..)(.+)$";
        Pattern pattern = Pattern.compile(regex);
	    Matcher matcher = pattern.matcher(user.getEmail());
	    if (!matcher.matches()) {
	    	System.out.println("Mail alaný mail formatýnda olmalý.");
		    return ;
	     }
		
	    for(User i:userDao.getAll()) {
	    	if(i.getEmail()==user.getEmail()) {
	    		System.out.println("Bu mail adresi sisteme kayýtlý");
	    		return;
	    	}
	    }
		
	    if(user.getFirstName().length()<2 || user.getLastName().length()<2) {
			System.out.println("Ýsim ve soyisim en az 2 karakterden oluþmalý.");
			return;
		}
	    
	    this.userDao.register(user);
	    
 }
	
	@Override
	public void verifyAccount(User user) {
		System.out.println("Mail adresine gelen doðrulama linkine týklayarak kayýt iþlemini baþarýlý þekilde bitirebilirsin.");
		}

	@Override
	public void logIn(String mail, String password) {
		for(User i:userDao.getAll()) {
			if(i.getEmail()== mail && i.getPassword()==password) {
				this.userDao.logIn(user);
				return;
			}else {
				System.out.println("Girdiðin kullanýcý adý ve þifre kayýtlarýmýzdakiyle eþleþmedi. Lütfen doðru girdiðinden emin ol ve tekrar dene.");
				return;
			}
		}
		
	}

	@Override
	public void registerWithGoogleAccount(String gmail, String password) {
		this.googleService.register(user);
		}

	@Override
	public void logInWithGoogleAccount(String gmail, String password) {
		this.googleService.logIn(user);
   }



	

	

}
