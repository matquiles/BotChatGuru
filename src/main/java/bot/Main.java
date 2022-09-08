package bot;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import bot.ui.LoginScreen;

public class Main {

	public static void main(String[] args) throws IOException  {
		
		checkArquivoLogin();
		new LoginScreen("Insira seu login e senha no ChatGuru", 600, 250);
	}

	private static void checkArquivoLogin() throws IOException {

		String filePath = "C:\\Bot_Files";
		Path path = Paths.get(filePath);
		boolean exists = Files.exists(path);

		if(!exists) {
			Files.createDirectory(path);

			FileWriter fileWriter = new FileWriter("C:/Bot_Files/login.txt");
			fileWriter.close();
		}
	}

}
