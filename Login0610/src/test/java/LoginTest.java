import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class LoginTest {

    WebDriver driver;

    @BeforeEach
    public void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-extensions");
        //options.addArguments("--headless");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("start-maximized");
        //options.addArguments("user-agent=\"Mozilla/5.0 (compatible; Googlebot/2.1; +http://www.google.com/bot.html)\"");
        driver = new ChromeDriver(options);
        //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void validateEmail()
    {
        LandingPage lp = new LandingPage(driver);
        lp.navigate();
        CreateaccountPage accountPage = lp.clickonSignin();
        Boolean actual = accountPage.emailSend("fpffejktqkuhuqueug@nvhrw.com");
        Assertions.assertTrue(actual);
    }

    @AfterEach
    public void NukeIt(){
        driver.quit();
    }
}
