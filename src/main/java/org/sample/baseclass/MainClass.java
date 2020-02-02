package org.sample.baseclass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MainClass extends BaseClass {
public static void main(String[] args) throws Throwable {
launchChromeBrowser();
loadUrl("https://www.facebook.com/");
driver.manage().window().maximize();
getTitle();
getCurrentUrl();
WebElement u = driver.findElement(By.id("email"));
fill(u,getDataFromExcel(1,0));
WebElement p = driver.findElement(By.id("pass"));
fill(p, getDataFromExcel(2,0));
WebElement date = driver.findElement(By.id("day"));
SBI(date,5);
WebElement month = driver.findElement(By.id("month"));
SBI(month, 8);
WebElement button = driver.findElement(By.id("loginbutton"));
btnClick(button);
getCurrentUrl();
quitBrowser();
System.out.println("Peaky Blinders");
System.out.println("Peaky Blinders");
}

}
