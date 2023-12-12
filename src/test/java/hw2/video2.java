package hw2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class video2 {

            public static void main(String[] args) throws InterruptedException {
                WebDriver driver = new ChromeDriver();
                driver.get("http://www.ashortjourney.com/");
                Thread.sleep(8000);

                Actions actions = new Actions(driver);

                WebElement sourceElement = driver.findElement(By.cssSelector("circle[cx='571.5'][cy='108.75'][r='40']"));
                WebElement targetElement = driver.findElement(By.cssSelector("circle[style*='-webkit-tap-highlight-color: rgba(0, 0, 0, 0)']"));

                actions.clickAndHold(sourceElement)
                        .moveToElement(targetElement)
                        .release()
                        .build()
                        .perform();
            }
        }


