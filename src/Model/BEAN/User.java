package Model.BEAN;

public class User {
	private int id;
	private String username;
	private String password;
	private String email;

	public int getid() {
		return id;
	}

	public void setid(int id) {
		this.id = id;
	}

	public String getusername() {
		return username;
	}

	public void setusername(String username) {
		this.username = username;
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
}