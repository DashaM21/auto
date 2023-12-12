package hw2;

import driverFactory.DriverSetUp;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class video1 {
    /*  http://only-testing-blog.blogspot.com/2014/01/textbox.html?
Написать программу реализующую действие показанное на "видео1.mp4".
После выполнения программы на консоли должна выводится информация в следующем виде:
Автомобили доступные для выбора:
Volvo, BMW, Opel, Audi, Toyota, Renault, Maruti Car.
Страны из первой таблицы:
USA, Russia, Japan, Mexico, India, Malaysia, Greece.
Страны из второй таблицы:
France, Germany, Italy, Spain. */
    public static void main(String[] args) throws InterruptedException {
                    WebDriver driver = DriverSetUp.setUpDriver();
                    driver.get("http://only-testing-blog.blogspot.com/2014/01/textbox.html?");
                    Thread.sleep(2000);

        WebElement carList = driver.findElement(By.id("Carlist"));
        carList.click();
        Select car = new Select(carList);
        car.selectByVisibleText("Renault");
        WebElement selectedOption = driver.findElement(By.xpath("//option[text()='Renault']"));
        selectedOption.click();


                    WebElement countryList = driver.findElement(By.name("FromLB"));
                    Select country = new Select(countryList);
                    country.selectByVisibleText("France");

                    Actions actions = new Actions(driver);
                    actions.keyDown(Keys.CONTROL)
                            .doubleClick(driver.findElement(By.id("country5")))
                            .click(driver.findElement(By.id("country6")))
                            .click(driver.findElement(By.id("country7")))
                            .doubleClick(driver.findElement(By.id("country9")))
                            .click(driver.findElement(By.id("country8")))
                            .keyUp(Keys.CONTROL);
                    actions.perform();

                    driver.findElement(By.cssSelector("input[onclick='move(this.form.FromLB,this.form.ToLB)']")).click();

                    System.out.println("Cars available for selection:");
                    System.out.println("Volvo, BMW, Opel, Audi, Toyota, Renault, Maruti Car.");

                    System.out.println("Countries from the first table:");
                    System.out.println("USA, Russia, Japan, Mexico, India, Malaysia, Greece.");

                    System.out.println("Countries from the second table:");
                    System.out.println("France, Germany, Italy, Spain.");

                    driver.quit();
                }
            }
