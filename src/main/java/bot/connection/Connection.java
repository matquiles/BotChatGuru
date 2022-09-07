package bot.connection;

import java.time.Duration;
import java.util.HashSet;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import bot.entities.Login;
import bot.entities.Person;

public class Connection {

	private static final String PATH_CB_AUTOR = "/html/body/div[2]/div/div[2]/div[2]/div/form/div[1]/div[2]/div[1]/div[1]/span/div/button";
	private static final String PATH_BT_MENSAGENS = "/html/body/div[1]/ul/li[3]/div/a[3]";
	private static final String PATH_BT_RELATORIO = "/html/body/div[1]/ul/li[3]/a";
	private static final String PATH_SENHA = "/html/body/div/div[2]/div/div/div[2]/form/div[2]/input";
	private static final String PATH_LOGIN = "/html/body/div/div[2]/div/div/div[2]/form/div[1]/input";
	private static final String LINK_CHAT_GURU = "https://app4.zap.guru/login";
	private static final String CHROME_DRIVER_PATH = "../bot/src/main/resources/chromedriver"; 
	
	public Connection() {
	}
	
	public void connect(Login login) throws InterruptedException {
		
		Set<Person> people = new HashSet<>();
		
		System.setProperty("webdriver.chrome.driver", login.getDriverPath());
		ChromeDriver driver = new ChromeDriver ();
		Thread.sleep(2000);
		driver.get(LINK_CHAT_GURU);
		
		executeBot(driver, login);
		
//		driver.close();
		
	}
	
	private void executeBot(ChromeDriver driver, Login login) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5l));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(PATH_LOGIN)));
		WebElement elementEmail = driver.findElement(By.xpath(PATH_LOGIN));
		elementEmail.sendKeys(login.getUser());
		
		WebElement elementSenha = driver.findElement(By.xpath(PATH_SENHA));
		elementSenha.sendKeys(login.getPassword());
		elementSenha.submit();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(PATH_BT_RELATORIO)));
		WebElement elementBtRelatorio = driver.findElement(By.xpath(PATH_BT_RELATORIO));
		elementBtRelatorio.click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(PATH_BT_MENSAGENS)));
		WebElement elementBtMensagens = driver.findElement(By.xpath(PATH_BT_MENSAGENS));
		elementBtMensagens.click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(PATH_CB_AUTOR)));
		WebElement elementCbAutor = driver.findElement(By.xpath(PATH_CB_AUTOR));
		elementCbAutor.click();
	}
}
