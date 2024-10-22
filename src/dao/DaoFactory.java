package dao;
import entities.Admin;
import entities.Training;
import entities.Basket;
import entities.User;

public class DaoFactory {
	
	public static Dao<Training> getTrainingDao() {
		return new TrainingDao();		
	}
	public static Dao<User> getUserDao() {
		return new UserDao();		
	}
	public static Dao<Basket> getBasketDao() {
		return new BasketDao();	
	}
	
	public static Dao<Admin> getAdminDao() {
		return new AdminDao();
	}
}