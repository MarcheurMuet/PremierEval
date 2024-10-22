package entities;

public class Admin {

	private int idAdmin;
	private String NickName;
	private String passwordA;
	
	public Admin(int idAdmin, String NickName, String passwordA) {
		this.idAdmin = idAdmin;
		this.NickName = NickName;
		this.passwordA = passwordA;
	}

	public int getIdAdmin() {
		return idAdmin;
	}

	public void setIdAdmin(int idAdmin) {
		this.idAdmin = idAdmin;
	}
	
	public String getNickName() {
		return NickName;
	}

	public void setNickName(String NickName) {
		this.NickName = NickName;
	}
	
	public String getpasswordA() {
		return passwordA;
	}

	public void setpasswordA(String passwordA) {
		this.passwordA = passwordA;
	}
	
}
