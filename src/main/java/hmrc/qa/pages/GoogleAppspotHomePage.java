package hmrc.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hmrc.qa.utils.BaseTest;

public class GoogleAppspotHomePage extends BaseTest{
	
	private WebDriver _driver = null;
    private static GoogleAppspotHomePage _objGoogleAppspotHomePage = null;
	
	@FindBy(xpath = "//a[text()='Sign up']")
	private WebElement signUpButton ;
	
	@FindBy(xpath = "//a[text()='Sign in']")
	private WebElement signInButton ;
	
    public GoogleAppspotHomePage(WebDriver inDriver)
    {
        _driver = inDriver;
        _driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    
    public static GoogleAppspotHomePage performAction()
    {
    	if (_objGoogleAppspotHomePage == null)
            {
    			_objGoogleAppspotHomePage = PageFactory.initElements(driver, GoogleAppspotHomePage.class);
            }
            return _objGoogleAppspotHomePage;
    }
    
    public void signUp()
    {
    	signUpButton.click();
    }
    
    public void signIn()
    {
    	signInButton.click();
    }
	
}
