package hmrc.qa.pages;


import java.util.ArrayList;
import java.util.List;
import java.util.PrimitiveIterator.OfDouble;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hmrc.qa.utils.BaseTest;

public class UserHomePage extends BaseTest{
	private WebDriver _driver = null;
    private static UserHomePage _objUserHomePage = null;
	
	@FindBy(xpath = "//a[text()='My Snippets']")
	private WebElement  mySnippetsLink;
	
	@FindBy(xpath = "//*[@id='menu-left']/a[3]")
	private WebElement newSnippetLink ;
	
	@FindBy(xpath = "//*[@id='menu-right']/span")
	private WebElement loggedinUser ;
	
	@FindBy(xpath = "//textarea[@name='snippet']")
	private WebElement snippetTextArea ;
	
	@FindBy(xpath = "//input[@type='submit' and @value='Submit']")
	private WebElement submitSnippetButton ;
	
	@FindBy(xpath = "//div[@class='content']/table/tbody/tr/td/div")
	private List<WebElement> mySnippetsList ;
	
	

	public UserHomePage(WebDriver inDriver)
	{
	    _driver = inDriver;
	    _driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	    
	public static UserHomePage performAction()
	{
		if (_objUserHomePage == null)
	    {
			_objUserHomePage = PageFactory.initElements(driver, UserHomePage.class);
	    }
	    return _objUserHomePage;
	}
	
	public String getUserDisplayedInPage()
	{
		return loggedinUser.getText();
	}
	
	public void AddNewSnippet(String snippet)
	{
		newSnippetLink.click();
		snippetTextArea.sendKeys(snippet);
		submitSnippetButton.click();
	}
	
	public boolean isSnippetDisplayedInMySnippets(String snippet)
	{
		boolean isDisplayed = false;
		System.out.println("number of snippets = " + mySnippetsList.size());
		for (WebElement Element : mySnippetsList) 
		{
			if (Element.getText().equals(snippet))
			{
				isDisplayed = true;
				break;
			}
		}
		return isDisplayed;
	}

}
