package db;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DbChallenge {
    private WebDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://jobs.deutschebahngroup.careers/");
    }

    @Test
    public void logIn() {
        WebElement login = driver.findElement(
                By.xpath("/html/body/div[1]/header/div[1]/div[2]/div/div/nav/ul/li[3]/a"));
        login.click();
        LogInPage loginPage = new LogInPage(driver);
        loginPage.setLogIn("sunita@test.com","Tester@12345");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Assert.assertEquals("Welcome",
                driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[1]/h2/span[1]")).getText());
    }

    @Test
    public void searchJobs() {
        SearchPage search = new SearchPage(driver);
        search.searchJobs("Test Engineer");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void applyFilters() {
        SearchPage filters = new SearchPage(driver);
        filters.applyFilters("Angola", "Bus Transport");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void createProfile() {
        WebElement createProfileLink = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/div/div[1]/a[2]"));
        createProfileLink.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        CreateProfilePage createProfilePage = new CreateProfilePage(driver);
        createProfilePage.createProfile(
                "Test1", "Demo1", "test123@demo.com", "Tester@12345", "Tester@12345", "Algeria", "Internationally across the DB Group", "Yes");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void jobAlertMessage() {
        WebElement job_alert = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/div/div[1]/a[3]"));
        job_alert.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        JobAlertPage alert = new JobAlertPage(driver);
        alert.jobAlerts("myName", "surname", "myName@test.de", "myName@12345", "myName@12345");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void languageSelection() {
        WebElement languageMenu = driver.findElement(
                By.xpath("/html/body/div/header/div[1]/div[2]/div/div/nav/ul/li[2]"));
        languageMenu.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        LanguageMenuPage language = new LanguageMenuPage(driver);
        language.setLanguageMenu("Nederlands");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
