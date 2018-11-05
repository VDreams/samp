package VDreams.AutocodeGen;

import java.net.URL;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.TargetLocator;

/**
 * All the Functional Actions are present here
 */
public class ComonActions extends LaunchPage
{
	public TargetLocator switchTo() {
		
		return null;
	}
	
	public void quit() {
		LaunchPage.driver.quit();
	}
	
	public void close() {
		LaunchPage.driver.close();
	}
	
	public Navigation navigate() {
		back();
	    forward();
	    to(String url);
	    to(URL url);
	    refresh();
		return null;
	}
	

	public Options manage() {
		
		return null;
	}
	
	public Set<String> getWindowHandles() {
		
		return null;
	}
	
	public String getWindowHandle() {
		
		return null;
	}
	
	public String getTitle() {
		
		return LaunchPage.driver.getTitle();
	}
	
	public String getPageSource() {
		
		return LaunchPage.driver.getPageSource();
	}
	
	public String getCurrentUrl() {
		
		return LaunchPage.driver.getCurrentUrl();
	}
	
	public void get(String url) {
		LaunchPage.driver.get(url);		
	}
	
	public List<WebElement> findElements(By by) {
		
		return LaunchPage.driver.findElements(by);
	}
	
	public WebElement findElement(By by) {
		
		return LaunchPage.driver.findElement(by);
	}
	
}
