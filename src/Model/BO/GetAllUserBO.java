package Model.BO;

import java.util.ArrayList;

import Model.BEAN.User;
import Model.DAO.GetAllUserDAO;

public class GetAllUserBO {
	GetAllUserDAO getAllUserDAO = new GetAllUserDAO();

	public ArrayList<User> getListUser() {
		ArrayList<User> listUser = new ArrayList<User>();
		try {
			listUser = getAllUserDAO.getListUser();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listUser;
	}
}
