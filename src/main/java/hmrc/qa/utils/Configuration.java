package hmrc.qa.utils;
import java.io.FileInputStream;
import java.util.Properties;

public class Configuration {
	private static Properties prop;
	private static String propertiesResourcePath ="src\\resources\\properties\\";
	private static String frameworkPropertiesFilename ="framework.properties";
	
	public Configuration()
	{
		Configuration.loadProperties();
	}
	
	public static Properties getProp()
	{
		return prop;
	}
	
	private static void loadProperties()
	{
		try {
			if(prop == null)
			{
				prop = new Properties();
				prop.load(new FileInputStream(propertiesResourcePath + frameworkPropertiesFilename));
			}
			
		} catch(Exception e)
		{
			
		}
	}
}
