package bot.ui.components;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

import bot.entities.Login;


public class ExportLoginData {
	
	private static final String PATH_LOGIN_DATA = "../bot/src/main/resources/login.txt";
	
	private PrintWriter gravarArq;

	public ExportLoginData() {
	}
	
	public Login checkSavedFile() {
		Login savedLogin = new Login();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(PATH_LOGIN_DATA));
			String line = br.readLine();
			
			if(line == null) return savedLogin;
			
			String[] vect = line.split(",");
			savedLogin.setUser(vect[0]);
			savedLogin.setPassword(vect[1]);
			savedLogin.setDriverPath(vect[2]);
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return savedLogin;
	}

	public void saveLoginData(Login login) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(PATH_LOGIN_DATA));
			String line = br.readLine();
			
			if(line != null) return;
			
			FileWriter arq = new FileWriter(PATH_LOGIN_DATA);
			gravarArq = new PrintWriter(arq);
			gravarArq.print(login.toFormatedString());
			
			arq.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
