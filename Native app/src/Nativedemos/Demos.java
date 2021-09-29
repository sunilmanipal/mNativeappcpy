package Nativedemos;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static java.time.Duration.ofSeconds;

public class Demos extends Capability{
	
	AndroidDriver<AndroidElement> driver;
	
	@BeforeTest
	public void setup() throws MalformedURLException
	{
		driver = capabilities();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@Test(enabled=false)
	public void testcase1() throws InterruptedException
	{
	driver.findElementByAccessibilityId("Preference").click();
	//driver.findElement(MobileBy.AccessibilityId("Preference")).click();
	driver.findElementByAccessibilityId("3. Preference dependencies").click();
	driver.findElement(By.id("android:id/checkbox")).click();
	//so i can use this//the below three line perform the ssame operation
	//driver.findElement(By.xpath("//*[@text='WiFi settings']")).click();
	//driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"WiFi settings\")")).click();
	driver.findElementByAndroidUIAutomator("text(\"WiFi settings\")").click();
	//i have enetered some data using send keys.
	driver.findElement(By.className("android.widget.EditText")).sendKeys("sunil");
	//when you use a phone and type something //keypad will be open//to cose the keypad 
	driver.hideKeyboard();
	//i want to click on cancel button//i want to use index 
	 driver.findElements(By.className("android.widget.Button")).get(0).click();
	 //if i want to navigate back to the first screen//what should i do?
	 driver.pressKey(new KeyEvent(AndroidKey.BACK));
	 Thread.sleep(5000);
	 driver.pressKey(new KeyEvent(AndroidKey.BACK));
	}
	
	
	//i am teaching you mobile gestures 
	@Test(enabled=false)
	public void testcase2()
	{
		//the output of this test method will be it will open the app 
		//i want to click on views usinf an attribute called text.
		driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
		//do you click on an element in your /tap on a element 
		//i am trying to teach here is to tap on an element 
		WebElement ele2 = driver.findElementByAccessibilityId("Expandable Lists");
		//Actions
		TouchAction t = new TouchAction(driver);
		t.tap(tapOptions().withElement(element(ele2))).perform();
		driver.findElementByAccessibilityId("1. Custom Adapter").click();
		WebElement ele3 = driver.findElementByAndroidUIAutomator("text(\"People Names\")");
		t.longPress(longPressOptions().withElement(element(ele3)).withDuration(ofSeconds(3))).release().perform();
		
	System.out.println(driver.findElements(By.className("android.widget.TextView")).get(1).getText());
		
	}
	
	//this is about opening notification
	@Test(enabled=false)
	public void testcase3()
	{
		//i want to open my notification
		driver.openNotifications();
		driver.findElementByAccessibilityId("Battery Saver").click();
	}
	
	@Test(enabled=false)
	public void testcase4()
	{
		driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
		//After clicking on Views i want to scroll to the ened of the page to click on WebViews
		//javascript executor will work only for web app not for Native app
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"))").click();
	}
	
	//Swipe using android
	@Test(enabled=false)
	public void testcase5()
	{
		driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
		driver.findElement(MobileBy.AccessibilityId("Date Widgets")).click();
		driver.findElement(MobileBy.AccessibilityId("2. Inline")).click();
		driver.findElement(MobileBy.AccessibilityId("9")).click();
	WebElement btn1 =	driver.findElement(MobileBy.AccessibilityId("15"));
	WebElement btn2 =driver.findElement(MobileBy.AccessibilityId("45"));
	TouchAction t = new TouchAction(driver);
	//Drag and Drop //Swipe 
	t.longPress(longPressOptions().withElement(element(btn1)).withDuration(ofSeconds(3))).moveTo(element(btn2)).release().perform();
	}
	
	//will check tomorrow
	//i want to click on views//drag and drop//select the first object drag it to second obj
	@Test
	public void testcase6()
	{
		/*driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
        driver.findElementByAccessibilityId("Drag and Drop").click();
        driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1")).click();
        WebElement btn1 =driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
        WebElement btn2 =driver.findElement(By.id("io.appium.android.apis:id/drag_dot_2"));
        TouchAction t = new TouchAction(driver);
        t.longPress(longPressOptions().withElement(element(btn1)).withDuration(ofSeconds(3))).moveTo(element(btn2)).release().perform();*/
		driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
		 driver.findElementByAccessibilityId("Drag and Drop").click();
		 WebElement ele1 = driver.findElementById("io.appium.android.apis:id/drag_dot_1");
	        
	        WebElement ele2 = driver.findElementById("io.appium.android.apis:id/drag_dot_2");
	        TouchAction t = new TouchAction(driver);
	        
	        System.out.println("It Is dragging element.");
	        
	        t.longPress(longPressOptions().withElement(element(ele1)).withDuration(ofSeconds(3))).moveTo(element(ele2)).release().perform();
        
	}

}
