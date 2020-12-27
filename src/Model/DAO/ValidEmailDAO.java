package Model.DAO;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashMap;

import com.google.gson.Gson;

public class ValidEmailDAO {
	private InputStream is;
	private InputStreamReader isr;
	private BufferedReader br;
	private PrintWriter pw = null;
	Socket soc;
	Gson gson = new Gson();
	@SuppressWarnings("unchecked")
	public boolean validEmail(String email) {
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
            pairs.put("command", "valid_Email");
            pairs.put("email", email);
            String request = gson.toJson(pairs);
            request = request + "\n";
            pw.write(request);
            pw.flush();

            String strRes = br.readLine();
            HashMap<String, String> response = new HashMap<>();
            response = gson.fromJson(strRes, response.getClass());
            String status = response.get("status");
            if (status.equals("unavailable")) {
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
	public int validAcc(String email, String username) {
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
            pairs.put("command", "valid_Acc");
            pairs.put("email", email);
            pairs.put("username", username);
            String request = gson.toJson(pairs);
            request = request + "\n";
            pw.write(request);
            pw.flush();

            String strRes = br.readLine();
            HashMap<String, String> response = new HashMap<>();
            response = gson.fromJson(strRes, response.getClass());
            String status = response.get("status");
            if (status.equals("userexist")) {
                return 1;
            } 
            else if (status.equals("emailexist")) {
				return 2;
			}
            else if (status.equals("unavailable")) {
				return 0;
			}
            else {
                return -1;
            }
		}
		catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
}