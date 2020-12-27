package Model.BO;

import java.util.ArrayList;

import Model.BEAN.Attachment;
import Model.BEAN.Attachment_Sent;
import Model.DAO.GetListAttachmentDAO;

public class GetListAttachmentBO {
	public ArrayList<Attachment> getAttachment(String id_mess) {
		GetListAttachmentDAO getListAttachmentDAO = new GetListAttachmentDAO();
		ArrayList<Attachment> attachment = new ArrayList<Attachment>();
		try {
			attachment = getListAttachmentDAO.getAttachment(id_mess);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return attachment;
	}
	
	public ArrayList<Attachment_Sent> getAttachmentSent(String id_mess) {
		GetListAttachmentDAO getListAttachmentDAO = new GetListAttachmentDAO();
		ArrayList<Attachment_Sent> attachment = new ArrayList<Attachment_Sent>();
		try {
			attachment = getListAttachmentDAO.getAttachmentSent(id_mess);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return attachment;
	}
}
