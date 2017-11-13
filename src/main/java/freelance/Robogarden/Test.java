package freelance.Robogarden;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test

public class Test1 {
    
 public WebDriver driver= new FirefoxDriver();
 
 @Test
 public void test(){
     driver.get("https://qc.robogarden.ca/index/mission/57/282?journey_id=8");
     
 }
}
