package freelance.Robogarden;

import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Regression {

    public WebDriver driver;

    public int time = 30;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.gecko.driver", "/Resources/geckodriver");
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + File.separator + "Resources" + File.separator + "chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://qc.rgp-dev.com/home");

    }

    @Test
    public void test() throws InterruptedException {
        waitForVisibilityOf(By.xpath(".//*[@id='menuzord-right']/ul/li[7]/a"));
        driver.findElement(By.xpath(".//*[@id='menuzord-right']/ul/li[7]/a")).click();
        waitForVisibilityOf(By.id("username-login"));
        driver.findElement(By.id("username-login")).sendKeys("maged123456");
        driver.findElement(By.id("password-login")).sendKeys("maged123456");
        driver.findElement(By.id("login-popup")).click();
        waitForVisibilityOf(By.xpath(".//*[@id='page-wrapper']/div[2]/div/div/section[2]/div/div/div[1]/div/div[1]/div/div[1]"));
        String playNowId = driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[2]/div/div/section[2]/div/div/div[1]/div/div[1]/div/div[1]"))
                .getAttribute("id");
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[2]/div/div/section[2]/div/div/div[1]/div/div[1]/div/div[1]"))).build()
                .perform();
        driver.findElement(By.id(playNowId)).click();
        try {
            waitForVisibilityOf(By.cssSelector(".enjoyhint_close_btn"));
            driver.findElement(By.cssSelector(".enjoyhint_close_btn")).click();
        } catch (Exception e) {
            System.out.println("Hint was shown before");
        }
        try {
            List<WebElement> dots = driver.findElements(By.cssSelector(".slick-dots>li"));
            dots.get(0).click();
        } catch (Exception e) {
            System.out.println("User is on first mission");
        }

        List<WebElement> missions = driver.findElements(By.cssSelector("div[class='unlocked_class zoom_in_hover']"));
        missions.get(0).click();
        for (int i = 0; i < missions.size(); i++) {
            // every 5 missions will do the following
            if (i != 0 && i % 5 == 0) {
                waitForVisibilityOf(By.cssSelector(".slick-next"));
                driver.findElement(By.cssSelector(".slick-next")).click();
                List<WebElement> mission = driver.findElements(By.cssSelector("div[class='unlocked_class zoom_in_hover']"));
                mission.get(i).click();

            }
            waitForVisibilityOf(By.cssSelector(".close.ng-scope"));
            driver.findElement(By.cssSelector(".close.ng-scope")).click();
            driver.findElement(By.id("actions")).click();
            driver.findElement(By.id("modelanswer")).click();
            driver.findElement(By.id("run_button")).click();
            waitForVisibilityOf(By.id("check_answer_button"));
            driver.findElement(By.id("check_answer_button")).click();

        }

    }

    public void waitForVisibilityOf(final By locator) {
        final WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
