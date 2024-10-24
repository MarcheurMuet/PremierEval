package entities;

import java.sql.Date;

public class Training {

		private int IdTraining;
		private String NameT;
		private String description;
		private int durationD;
		private String format;
		private int IdBasket;
		private Date date;
		private int idUser;
		@SuppressWarnings("unused")
		private String Amount;
		private int Quantity;
		private double price;
		
		public Training(int idTraining, String NameT, String description, int durationD, String format, double rsprice, int Quantity) {
			this.IdTraining = idTraining;
			this.NameT = NameT;
			this.description = description;
			this.durationD = durationD;
			this.format = format;
			this.Quantity = Quantity;
			this.price = rsprice;
		}
		
		public Training(int IdTraining, String NameT, String description, int durationD, String format, double rsprice) {
			this.IdTraining = IdTraining;
			this.NameT = NameT;
			this.description = description;
			this.durationD = durationD;
			this.format = format;
			this.price = rsprice;
		}
		
		public int getIdTraining() {
			return IdTraining;
		}

		public void setIdTraining(int IdTraining) {
			this.IdTraining = IdTraining;
		}
		
		public String getNameT() {
			return NameT;
		}

		public void setNameT(String NameT) {
			this.NameT = NameT;
		}
		
		public String getdescription() {
			return description;
		}

		public void setdescription(String description) {
			this.description = description;
		}
		
		public int getdurationD() {
			return durationD;
		}

		public void setdurationD(int durationD) {
			this.durationD = durationD;
		}
		
		public String getformat() {
			return format;
		}

		public void setformat(String format) {
			this.format = format;
		}

		public void setprice(double price) {
			this.price = price;
		}
		
		public double getprice() {
			return price;
		}

		public void setDescription(String description) {
			this.description = description;
		}
		
		public void setIdBasket(int idBasket) {
			this.IdBasket = idBasket;
		}

		public int getIdBasket() {
			return IdBasket;
		}

		public void setAmount(String Amount) {
			this.Amount = Amount;
		}
		
		public Object getAmount() {
			return null;
		}
		
		public void setDateBasket(Date date) {
			this.date = date;
		}

		public Date getDateBasket() {
			return date;
		}

		public void setidUser(int idUser) {
			this.idUser = idUser;
		}
		
		public int getidUser() {
			return idUser;
		}
		
		public void setQuantity(int Quantity) {
			this.Quantity = Quantity;
		}

		public int getQuantity() {
			return Quantity;
		}
		
}
