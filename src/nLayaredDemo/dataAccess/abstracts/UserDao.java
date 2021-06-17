package nLayaredDemo.dataAccess.abstracts;

import java.util.List;

import nLayaredDemo.entities.concrets.User;

public interface UserDao {
	void register(User user);
	void logIn(User user);
	void delete(User user);
	
	List<User> getAll();
	

}
