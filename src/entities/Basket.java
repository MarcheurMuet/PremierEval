package entities;

public class Basket {

	private int id;
	private String FormaList;
	private int idUser;
	
	public Basket(int id, String FormaList,int idUser) {
		this.id = id;
		this.FormaList = FormaList;
		this.idUser = idUser;
	}
	
	public int id() {
		return id;
	}
	
	public void setid(int id) {
		this.id = id;
	}
	
	public String getFormaList() {
		return FormaList;
	}

	public void setFormaList(String FormaList) {
		this.FormaList = FormaList;
	}
	
	public int idUser() {
		return idUser;
	}
	
	public void setidUser(int idUser) {
		this.idUser = idUser;
	}
	
	public String toString() {
		return "Commande [id=" + id + ", contenu du panier=" + FormaList + ", id de l'utilisateur=" + idUser + "]";
	}
}
