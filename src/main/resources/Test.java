package l1;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
public class Test {
    public static void main(String[] args) throws InterruptedException {


    System.setProperty("webdriver.chrome.driver", "C:\\Users\\Даша\\Desktop\\HW_JAVA\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Users\\Даша\\Desktop\\HW_JAVA\\chrome-win64\\chrome.exe");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
        Thread.sleep(3000);
        driver.quit();
    }
}
