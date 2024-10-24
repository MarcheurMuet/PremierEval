package entities;

import java.sql.Date;

public class Training {

		private static int idTraining;
		private String NameT;
		private String description;
		private static int durationD;
		private String format;
		private int IdBasket;
		private Date date;
		private static int IdUser;
		private String Amount;
		private static int Quantity;
		private static double price;
		
		public Training(int idTraining, String NameT, String description, int durationD, String format, double rsprice) {
			Training.idTraining = idTraining;
			this.NameT = NameT;
			this.description = description;
			Training.durationD = durationD;
			this.format = format;
			this.Quantity = Quantity;
			Training.price = rsprice;
		}
		
		public static int getidTraining() {
			return idTraining;
		}

		public void setIdTraining(int idTraining) {
			this.idTraining = idTraining;
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
		
		public static int getdurationD() {
			return durationD;
		}

		public void setdurationD(int durationD) {
			Training.durationD = durationD;
		}
		
		public String getformat() {
			return format;
		}

		public void setformat(String format) {
			this.format = format;
		}

		public void setprice(double price) {
			Training.price = price;
		}
		
		public static double getprice() {
			return price;
		}

		public void setDescription(String description) {
			this.description = description;
		}
		
		public void setIdBasket(int id) {
			this.IdBasket = id;
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

		public void setIdUser(int IdUser) {
			this.IdUser = IdUser;
		}
		
		public static int getIdUser() {
			return IdUser;
		}
		
		public void setQuantity(int Quantity) {
			Training.Quantity = Quantity;
		}

		public static int getQuantity() {
			return Quantity;
		}

		
}
