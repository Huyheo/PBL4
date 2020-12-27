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


public class ConfirmDAO {
	private InputStream is;
	private InputStreamReader isr;
	private BufferedReader br;
	private PrintWriter pw = null;
	Socket soc;
	Gson gson = new Gson();
	@SuppressWarnings("unchecked")
	public boolean confirm(String email, String username, String password) {
		try {
			this.soc = new Socket("localhost", 9696);
			System.out.println("Connect");
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
		try {
			HashMap<String, String> pairs = new HashMap<>();
            pairs.put("command", "register");
            pairs.put("username", username);
            pairs.put("password", password);
            pairs.put("email", email);
            String request = gson.toJson(pairs);
            request = request + "\n";
            pw.write(request);
            pw.flush();

            String strRes = br.readLine();
            HashMap<String, String> response = new HashMap<>();
            response = gson.fromJson(strRes, response.getClass());
            String status = response.get("status");
            if (status.equals("fail")) {
                return false;
            } else {
                return true;
            }
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	@SuppressWarnings("unchecked")
	public boolean fogetpassword(String email, String pass) throws SQLException, IOException {
		try {
			this.soc = new Socket("localhost", 9696);
			System.out.println("Connect");
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
        try {
            HashMap<String, String> pairs = new HashMap<>();
            pairs.put("command", "forget_Password");
            pairs.put("email", email);
            pairs.put("password", pass);
            String request = gson.toJson(pairs);
            request = request + "\n";
            pw.write(request);
            pw.flush();

            String strRes = br.readLine();
            HashMap<String, String> response = new HashMap<>();
            response = gson.fromJson(strRes, response.getClass());
            String status = response.get("status");
            if (status.equals("fail")) {
                return false;
            } else {
                return true;
            }
        } catch (IOException e) {
        	System.out.println("ToServer");
        }
        return false;
	}
}