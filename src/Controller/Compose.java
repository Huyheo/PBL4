package Controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import Model.BEAN.Message;
import Model.BEAN.User;
import Model.BO.ComposeBO;
import Model.BO.GetAllUserBO;
import Model.BO.HomepageBO;

@WebServlet("/Compose")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
		maxFileSize = 1024 * 1024 * 50, // 50MB
		maxRequestSize = 1024 * 1024 * 50) // 50MB
public class Compose extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Compose() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String destination = null;
		if (request.getParameter("name_sender") != null) {
			String name_sender = request.getParameter("name_sender");
			request.setAttribute("name_sender", name_sender);
			destination = "/Compose.jsp";
			RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
			rd.forward(request, response);
		} else {
			String receiver = request.getParameter("receiver");
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			HttpSession session = request.getSession();
			String id_sender = (String) session.getAttribute("id");
			int id_sd = Integer.parseInt(id_sender);
			ComposeBO composeBO = new ComposeBO();
			String result=composeBO.insertMess(id_sd, receiver, title, content);
			if (result.equals("")) {
				System.out.println("Don't send");
				request.setAttribute("alertMsg", "Sent email fail");
				destination = "/Homepage.jsp";
				RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
				rd.forward(request, response);
			} else {
				for (Part part : request.getParts()) {
					String file_name = extractFileName(part);
					if (file_name != null && file_name.length() > 0) {
						InputStream is = part.getInputStream();
						byte[] data = is.readAllBytes();
						String file_data = data.toString();
						composeBO.insertAttachment(result, file_name, file_data);
					}
				}
				System.out.println("Send success");
				request.setAttribute("alertMsg", "Sent email success");
				HomepageBO homepageBO = new HomepageBO();
				ArrayList<Message> listMessage = new ArrayList<Message>();
				listMessage = homepageBO.getListMessage(String.valueOf(session.getAttribute("id")));
				GetAllUserBO getAllUserBO = new GetAllUserBO();
				ArrayList<User> listUser = new ArrayList<User>();
				listUser = getAllUserBO.getListUser();
				request.setAttribute("listMessage", listMessage);
				request.setAttribute("listUser", listUser);
				destination = "/Homepage.jsp";
				RequestDispatcher rd = getServletContext().getRequestDispatcher(destination);
				rd.forward(request, response);
			}
		}
	}

	private String extractFileName(Part part) {
		String contentDisp = part.getHeader("content-disposition");
		String[] items = contentDisp.split(";");
		for (String s : items) {
			if (s.trim().startsWith("filename")) {
				String clientFileName = s.substring(s.indexOf("=") + 2, s.length() - 1);
				clientFileName = clientFileName.replace("\\", "/");
				int i = clientFileName.lastIndexOf('/');
				return clientFileName.substring(i + 1);
			}
		}
		return null;
	}
}