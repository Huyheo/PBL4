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
import Model.BO.AuthenticateBO;
import Model.BO.GetAllUserBO;
import Model.BO.HomepageBO;

@WebServlet("/Authenticate")
public class Authenticate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String destination = null;
		String name = request.getParameter("UserName");	
		String pass = request.getParameter("PassWord");
		String pass_MD5 = " ";
		if (pass != null) {
			pass_MD5 = CryptWithMD5.cryptWithMD5(pass);
		}
		HttpSession sessionget = request.getSession();
		String nameget = (String) sessionget.getAttribute("userName");
		String passget = (String) sessionget.getAttribute("passWord");
		if (nameget != null && passget != null) {
			name = nameget;
			pass_MD5 = passget;
		}
		AuthenticateBO authenticateBO = new AuthenticateBO();
		User user = new User();
		user = authenticateBO.isUser(name, pass_MD5);
		if (user.getid() != 0) {
			HomepageBO homepageBO = new HomepageBO();
			ArrayList<Message> listMessage = new ArrayList<Message>();
			listMessage = homepageBO.getListMessage(String.valueOf(user.getid()));
			GetAllUserBO getAllUserBO = new GetAllUserBO();
			ArrayList<User> listUsers = new ArrayList<User>();
			listUsers = getAllUserBO.getListUser();
			HttpSession session = request.getSession();
			session.setAttribute("name", user.getusername());
			session.setAttribute("pass", user.getpassword());
			session.setAttribute("id", String.valueOf(user.getid()));
			request.setAttribute("listMessage", listMessage);
			request.setAttribute("listUser", listUsers);
			destination = "/Homepage.jsp";
			RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
			rd.forward(request, response);
		} else {
			destination = "/Login.jsp";
			RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
			rd.forward(request, response);
		}
	}
}