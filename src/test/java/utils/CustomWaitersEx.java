package utils;

import driverFactory.DriverSetUp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CustomWaitersEx {
        public static void main(String[] args) {
            WebDriver driver = DriverSetUp.setUpDriver();
            driver.get("https://www.guinnessworldrecords.com/Account/Login");
            new WaiterClass(driver).waitForVisabilityOfWebElement(By.id("ez-accept-all")).click();
        }
}
