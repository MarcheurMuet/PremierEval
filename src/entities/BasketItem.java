package entities;

public class BasketItem {
	private int idBasketItem;

	private int idBasket;
	private Object idTraining;
	private int quantity;
	private double unitaryPrice;

	public BasketItem(int idBasketItem, Object object, int quantity, double unitaryPrice, int idBasket) {
		this.idBasketItem = idBasketItem;
		this.idTraining = object;
		this.quantity = quantity;
		this.unitaryPrice = unitaryPrice;
		this.idBasket = idBasket;
	}

	public int getIdBasketItem() {
		return idBasketItem;
	}

	public void setIdOrderItem(int idBasketItem) {
		this.idBasketItem = idBasketItem;
	}

	public Object getIdTraining() {
		return idTraining;
	}

	public void setIdTraining(int idTraining) {
		this.idTraining = idTraining;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getUnitaryPrice() {
		return unitaryPrice;
	}

	public void setUnitaryPrice(double unitaryPrice) {
		this.unitaryPrice = unitaryPrice;
	}

	public int getIdBasket() {
		return idBasket;
	}

	public void setIdBasket(int idBasket) {
		this.idBasket = idBasket;
	}
}