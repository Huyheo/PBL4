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

import Model.BEAN.Message_Sent;
import Model.BO.MessageSentBO;

@WebServlet("/MessageSent")
public class MessageSent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String destination = null;
		HttpSession ss = request.getSession();
		String name_user = ss.getAttribute("name").toString();
		String id_user = ss.getAttribute("id").toString();
		String pass = ss.getAttribute("pass").toString();
		MessageSentBO messageSentBO = new MessageSentBO();
		ArrayList<Message_Sent> listMessage = new ArrayList<Message_Sent>();
		listMessage = messageSentBO.getListMessageSent(id_user);
		HttpSession session = request.getSession();
		session.setAttribute("name", name_user);
		session.setAttribute("id", id_user);
		session.setAttribute("pass", pass);
		request.setAttribute("listMessage", listMessage);
		destination = "/MessageSent.jsp";
		RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
		rd.forward(request, response);
	}

}
