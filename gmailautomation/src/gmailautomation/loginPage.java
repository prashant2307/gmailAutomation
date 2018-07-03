package gmailautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class loginPage {
  WebDriver driver;
  
  public loginPage(WebDriver driver) {
	  this.driver = driver;
	  PageFactory.initElements(driver, this);
  }
  public void login(String user, String pass) {
	  driver.findElement(By.id("identifierId")).sendKeys(user);;
	  driver.findElement(By.id("identifierNext")).click();
	  WebDriverWait wait = new WebDriverWait(driver, 10);
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("passwordNext")));
	  driver.findElement(By.cssSelector("input[name=password]")).sendKeys(pass);
	  driver.findElement(By.id("passwordNext")).click();
  }
}