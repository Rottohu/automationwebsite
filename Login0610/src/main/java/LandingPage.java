import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {

    WebDriver driver;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    public final String url = "http://automationpractice.com/index.php";
    public final By signinbutton = By.xpath("//*[@class=\"login\"]");

    public void navigate()
    {
        driver.navigate().to(url);
    }

    public CreateaccountPage clickonSignin() {
        driver.findElement(signinbutton).click();
        return new CreateaccountPage(driver);
    }
}
