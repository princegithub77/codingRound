package pageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by prince on 20/10/17.
 */
public class Signin {
    @FindBy(linkText = "Your trips")
    public WebElement your_trips;

    @FindBy(id = "SignIn")
    public WebElement signIn;

    @FindBy(id = "modal_window")
    public WebElement iframe;

    @FindBy(id = "email")
    public WebElement userName;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(id = "signInButton")
    public WebElement signInButton;

    @FindBy(id = "errors1")
    public List<WebElement> error_Message;


}
