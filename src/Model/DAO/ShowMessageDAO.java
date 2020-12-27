package Model.DAO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.SQLException;
import java.util.HashMap;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import Model.BEAN.Message;
import Model.BEAN.Message_Sent;

public class ShowMessageDAO {
	private InputStream is;
	private InputStreamReader isr;
	private BufferedReader br;
	private PrintWriter pw = null;
	Socket soc;
	Gson gson = new Gson();

	@SuppressWarnings("unchecked")
	public Message getMessage(String id) throws SQLException, IOException {
		try {
			this.soc = new Socket("localhost", 9696);
		} catch (Exception e) {
			System.out.println("Error");
		}
		try {
			is = soc.getInputStream();
			isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
			if (pw == null) {
				pw = new PrintWriter(soc.getOutputStream());
			}
		} catch (Exception e) {
			System.out.println("Error User Thread");
		}
		Message message = new Message();
		try {
			HashMap<String, String> pairs = new HashMap<>();
			pairs.put("command", "show_Mess");
			pairs.put("id", id);
			String request = gson.toJson(pairs);
			request = request + "\n";
			pw.write(request);
			pw.flush();
			String strRes = br.readLine();
			HashMap<String, String> response = new HashMap<>();
			response = gson.fromJson(strRes, response.getClass());
			String status = response.get("status");
			if (status.equals("success")) {
				String show_mess = response.get("show_Mess");
				message = gson.fromJson(show_mess, new TypeToken<Message>() {
				}.getType());
			}
		} catch (IOException e) {
			System.out.println("ToServer");
		}
		return message;
	}
	
	@SuppressWarnings("unchecked")
	public Message_Sent getMessageSent(String id) throws SQLException, IOException {
		try {
			this.soc = new Socket("localhost", 9696);
		} catch (Exception e) {
			System.out.println("Error");
		}
		try {
			is = soc.getInputStream();
			isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
			if (pw == null) {
				pw = new PrintWriter(soc.getOutputStream());
			}
		} catch (Exception e) {
			System.out.println("Error User Thread");
		}
		Message_Sent message = new Message_Sent();
		try {
			HashMap<String, String> pairs = new HashMap<>();
			pairs.put("command", "show_MessSent");
			pairs.put("id", id);
			String request = gson.toJson(pairs);
			request = request + "\n";
			pw.write(request);
			pw.flush();
			String strRes = br.readLine();
			HashMap<String, String> response = new HashMap<>();
			response = gson.fromJson(strRes, response.getClass());
			String status = response.get("status");
			if (status.equals("success")) {
				String show_mess = response.get("show_Mess");
				message = gson.fromJson(show_mess, new TypeToken<Message_Sent>() {
				}.getType());
			}
		} catch (IOException e) {
			System.out.println("ToServer");
		}
		return message;
	}
}
