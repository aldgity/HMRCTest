package hmrc.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hmrc.qa.utils.BaseTest;

public class LoginPage extends BaseTest{
	
	private WebDriver _driver = null;
    private static LoginPage _objLoginPage = null;
	
	@FindBy(xpath = "//input[@name='uid']")
	private WebElement userNameTextField ;
	
	@FindBy(xpath = "//input[@name='pw']")
	private WebElement passwordTextField ;
	
	@FindBy(xpath = "//input[@type='submit' and @value='Login']")
	private WebElement loginButton ;
	
	public LoginPage(WebDriver inDriver)
	{
	    _driver = inDriver;
	    _driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	    
	public static LoginPage performAction()
	{
		if (_objLoginPage == null)
	    {
			_objLoginPage = PageFactory.initElements(driver, LoginPage.class);
	    }
	    return _objLoginPage;
	}
	
	public void Login(String username, String password)
	{
		userNameTextField.sendKeys(username);
		passwordTextField.sendKeys(password);
		loginButton.click();
	}
}
