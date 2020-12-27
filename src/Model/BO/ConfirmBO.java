package Model.BO;


import java.io.IOException;
import java.sql.SQLException;

import Model.DAO.ConfirmDAO;

public class ConfirmBO {
	public boolean Confirm(String email, String username, String password) {
		ConfirmDAO confirmDAO = new ConfirmDAO();
		return confirmDAO.confirm(email, username, password);
	}
	
	public boolean forgetPassword(String email, String pass) throws SQLException, IOException {
		ConfirmDAO confirmDAO = new ConfirmDAO();
		return confirmDAO.fogetpassword(email, pass);
	}
}