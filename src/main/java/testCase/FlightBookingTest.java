package testCase;

import apphelper.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class FlightBookingTest extends Driver{

    //WebDriver driver = new ChromeDriver();


    @Test
    public void testThatResultsAppearForAOneWayJourney() throws InterruptedException {
        try {
            //setDriverPath();: - done
            driver.get("https://www.cleartrip.com/");
            waitFor(2000);
            driver.findElement(By.id("OneWay")).click();

            driver.findElement(By.id("FromTag")).clear();
            driver.findElement(By.id("FromTag")).sendKeys("Bangalore");

            //wait for the auto complete options to appear for the origin

            waitFor(2000);
            List<WebElement> originOptions = driver.findElement(By.id("ui-id-1")).findElements(By.tagName("li"));
            originOptions.get(0).click();

            waitFor(2000);

            driver.findElement(By.id("ToTag")).click();
            driver.findElement(By.id("ToTag")).clear();
            driver.findElement(By.id("ToTag")).sendKeys("Delhi");

            //wait for the auto complete options to appear for the destination

            waitFor(2000);
            //select the first item from the destination auto complete list
            List<WebElement> destinationOptions = driver.findElement(By.id("ui-id-2")).findElements(By.tagName("li"));
            destinationOptions.get(0).click();


            driver.findElement(By.id("DepartDate")).click();
            WebElement dateWidget = driver.findElement(By.id("ui-datepicker-div"));
            List<WebElement> rows = dateWidget.findElements(By.tagName("tr"));
            List<WebElement> columns = dateWidget.findElements(By.tagName("td"));
            for (WebElement cell : columns) {
                //Select 21th Date
                if (cell.getText().equals("21")) {
                    cell.findElement(By.linkText("21")).click();
                    break;
                }
            }

            Select adults = new Select(driver.findElement(By.id("Adults")));
            adults.selectByVisibleText("2");
            driver.findElement(By.id("Adults")).sendKeys("2");
            //all fields filled in. Now click on search
            driver.findElement(By.id("SearchBtn")).click();

            waitFor(5000);
            //verify that result appears for the provided journey search
            Assert.assertTrue(isElementPresent(By.className("searchSummary")));

            //close the browser
            driver.quit();

        }
        catch (Exception e){
            System.out.println("Exception in testThatResultsAppearForAOneWayJourney method in FlightBookingTest"+e);
        }
    }


    private void waitFor(int durationInMilliSeconds) {
        try {
            Thread.sleep(durationInMilliSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }


    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    //move into Drive java class that is available in apphelper package
    /*private void setDriverPath() {
        if (PlatformUtil.isMac()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver");
        }
        if (PlatformUtil.isWindows()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        }
        if (PlatformUtil.isLinux()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver_linux");
        }
    }*/
}
