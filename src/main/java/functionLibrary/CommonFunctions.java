package functionLibrary;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class CommonFunctions {

    public static WebDriver driver;

    public void openBrowser()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    public void closeBrowser()
    {
        driver.quit();
    }

    public void waitWithTime(int wait)
    {
        driver.manage().timeouts().implicitlyWait(wait, TimeUnit.SECONDS);
    }

    public String readFromPropertyFile(String key) throws Exception{

        FileInputStream inputStream = new FileInputStream("C:\\Users\\Admin\\IdeaProjects\\TopCashbackTask\\src\\main\\resources\\data.properties");
        Properties properties = new Properties();
        properties.load(inputStream);
        return properties.get(key).toString();
    }
}
