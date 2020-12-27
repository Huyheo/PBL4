package Model.BO;

import java.util.ArrayList;

import Model.BEAN.Message;
import Model.DAO.HomepageDAO;

public class HomepageBO {
	HomepageDAO homepageDAO = new HomepageDAO();
	public ArrayList<Message> getListMessage(String id) {
		ArrayList<Message> listMessage = new ArrayList<Message>();
		try {
			listMessage = homepageDAO.getListMessage(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listMessage;
	}
}
