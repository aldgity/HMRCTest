package hmrc.qa.tests;

import org.testng.Assert;
import org.testng.TestNG;
import org.testng.annotations.*;

import com.sun.jna.platform.win32.Advapi32Util.Account;
import com.thoughtworks.selenium.webdriven.commands.IsAlertPresent;

import bsh.Console;
import hmrc.qa.pages.GoogleAppspotHomePage;
import hmrc.qa.pages.LoginPage;
import hmrc.qa.pages.SignUpPage;
import hmrc.qa.pages.UserHomePage;
import hmrc.qa.utils.BaseTest;
import hmrc.qa.utils.*;

public class TestGoogleAppSpot extends BaseTest{
		
	User testUser ;
	
	@Test
	public void TestUserSignUp()
	{
		testUser = new User();
		testUser.generateUserNameAndPassword();
		GoogleAppspotHomePage.performAction().signUp();
		SignUpPage.performAction().createAccount(testUser.userName, testUser.passWord);
		String messageDisplayedonSignUp = SignUpPage.performAction().getDisplayedMessage();
		Assert.assertEquals(messageDisplayedonSignUp, "Account created.");
	}
		
	@Test()
	public void TestCreateNewSnippet()
	{
		String userName = "user1";
		String userPassword = "pass1";
		HtmlSnippet html = new HtmlSnippet();
		html.generateRandomnHtmlSnippetString();
		String SnippetToCreate = "<b>" + html.snippetString + "</b>";
		loginToGoogleAppspotWithUserNameAndPassword(userName, userPassword);
		CreateNewSnippetFromUserHomePage(SnippetToCreate);
		VerifySnippetCreatedinMySnippetsLink(html.snippetString);		
	}
	
	@Test
	public void TestUserSignUpWithExistingUser() 
	{
		String existingUserName = "user1";
		String userPassword = "pass145";
		GoogleAppspotHomePage.performAction().signUp();
		SignUpPage.performAction().createAccount(existingUserName, userPassword);
		String messageDisplayedonSignUp = SignUpPage.performAction().getDisplayedMessage();
		Assert.assertEquals(messageDisplayedonSignUp, "User already exists.");
	}


	private void VerifySnippetCreatedinMySnippetsLink(String snippet) 
	{
		boolean isSnippetDisplayed = UserHomePage.performAction().isSnippetDisplayedInMySnippets(snippet);
		Assert.assertEquals(isSnippetDisplayed, true);
	}

	private void loginToGoogleAppspotWithUserNameAndPassword(String username, String password) 
	{
		GoogleAppspotHomePage.performAction().signIn();
		LoginPage.performAction().Login(username, password);
		String displayedUser = UserHomePage.performAction().getUserDisplayedInPage();
		Assert.assertEquals(displayedUser, username + " <" + username + ">");
	}
	
	private void CreateNewSnippetFromUserHomePage(String snippet) 
	{
		UserHomePage.performAction().AddNewSnippet(snippet);
		
	}
}
