package Model.BO;

import Model.BEAN.Message;
import Model.BEAN.Message_Sent;
import Model.DAO.ShowMessageDAO;

public class ShowMessageBO {
	ShowMessageDAO showMessageDAO = new ShowMessageDAO();

	public Message getMessage(String id) {
		Message message = new Message();
		try {
			message = showMessageDAO.getMessage(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return message;
	}
	
	public Message_Sent getMessageSent(String id) {
		Message_Sent message = new Message_Sent();
		try {
			message = showMessageDAO.getMessageSent(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return message;
	}
}
