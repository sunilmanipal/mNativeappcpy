package Nativedemos;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;

public class Capability {

	public static AndroidDriver<AndroidElement> capabilities() throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		//This are the capabilites which are manadatory all the time 
		//File f = new File("src\\ApiDemos-debug.apk");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "sunil Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		//Automation Name 
		//This is optional in android //but this is mandatory when it comes IPhone 
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
		//in mac machien we use xcode to simulate ui Test//xc//this something very m
		//cap.setCapability(MobileCapabilityType.APP, f.getAbsolutePath());
		cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "io.appium.android.apis");
        cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "io.appium.android.apis.ApiDemos");
		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"),cap);
		return driver;
	}

}
