package hmrc.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hmrc.qa.utils.BaseTest;

public class SignUpPage extends BaseTest{
	
	private WebDriver _driver = null;
    private static SignUpPage _objSignUpPage = null;
	
	@FindBy(xpath = "//input[@name='uid']")
	private WebElement userNameTextField ;
	
	@FindBy(xpath = "//input[@name='pw']")
	private WebElement passwordTextField ;
	
	@FindBy(xpath = "//input[@type='submit' and @value='Create account']")
	private WebElement createAccountButton ;

	@FindBy(xpath = "//div[@class='message']")
	private WebElement messageDiaplyed ;
	
	public SignUpPage(WebDriver inDriver)
	{
	    _driver = inDriver;
	    _driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	    
	public static SignUpPage performAction()
	    {
	    	if (_objSignUpPage == null)
	            {
	    			_objSignUpPage = PageFactory.initElements(driver, SignUpPage.class);
	            }
	            return _objSignUpPage;
	    }
	    
	    
	    public void createAccount(String username, String password)
	    {
	    	userNameTextField.sendKeys(username);
	    	passwordTextField.sendKeys(password);
	    	createAccountButton.click();
	    }
	    
	    public String getDisplayedMessage()
	    {
	    	return messageDiaplyed.getText();
	    }


}
