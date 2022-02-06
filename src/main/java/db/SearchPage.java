package db;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.List;

public class SearchPage {
    private WebDriver driver;

    @FindBy(xpath = "/html/body/div/header/div/div[2]/div/div/nav/ul/li[1]/a")
    WebElement jobSearch;
    @FindBy(id = "155704")
    WebElement enterKeyword;
    @FindBy(id = "155705-submit")
    WebElement searchButton;
    @FindBy(xpath = "//*[@id=\"tpt_jobSortableForm\"]/a[1]")
    WebElement location;
    @FindBy(id = "select2-3_387_3-container")
    WebElement country;
    @FindBy(id = "select2-3_387_3-results")
    WebElement countryList;
    @FindBy(xpath = "//*[@id=\"tpt_jobSortableForm\"]/a[4]")
    WebElement jobGroup;
    @FindBy(id = "3_57_3")
    WebElement jobOptions;
    @FindBy(id = "select2-3_116_3-results")
    WebElement jobLists;
    @FindBy(xpath = "//*[@id=\"tpt_jobSortableForm\"]/div/div/button")
    WebElement applyFilterButton;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void searchJobs(String enterKeyword) {
        this.enterKeyword.clear();
        this.enterKeyword.sendKeys(enterKeyword);
        this.searchButton.click();
    }
    public void applyFilters(String location, String jobOption) {
        setLocation(location);
        setJobGroup(jobOption);
    }
    public void setLocation(String location) {
        this.location.click();
        this.country.click();
        this.countryList.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        List<WebElement> countryListDropDown = countryList.findElements(By.tagName("li"));

        for(WebElement countries : countryListDropDown) {
            if (countries.getText().equals(location)) {
                countries.click();
                break;
            }
        }
    }
    public void setJobGroup(String jobOption) {
            this.jobGroup.click();
            WebElement jobOptions = driver.findElement(By.id("3_116_3-search__field"));
            jobOptions.click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            List<WebElement> jobList = jobLists.findElements(By.tagName("li"));

            for(WebElement jobDropdown : jobList) {
                if (jobDropdown.getText().equals(jobOption)) {
                    jobDropdown.click();
                    break;
                }
            }
            this.applyFilterButton.click();
    }

}
