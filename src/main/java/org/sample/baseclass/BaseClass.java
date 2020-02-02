package org.sample.baseclass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class BaseClass {
static WebDriver driver;
public static void launchChromeBrowser() {
	System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\eclipse-workspace\\JavaUnit\\driver\\chromedriver.exe");
	driver = new ChromeDriver();
}
public static void loadUrl(String url) {
	driver.get(url);
}
public static void getTitle() {
driver.getTitle();
System.out.println("Git");
}

public static void getCurrentUrl() {
String currentUrl = driver.getCurrentUrl();
System.out.println(currentUrl);
}
public static void fill(WebElement e, String value) {
e.sendKeys(value);
}
public static void SBI(WebElement e, int index) {
Select s = new Select(e);
s.selectByIndex(index);
}
public static void btnClick(WebElement e) {
e.click();
}
public static void quitBrowser() {
driver.quit();
}
public static String getDataFromExcel(int rowNo, int cellNo) throws Throwable {
String value = null;
File f = new File("C:\\Users\\Admin\\eclipse-workspace\\projectclass\\jar\\Excel.xlsx");
FileInputStream st = new FileInputStream(f);
Workbook w = new XSSFWorkbook(st);
Sheet s = w.getSheet("Sheet1");
Row r = s.getRow(cellNo);
Cell cell = r.getCell(cellNo);
int type = cell.getCellType();
		if(type==1) {
		value = cell.getStringCellValue();
		}
		else if(type==0) {
			if(DateUtil.isCellDateFormatted(cell)) {
				Date dt = cell.getDateCellValue();
				SimpleDateFormat st1 = new SimpleDateFormat("DD-MMM-YYYY");
				value = st1.format(dt);
			}
			else {
				double nm = cell.getNumericCellValue();
				long l = (long)nm;
				value = String.valueOf(l);
			}
		}
		return value;
}

}

		