package Model.BO;

import Model.BEAN.Attachment;
import Model.BEAN.Attachment_Sent;
import Model.DAO.DownloadAttachmentDAO;

public class DownloadAttachmentBO {
	public Attachment downAttachment_mail(String id) {
		DownloadAttachmentDAO downloadAttachmentDAO = new DownloadAttachmentDAO();
		Attachment attachment = new Attachment();
		try {
			attachment = downloadAttachmentDAO.downloadAttachment_mail(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return attachment;
	}
	public Attachment_Sent downAttachment_sent(String id) {
		DownloadAttachmentDAO downloadAttachmentDAO = new DownloadAttachmentDAO();
		Attachment_Sent attachment = new Attachment_Sent();
		try {
			attachment = downloadAttachmentDAO.downloadAttachment_sent(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return attachment;
	}
}
