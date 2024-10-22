package entities;

public class Training {

		private int idTraining;
		private String NameT;
		private String description;
		private int durationD;
		private String format;
		private int price;
		
		public Training(int idTraining, String NameT, String description, int durationD, String format, int price) {
			this.idTraining = idTraining;
			this.NameT = NameT;
			this.description = description;
			this.durationD = durationD;
			this.format = format;
			this.price = price;
		}
		
		public int getidTraining() {
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

		public void setprice(int price) {
			this.price = price;
		}
		
		public int getprice() {
			return price;
		}

		public void setDescription(String string) {
			// TODO Auto-generated method stub
			
		}

		public int getId() {
			// TODO Auto-generated method stub
			return 0;
		}
		
}
