package dao;
import entities.Admin;
import entities.Training;
import entities.Basket;
import entities.User;

public class DaoFactory {
	
	public static Dao getAdminDao() {
		return (Dao) new UserDao();		
	}
	public static Dao getTrainingDao() {
		return (Dao) new TrainingDao();		
	}
	public static Dao getBasketDao() {
		return new BasketDao();	
	}
	
	public static Dao getUserDao() {
		return (Dao) new UserDao();		
	}
}