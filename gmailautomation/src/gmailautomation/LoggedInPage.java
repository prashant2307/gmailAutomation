package gmailautomation;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoggedInPage {
   WebDriver driver;
   
 //  String mailCount;
   
   public LoggedInPage(WebDriver driver) {
	   this.driver = driver;
	  // js = (JavascriptExecutor)driver;
   }
   
   //JavascriptExecutor js = (JavascriptExecutor)driver;
   
   public void readFirstUnreadEmail() {
	//   WebDriverWait wait = new WebDriverWait(driver, 10);
	  // 	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.aio.UKr6le > span > a")));
        try {
	   	List<WebElement> unread_mails = driver.findElements(By.cssSelector("div.Cp > div > table.F.cf.zt > tbody > tr.zA.zE"));
      //System.out.println(unread_mails.size());
      unread_mails.get(0).click();
        } catch(IndexOutOfBoundsException e) {
        	System.out.println("Not here");
        	nextInboxPage();
        }
      //driver.navigate().back();
    //  driver.findElement(By.cssSelector("div.aio.UKr6le > span > a")).click();
   }
   
   //WebElement profilebtn = driver.findElement(By.xpath("//span[@class='gb_db gbii']"));
   
   public void nextInboxPage() {
	   //driver.navigate().refresh();
	   //WebDriverWait wait = new WebDriverWait(driver, 10);
	   	//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id=':io']")));
	  /* profilebtn.click();
	   profilebtn.click();*/
	   driver.findElement(By.xpath("//span[@class='gb_db gbii']")).click();
	   driver.findElement(By.xpath("//span[@class='gb_db gbii']")).click();
	   driver.findElement(By.xpath("//div[@id=':io']")).click();
	 //  JavascriptExecutor js = (JavascriptExecutor)driver;
	   //js.executeScript("arguments[0].click();", nextInboxbtn);
	  // 	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.aio.UKr6le > span > a")));
	   
	   readFirstUnreadEmail();
   }
   
   public String unreadEmails() {
	   WebDriverWait wait = new WebDriverWait(driver, 10);
	   	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.aio.UKr6le > span > a")));
	   	WebElement inboxBtn = driver.findElement(By.partialLinkText("Inbox"));
	   	String unread_inbox = inboxBtn.getAttribute("title");
	   	String total_unread = inboxBtn.getAttribute("aria-label");
	   	System.out.println("Unread Primary Mails = " + unread_inbox.substring(7, unread_inbox.length()-1));
	   	System.out.println("Total unread Mails = " + total_unread.substring(6, total_unread.length()-7));
        return total_unread.substring(6, total_unread.length()-7);
   }
   

   public int sentMails(String check) {
	   
	   WebDriverWait wait = new WebDriverWait(driver, 10);
	   wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.aio.UKr6le")));
	   driver.findElement(By.xpath("//a[text()='Sent Mail']")).click();

	   	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.ae4.UI>div>div>table>tbody")));
	   List<WebElement> sent_mails =  driver.findElements(By.cssSelector("div.ae4.UI>div>div>table>tbody>tr.zA.yO"));
	   
	//   driver.navigate().back();
	   return sent_mails.size();
   }
   
   
   public String composeMail() throws InterruptedException {
	   driver.findElement(By.cssSelector("div.z0>div")).click();
	   WebDriverWait wait = new WebDriverWait(driver, 10);
	   wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.wO.nr.l1>textarea")));
	   driver.findElement(By.cssSelector("div.wO.nr.l1>textarea")).sendKeys("kvikas96@gmail.com");
	   driver.findElement(By.xpath("//input[@class='aoT']")).sendKeys("Test mail");
	   driver.findElement(By.cssSelector("div.Am.Al.editable.LW-avf")).sendKeys("Test mail continue.......");
	   driver.findElement(By.cssSelector("div.T-I.J-J5-Ji.aoO.T-I-atl.L3")).click();
	   System.out.println(driver.findElement(By.cssSelector("div.vh")).getText());
	   Thread.sleep(1000);
	   return driver.findElement(By.cssSelector("div.vh")).getText();
	  // Thread.sleep(20000);
   }
   
}