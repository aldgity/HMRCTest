package hmrc.qa.utils;

import org.apache.commons.lang.RandomStringUtils;

public class HtmlSnippet {
	
	RandomStringUtils objRandomn;
	public String snippetString;
	
	public void generateRandomnHtmlSnippetString()
	{
		objRandomn = new RandomStringUtils();
		snippetString = objRandomn.randomAlphanumeric(50);
	}
}