// Librarias
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ComprarumapassagemTest {
  private WebDriver driver;
  // private Map<String, Object> vars;
  JavascriptExecutor js;

  @BeforeEach
  public void setUp() {
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    // vars = new HashMap<String, Object>();
  }

  @AfterEach
  public void tearDown() {
    driver.quit();
  }

  @Test
  public void comprarumapassagem() {
    driver.get("https://blazedemo.com/");
    driver.manage().window().setSize(new Dimension(2560, 1318));
    assertEquals(driver.findElement(By.cssSelector("h1")).getText(), "Welcome to the Simple Travel Agency!");
    driver.findElement(By.name("fromPort")).click();
    {
      WebElement dropdown = driver.findElement(By.name("fromPort"));
      dropdown.findElement(By.xpath("//option[. = 'Philadelphia']")).click();
    }
    driver.findElement(By.name("toPort")).click();
    {
      WebElement dropdown = driver.findElement(By.name("toPort"));
      dropdown.findElement(By.xpath("//option[. = 'Rome']")).click();
    }
    driver.findElement(By.cssSelector(".btn-primary")).click();
    assertEquals(driver.findElement(By.cssSelector("h3")).getText(), "Flights from Philadelphia to Rome:");
    driver.findElement(By.cssSelector("tr:nth-child(3) .btn")).click();
    assertEquals(driver.findElement(By.cssSelector("h2")).getText(), "Your flight from TLV to SFO has been reserved.");
    driver.findElement(By.id("inputName")).click();
    driver.findElement(By.id("inputName")).sendKeys("John");
    driver.findElement(By.id("address")).sendKeys("123 Main st");
    driver.findElement(By.id("city")).click();
    driver.findElement(By.id("city")).sendKeys("Philadelphia");
    driver.findElement(By.id("state")).sendKeys("Pennsylvania");
    driver.findElement(By.id("zipCode")).sendKeys("458515");
    driver.findElement(By.id("creditCardNumber")).click();
    driver.findElement(By.id("creditCardNumber")).sendKeys("4567875245814582");
    driver.findElement(By.id("creditCardMonth")).click();
    driver.findElement(By.id("creditCardMonth")).sendKeys("10");
    driver.findElement(By.id("creditCardYear")).click();
    driver.findElement(By.id("creditCardYear")).sendKeys("2024");
    driver.findElement(By.id("nameOnCard")).sendKeys("John Test");
    driver.findElement(By.cssSelector(".btn-primary")).click();
    assertEquals(driver.findElement(By.cssSelector("h1")).getText(), "Thank you for your purchase today!");
    driver.close();
  }
}
