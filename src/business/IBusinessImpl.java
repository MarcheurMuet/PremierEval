package business;
import java.util.Date;
import java.util.ArrayList;
import java.util.HashMap;

import dao.DaoFactory;
import dao.TrainingDao;
import dao.Dao;
import entities.Training;
import entities.Format;
import entities.User;
import entities.Basket;
import entities.BasketItem;

public class IBusinessImpl implements IBusiness {	
	private HashMap<Integer,Training> cart;
	private Dao<Training> trainingDao = DaoFactory.getTrainingDao();
	//private TrainingDao trainingDao = new TrainingDao();
	//private Dao<User> userDao = DaoFactory.getUserDao();
	private Dao<Format> formatDao = DaoFactory.getFormatDao();
	private Dao<Basket> basketDao = DaoFactory.getBasketDao();
	private Dao<BasketItem> BasketItemDao = DaoFactory.getBasketItemDao();
	private Dao<User> UserDao = DaoFactory.getUserDao();
	
	public IBusinessImpl() {
		this.cart = new HashMap<Integer,Training>();
	}

	@Override
	public void addToCart(Training training) {
		Training art = cart.get(training.getId());
		if(art != null) {
			art.setQuantity(Training.getQuantity() + 1);
		}
		else cart.put(training.getId(), training);
	}

	@Override
	public void rmFromCart(int id) {
		Training training = cart.get(id);
		if(training != null) {
			if(Training.getQuantity() == 1)	cart.remove(id);
			else training.setQuantity(Training.getQuantity() - 1);
		}				
	}

	@Override
	public ArrayList<Training> getFormat() {
		return new ArrayList<Training> (Format.values());
	}

	@Override
	public int order(int IdUser) {	
		if(UserDao.read(IdUser) != null) {
			double total = getTotal(); 
			Basket basket = new Basket(total, new Date(), IdUser);
			if(basketDao.create(basket)) {	
				for(Training training : cart.values()) {	
					BasketItemDao.create(new BasketItem(0, training.getIdTraining(), Training.getQuantity(), Training.getprice(), Basket.getIdBasket(IdUser)));
				}
				return Basket.getIdBasket(IdUser);
			}
		}
		return 0;
	}

	@Override
	public ArrayList<Training> readTraining() {
		return trainingDao.readAll();
	}
	
	@Override
	public ArrayList<Format> readFormat() {
		return formatDao.readAll();
	}

	@Override
	public Training readOneTraining(int id) {
		return trainingDao.read(id);
	}

	@Override
	public ArrayList<Training> readTrainingByFormId(int IdFormat) {
		return ((TrainingDao) trainingDao).readAllByCat(IdFormat);
	}

	public double getTotal() {
		double [] total = {0};
		cart.values().forEach((a) -> total[0] += Training.getprice() * Training.getQuantity()); 	
		return total[0];
	}

	public boolean isCartEmpty() {
		return cart.isEmpty();
	}
	
	public void clearCart() {
		cart.clear();		
	}

	public Format readOneCategory(int id) {
		return formatDao.read(id);
	}

	@Override
	public ArrayList<Training> getCart() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Training> readTrainings() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Training> readTrainingsByFormat(String IdFormat) {
		// TODO Auto-generated method stub
		return null;
	}

	public void rmFromBasket(int id) {
		// TODO Auto-generated method stub
		
	}

	public void addToBasket(Training training) {
		// TODO Auto-generated method stub
		
	}

	public boolean isBasketEmpty() {
		// TODO Auto-generated method stub
		return false;
	}
}