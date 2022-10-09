import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class Homework {

    private static WebDriver driver;
    public static final String CHROMEDRIVER_PATH = "/Users/shirazelbaz/Downloads/chromedriver";

    @BeforeClass
    public void beforerun(){
        System.setProperty("webdriver.chrome.driver", CHROMEDRIVER_PATH);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @Test
    public void test01_openWalla(){
        driver.get("https://www.walla.co.il/");
    }

    @Test
    public void test02_printTranslationBox(){
        driver.get("https://translate.google.com");
        System.out.println(driver.findElement(By.cssSelector("textarea[jsname=BJE2fc]")));
    }
    @Test
    public void test03_printYoutubeIconElement(){
        driver.get("https://www.youtube.com/");
        System.out.println(driver.findElement(By.cssSelector("yt-icon[id=\"logo-icon\"]")));

    }

    @Test
    public void test04_searchSelenium(){
        driver.get("http://www.seleniumhq.org/");
        WebElement searchButton = driver.findElement(By.cssSelector("span[class=\"DocSearch-Button-Container\"]"));
        searchButton.click();
        driver.findElement(By.cssSelector("input[enterkeyhint=\"search\"]")).sendKeys("selenium");

    }

    @Test
    public void test05_searchOnAmazon(){
        driver.get("https://www.amazon.com/");
        Assert.assertEquals(driver.getTitle(), "Amazon.com. Spend less. Smile more.");
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("iphone tripod");
        searchBox.submit();


    }

    @Test
    public void test06_insertHebrew() {
        driver.get("https://translate.google.com");
        driver.findElement(By.cssSelector("textarea[jsname=\"BJE2fc\"]")).sendKeys("שלום");
    }

    @Test
    public void test07_searchSong(){
        driver.get("https://www.youtube.com/");
        WebElement searchBox = driver.findElement(By.cssSelector("input[id=\"search\"]"));
        searchBox.sendKeys("gravity john mayer");

    }


    @AfterClass
    public void After(){
        driver.quit();
    }
}
