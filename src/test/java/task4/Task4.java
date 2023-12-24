package task4;

import driverFactory.DriverSetUp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

    public class Task4 {

        private WebDriver driver;

        @DataProvider(name = "searchWords")
        public Object[][] searchData() {
            return new Object[][]{
                    {"машина"},
                    {"input"},
                    {"смысл"}
            };
        }
        @Parameters("searchWord")
        @Test(dataProvider = "searchWords")
        public void testFoxtrotSearch(String searchWord) {
            WebDriver driver = DriverSetUp.setUpDriver();
            driver.get("https://www.foxtrot.com.ua/");

            WebElement searchInput = driver.findElement(By.id("search"));
            searchInput.sendKeys(searchWord);

            WebElement searchButton = driver.findElement(By.cssSelector("button[type='submit']"));
            searchButton.click();

            WebElement searchResults = driver.findElement(By.id("search-result"));
            assertTrue(searchResults.isDisplayed());

            WebElement highlightedElement = driver.findElement(By.cssSelector(".highlight"));
            String highlightedText = highlightedElement.getText().toLowerCase();
            assertTrue(highlightedText.contains(searchWord.toLowerCase()));
            driver.quit();
        }
    }

