import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreateaccountPage {
    WebDriver driver;

    public CreateaccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public final By emailBox = By.xpath("//*[@id=\"email_create\"]");
    public final By createButton = By.xpath("//*[@id=\"SubmitCreate\"]");

    public final By validateEmail = By.xpath("//*[@class=\"form-group form-error\"]");

    public RegisterPage clickCreateAccountButton() {
        driver.findElement(createButton).click();
        return new RegisterPage(driver);
    }

    public Boolean emailSend(String emailAddress) {
        WebElement tempBox = driver.findElement(emailBox);
        tempBox.sendKeys(emailAddress);
        tempBox.sendKeys(Keys.TAB);

        try {
            driver.findElement(validateEmail);
            return false;
        } catch (Exception e) {
            return true;
        }
    }
}
