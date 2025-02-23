import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasicSeleniumTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            driver.get("https://google.com");
            System.out.println("Page title is: " + driver.getTitle());
        } finally {
            driver.quit();
        }
    }
}mvn exec:java -Dexec.mainClass="BasicSeleniumTest"