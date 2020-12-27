package Model.DAO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import com.google.gson.reflect.TypeToken;

import com.google.gson.Gson;

import Model.BEAN.Message;
import Model.BEAN.Message_Sent;

public class SearchMessageDAO {
	private InputStream is;
	private InputStreamReader isr;
	private BufferedReader br;
	private PrintWriter pw = null;
	private ArrayList<Message> listMessage;
	private ArrayList<Message_Sent> listMessageSent;
	Socket soc;
	Gson gson = new Gson();

	@SuppressWarnings("unchecked")
	public ArrayList<Message> search(String text, String id) throws SQLException, IOException {
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
		listMessage = new ArrayList<Message>();
		try {
			HashMap<String, String> pairs = new HashMap<>();
			pairs.put("command", "search");
			pairs.put("id", id);
			pairs.put("text", text);
			String request = gson.toJson(pairs);
			request = request + "\n";
			pw.write(request);
			pw.flush();
			String strRes = br.readLine();
			HashMap<String, String> response = new HashMap<>();
			response = gson.fromJson(strRes, response.getClass());
			String status = response.get("status");
			if (status.equals("fail")) {
				listMessage = null;
			} else {
				String search = response.get("search");
				listMessage = gson.fromJson(search, new TypeToken<ArrayList<Message>>() {
				}.getType());
			}
		} catch (IOException e) {
			System.out.println("ToServer");
		}
		return listMessage;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Message_Sent> searchSent(String text, String id) throws SQLException, IOException {
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
		listMessageSent = new ArrayList<Message_Sent>();
		try {
			HashMap<String, String> pairs = new HashMap<>();
			pairs.put("command", "search_sent");
			pairs.put("id", id);
			pairs.put("text", text);
			String request = gson.toJson(pairs);
			request = request + "\n";
			pw.write(request);
			pw.flush();
			String strRes = br.readLine();
			HashMap<String, String> response = new HashMap<>();
			response = gson.fromJson(strRes, response.getClass());
			String status = response.get("status");
			if (status.equals("fail")) {
				listMessage = null;
			} else {
				String search = response.get("search");
				listMessageSent = gson.fromJson(search, new TypeToken<ArrayList<Message_Sent>>() {
				}.getType());
			}
		} catch (IOException e) {
			System.out.println("ToServer");
		}
		return listMessageSent;
	}
}