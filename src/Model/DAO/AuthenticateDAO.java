package Model.DAO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.SQLException;
import java.util.HashMap;

import Model.BEAN.User;
import com.google.gson.Gson;

public class AuthenticateDAO {
	private InputStream is;
	private InputStreamReader isr;
	private BufferedReader br;
	private PrintWriter pw = null;
	private User user;
	Socket soc;
	Gson gson = new Gson();
	@SuppressWarnings("unchecked")
	public User isUser(String name, String pass) throws SQLException, IOException {
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
        user = new User();
        try {
            HashMap<String, String> pairs = new HashMap<>();
            pairs.put("command", "authenticate");
            pairs.put("username", name);
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
                user.setid(Integer.parseInt("0"));
            } else {
                user.setid(Integer.parseInt(response.get("id")));
                user.setusername(response.get("username"));
                user.setpassword(response.get("password"));
            }
        } catch (IOException e) {
        	System.out.println("ToServer");
        }
		return user;
	}
}
