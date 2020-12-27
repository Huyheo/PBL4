package Model.DAO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import Model.BEAN.Attachment;
import Model.BEAN.Attachment_Sent;

public class GetListAttachmentDAO {
	private InputStream is;
	private InputStreamReader isr;
	private BufferedReader br;
	private PrintWriter pw = null;
	Socket soc;
	Gson gson = new Gson();

	@SuppressWarnings("unchecked")
	public ArrayList<Attachment> getAttachment(String id_mess) {
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
		ArrayList<Attachment> attachment = new ArrayList<Attachment>();
		try {
			HashMap<String, String> pairs = new HashMap<>();
			pairs.put("command", "show_Attachment");
			pairs.put("id_mess", id_mess);
			String request = gson.toJson(pairs);
			request = request + "\n";
			pw.write(request);
			pw.flush();
			String strRes = br.readLine();
			HashMap<String, String> response = new HashMap<>();
			response = gson.fromJson(strRes, response.getClass());
			String status = response.get("status");
			if (status.equals("fail")) {
				attachment = null;
			} else {
				String show_Attachment = response.get("show_Attachment");
				attachment = gson.fromJson(show_Attachment, new TypeToken<ArrayList<Attachment>>() {
				}.getType());
			}
		} catch (IOException e) {
			System.out.println("ToServer");
			attachment = null;		
		}
		return attachment;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Attachment_Sent> getAttachmentSent(String id_mess) {
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
		ArrayList<Attachment_Sent> attachment = new ArrayList<Attachment_Sent>();
		try {
			HashMap<String, String> pairs = new HashMap<>();
			pairs.put("command", "show_AttachmentSent");
			pairs.put("id_mess", id_mess);
			String request = gson.toJson(pairs);
			request = request + "\n";
			pw.write(request);
			pw.flush();
			String strRes = br.readLine();
			HashMap<String, String> response = new HashMap<>();
			response = gson.fromJson(strRes, response.getClass());
			String status = response.get("status");
			if (status.equals("fail")) {
				attachment = null;
			} else {
				String show_Attachment = response.get("show_Attachment");
				attachment = gson.fromJson(show_Attachment, new TypeToken<ArrayList<Attachment_Sent>>() {
				}.getType());
			}
		} catch (IOException e) {
			System.out.println("ToServer");
			attachment = null;		
		}
		return attachment;
	}
}
