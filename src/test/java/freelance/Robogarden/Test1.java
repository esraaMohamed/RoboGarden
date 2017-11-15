package freelance.Robogarden;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Test1 {

    public WebDriver driver;

    public int time = 30;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.gecko.driver", "/Resources/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();

    }

    @Test
    public void test() throws InterruptedException {
        driver.get("https://qc.robogarden.ca/home");
        waitForVisibilityOf(By.xpath(".//*[@id='menuzord-right']/ul/li[8]/a"));
        driver.findElement(By.xpath(".//*[@id='menuzord-right']/ul/li[8]/a")).click();
        waitForVisibilityOf(By.xpath("html/body/div[2]/div/div[2]/section[2]/div/div[2]/div[1]/div/div[2]/div[2]/button[1]"));
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 600);");
        driver.findElement(By.xpath("html/body/div[2]/div/div[2]/section[2]/div/div[2]/div[1]/div/div[2]/div[2]/button[1]")).click();
        waitForVisibilityOf(By.xpath(".//*[@id='page-wrapper']/div/div/div[2]/div/a"));
        driver.findElement(By.xpath(".//*[@id='page-wrapper']/div/div/div[2]/div/a")).click();
        Thread.sleep(2000);
        waitForVisibilityOf(By.id("my_code"));
        driver.findElement(By.id("my_code")).click();
        Actions action = new Actions(driver);
        waitForVisibilityOf(By.cssSelector("g[class='blocklyDraggable']"));
        WebElement draggable = driver.findElement(By.cssSelector("g[class='blocklyDraggable']"));
        action.dragAndDropBy(draggable, 569, 403).build().perform();
        // action.dragAndDropBy(draggable, 569, 413).build().perform();
        driver.findElement(By.id("run_button")).click();
        waitForVisibilityOf(By.cssSelector(".close"));
        String success = driver.findElement(By.cssSelector(".modal-title.ng-binding")).getText();
        assertEquals(success, "Mission Accomplished");
        driver.findElement(By.id("check_answer_button")).click();
        // Journey 2
        waitForVisibilityOf(By.xpath(".//*[@id='page-wrapper']/div/div/div[2]/div/a"));
        driver.findElement(By.xpath(".//*[@id='page-wrapper']/div/div/div[2]/div/a")).click();
        Thread.sleep(2000);
        waitForVisibilityOf(By.id("my_code"));
        driver.findElement(By.id("my_code")).click();
        waitForVisibilityOf(By.cssSelector("g[class='blocklyDraggable']"));
        WebElement draggable1 = driver.findElement(By.cssSelector("g[class='blocklyDraggable']"));
        action.dragAndDropBy(draggable1, 569, 403).build().perform();
        action.dragAndDropBy(draggable1, 569, 413).build().perform();
        driver.findElement(By.id("run_button")).click();
        waitForVisibilityOf(By.cssSelector(".close"));
        String success1 = driver.findElement(By.cssSelector(".modal-title.ng-binding")).getText();
        assertEquals(success1, "Mission Accomplished");
        driver.findElement(By.id("check_answer_button")).click();
        // journey 3
        waitForVisibilityOf(By.xpath(".//*[@id='page-wrapper']/div/div/div[2]/div/a"));
        driver.findElement(By.xpath(".//*[@id='page-wrapper']/div/div/div[2]/div/a")).click();
        Thread.sleep(2000);
        waitForVisibilityOf(By.id("my_code"));
        driver.findElement(By.id("my_code")).click();
        waitForVisibilityOf(By.cssSelector("g[class='blocklyDraggable'"));
        List<WebElement> elements = driver.findElements(By.cssSelector("g[class='blocklyDraggable'"));
        System.out.println(elements.size());
        
        action.dragAndDropBy(elements.get(2), 569, 403).build().perform();
        action.dragAndDropBy(elements.get(1), 569, 413).build().perform();
        action.dragAndDropBy(elements.get(3), 559, 403).build().perform();
        
    }

    @AfterClass
    public void after() {
        // driver.close();
    }

    public void waitForVisibilityOf(final By locator) {
        final WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
