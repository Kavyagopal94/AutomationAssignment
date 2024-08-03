import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;

public class FitPeoAutomationn {
    public static void main(String[] args) {
        // Set the path for ChromeDriver
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        
        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();
        
        try {
            // Step 1: Navigate to FitPeo Homepage
            driver.get("https://www.fitpeo.com/");
            System.out.println("Navigated to FitPeo Homepage.");
            
            // Step 2: Navigate to Revenue Calculator Page
            driver.navigate().to("https://fitpeo.com/revenue-calculator");
            System.out.println("Navigated to Revenue Calculator Page.");
            
            // Step 3: Scroll Down to the Slider section
            JavascriptExecutor js = (JavascriptExecutor) driver;
            WebElement sliderSection = driver.findElement(By.id("slider-section-id")); // Replace with the actual ID of the slider section
            js.executeScript("arguments[0].scrollIntoView();", sliderSection);
            System.out.println("Scrolled down to the slider section.");
            
            // Step 4: Adjust the Slider to set its value to 820
            WebElement slider = driver.findElement(By.id("slider-id")); // Replace with the actual ID of the slider
            js.executeScript("arguments[0].value=820;", slider);
            System.out.println("Slider adjusted to 820.");
            
            // Step 5: Update the Text Field with value 560
            WebElement textField = driver.findElement(By.id("text-field-id")); // Replace with the actual ID of the text field
            textField.clear();
            textField.sendKeys("560");
            System.out.println("Text field updated to 560.");
            
            // Step 6: Validate Slider Value
            String sliderValue = slider.getAttribute("value");
            if (sliderValue.equals("560")) {
                System.out.println("Slider value is correctly updated to 560.");
            } else {
                System.out.println("Slider value is not correctly updated.");
            }
            
            // Step 7: Select CPT Codes
            String[] cptCodes = {"CPT-99091", "CPT-99453", "CPT-99454", "CPT-99474"};
            for (String cpt : cptCodes) {
                WebElement checkbox = driver.findElement(By.id(cpt)); // Replace with the actual ID of the checkbox
                if (!checkbox.isSelected()) {
                    checkbox.click();
                }
            }
            System.out.println("Selected the CPT codes.");
            
            // Step 8: Validate Total Recurring Reimbursement
            WebElement reimbursementHeader = driver.findElement(By.id("reimbursement-header-id")); // Replace with the actual ID of the header
            String expectedValue = "$110700";
            if (reimbursementHeader.getText().contains(expectedValue)) {
                System.out.println("Total Recurring Reimbursement value is correctly displayed as $110700.");
            } else {
                System.out.println("Total Recurring Reimbursement value is not correctly displayed.");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
