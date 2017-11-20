package freelance.Robogarden;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + File.separator + "Resources" + File.separator + "chromedriver");

        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @Test
    public void test() throws InterruptedException {
        driver.get("https://www.robogarden.ca/home");
        waitForVisibilityOf(By.xpath(".//*[@id='menuzord-right']/ul/li[8]/a"));
        driver.findElement(By.xpath(".//*[@id='menuzord-right']/ul/li[8]/a")).click();
        Thread.sleep(5000);
        waitForVisibilityOf(By.xpath("html/body/div[2]/div/div[2]/section[2]/div/div[2]/div[1]/div/div[2]/div[2]/button[1]"));
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 600);");
        Thread.sleep(5000);
        driver.findElement(By.xpath("html/body/div[2]/div/div[2]/section[2]/div/div[2]/div[1]/div/div[2]/div[2]/button[1]")).click();
        waitForVisibilityOf(By.xpath(".//*[@id='page-wrapper']/div/div/div[2]/div/a"));
        driver.findElement(By.xpath(".//*[@id='page-wrapper']/div/div/div[2]/div/a")).click();
        waitForVisibilityOf(By.cssSelector("div[class='enjoyhint_close_btn']"));
        driver.findElement(By.cssSelector("div[class='enjoyhint_close_btn']")).click();
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
        // waitForVisibilityOf(By.id("my_code"));
        // driver.findElement(By.id("my_code")).click();
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
        // waitForVisibilityOf(By.id("my_code"));
        // driver.findElement(By.id("my_code")).click();
        waitForVisibilityOf(By.cssSelector("g[class='blocklyDraggable']"));
        List<WebElement> elements = driver.findElements(By.cssSelector("g[class='blocklyDraggable']"));
        // System.out.println(elements.size());
        // driver.findElement(By.cssSelector("g[class='blocklyEditableText'")).click();
        WebElement element = driver.findElement(By.cssSelector("g[class='blocklyEditableText']"));
        action.moveToElement(element);
        action.click();
        action.sendKeys("8");
        action.build().perform();
        // Point p = elements.get(0).getLocation();
        // System.out.println(p.x);
        // System.out.println(p.y);
        action.dragAndDropBy(elements.get(1), elements.get(0).getLocation().x, elements.get(0).getLocation().y - 100).build().perform();
        action.dragAndDropBy(elements.get(3), elements.get(0).getLocation().x + 5, elements.get(0).getLocation().y - 270).build().perform();
        driver.findElement(By.id("run_button")).click();
        waitForVisibilityOf(By.cssSelector(".close"));
        String success2 = driver.findElement(By.cssSelector(".modal-title.ng-binding")).getText();
        assertEquals(success2, "Mission Accomplished");
        driver.findElement(By.id("check_answer_button")).click();
        // Journey 4
        waitForVisibilityOf(By.xpath(".//*[@id='page-wrapper']/div/div/div[2]/div/a"));
        driver.findElement(By.xpath(".//*[@id='page-wrapper']/div/div/div[2]/div/a")).click();
        Thread.sleep(2000);
        waitForVisibilityOf(By.cssSelector("g[class='blocklyDraggable'"));
        List<WebElement> elements1 = driver.findElements(By.cssSelector("g[class='blocklyDraggable']"));
        action.dragAndDropBy(elements1.get(3), elements1.get(2).getLocation().x - 50, elements1.get(2).getLocation().y - 100).build().perform();
        action.dragAndDropBy(elements1.get(3), elements1.get(2).getLocation().x - 30, elements1.get(2).getLocation().y - 100).build().perform();
        driver.findElement(By.id("run_button")).click();
        waitForVisibilityOf(By.cssSelector(".close"));
        String success3 = driver.findElement(By.cssSelector(".modal-title.ng-binding")).getText();
        assertEquals(success3, "Mission Accomplished");
        driver.findElement(By.id("check_answer_button")).click();
        // Journey 5
        waitForVisibilityOf(By.xpath(".//*[@id='page-wrapper']/div/div/div[2]/div/a"));
        driver.findElement(By.xpath(".//*[@id='page-wrapper']/div/div/div[2]/div/a")).click();
        Thread.sleep(2000);
        waitForVisibilityOf(By.cssSelector("g[class='blocklyDraggable'"));
        List<WebElement> elements2 = driver.findElements(By.cssSelector("g[class='blocklyDraggable']"));
        action.dragAndDropBy(elements2.get(11), elements2.get(8).getLocation().x - 50, elements2.get(8).getLocation().y - 200).build().perform();
        action.dragAndDropBy(elements2.get(9), elements2.get(8).getLocation().x - 50, elements2.get(8).getLocation().y - 70).build().perform();
        action.dragAndDropBy(elements2.get(9), elements2.get(8).getLocation().x - 50, elements2.get(8).getLocation().y - 50).build().perform();
        action.dragAndDropBy(elements2.get(11), elements2.get(8).getLocation().x - 50, elements2.get(8).getLocation().y - 120).build().perform();
        action.dragAndDropBy(elements2.get(9), elements2.get(8).getLocation().x - 50, elements2.get(8).getLocation().y).build().perform();
        action.dragAndDropBy(elements2.get(9), elements2.get(8).getLocation().x - 50, elements2.get(8).getLocation().y + 20).build().perform();
        action.dragAndDropBy(elements2.get(9), elements2.get(8).getLocation().x - 50, elements2.get(8).getLocation().y + 40).build().perform();
        action.dragAndDropBy(elements2.get(9), elements2.get(8).getLocation().x - 50, elements2.get(8).getLocation().y + 60).build().perform();
        action.dragAndDropBy(elements2.get(9), elements2.get(8).getLocation().x - 50, elements2.get(8).getLocation().y + 80).build().perform();
        driver.findElement(By.id("run_button")).click();
        waitForVisibilityOf(By.cssSelector(".close"));
        String success4 = driver.findElement(By.cssSelector(".modal-title.ng-binding")).getText();
        assertEquals(success4, "Mission Accomplished");
        driver.findElement(By.id("check_answer_button")).click();
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
