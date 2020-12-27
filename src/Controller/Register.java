package Controller;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.BO.ValidEmailBO;



/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Register() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String destination = null;
		String email = request.getParameter("email");	
		String username = request.getParameter("username");
		try {
			ValidEmailBO validEmailBO = new ValidEmailBO();
			int valid  = validEmailBO.validAcc(email,username);
			if (valid==0) {
				HttpSession session = request.getSession();
				String codeString = ValidEmail.randomCode();
				session.setAttribute("codevalid", codeString);
				session.setAttribute("userName", username);
				session.setAttribute("passWord", CryptWithMD5.cryptWithMD5(request.getParameter("password")));
				session.setAttribute("email", email);
				session.setAttribute("flag", "1");
				String host = "smtp.gmail.com";
				String port = "587";
				String sub = "CODE";
				String usernameString  = "hoa10chuyenltt2015@gmail.com";
				String passString = "hoa10chuyen";
				ValidEmail.sendEmail(host, port, usernameString, passString, email, sub, codeString);
				destination = "/Confirm.jsp";
				RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
				rd.forward(request, response);
			}
			else if (valid==1){
				request.setAttribute("alertMsg", "Username da ton tai");
				destination = "/RegisterForm.jsp";
				RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
				rd.forward(request, response);
			}
			else if (valid==2) {
				request.setAttribute("alertMsg", "Email da ton tai");
				destination = "/RegisterForm.jsp";
				RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
				rd.forward(request, response);
			}
			else {
				request.setAttribute("alertMsg", "Error");
				destination = "/RegisterForm.jsp";
				RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
				rd.forward(request, response);
			}
			
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
	}
}
