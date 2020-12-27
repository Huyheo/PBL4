package Model.BO;

import Model.DAO.DeleteMessageDAO;
public class DeleteMessageBO {
	DeleteMessageDAO deleteMessageDAO = new DeleteMessageDAO();
	public boolean deleteMessage(String[] listId) {
		boolean check = false;
		try {
			check = deleteMessageDAO.deleteMessage(listId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}
	
	public boolean deleteMessageSent(String[] listId) {
		boolean check = false;
		try {
			check = deleteMessageDAO.deleteMessageSent(listId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}
	
	public boolean deleteMessage1(String id) {
		boolean check = false;
		try {
			check = deleteMessageDAO.deleteMessage1(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}
	
	public boolean deleteMessageSent1(String id) {
		boolean check = false;
		try {
			check = deleteMessageDAO.deleteMessageSent1(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}
}
