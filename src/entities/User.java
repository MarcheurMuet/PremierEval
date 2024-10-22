package entities;

public class User {

		private int idUser;
		private String Name;
		private String FirstName;
		private String password;
		private String email;
		private String adress;
		private int phoneNumber;
		
		public User(int idUser, String Name, String FirstName, String password, String email, String adress, int phoneNumber) {
			this.idUser = idUser;
			this.Name = Name;
			this.FirstName = FirstName;
			this.password = password;
			this.email = email;
			this.adress = adress;
			this.phoneNumber = phoneNumber;
		}


		public int getIdUser() {
			return idUser;
		}

		public void setIdUser(int idUser) {
			this.idUser = idUser;
		}
		
		public String getName() {
			return Name;
		}

		public void setName(String Name) {
			this.Name = Name;
		}
		
		public String getFirstName() {
			return FirstName;
		}

		public void setFirstName(String FirstName) {
			this.FirstName = FirstName;
		}
		
		public String getpassword() {
			return password;
		}

		public void setpassword(String password) {
			this.password = password;
		}
		
		public String getemail() {
			return email;
		}

		public void setemail(String email) {
			this.email = email;
		}
		
		public String getadress() {
			return adress;
		}

		public void setadress(String adress) {
			this.adress = adress;
		}
		
		public int getphoneNumber() {
			return phoneNumber;
		}

		public void setphoneNumber(int phoneNumber) {
			this.phoneNumber = phoneNumber;
		}
		
		public String toString() {
			return "User [id=" + idUser + ", nom=" + Name + ", prénom=" + FirstName + "]";
		}
}
