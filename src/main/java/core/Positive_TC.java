package core;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Positive_TC {
	
	public static void main(String[] args) {
	 
	// WebDriver driver = new HtmlUnitDriver();
	WebDriver driver = new FirefoxDriver();
	String text_case_id_01 = "TC-001.01";
	String text_case_id_02 = "TC-001.02";
	String text_case_id_03 = "TC-001.03";
	String text_case_id_04 = "TC-001.04";
	String text_case_id_05 = "TC-001.05";
	String text_case_id_06 = "TC-001.06";
	String text_case_id_07 = "TC-001.07";
	String text_case_id_08 = "TC-001.08";
	String text_case_id_09 = "TC-001.09";
	String text_case_id_10 = "TC-001.10";
	String url = "http://learn2test.net/qa/apps/sign_up/v1/";
	String title_sign_up_expected = "Welcome to Sign Up";
	String app_title_sign_up_expected = "Sign Up";
	String title_facebook_expected = "Welcome to Facebook - Log In, Sign Up or Learn More";
	String error_fname_empty_expected = "Please enter First Name";
	String error_lname_empty_expected = "Please enter Last Name";
	String error_email_empty_expected = "Please enter Email Address";
	String error_phone_empty_expected = "Please enter Phone Number";
	String error_fname_length_expected = "Invalid First Name: [a-zA-Z,.'-]{3,30}";
	
	String fname = "Yulia";
	String lname = "Novak";
	String email = "yulianovak7777@gmail.com";
	String phone = "415 555-1212";
	 
	// TC-001.01
	// Sign Up page html title is: "Welcome to Sign Up"
	 
	driver.get(url);
	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	String title_sign_up_actual = driver.getTitle();
	 
	if (title_sign_up_expected.equals(title_sign_up_actual)) {
	System.out.println("Test Case ID: \t\t" + text_case_id_01
	+ " - PASSED");
	System.out.println("Title Expected/Actual: \t"
	+ title_sign_up_expected + "/" + title_sign_up_actual);
	System.out.println("=======================================");
	} else {
	System.out.println("Test Case ID: \t\t" + text_case_id_01
	+ " - FAILED");
	System.out.println("Title Expected/Actual: \t"
	+ title_sign_up_expected + "/" + title_sign_up_actual);
	System.out.println("=======================================");
	}
		
	// TC-001.02
	// Sign Up page application title is: "Sign Up" 
	
	String app_title_sign_up_actual = driver.findElement(By.id("id_f_title")).getText();
	if (app_title_sign_up_expected.equals(app_title_sign_up_actual))  {
	System.out.println("Test Case ID: \t\t" + text_case_id_02 + " - PASSED");
	System.out.println("Form title Expected/Actual: \t"+ app_title_sign_up_expected + "/" + app_title_sign_up_actual);
	System.out.println("=======================================");
	} else {
	System.out.println("Test Case ID: \t\t" + text_case_id_02 + " - FAILED");
	System.out.println("Form title Expected/Actual: \t" +app_title_sign_up_expected + "/" + app_title_sign_up_actual);
	System.out.println("=======================================");
				}
	
	// TC-001.03
	// New quote is displayed after each reload of a page
	
	String quote_old = driver.findElement(By.id("id_quotes")).getText();
	driver.navigate().refresh();
	String quote_new = driver.findElement(By.id("id_quotes")).getText();
	if (quote_old.equals(quote_new))  {
		System.out.println("Test Case ID: \t\t" + text_case_id_03 + " - FAILED");
		System.out.println("Quote before reload / after reload: \t" + quote_old + "/" + quote_new);
		System.out.println("=======================================");
	  } else {
		System.out.println("Test Case ID: \t\t" + text_case_id_03 + " - PASSED");
		System.out.println("Quote before reload / after reload: \t" + quote_old + "/" + quote_new);
		System.out.println("=======================================");
	  }
	
	// TC-001.04
	// Click on "Facebook" image link should redirect on Facebook Login page.
	
	driver.findElement(By.id("id_img_facebook")).click();
    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    ArrayList<String> allTabs = new ArrayList<String>(
    driver.getWindowHandles());
    driver.switchTo().window(allTabs.get(1));
    String title_facebook_actual = driver.getTitle();
    driver.close();
    driver.switchTo().window(allTabs.get(0));
 
    if (title_facebook_expected.equals(title_facebook_actual)) {
    System.out.println("Test Case ID: \t\t" + text_case_id_04+ " - PASSED");
    System.out.println("Title Expected/Actual: \t"+ title_facebook_expected + "/" + title_facebook_actual);
    System.out.println("=======================================");
    } else {
    System.out.println("Test Case ID: \t\t" + text_case_id_04+ " - FAILED");
    System.out.println("Title Expected/Actual: \t"+ title_facebook_expected + "/" + title_facebook_actual);
    System.out.println("=======================================");
}
    
 // TC-001.05
 // Login with valid credentials
    
	driver.findElement(By.id("id_fname")).sendKeys(fname);
    driver.findElement(By.id("id_lname")).sendKeys(lname);
    driver.findElement(By.id("id_email")).sendKeys(email);
    driver.findElement(By.id("id_phone")).sendKeys(phone);
    driver.findElement(By.id("id_submit_button")).click();
 
    String fname_conf_actual = driver.findElement(By.id("id_fname_conf")).getText();
    String lname_conf_actual = driver.findElement(By.id("id_lname_conf")).getText();
    String email_conf_actual = driver.findElement(By.id("id_email_conf")).getText();
    String phone_conf_actual = driver.findElement(By.id("id_phone_conf")).getText();
 
  if (fname.equals(fname_conf_actual) && lname.equals(lname_conf_actual)
  && email.equals(email_conf_actual)
  && phone.equals(phone_conf_actual)) {
  System.out.println("Test Case ID: \t\t" + text_case_id_05+ " - PASSED");
System.out.println("First Expected/Actual: \t" + fname + "/"+ fname_conf_actual);
System.out.println("Last Expected/Actual: \t" + lname + "/"+ lname_conf_actual);
System.out.println("Email Expected/Actual: \t" + email + "/"+ email_conf_actual);
System.out.println("Phone Expected/Actual: \t" + phone + "/"+ phone_conf_actual);
System.out.println("=======================================");
} else {
System.out.println("Test Case ID: \t\t" + text_case_id_05+ " - FAILED");
System.out.println("First Expected/Actual: \t" + fname + "/"+ fname_conf_actual);
System.out.println("Last Expected/Actual: \t" + lname + "/"+ lname_conf_actual);
System.out.println("Email Expected/Actual: \t" + email + "/"+ email_conf_actual);
System.out.println("Phone Expected/Actual: \t" + phone + "/"+ phone_conf_actual);
System.out.println("=======================================");
}
 
//driver.quit();
    
// TC on error handling
	
// TC-001.06
// Error message "Please enter First Name" comes up. 
	
	driver.get(url);
	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	driver.findElement(By.id("id_submit_button")).click();  
	String error_fname_empty_actual = driver.findElement(By.id("ErrorLine")).getText();
 
   if (error_fname_empty_expected.equals(error_fname_empty_actual)) {
   System.out.println("Test Case ID: \t\t" + text_case_id_06+ " - PASSED");
   System.out.println("Error Expected/Actual: \t"+ error_fname_empty_expected + "/"+ error_fname_empty_actual);
   System.out.println("=======================================");
   } else {
   System.out.println("Test Case ID: \t\t" + text_case_id_06 + " - FAILED");
   System.out.println("Error Expected/Actual: \t"+ error_fname_empty_expected + "/"+ error_fname_empty_actual);
   System.out.println("=======================================");
}
   
// TC-001.07
// Error message  "Please enter Last Name" shows up.
   
   driver.findElement(By.id("id_fname")).sendKeys(fname);
   driver.findElement(By.id("id_submit_button")).click();  
   String error_lname_empty_actual = driver.findElement(By.id("ErrorLine")).getText();

  if (error_lname_empty_expected.equals(error_lname_empty_actual)) {
  System.out.println("Test Case ID: \t\t" + text_case_id_07+ " - PASSED");
  System.out.println("Error Expected/Actual: \t"+ error_lname_empty_expected + "/"+ error_lname_empty_actual);
  System.out.println("=======================================");
  } else {
  System.out.println("Test Case ID: \t\t" + text_case_id_07 + " - FAILED");
  System.out.println("Error Expected/Actual: \t"+ error_lname_empty_expected + "/"+ error_lname_empty_actual);
  System.out.println("=======================================");
}
   
//TC-001.08
//Error message  "Please enter Email Address" shows up.
  
  driver.findElement(By.id("id_lname")).sendKeys(lname);
  driver.findElement(By.id("id_submit_button")).click();  
  String error_email_empty_actual = driver.findElement(By.id("ErrorLine")).getText();

 if (error_email_empty_expected.equals(error_email_empty_actual)) {
 System.out.println("Test Case ID: \t\t" + text_case_id_08+ " - PASSED");
 System.out.println("Error Expected/Actual: \t"+ error_email_empty_expected + "/"+ error_email_empty_actual);
 System.out.println("=======================================");
 } else {
 System.out.println("Test Case ID: \t\t" + text_case_id_08 + " - FAILED");
 System.out.println("Error Expected/Actual: \t"+ error_email_empty_expected + "/"+ error_email_empty_actual);
 System.out.println("======================================="); 
 } 
  
  
// TC-001.09
//Error message  "Please enter Phone Number" shows up.
 
 driver.findElement(By.id("id_email")).sendKeys(email);
 driver.findElement(By.id("id_submit_button")).click();  
 String error_phone_empty_actual = driver.findElement(By.id("ErrorLine")).getText();

if (error_phone_empty_expected.equals(error_phone_empty_actual)) {
System.out.println("Test Case ID: \t\t" + text_case_id_09+ " - PASSED");
System.out.println("Error Expected/Actual: \t"+ error_phone_empty_expected + "/"+ error_phone_empty_actual);
System.out.println("=======================================");
} else {
System.out.println("Test Case ID: \t\t" + text_case_id_09 + " - FAILED");
System.out.println("Error Expected/Actual: \t"+ error_phone_empty_expected + "/"+ error_phone_empty_actual);
System.out.println("======================================="); 
}

//TC-001.10
// Error message "Invalid First Name: [a-zA-Z,.'-]{3,30}" shows up when user enter FN < 3 characters.

 driver.findElement(By.id("id_reset_button")).click();
 driver.findElement(By.id("id_fname")).sendKeys("Yu");
 driver.findElement(By.id("id_lname")).sendKeys(lname);
 driver.findElement(By.id("id_email")).sendKeys(email);
 driver.findElement(By.id("id_phone")).sendKeys(phone);
 driver.findElement(By.id("id_submit_button")).click();
 String error_fname_lenght_actual = driver.findElement(By.id("ErrorLine")).getText();
 if (error_fname_length_expected.equals(error_fname_lenght_actual)) {
	 System.out.println("Test Case ID: \t\t" + text_case_id_10+ " - PASSED");
	 System.out.println("Error Expected/Actual: \t"+ error_fname_length_expected + "/"+ error_fname_lenght_actual);
	 System.out.println("=======================================");
	 } else {
	 System.out.println("Test Case ID: \t\t" + text_case_id_10 + " - FAILED");
	 System.out.println("Error Expected/Actual: \t"+ error_fname_length_expected + "/"+ error_fname_lenght_actual);
	 System.out.println("======================================="); 
	 }
 
 
driver.quit();
}
}

	
	
	





