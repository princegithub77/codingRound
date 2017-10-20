package testCase;

import apphelper.Driver;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;


public class SignInTest extends Driver {

    //WebDriver driver = new ChromeDriver(); done in Drive java class that is inside apphelper package

    @Test
    public void shouldThrowAnErrorIfSignInDetailsAreMissing() {
        try {

            //setDriverPath(); done

            driver.get("https://www.cleartrip.com/");
            waitFor(2000);

            driver.findElement(By.linkText("Your trips")).click();
            driver.findElement(By.id("SignIn")).click();

            driver.switchTo().frame("modal_window");

            driver.findElement(By.id("signInButton")).click();

            String errors1 = driver.findElement(By.id("errors1")).getText();
            Assert.assertTrue(errors1.contains("There were errors in your submission"));
            driver.quit();

            // create page factory
           /*SignIn login = PageFactory.initElements(driver, SignIn.class);
           login.your_trips.click();
           login.signIn.click();
           driver.switchTo().frame(login.iframe);
           login.signInButton.click();
           String error_Text=login.error_Message.get(0).getText();
           System.out.println(error_Text);
           Assert.assertTrue(error_Text.contains("There were errors in your submission"));*/
        }
        catch (Exception e){
            System.out.println("Exception in shouldThrowAnErrorIfSignInDetailsAreMissing method in SignInText"+e);

        }

    }

    private void waitFor(int durationInMilliSeconds) {
        try {
            Thread.sleep(durationInMilliSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

   /* private void setDriverPath() {
        if (PlatformUtil.isMac()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver");
        }
        if (PlatformUtil.isWindows()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        }
        if (PlatformUtil.isLinux()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver_linux");
        }
    }
*/

}
