package hmrc.qa.utils;
import org.apache.commons.lang.RandomStringUtils;

public class User {
	public String userName;
	public String passWord;
	RandomStringUtils objRandomn ; 
	
	public void generateUserNameAndPassword()
	{
		objRandomn = new RandomStringUtils();
		userName = objRandomn.randomAlphanumeric(10);
		passWord = objRandomn.randomAlphanumeric(6);
	}
}
