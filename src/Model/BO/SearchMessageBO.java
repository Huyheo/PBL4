package Model.BO;

import java.util.ArrayList;

import Model.BEAN.Message;
import Model.BEAN.Message_Sent;
import Model.DAO.SearchMessageDAO;

public class SearchMessageBO {
	SearchMessageDAO searchMessageDAO = new SearchMessageDAO();
	public ArrayList<Message> search(String text, String id) {
		ArrayList<Message> listMessage = new ArrayList<Message>();
		try {
			listMessage = searchMessageDAO.search(text, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listMessage;
	}
	
	public ArrayList<Message_Sent> searchSent(String text, String id) {
		ArrayList<Message_Sent> listMessage = new ArrayList<Message_Sent>();
		try {
			listMessage = searchMessageDAO.searchSent(text, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listMessage;
	}
}
