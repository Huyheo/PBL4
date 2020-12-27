package Model.BO;

import java.util.ArrayList;

import Model.BEAN.Message_Sent;
import Model.DAO.MessageSentDAO;

public class MessageSentBO {
	MessageSentDAO messageSentDAO = new MessageSentDAO();
	public ArrayList<Message_Sent> getListMessageSent(String id) {
		ArrayList<Message_Sent> listMessage = new ArrayList<Message_Sent>();
		try {
			listMessage = messageSentDAO.getListMessageSent(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listMessage;
	}
}
