import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FitPeoAutomationn {

    WebDriver driver;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testRevenueCalculator() {
        // Step 1: Navigate to the FitPeo Homepage
        driver.get("https://www.fitpeo.com");

        // Step 2: Navigate to the Revenue Calculator Page
        driver.findElement(By.linkText("Revenue Calculator")).click();

        // Step 3: Scroll Down to the Slider section
        WebElement slider = driver.findElement(By.xpath("//div[@class='slider']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", slider);

        // Step 4: Adjust the Slider to 820
        WebElement sliderHandle = driver.findElement(By.xpath("//div[@class='slider-handle']"));
        Actions moveSlider = new Actions(driver);
        moveSlider.dragAndDropBy(sliderHandle, 820, 0).perform();
        WebElement sliderValue = driver.findElement(By.id("slider-value"));
        Assert.assertEquals(sliderValue.getAttribute("value"), "820");

        // Step 5: Update the Text Field to 560
        WebElement textField = driver.findElement(By.id("slider-text-field"));
        textField.clear();
        textField.sendKeys("560");

        // Step 6: Validate Slider Value is 560
        Assert.assertEquals(sliderHandle.getAttribute("aria-valuenow"), "560");

        // Step 7: Select CPT Codes
        driver.findElement(By.id("cpt-99091")).click();
        driver.findElement(By.id("cpt-99453")).click();
        driver.findElement(By.id("cpt-99454")).click();
        driver.findElement(By.id("cpt-99474")).click();

        // Step 8: Validate Total Recurring Reimbursement
        WebElement reimbursement = driver.findElement(By.id("total-reimbursement"));
        Assert.assertEquals(reimbursement.getText(), "$110700");
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }
}

