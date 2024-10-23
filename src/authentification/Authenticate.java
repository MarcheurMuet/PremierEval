package authentification;

import dao.DaoFactory;
import dao.Dao;
import dao.UserDao;
import entities.User;

public class Authenticate {
	private Dao<User> UserDao = DaoFactory.getUserDao();

	public int existUser(String Name, String FirstName) {
		User user = ((UserDao)UserDao).findUserByCredentials(Name,FirstName);
		if(user != null )	return user.getIdUser();
		return 0;
	}
	
	public int existUser(String Name) {
		User user = ((UserDao)UserDao).findUserByName(Name);
		if(user != null )	return user.getIdUser();
		return 0;
	}
	
	public User existUserByEmail(String Name) {
		return ((UserDao)UserDao).findUserByName(Name);
	}

	public void addUser(String Name, String FirstName, String password,String email,String adress) {
		UserDao.create(new User(0, Name, FirstName, password, email, adress, 0));		
	}

	public void addUser(String name, String password) {
		
		
	}

	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}
}