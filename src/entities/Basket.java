package entities;

import java.sql.Date;

public class Basket {

	private int id;
	private float Amount;
	private Date DateBasket;
	private int idUser;
	
	public Basket(int id, float Amount, Date DateBasket, int idUser) {
		this.id = id;
		this.Amount = Amount;
		this.DateBasket = DateBasket;
		this.idUser = idUser;
	}
	
	public Basket(double total, java.util.Date date, int idUser) {
		
	}

	public int id() {
		return id;
	}
	
	public void setid(int id) {
		this.id = id;
	}
	
	public float getAmount() {
		return Amount;
	}

	public void setAmount(float Amount) {
		this.Amount = Amount;
	}
	
	public Date getDateBasket(Date DateBasket) {
		return DateBasket;
	}
	
	public void setDateBasket(Date DateBasket) {
		this.DateBasket = DateBasket;
	}
	
	public int idUser() {
		return idUser;
	}
	
	public void setidUser(int idUser) {
		this.idUser = idUser;
	}
	
	public String toString() {
		return "Commande [id=" + id + ", contenu du panier=" + Amount + "Date de la prise de commande : "+ DateBasket +", id de l'utilisateur=" + idUser + "]";
	}

	public static int getIdBasket(int id) {
		return id;
	}

	public String getFormaList() {
		// TODO Auto-generated method stub
		return null;
	}
}
