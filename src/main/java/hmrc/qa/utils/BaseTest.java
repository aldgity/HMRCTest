package hmrc.qa.utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.TestNG;
import org.testng.annotations.*;

public class BaseTest {
	
	public static WebDriver driver;
	Configuration config = new Configuration();
	
	@BeforeTest
	public void setup()
	{
		
		String chromeBinary = System.getProperty("user.dir") + "\\src\\resources\\binaries\\" + "chromedriver.exe"; 
		String baseUrl = "http://google-gruyere.appspot.com/432366167449";
		System.setProperty("webdriver.chrome.driver", chromeBinary);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-extensions");
		driver = new ChromeDriver(options);	
		driver.get(baseUrl);
	}
	
	@AfterTest
	public void teardown()
	{
		driver.quit();
	}
}
