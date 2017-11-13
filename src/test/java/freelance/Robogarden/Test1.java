package freelance.Robogarden;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
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

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.gecko.driver", "/Resources/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();

    }

    @Test
    public void test() throws InterruptedException {
        driver.get("https://qc.robogarden.ca/home");
        final WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='menuzord-right']/ul/li[8]/a")));
        driver.findElement(By.xpath(".//*[@id='menuzord-right']/ul/li[8]/a")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[2]/div/div[2]/section[2]/div/div[2]/div[1]/div/div[2]/div[2]/button[1]")));
        //WebElement element = driver.findElement(By.xpath("html/body/div[2]/div/div[2]/section[2]/div/div[2]/div[1]/div/div[2]/div[2]/button[1]"));
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 600);");
        Thread.sleep(500); 
        
        driver.findElement(By.xpath("html/body/div[2]/div/div[2]/section[2]/div/div[2]/div[1]/div/div[2]/div[2]/button[1]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='page-wrapper']/div/div/div[2]/div/a")));
        driver.findElement(By.xpath(".//*[@id='page-wrapper']/div/div/div[2]/div/a")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("my_code")));
        driver.findElement(By.id("my_code")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("my_code")));
        Actions action = new Actions(driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("g[class='blocklyDraggable']")));
        WebElement draggable = driver.findElement(By.cssSelector("g[class='blocklyDraggable']"));
        Thread.sleep(500); 
        action.dragAndDropBy(draggable, 569, 403).build().perform();
        action.dragAndDropBy(draggable, 569, 413).build().perform();
        WebElement run_button = driver.findElement(By.id("run_button"));
        run_button.click();
        Thread.sleep(500);

    }
    @AfterClass
    public void after(){
        //driver.close();
    }
}
