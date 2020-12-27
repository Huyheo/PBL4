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

import Model.BEAN.Message;
import Model.BEAN.User;
import Model.BO.DeleteMessageBO;
import Model.BO.GetAllUserBO;
import Model.BO.HomepageBO;

@WebServlet("/DeleteMessage")
public class DeleteMessage extends HttpServlet {
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
		DeleteMessageBO deleteMessage = new DeleteMessageBO();
		String listId[] = request.getParameterValues("listDelete");
		String idString = request.getParameter("id_mess");
		if(idString!=null) {
			if (deleteMessage.deleteMessage1(idString) == true) {
				HomepageBO homepageBO = new HomepageBO();
				ArrayList<Message> listMessage = new ArrayList<Message>();
				listMessage = homepageBO.getListMessage(id_user);
				GetAllUserBO getAllUserBO = new GetAllUserBO();
				ArrayList<User> listUsers = new ArrayList<User>();
				listUsers = getAllUserBO.getListUser();
				HttpSession session = request.getSession();
				session.setAttribute("name", name_user);
				session.setAttribute("id", id_user);
				request.setAttribute("listMessage", listMessage);
				request.setAttribute("listUser", listUsers);
				destination = "/Homepage.jsp";
				RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
				rd.forward(request, response);
			}
		}
		else if (listId == null) {
			HomepageBO homepageBO = new HomepageBO();
			ArrayList<Message> listMessage = new ArrayList<Message>();
			listMessage = homepageBO.getListMessage(id_user);
			GetAllUserBO getAllUserBO = new GetAllUserBO();
			ArrayList<User> listUsers = new ArrayList<User>();
			listUsers = getAllUserBO.getListUser();
			HttpSession session = request.getSession();
			session.setAttribute("name", name_user);
			session.setAttribute("id", id_user);
			request.setAttribute("listMessage", listMessage);
			request.setAttribute("listUser", listUsers);
			destination = "/Homepage.jsp";
			RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
			rd.forward(request, response);
		} else {
			if (deleteMessage.deleteMessage(listId) == true) {
				HomepageBO homepageBO = new HomepageBO();
				ArrayList<Message> listMessage = new ArrayList<Message>();
				listMessage = homepageBO.getListMessage(id_user);
				GetAllUserBO getAllUserBO = new GetAllUserBO();
				ArrayList<User> listUsers = new ArrayList<User>();
				listUsers = getAllUserBO.getListUser();
				HttpSession session = request.getSession();
				session.setAttribute("name", name_user);
				session.setAttribute("id", id_user);
				request.setAttribute("listMessage", listMessage);
				request.setAttribute("listUser", listUsers);
				destination = "/Homepage.jsp";
				RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
				rd.forward(request, response);
			}
		}
	}
}