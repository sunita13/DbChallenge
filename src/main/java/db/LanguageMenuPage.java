package db;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LanguageMenuPage {
    private WebDriver driver;

    @FindBy(xpath = "/html/body/div/header/div[1]/div[2]/div/div/nav/ul/li[2]/ul")
    WebElement languageDropDown;


    public LanguageMenuPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void setLanguageMenu(String langOption){
        List<WebElement> langList = languageDropDown.findElements(By.tagName("li"));

        for(WebElement jobDropdown : langList) {
            if (jobDropdown.getText().equals(langOption)) {
                jobDropdown.click();
                break;
            }
        }


    }


}
