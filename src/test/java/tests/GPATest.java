package tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class GPATest {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void testGPA() {
        driver.get("https://saraswathi892.github.io/cgpa-calculator/");
        driver.findElement(By.id("grade1")).sendKeys("A");
        driver.findElement(By.id("credit1")).sendKeys("4");
        driver.findElement(By.tagName("button")).click();
        WebElement result = driver.findElement(By.id("result"));
        String output = result.getText();
        Assert.assertEquals(output, "GPA: 10.00");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
