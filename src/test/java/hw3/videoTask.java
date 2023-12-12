
package hw3;

import driverFactory.DriverSetUp;
import org.openqa.selenium.*;

import java.util.Set;

    public class videoTask {
        public static void main(String[] args) throws InterruptedException {
            WebDriver driver = DriverSetUp.setUpDriver();
            driver.get("https://www.google.com");
            /*WebElement searchBox = driver.findElement(By.name("q"));
            searchBox.sendKeys("https://www.guinnessworldrecords.com/account/register");
            searchBox.sendKeys(Keys.RETURN);
            Thread.sleep(4000);
            openLinkInNewWindow(driver);

            driver.get("https://www.google.com");
            searchBox = driver.findElement(By.name("q"));
            searchBox.sendKeys("https://www.hyrtutorials.com/p/alertsdemo.html");
            searchBox.sendKeys(Keys.RETURN);
            Thread.sleep(4000);

            openLinkInNewWindow(driver);

            Thread.sleep(4000);*/

            driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_form_submit");
            Thread.sleep(2000);

            driver.switchTo().frame("iframeResult");
            Thread.sleep(2000);
            WebElement firstNameField = driver.findElement(By.id("fname"));
            firstNameField.clear();
            firstNameField.sendKeys("Dasha");
            WebElement lastNameField = driver.findElement(By.id("lname"));
            lastNameField.clear();
            lastNameField.sendKeys("Menshykova");
            WebElement buttonSubmit = driver.findElement(By.cssSelector("input[type='submit']"));
            buttonSubmit.click();
            WebElement noteElement1 = driver.findElement(By.tagName("strong"));
            String noteText1 = noteElement1.getText();
            WebElement noteElement2 = driver.findElement(By.xpath("//a[@href = '/php/default.asp']"));
            String noteText2 = noteElement2.getText();
            System.out.println(" This tutorial will not teach you how servers are processing input. Processing input is explained in our  " + noteText1 + noteText2);
            driver.switchTo().defaultContent();
            driver.quit();
        }

        private static void openLinkInNewWindow(WebDriver driver) {
            Set<String> windowHandles = driver.getWindowHandles();
            String newWindowHandle = windowHandles.iterator().next();
            driver.switchTo().window(newWindowHandle);
            ((JavascriptExecutor) driver).executeScript("window.open('','_blank');");
            driver.switchTo().window(newWindowHandle);
        }
    }


