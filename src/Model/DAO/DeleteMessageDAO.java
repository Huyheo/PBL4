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

public class DeleteMessageDAO {
	private InputStream is;
	private InputStreamReader isr;
	private BufferedReader br;
	private PrintWriter pw = null;
	Socket soc;
	Gson gson = new Gson();

	@SuppressWarnings("unchecked")
	public boolean deleteMessage(String[] listId) throws SQLException, IOException {
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
		boolean check = false;
		try {
			for (int i = 0; i < listId.length; i++) {
				String id = listId[i];
				HashMap<String, String> pairs = new HashMap<>();
				pairs.put("command", "delete_Mess");
				pairs.put("id", id);
				String request = gson.toJson(pairs);
				request = request + "\n";
				pw.write(request);
				pw.flush();
				String strRes = br.readLine();
				HashMap<String, String> response = new HashMap<>();
				response = gson.fromJson(strRes, response.getClass());
				String status = response.get("status");
				if (status.equals("fail")) {
					check = false;
				} else {
					check = true;
				}
			}
		} catch (IOException e) {
			System.out.println("ToServer");
		}
		return check;
	}
	
	@SuppressWarnings("unchecked")
	public boolean deleteMessage1(String ID) throws SQLException, IOException {
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
		boolean check = false;
		try {
			HashMap<String, String> pairs = new HashMap<>();
			pairs.put("command", "delete_Mess");
			pairs.put("id", ID);
			String request = gson.toJson(pairs);
			request = request + "\n";
			pw.write(request);
			pw.flush();
			String strRes = br.readLine();
			HashMap<String, String> response = new HashMap<>();
			response = gson.fromJson(strRes, response.getClass());
			String status = response.get("status");
			if (status.equals("fail")) {
				check = false;
			} else {
				check = true;
			}
		} catch (IOException e) {
			System.out.println("ToServer");
		}
		return check;
	}
	
	@SuppressWarnings("unchecked")
	public boolean deleteMessageSent(String[] listId) throws SQLException, IOException {
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
		boolean check = false;
		try {
			for (int i = 0; i < listId.length; i++) {
				String id = listId[i];
				HashMap<String, String> pairs = new HashMap<>();
				pairs.put("command", "delete_MessSent");
				pairs.put("id", id);
				String request = gson.toJson(pairs);
				request = request + "\n";
				pw.write(request);
				pw.flush();
				String strRes = br.readLine();
				HashMap<String, String> response = new HashMap<>();
				response = gson.fromJson(strRes, response.getClass());
				String status = response.get("status");
				if (status.equals("fail")) {
					check = false;
				} else {
					check = true;
				}
			}
		} catch (IOException e) {
			System.out.println("ToServer");
		}
		return check;
	}
	
	@SuppressWarnings("unchecked")
	public boolean deleteMessageSent1(String ID) throws SQLException, IOException {
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
		boolean check = false;
		try {
			HashMap<String, String> pairs = new HashMap<>();
			pairs.put("command", "delete_MessSent");
			pairs.put("id", ID);
			String request = gson.toJson(pairs);
			request = request + "\n";
			pw.write(request);
			pw.flush();
			String strRes = br.readLine();
			HashMap<String, String> response = new HashMap<>();
			response = gson.fromJson(strRes, response.getClass());
				String status = response.get("status");
			if (status.equals("fail")) {
				check = false;
			} else {
				check = true;
			}
		} catch (IOException e) {
			System.out.println("ToServer");
		}
		return check;
	}
}
