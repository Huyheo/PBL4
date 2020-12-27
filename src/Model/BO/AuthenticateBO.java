package Model.BO;

import Model.BEAN.User;
import Model.DAO.AuthenticateDAO;
public class AuthenticateBO {
	AuthenticateDAO authenticateDAO = new AuthenticateDAO();
	public User isUser(String name, String pass) {
		User user = new User();
		try {
			user = authenticateDAO.isUser(name, pass);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
}