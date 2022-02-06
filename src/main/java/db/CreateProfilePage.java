package db;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class CreateProfilePage {
    private WebDriver driver;

    //@FindBy(xpath = "//*[@id=\\\"mainContent\\\"]/div/div[1]/div[1]/div[3]/div/div[2]/div/div/a")
    //WebElement inputYourData;
    @FindBy(id = "1450")
    WebElement firstName;
    @FindBy(id = "1451")
    WebElement lastName;
    @FindBy(id = "1453")
    WebElement email;
    @FindBy(id = "1464")
    WebElement passwd;
    @FindBy(id = "1465")
    WebElement confirmPasswd;
    @FindBy(xpath = "//*[@id=\"ui-widget_152359\"]/span/span[1]/span")
    WebElement countriesOfInterest;
    @FindBy(id = "select2-152359-results")
    WebElement countries;
    @FindBy(id = "1475")
    WebElement privacyPolicy;
    @FindBy(id = "1478")
    WebElement shareMyData;
    @FindBy(id = "120903")
    WebElement suitablePosition;
    @FindBy(id = "1480-save")
    WebElement saveAndNext;
    @FindBy(id = "792-save")
    WebElement applyButton1;

    public CreateProfilePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void createProfile(String fName, String lName, String eMail, String pwd, String confirmPwd,
                              String countryName, String myData, String position) {
        WebElement input_your_data = driver.findElement(
                By.xpath("//*[@id=\"mainContent\"]/div/div[1]/div[1]/div[3]/div/div[2]/div/div/a"));
        input_your_data.click();
        this.firstName.sendKeys(fName);
        this.lastName.sendKeys(lName);
        this.email.sendKeys(eMail);
        this.passwd.sendKeys(pwd);
        this.confirmPasswd.sendKeys(confirmPwd);
        this.countriesOfInterest.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        List<WebElement> countryList = countries.findElements(By.tagName("li"));
        for(WebElement country : countryList){
            if(country.getText().equals(countryName)){
                country.click();
                break;
            }
        }
        this.privacyPolicy.click();
        Select myDataDropDown = new Select(shareMyData);
        myDataDropDown.selectByVisibleText(myData);

        Select positionDropdown = new Select(suitablePosition);
        positionDropdown.selectByVisibleText(position);
        this.saveAndNext.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        this.applyButton1.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
}
