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
	private HashMap<Integer,Training> basket;
	private Dao<Training> trainingDao = DaoFactory.getTrainingDao();
	//private TrainingDao trainingDao = new TrainingDao();
	//private Dao<User> userDao = DaoFactory.getUserDao();
	private Dao<Format> formatDao = DaoFactory.getFormatDao();
	private Dao<Basket> basketDao = DaoFactory.getBasketDao();
	private Dao<BasketItem> BasketItemDao = DaoFactory.getBasketItemDao();
	private Dao<User> UserDao = DaoFactory.getUserDao();
	
	public IBusinessImpl() {
		this.basket = new HashMap<Integer,Training>();
	}

	@Override
	public void addToBasket(Training training) {
		Training art = basket.get(this.getIdTraining());
		if(art != null) {
			art.setQuantity(this.getQuantity() + 1);
		}
		else basket.put(this.getIdUser(), art);
	}

	@Override
	public void rmFromCart(int IdTraining) {
		Training training = basket.get(IdTraining);
		if(training != null) {
			if(this.getQuantity() == 1)	basket.remove(IdTraining);
			else training.setQuantity(this.getQuantity() - 1);
		}	
	}

	@Override
	public ArrayList<Training> getCart() {
		return new ArrayList<Training> (Format.values());
	}

	@Override
	public int basket(int IdUser) {	
		if(UserDao.read(IdUser) != null) {
			double total = getTotal(); 
			Basket basket = new Basket(total, new Date(), IdUser);
			if(basketDao.create(basket)) {	
				for(@SuppressWarnings("unused") Training training : basket.values()) {	
					BasketItemDao.create(new BasketItem(0, this.getIdTraining(), this.getQuantity(), this.getprice(), Basket.getIdBasket(IdUser)));
				}
				return Basket.getIdBasket(IdUser);
			}
		}
		return 0;
	}

	@Override
	public ArrayList<Training> readTrainings() {
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

	public double getTotal() {
		double [] total = {0};
		basket.values().forEach((a) -> total[0] += this.getprice() * this.getQuantity()); 	
		return total[0];
	}

	private int getprice() {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean isBasketEmpty() {
		return basket.isEmpty();
	}
	
	public void clearBasket() {
		basket.clear();		
	}

	public Format readOneBasket(int IdBasket) {
		return formatDao.read(IdBasket);
	}

	public Format readOneFormat(int IdFormat) {
		return formatDao.read(IdFormat);
	}
	

	@Override
	public ArrayList<Training> readTrainingsByFormat(String Format) {
		return ((TrainingDao) trainingDao).readAllByFormat(Format);
	}


	@Override
	public ArrayList<Training> readTraining() {
		return ((TrainingDao) trainingDao).readAll();
	}

	@Override
	public int order(int IdUser) {
		return IdUser;
	}

	@Override
	public ArrayList<Training> getBasket() {
		return new ArrayList<Training> (basket.values());
	}

	@Override
	public ArrayList<Training> readTrainingsByFormId(int IdFormat) {
		return ((TrainingDao) trainingDao).readAllByFormatId(IdFormat);
	}


	

	@Override
	public ArrayList<Training> readTrainingByFormId(int IdFormat) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Training> readTrainingByFormat(int IdFormat) {
		return ((TrainingDao) trainingDao).readAllByFormatId(IdFormat);
	}

	@Override
	public ArrayList<Training> getFormat() {
		return new ArrayList<Training> (Format.values());
	}

	@SuppressWarnings("unlikely-arg-type")
	@Override
	public void rmFromBasket(int IdBasket) {
		Training training = basket.get(IdBasket);
		if(training != null) {
			if(this.getQuantity() == 1)	basket.remove(training);
			else training.setQuantity(this.getQuantity() - 1);
		}
	}

	private int getQuantity() {
		// TODO Auto-generated method stub
		return 0;
	}

	private Object getIdTraining() {
		// TODO Auto-generated method stub
		return null;
	}

	private Integer getIdUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Training> readTrainingsByFormat(int IdFormat) {
		return null;
	}

	@Override
	public void addToCart(Training training) {
		// TODO Auto-generated method stub
		
	}
}