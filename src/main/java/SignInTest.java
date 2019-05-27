package TestNg;
import com.sun.javafx.PlatformUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SignInTest {
	public static WebDriver driver;
    
 @BeforeTest
        public void launchbrowser(){
	    setDriverPath();
         driver = new ChromeDriver();
    }

 @Test
    public void shouldThrowAnErrorIfSignInDetailsAreMissing() {

        driver.get("https://www.cleartrip.com/");
        driver.manage().window().maximize();
        waitFor(2000);

        driver.findElement(By.linkText("Your trips")).click();
        driver.findElement(By.id("SignIn")).click();
        waitFor(1000);
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("driver.findElement(By.id('signInButton')).click();");
        waitFor(1000);
        String errors1 = driver.findElement(By.id("errors1")).getText();
        Assert.assertTrue(errors1.contains("There were errors in your submission"));
        Reporter.log("Test Case is passed");
     }
    
    @AfterTest()
   public void TearDown(){
    	 
           driver.quit();
    }

    private void waitFor(int durationInMilliSeconds) {
        try {
            Thread.sleep(durationInMilliSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();  
        }
    }

    private void setDriverPath() {
        if (PlatformUtil.isMac()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver");
        }
        if (PlatformUtil.isWindows()) {
            System.setProperty("webdriver.chrome.driver", "C:/Users/PRAVISHTHA JAIN/eclipse-workspace/chromedriver.exe");
        }
        if (PlatformUtil.isLinux()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver_linux");
        }
    }

	public static void main(String[] args) {
		chromedriver.exe
	}


}
