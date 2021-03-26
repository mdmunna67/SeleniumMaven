package example;		


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class NewTest {
    public static WebDriver driver; 


    @BeforeClass
    public void setUp(){
    	// System.setProperty("webdriver.chrome.driver", "C:\\Users\\rgcet\\Desktop\\SeleniumDocker project\\CRAFT_Selenium - Maven\\Browser Drivers\\chromedriver.exe");
        //  driver=new ChromeDriver();
        System.setProperty("webdriver.chrome.driver","/app/bin/chromedriver");
        ChromeOptions options = new ChromeOptions();
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("intl.accept_languages", "ja");
		options.setExperimentalOption("prefs", prefs);
        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        System.setProperty("webdriver.chrome.args", "--disable-logging");
        System.setProperty("webdriver.chrome.silentOutput", "true");
        options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
        options.addArguments("disable-infobars"); // disabling infobars
        options.addArguments("--disable-extensions"); // disabling extensions
        options.addArguments("--disable-gpu"); // applicable to windows os only
        options.addArguments("window-size=1024,768"); // Bypass OS security model
        //options.setCapability("chrome.verbose", false); //disable logging
        driver = new ChromeDriver(options);

}
   @Test 
    public static void TestFacebook() {
        try {
        	driver.get("http://demo.guru99.com/test/guru99home/");  
			String title = driver.getTitle();				 
			Assert.assertTrue(title.contains("Demo Guru99 Page")); 	
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



 @AfterClass
 public void tearDown(){
     driver.close();
     driver.quit();
 }

}
