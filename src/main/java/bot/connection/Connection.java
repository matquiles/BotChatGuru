package bot.connection;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import bot.entities.Login;
import bot.ui.components.DateFormater;

public class Connection {

	private static final String PATH_TABLE = "//*[@id=\"tags_table\"]";
	private static final String PATH_TABLE2 = "//*[@id=\"tags_table\"]/tbody/tr";
	private static final String BT_GERAR_RELATORIO = "/html/body/div[2]/div/div[2]/div[2]/div/form/div[2]/div/button";
	private static final String DT_FINAL = "/html/body/div[2]/div/div[2]/div[2]/div/form/div[1]/div[2]/div/div[3]/input";
	private static final String DT_INICIAL = "/html/body/div[2]/div/div[2]/div[2]/div/form/div[1]/div[2]/div/div[2]/input";
	private static final String EXTRAIR_LISTA = "//*[@id=\"accesses_report_form\"]/div[1]/div[2]/div/div[1]/span/div/ul/li";
	private static final String PATH_LISTA_USUARIOS = "/html/body/div[2]/div/div[2]/div[2]/div/form/div[1]/div[2]/div/div[1]/span/div/button";
	private static final String PATH_BT_ACESSOS = "/html/body/div[1]/ul/li[3]/div/a[1]";
	private static final String PATH_BT_RELATORIO = "/html/body/div[1]/ul/li[3]/a";
	private static final String PATH_SENHA = "/html/body/div/div[2]/div/div/div[2]/form/div[2]/input";
	private static final String PATH_LOGIN = "/html/body/div/div[2]/div/div/div[2]/form/div[1]/input";
	private static final String LINK_CHAT_GURU = "https://app4.zap.guru/login";
	
	public Connection() {
	}
	
	public void connect(Login login) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", login.getDriverPath());
		ChromeDriver driver = new ChromeDriver ();
		Thread.sleep(2000);
		driver.manage().window().maximize();
		driver.get(LINK_CHAT_GURU);
		executeBot(driver, login);
		
//		driver.close();
		
	}
	
	private void executeBot(ChromeDriver driver, Login login) throws InterruptedException {
		
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
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(PATH_BT_ACESSOS)));
		WebElement elementCbAutor = driver.findElement(By.xpath(PATH_BT_ACESSOS));
		elementCbAutor.click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(PATH_LISTA_USUARIOS)));
		WebElement listUsuariuos = driver.findElement(By.xpath(PATH_LISTA_USUARIOS));
		listUsuariuos.click();
		
		selectUsersInComboBox(driver);
		listUsuariuos.click();
		
		WebElement btDtInicial = driver.findElement(By.xpath(DT_INICIAL));
		btDtInicial.sendKeys(DateFormater.getYesterday());
		
		WebElement btDtFinal = driver.findElement(By.xpath(DT_FINAL));
		btDtFinal.sendKeys(DateFormater.getYesterday());
		
		WebElement btGerarRelatorio = driver.findElement(By.xpath(BT_GERAR_RELATORIO));
		btGerarRelatorio.click();
		
		Thread.sleep(2000);
		getTable(driver);
		
		
	}


	private void selectUsersInComboBox(ChromeDriver driver) {

		List<WebElement> elements = (new WebDriverWait(driver, Duration.ofSeconds(5l)))
									.until(ExpectedConditions
									.visibilityOfAllElementsLocatedBy(By.xpath(EXTRAIR_LISTA)));

		for (WebElement cb : elements) {
			cb.click();
		}

	}
	
	private void getTable(ChromeDriver driver) {
		
		WebElement table = driver.findElement(By.xpath(PATH_TABLE));
		List<WebElement> rowList = table.findElements(By.tagName("tr"));
		
		List<WebElement> columnsList = null ;
		
		for (WebElement row : rowList) {
			System.out.println();
			columnsList = row.findElements(By.tagName("td"));
			
			for (WebElement column : columnsList) {
				System.out.println(column.getText()+ ",");
			}
			
		}
	}
	
}
