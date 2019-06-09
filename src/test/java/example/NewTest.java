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
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\rgcet\\Desktop\\SeleniumDocker project\\CRAFT_Selenium - Maven\\Browser Drivers\\chromedriver.exe");
         driver=new ChromeDriver();

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
