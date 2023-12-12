package hw1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Task3 {
    /* Написать метод который выводит сообщение об айди элемента,
значении тэга элемента , значении класса элемента,
значении атрибута name элемента, текста данного элемента,
а также о координатах центра контейнера данного элемента. */
    public static void metod2(By locator, WebDriver driver) {
        WebElement elementX = driver.findElement(locator);
        String id = elementX.getAttribute("id");
        String tagName = elementX.getTagName();
        String className = elementX.getAttribute("class");
        String nameAttribute = elementX.getAttribute("name");
        String text = elementX.getText();

        int centerX = elementX.getLocation().getX() + elementX.getSize().getWidth() / 2;
        int centerY = elementX.getLocation().getY() + elementX.getSize().getHeight() / 2;

        System.out.println("ID элемента: " + id);
        System.out.println("Тэг элемента: " + tagName);
        System.out.println("Класс элемента: " + className);
        System.out.println("Атрибут 'name' элемента: " + nameAttribute);
        System.out.println("Текст элемента: " + text);
        System.out.println("Координаты центра контейнера элемента: (" + centerX + ", " + centerY + ")");
    }

}
