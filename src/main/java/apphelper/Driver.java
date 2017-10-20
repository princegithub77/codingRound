package apphelper;

import com.sun.javafx.PlatformUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/**
 * Created by prince on 20/10/17.
 */
public class Driver {
    public static WebDriver driver;
    private static Logger logger = Logger.getLogger(Driver.class.getName());



    /*@BeforeMethod
    public void startDriver(Method method) throws IOException {
        //ReportUtil.startTest(method.getName());
        //System.setProperty("webdriver.chrome.driver", "E:\\glider-automation\\src\\test\\java\\glider\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        // driver=new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(300, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(300, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }*/
    @BeforeMethod
    public void Driver(Method method) throws IOException{
        if (PlatformUtil.isMac()) {
            //System.setProperty("webdriver.chrome.driver", "chromedriver");
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(300, TimeUnit.SECONDS);
            driver.manage().timeouts().setScriptTimeout(300, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }
        if (PlatformUtil.isWindows()) {
            //System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(300, TimeUnit.SECONDS);
            driver.manage().timeouts().setScriptTimeout(300, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }
        if (PlatformUtil.isLinux()) {
            //System.setProperty("webdriver.chrome.driver", "chromedriver_linux");
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(300, TimeUnit.SECONDS);
            driver.manage().timeouts().setScriptTimeout(300, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }
    }

}
