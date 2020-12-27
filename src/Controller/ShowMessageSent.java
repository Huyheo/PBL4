package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.BEAN.Attachment_Sent;
import Model.BEAN.Message_Sent;
import Model.BO.GetListAttachmentBO;
import Model.BO.ShowMessageBO;

@WebServlet("/ShowMessageSent")
public class ShowMessageSent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String destination = null;
		HttpSession ss = request.getSession();
		String name_user = ss.getAttribute("name").toString();
		String id_user = ss.getAttribute("id").toString();
		ShowMessageBO showMessageSentBO = new ShowMessageBO();
		Message_Sent message_Sent = new Message_Sent();
		String id = request.getParameter("id_mess");
		message_Sent = showMessageSentBO.getMessageSent(id);
		request.setAttribute("mess", message_Sent);
		GetListAttachmentBO getListAttachmentBO = new GetListAttachmentBO();
		ArrayList<Attachment_Sent> attachment = new ArrayList<Attachment_Sent>();
		attachment = getListAttachmentBO.getAttachmentSent(id);
		request.setAttribute("attachment", attachment);
		HttpSession session = request.getSession();
		session.setAttribute("name", name_user);
		session.setAttribute("id", id_user);
		session.setAttribute("download", "sent");
		destination = "/ShowMessageSent.jsp";
		RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
		rd.forward(request, response);
	}

}
