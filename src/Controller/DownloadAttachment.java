package Controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.BEAN.Attachment;
import Model.BEAN.Attachment_Sent;
import Model.BO.DownloadAttachmentBO;

@WebServlet("/DownloadAttachment")
public class DownloadAttachment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if ((String) session.getAttribute("download")=="mail") {
			try {
				String id = request.getParameter("id_attachment");
				DownloadAttachmentBO downloadAttachmentBO = new DownloadAttachmentBO();
				Attachment attachment = new Attachment();
				attachment = downloadAttachmentBO.downAttachment_mail(id);
				String file_name = attachment.getfile_name();
				String file_data = attachment.getfile_data();
				OutputStream out = response.getOutputStream();
				InputStream in = new ByteArrayInputStream(file_data.getBytes());
				response.setContentType("APPLICATION/OCTET-STREAM");
				response.setHeader("Content-Disposition", "attachment; filename=\"" + file_name + "\"");
				byte[] bytes = new byte[1024];
				int bytesRead;
				while ((bytesRead = in.read(bytes)) != -1) {
					out.write(bytes, 0, bytesRead);
					System.out.println(bytesRead);
				}
				in.close();
				out.flush();
			} catch (Exception e) {
				throw new ServletException(e);
			}
		} else if ((String)session.getAttribute("download")=="sent") {
			try {
				String id = request.getParameter("id_attachment");
				DownloadAttachmentBO downloadAttachmentBO = new DownloadAttachmentBO();
				Attachment_Sent attachment = new Attachment_Sent();
				attachment = downloadAttachmentBO.downAttachment_sent(id);
				String file_name = attachment.getfile_name();
				String file_data = attachment.getfile_data();
				OutputStream out = response.getOutputStream();
				InputStream in = new ByteArrayInputStream(file_data.getBytes());
				response.setContentType("APPLICATION/OCTET-STREAM");
				response.setHeader("Content-Disposition", "attachment; filename=\"" + file_name + "\"");
				byte[] bytes = new byte[1024];
				int bytesRead;
				while ((bytesRead = in.read(bytes)) != -1) {
					out.write(bytes, 0, bytesRead);
					System.out.println(bytesRead);
				}
				in.close();
				out.flush();
			} catch (Exception e) {
				throw new ServletException(e);
			}
		}
	}
}
