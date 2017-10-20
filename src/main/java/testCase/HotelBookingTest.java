package testCase;

import apphelper.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class HotelBookingTest extends Driver{

    // WebDriver driver = new ChromeDriver();

    @FindBy(linkText = "Hotels")
    private WebElement hotelLink;

    @FindBy(id = "Tags")
    private WebElement localityTextBox;

    //@FindBy(id = "travellersOnhome")
    @FindBy(xpath = ".//*[@id='travellersOnhome']")
    private WebElement travellerSelection;

    @FindBy(id="SearchHotelsButton")
    public WebElement searchButton;

    @Test
    public void shouldBeAbleToSearchForHotels() throws InterruptedException {
        //setDriverPath();

        driver.get("https://www.cleartrip.com/");
        HotelBookingTest hotelbook= PageFactory.initElements(driver,HotelBookingTest.class);
        hotelbook.hotelLink.click();
        hotelbook.localityTextBox.click();
        hotelbook.localityTextBox.clear();
        hotelbook.localityTextBox.sendKeys("Indiranagar, Bangalore");

        List<WebElement> originOptions = driver.findElement(By.id("ui-id-1")).findElements(By.tagName("li"));
        originOptions.get(1).click();

        for(int i=0;i<=2;i++){
            WebElement fromDate = driver.findElement(By.id("ui-datepicker-div"));
            List<WebElement> rows = fromDate.findElements(By.tagName("tr"));
            List<WebElement> columns = fromDate.findElements(By.tagName("td"));
            for(WebElement cell:columns){
                if (cell.getText().equals("23")){
                    cell.findElement(By.linkText("23")).click();
                    Thread.sleep(3000);
                    break;
                }}
            Thread.sleep(3000);
            WebElement toDate = driver.findElement(By.id("ui-datepicker-div"));
            List<WebElement> columns1 = toDate.findElements(By.tagName("td"));
            for(WebElement cell1:columns1){
                if(cell1.getText().equals("24")){
                    cell1.findElement(By.linkText("24")).click();
                    break;
                }

            }

        }
        /*for (WebElement cell : columns) {
            //Select 21th Date
            if (cell.getText().equals("21")) {
                cell.findElement(By.linkText("21")).click();

                    WebElement toDate=driver.findElement(By.id("ui-datepicker-div"));
                    List<WebElement> columns1 = toDate.findElements(By.tagName("td"));
                    for (WebElement cell1 : columns1) {
                        //Select 21th Date
                        if (cell1.getText().equals("23")) {
                            cell1.findElement(By.linkText("23")).click();
                            break;
                        }

                }
                break;
            }
        }*/
        //driver.findElement(By.xpath(".//*[@id='travellersOnhome']"));
        WebElement traveller= hotelbook.travellerSelection;
        Select travellers = new Select(traveller);
        traveller.click();
        travellers.selectByIndex(2);
        //driver.findElement(By.xpath("//input[@id='SearchHotelsButton']")).click();
        hotelbook.searchButton.click();
        driver.quit();

    }

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
