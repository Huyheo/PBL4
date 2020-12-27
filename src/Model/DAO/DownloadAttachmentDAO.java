package Model.DAO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashMap;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import Model.BEAN.Attachment;
import Model.BEAN.Attachment_Sent;

public class DownloadAttachmentDAO {
	private InputStream is;
	private InputStreamReader isr;
	private BufferedReader br;
	private PrintWriter pw = null;
	Socket soc;
	Gson gson = new Gson();

	@SuppressWarnings("unchecked")
	public Attachment downloadAttachment_mail(String id) {
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
		Attachment attachment = new Attachment();
		try {
			HashMap<String, String> pairs = new HashMap<>();
			pairs.put("command", "download_Attachment_mail");
			pairs.put("id_down", id);
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
				String attachment_down = response.get("attachment_down");
				attachment = gson.fromJson(attachment_down, new TypeToken<Attachment>() {
				}.getType());
			}
		} catch (IOException e) {
			System.out.println("ToServer");
			attachment = null;
		}
		return attachment;
	}

	@SuppressWarnings("unchecked")
	public Attachment_Sent downloadAttachment_sent(String id) {
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
		Attachment_Sent attachment = new Attachment_Sent();
		try {
			HashMap<String, String> pairs = new HashMap<>();
			pairs.put("command", "download_Attachment_sent");
			pairs.put("id_down", id);
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
				String attachment_down = response.get("attachment_down");
				attachment = gson.fromJson(attachment_down, new TypeToken<Attachment>() {
				}.getType());
			}
		} catch (IOException e) {
			System.out.println("ToServer");
			attachment = null;
		}
		return attachment;
	}
}
