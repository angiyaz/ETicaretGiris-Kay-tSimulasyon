package nLayaredDemo.dataAccess.concrets;

import java.util.ArrayList;
import java.util.List;

import nLayaredDemo.dataAccess.abstracts.UserDao;
import nLayaredDemo.entities.concrets.User;

public class HibernateUserDao implements UserDao{
	
	
	List<User> users=new ArrayList<User>();

	@Override
	public void register(User user) {
		System.out.println("Kullan�c� kay�t oldu.");
		users.add(user);
	}

	@Override
	public void logIn(User user) {
		System.out.println("Kullan�c� giri� yapt�.");
		
	}

	@Override
	public void delete(User user) {
		System.out.println("Kullan�c� bilgileri silindi.");
		users.remove(user);
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return this.users;
	}

	
	
	

}
