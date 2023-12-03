package hw1;

import driverFactory.DriverSetUp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

 public class video1 {
    /*Написать программу, которая повторит действия на видео "HW_AUTOMATION_LESSON_3_UPDATE.mp4".
    http://www.automationpractice.pl/index.php*/


    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = DriverSetUp.setUpDriver();
        driver.get("http://www.automationpractice.pl/index.php");
        Thread.sleep(1000);
        driver.findElement(By.id("search_query_top")).sendKeys("Printed Chiffon Dress");
        driver.findElement(By.xpath("//button[@class='btn btn-default button-search']")).click();
        driver.findElement(By.xpath("//a[@href='http://www.automationpractice.pl/index.php?id_product=7&controller=product&search_query=Printed+Chiffon+Dress&results=2']")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("Submit")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//span[@class='continue btn btn-default button exclusive-medium']")).click();
        driver.findElement(By.xpath("//a[@href='http://www.automationpractice.pl/index.php?id_category=3&controller=category']")).click();
        driver.findElement(By.id("search_query_top")).sendKeys("Faded Short");
        driver.findElement(By.xpath("//button[@class='btn btn-default button-search']")).click();
        driver.findElement(By.xpath("//a[@href='http://www.automationpractice.pl/index.php?id_product=1&controller=product&search_query=Faded+Short&results=1']")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("Submit")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//span[@class='continue btn btn-default button exclusive-medium']")).click();
        driver.findElement(By.xpath("//a[@href='http://www.automationpractice.pl/index.php?controller=order']")).click();
        Thread.sleep(3000);
        driver.quit();
    }

}
