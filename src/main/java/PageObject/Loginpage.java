package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {

    WebDriver driver;

    DashboardPage dashboardPage=new DashboardPage();

    public Loginpage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "AUser")
    private WebElement adminUserName;

    @FindBy(id = "APwd")
    private WebElement adminPassword;

    @FindBy(id = "ABtn")
    private WebElement signInButton;

    @FindBy(id="AdmSessLnk")
    private WebElement signOutButton;


    public void login(String userName, String password) throws InterruptedException
    {
        adminUserName.click();
        adminUserName.sendKeys(userName);
        adminPassword.click();
        adminPassword.sendKeys(password);

    }

    public boolean sighIn(){
        signInButton.click();
        return true;
    }

    public boolean sighOut(){
        signOutButton.click();
        return true;
    }


}
