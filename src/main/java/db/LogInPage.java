package db;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage {
    private WebDriver driver;

    @FindBy(id = "tpt_loginUsername")
    WebElement emailAddress;
    @FindBy(id = "tpt_loginPassword")
    WebElement password;
    @FindBy(name = "login")
    WebElement signInButton;

    public LogInPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setLogIn(String emailAddress, String password) {
        this.emailAddress.clear();
        this.emailAddress.sendKeys(emailAddress);
        this.password.clear();
        this.password.sendKeys(password);
        this.signInButton.click();
    }
}
