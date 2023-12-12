package hw1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Task2 {
    /* Написать метод в параметры которого принимаются два ВебЭлемента.
метод выводит в консоль информацию какой из двух элементов располагается  выше на странице,
какой из элементов располагается левее на странице,
а также какой из элементов занимает большую площадь.
Параметры метода могут также включать в себя другие аргументы, если это необходимо.*/
public static void method1 (WebElement element1, WebElement element2, WebDriver driver){
    int x1 = element1.getLocation().getX();
    int y1 = element1.getLocation().getY();
    int width1 = element1.getSize().getWidth();
    int height1 = element1.getSize().getHeight();

    int x2 = element2.getLocation().getX();
    int y2 = element2.getLocation().getY();
    int width2 = element2.getSize().getWidth();
    int height2 = element2.getSize().getHeight();

    System.out.println("Первый элемент:");
    System.out.println("х = " + x1 + ", у =  " + y1);
    System.out.println("ширина = " + width1 + ", высота = " + height1);

    System.out.println("\nВторой элемент:");
    System.out.println("х = " + x2 + ", у =  " + y2);
    System.out.println("ширина = " + width1 + ", высота = " + height1);

    if (y1 < y2) {
        System.out.println("\nПервый элемент находиться выше.");
    } else if (y1 > y2) {
        System.out.println("\nВторой элемент находиться выше.");
    } else {
        System.out.println("\nЭлементы находятся на одной линии.");
    }

    if (x1 < x2) {
        System.out.println("Первый элемент находиться левее.");
    } else if (x1 > x2) {
        System.out.println("Второй элемент находиться левее.");
    } else {
        System.out.println("Элементы находятся на одной линии.");
    }

    int areaOfElement1 = width1 * height1;
    int areaOfElement2 = width2 * height2;

    if (areaOfElement1 > areaOfElement2) {
        System.out.println("Первый элемент занимает большую площадь.");
    } else if (areaOfElement1 < areaOfElement2) {
        System.out.println("Второй элемент занимает большую площадь.");
    } else {
        System.out.println("Элементы занимают одинаковую площадь.");
    }
}
}
