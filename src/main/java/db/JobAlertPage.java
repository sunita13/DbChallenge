package db;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class JobAlertPage {
    private WebDriver driver;
    @FindBy(id = "884")
    WebElement firstName;
    @FindBy(id = "885")
    WebElement lastName;
    @FindBy(id = "886")
    WebElement emailId;
    @FindBy(id = "887")
    WebElement password;
    @FindBy(id = "888")
    WebElement confirmPassword;
    @FindBy(id = "107-save")
    WebElement submitButton;
    @FindBy(id = "147747-submit")
    WebElement submitNewAlert;

    public JobAlertPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void jobAlerts(String fName, String lName, String email, String pwd, String confirmPwd) {
        this.firstName.sendKeys(fName);
        this.lastName.sendKeys(lName);
        this.emailId.sendKeys(email);
        this.password.sendKeys(pwd);
        this.confirmPassword.sendKeys(confirmPwd);
        this.submitButton.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        this.submitNewAlert.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

}
