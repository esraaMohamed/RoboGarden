package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

    @FindBy(xpath = ".//*[@id='menuzord-right']/ul/li[7]/a")
    private WebElement loginButton;

    @FindBy(id = "username-login")
    private WebElement userName;

    @FindBy(id = "password-login")
    private WebElement password;
    
    @FindBy(id = "login-popup")
    private WebElement login;
    
    @FindBy(xpath = ".//*[@id='page-wrapper']/div[2]/div/div/section[2]/div/div/div[1]/div/div[1]/div/div[1]")
    private WebElement journey;
    
    @FindBy(css = ".enjoyhint_close_btn")
    private WebElement hintClose;
    
    @FindBy(css = ".slick-dots>li")
    private WebElement slickDots;
    
    @FindBy(id = "mission00")
    private WebElement firstMission;
    
    @FindBy(css = "div[class='unlocked_class zoom_in_hover']")
    private WebElement missions;
    

}
