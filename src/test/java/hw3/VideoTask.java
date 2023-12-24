package hw3;

import driverFactory.DriverSetUp;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ActionsClass;

import java.time.Duration;
import java.util.Set;

public class VideoTask {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverSetUp.setUpDriver();
        driver.get("https://www.google.com/search");
        ActionsClass actionsClass = new ActionsClass(driver);
        actionsClass.sendKeys(By.name("q"), "https://www.guinnessworldrecords.com/account/register");
        actionsClass.sendKeys(By.name("q"), Keys.ENTER);
        String handle1 = driver.getWindowHandle();

        Set<String> windowHandles1 = driver.getWindowHandles();
        actionsClass.clickAndOpenInNewWindow(By.xpath("//h3[text()='Create account']"));

        Set<String> windowHandles2 = driver.getWindowHandles();
        windowHandles2.removeAll(windowHandles1);

        String handle2 = windowHandles2.iterator().next();
        driver.switchTo().window(handle2);
        actionsClass.clearAndSendKeys(By.name("q"), "https://www.hyrtutorials.com/p/alertsdemo.html");
        actionsClass.sendKeys(By.name("q"), Keys.ENTER);

        Set<String> windowHandles3 = driver.getWindowHandles();
        actionsClass.clickAndOpenInNewWindow(By.xpath("////h3[text()='AlertsDemo']"));
        Set<String> windowHandles4 = driver.getWindowHandles();
        windowHandles4.removeAll(windowHandles3);
        actionsClass.clearAndSendKeys(By.name("q"), "https://www.w3schools.com/html/tryit.asp?filename=tryhtml_form_submit");
        actionsClass.sendKeys(By.name("q"), Keys.ENTER);
        String handle3 = windowHandles4.iterator().next();
        Set<String> windowHandles5 = driver.getWindowHandles();
        actionsClass.clickAndOpenInNewWindow(By.xpath("//h3[text()='W3Schools Tryit Editor - HTML Forms']"));
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
        driver.switchTo().window(handle2);
        Thread.sleep(1500);
        actionsClass.click(By.xpath("//p[text()='Consent']"));
        System.out.println(driver.getTitle());
        driver.findElement(By.id("LastName")).sendKeys("Menshykova");
        driver.findElement(By.id("FirstName")).sendKeys("Dasha");
        driver.findElement(By.id("DateOfBirthDay")).sendKeys("20");
        driver.findElement(By.id("DateOfBirthMonth")).sendKeys("10");
        driver.findElement(By.id("DateOfBirthYear")).sendKeys("2002");
        WebElement country = driver.findElement(By.id("Country"));
        Select select = new Select(country);
        select.selectByVisibleText("Ukraine");
        Thread.sleep(2000);
        driver.findElement(By.id("State")).sendKeys("Kyiv");
        driver.findElement(By.id("EmailAddress")).sendKeys("myown@gmail.com");
        driver.findElement(By.id("ConfirmEmailAddress")).sendKeys("myown@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("hi5478");
        driver.findElement(By.id("ConfirmPassword")).sendKeys("hi7864", Keys.ENTER);
        WebElement masageOfPasswod = driver.findElement(By.xpath("//span[@class=''Confirm password' and 'Password' do not match.'])"));
        System.out.println(masageOfPasswod.getText());

        driver.switchTo().window(handle3);
        Thread.sleep(1500);
        actionsClass.click(By.id("accept-choices"));
        System.out.println(driver.getTitle());
        driver.findElement(By.id("alertBox")).click();
        Alert alert = new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.alertIsPresent());
        System.out.println(alert.getText());
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.alertIsPresent()).accept();
        System.out.println("Popup box output");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeAsyncScript("window.scrollBy(0,500)");
        Thread.sleep(5000);
        driver.findElement(By.id("confirmBox")).click();
        Alert alert2 = driver.switchTo().alert();
        System.out.println(alert2.getText());
        alert2.dismiss();
        System.out.println(alert2.getText() + "Popup box output");


        driver.findElement(By.id("promptBox")).click();
        Alert alert3 = driver.switchTo().alert();
        System.out.println(alert3.getText());
        alert3.sendKeys("Final step of this task");
        String enteredText = alert3.getText();
        alert3.accept();
        System.out.println("Popup box output" + enteredText);
        driver.quit();
    }
}






