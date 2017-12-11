package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    WebDriver currentDriver;

    public int time = 30;

    Actions action = new Actions(currentDriver);

    final WebDriverWait wait = new WebDriverWait(currentDriver, time);

    BasePage(WebDriver driver) {
        currentDriver = driver;
    }

    public void click(WebElement element) {
        element.click();
    }

    public void sendKeys(WebElement element, String text) {
        element.sendKeys(text);
    }

    public void hover(WebElement element) {
        action.moveToElement(element).build().perform();
    }

    public void dragAndDropByLocation(WebElement element, int x, int y) {
        action.dragAndDropBy(element, x, y).build().perform();
    }
    
    public void dragAndDropByElement(WebElement draggable,WebElement droppable) {
        action.dragAndDrop(draggable,droppable).build().perform();
    }
    

    public void waitForVisibilityOf(final By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

}
