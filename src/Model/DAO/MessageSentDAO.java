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

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import Model.BEAN.Message_Sent;

public class MessageSentDAO {
	private InputStream is;
	private InputStreamReader isr;
	private BufferedReader br;
	private PrintWriter pw = null;
	private ArrayList<Message_Sent> listMessage;
	Socket soc;
	Gson gson = new Gson();

	@SuppressWarnings("unchecked")
	public ArrayList<Message_Sent> getListMessageSent(String id) throws SQLException, IOException {
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
		listMessage = new ArrayList<Message_Sent>();
		try {
			HashMap<String, String> pairs = new HashMap<>();
			pairs.put("command", "show_listMessSent");
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
				listMessage = null;
			} else {
				String show_list = response.get("show_listmess");
				listMessage = gson.fromJson(show_list, new TypeToken<ArrayList<Message_Sent>>() {
				}.getType());
			}
		} catch (IOException e) {
			System.out.println("ToServer");
		}
		return listMessage;
	}
}
