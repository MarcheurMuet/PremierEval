package dao;
import entities.Admin;
import entities.Training;
import entities.Basket;
import entities.BasketItem;
import entities.Format;
import entities.User;

public class DaoFactory {
	
	public static Dao<Training> getTrainingDao() {
		return new TrainingDao(null);		
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
	public static Dao<Format> getFormatDao() {
		// TODO Auto-generated method stub
		return null;
	}
	public static Dao<BasketItem> getBasketItemDao() {
		// TODO Auto-generated method stub
		return null;
	}
}