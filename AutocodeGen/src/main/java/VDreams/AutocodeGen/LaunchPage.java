package VDreams.AutocodeGen;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Launching Browser and hitting URL methods are here
 */
public class LaunchPage 
{
	public static WebDriver driver;
    public static void main( String[] args ) throws URISyntaxException, IOException
    {
//        System.out.println( "Hello World!" );
//        
//        Desktop desktop = java.awt.Desktop.getDesktop();
//        URI uri = new java.net.URI("https://www.google.com/?gws_rd=ssl");
//        desktop.browse(uri);
    	
    	Scanner webpageinput = new Scanner(System.in);
    	System.out.println("Please enter the current website link");
    	String inputurl=webpageinput.nextLine();
    	System.setProperty("webdriver.chrome.driver","D:\\Satish Chanaveeragoudar\\eclipse-workspace-satish\\AutocodeGen\\driver\\chromedriver.exe");
    	driver = new ChromeDriver();
    	
    	driver.get(inputurl);
    }
    
}


