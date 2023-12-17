package hw3;

import driverFactory.DriverSetUp;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class VideoTask {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverSetUp.setUpDriver();
        driver.get("https://www.google.com");
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("https://www.guinnessworldrecords.com/account/register");
        searchBox.sendKeys(Keys.ENTER);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        By searchResultsLocator = By.cssSelector("h3");
        List<WebElement> searchResults = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(searchResultsLocator));
        WebElement firstResult = searchResults.get(0);
        String firstResultUrl = firstResult.findElement(By.xpath("./ancestor::a")).getAttribute("href");
        ((JavascriptExecutor) driver).executeScript("window.open('" + firstResultUrl + "','_blank');");
        searchBox = driver.findElement(By.name("q"));
        searchBox.clear();
        searchBox.sendKeys("https://www.hyrtutorials.com/p/alertsdemo.html");
        searchBox.sendKeys(Keys.ENTER);
        List<WebElement> newSearchResults = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(searchResultsLocator));
        WebElement newFirstResult = newSearchResults.get(0);
        String newFirstResultUrl = newFirstResult.findElement(By.xpath("./ancestor::a")).getAttribute("href");
        ((JavascriptExecutor) driver).executeScript("window.open('" + newFirstResultUrl + "','_blank');");
        searchBox = driver.findElement(By.name("q"));
        searchBox.clear();
        searchBox.sendKeys("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_form_submit");
        searchBox.sendKeys(Keys.ENTER);
        List<WebElement> newSearchResults2 = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(searchResultsLocator));

        WebElement newFirstResult2 = newSearchResults2.get(0);
        String newFirstResultUrl2 = newFirstResult2.findElement(By.xpath("./ancestor::a")).getAttribute("href");
        ((JavascriptExecutor) driver).executeScript("window.open('" + newFirstResultUrl2 + "','_blank');");
        Thread.sleep(10000);
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(2));
        WebDriverWait newPageWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        newPageWait.until(ExpectedConditions.urlContains("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_form_submit"));
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
//не переключает на первую ссылку
        driver.switchTo().window(tabs.get(0));
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
        driver.get("https://www.hyrtutorials.com/p/alertsdemo.html");
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
        //driver.quit();
    }

    private static void openLinkInNewWindow(WebDriver driver, String url) {
        // Открыть новое окно
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("window.open();");

        // Получить список всех открытых окон
        Set<String> windowHandles = driver.getWindowHandles();

        // Переключиться на новое окно
        String newWindowHandle = getNewWindowHandle(driver, windowHandles);
        driver.switchTo().window(newWindowHandle);

        // Перейти по ссылке
        driver.get(url);
    }

    private static String getNewWindowHandle(WebDriver driver, Set<String> oldHandles) {
        // Получить новый handle окна
        Set<String> allHandles = driver.getWindowHandles();
        allHandles.removeAll(oldHandles);

        // Если все окна уникальны, вернуть последний из них
        return allHandles.iterator().next();

    }
}




