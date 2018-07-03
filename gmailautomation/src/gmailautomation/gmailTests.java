package gmailautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class gmailTests {
   WebDriver driver;
   String url = "https://gmail.com";
   String mailCountBefore, mailCountAfter, successfullSentmailMessage = "Your message has been sent. View message";
   int sentmailsbefore;
   
   
   @BeforeTest
   public void LaunchSignInPage() {
	
	   driver = new ChromeDriver();
	   driver.get(url);
   }
   
   @Test(priority=0)
   public void loginGmail() {
	   loginPage obj = new loginPage(driver);
	   obj.login("enterUsernameHere", "enterPasswordHere");
   }
   
   @Test(priority=1, enabled=true)
   public void unreadMails() {
	   LoggedInPage obj = new LoggedInPage(driver);
	   mailCountBefore = obj.unreadEmails();
   }
   
   @Test(priority=2)
   public void readFirstUnreadMail() {
	   LoggedInPage obj = new LoggedInPage(driver);
	   obj.readFirstUnreadEmail();
	   System.out.println("After reading first unread mail");
	   mailCountAfter = obj.unreadEmails();
	   Assert.assertTrue((Integer.parseInt(mailCountAfter)+1) == Integer.parseInt(mailCountBefore));
   }
   
  /* @Test(priority=1)
   public void sentMailBefore() {
	   LoggedInPage obj = new LoggedInPage(driver);
	   sentmailsbefore = obj.sentMails("before");
	   System.out.println("Mails Before ="+sentmailsbefore);
   }
   
   @Test(priority=2)
   public void sendMail() throws InterruptedException {
	   LoggedInPage obj = new LoggedInPage(driver);
	   Assert.assertEquals(obj.composeMail(), successfullSentmailMessage);
	   //-- VALIDATING SENT MAIL THROUGH TABLE ---
	   // obj.composeMail();
	//   System.out.println(obj.sentMails("after"));
	//   Assert.assertTrue( (sentmailsbefore+1) == obj.sentMails("after"));
	   //-------------------------------------------
   }*/
   
   @AfterTest
   public void close() throws InterruptedException {
	  // Thread.sleep(2500);
	   //driver.close();
   }
   
	
}