package baseclass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import 	java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LibGlobal {
	
	public static WebDriver driver;
	
	public static WebDriver getDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		return driver;
	}
	public static void loadUrl(String e) {
		driver.get(e);
	}
	public String currenturl() {
		String url = driver.getCurrentUrl();
		return url;
	}
	public String getTittle() {
		String title = driver.getTitle();
		return title;
	}
	public static void maximize() {
		driver.manage().window().maximize();
	}
	public WebElement findLocatorId(String id) {
		WebElement element = driver.findElement(By.id(id));
		return element;
	}

	public WebElement findLocatoreName(String name) {
		WebElement element = driver.findElement(By.id(name));
		return element;
	}

	public WebElement findLocatorXpath(String xpath) {
		WebElement element = driver.findElement(By.id(xpath));
		return element;
	}

	public static void type(WebElement element, String data) {
		element.sendKeys(data);
	}

	public static void btnClick(WebElement element) {
		element.click();
	}

	public String getText(WebElement element) {
		String data = element.getText();
		return data;
	}

	public String getAttributeValue(WebElement element) {
		String data = element.getAttribute("value");
		return data;
	}

	// select class
	public static void selectValue(WebElement element, String attributeName) {
		Select select = new Select(element);
		select.selectByValue(attributeName);
	}

	public static void selectvisibleText(WebElement element, String attributeName) {
		Select select = new Select(element);
		select.selectByVisibleText(attributeName);
	}

	public static void selectOptionIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	public static void deselectoptionValue(WebElement element, String attributeName) {
		Select select = new Select(element);
		select.deselectByValue(attributeName);
	}

	public static void deselectVisibleText(WebElement element, String index) {
		Select select = new Select(element);
		select.deselectByVisibleText(index);
	}

	public static void deselectoptionindex(WebElement element, int index) {
		Select select = new Select(element);
		select.deselectByIndex(index);
	}

	public static void firstselectoption(WebElement element) {
		Select select = new Select(element);
		select.getFirstSelectedOption();
	}

	public static void deselectall(WebElement element) {
		Select select = new Select(element);
		select.deselectAll();
	}

	
	public boolean multipleoption(WebElement element) {
		Select select = new Select(element);
		boolean multiple = select.isMultiple();
		return multiple;
	}

	public List<WebElement> getAllselected(WebElement element) {
		Select select = new Select(element);
		List<WebElement> allselect = select.getAllSelectedOptions();
		return allselect;
	}

	// robot class
	public static void robotkeydown() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
	}

	public static void robotkeypress() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
	}

	public static void robotkeyreleasenter() throws AWTException {
		Robot robot = new Robot();
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	public static void robotkeypresstab() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
	}

	public static void robotkeypresscontrol() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
	}
	
	public void javaScriptType(WebElement element,String data) {
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor)driver;
		javascriptExecutor.executeScript("aruments[0],'value',"+data+"",element);

	}
	
	public void scrollDown(WebElement element) {
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor)driver;
		try {
			javascriptExecutor.executeScript("arguments[0].scrollIntoView();", element);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
	
	public void JavaScriptClick(WebElement element) {		
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor)driver;
		if (element.isDisplayed()&&element.isEnabled()) {
			javascriptExecutor.executeScript("arguments[0].click()",element);
		}
	}

	// Alert
	public Alert switchToAlert() {
		Alert al = driver.switchTo().alert();
		return al;
	}

	public void alertAccept() {
		Alert alert = switchToAlert();
		alert.accept();
	}

	public void alertDismiss() {
		Alert alert = switchToAlert();
		alert.dismiss();
	}

	public boolean isEnabled(WebElement elem) {
		boolean enabled = elem.isEnabled();
		return enabled;
	}

	public String alertgetText(String data) {
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		return text;
	}

	public static void quit() {

		driver.quit();
	}

	public static void close() {

		driver.close();
	}

	// navigation
	public Navigation NavigateForward() {
		Navigation n = driver.navigate();
		return n;
	}
	

	public static void navigatebackward(String url) {
		Navigation navigate = driver.navigate();
		navigate.back();
	}

	public static void navigaterefresh(String url) {
		Navigation navigate = driver.navigate();
		navigate.refresh();
	}

	public static void screenshot(String path) throws IOException {

		TakesScreenshot tk = (TakesScreenshot) driver;
		File src = tk.getScreenshotAs(OutputType.FILE);
		File destination = new File(path);
		FileUtils.copyFile(src, destination);
	}

	// take screenshot
	public static void screenShort(String name, WebElement element) throws IOException {
		File file = element.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File(
				"C:\\Users\\admin\\eclipse-workspace\\FrameWork\\Excel\\sampledatadrven.xlsx" + name + "+.png"));
	}

	public static void screenShorts(String name) throws IOException {
		TakesScreenshot tk = (TakesScreenshot) driver;
		File file = tk.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File(
				"C:\\Users\\admin\\eclipse-workspace\\FrameWork\\Excel\\sampledatadrven.xlsx" + name + "+.png"));

	}
	
	public static void writeData(String sheetname, int rownum, int cellnum, String data) throws IOException {

		File file = new File("C:\\Users\\admin\\eclipse-workspace\\FrameWork\\Excel\\datas.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet s = workbook.getSheet(sheetname);
		Row row = s.getRow(rownum);
		Cell c = row.createCell(cellnum);
		c.setCellValue(data);
		FileOutputStream out = new FileOutputStream(file);
		workbook.write(out);
	}

	public String getDataFromExcel(String sheet, int row, int cell) throws IOException {
		String value = null;
		File exeloc = new File("C:\\Users\\admin\\eclipse-workspace\\FrameWork\\Excel\\datas.xlsx");
		FileInputStream str = new FileInputStream(exeloc);
		Workbook w = new XSSFWorkbook(str);
		Sheet s = w.getSheet(sheet);
		Row r = s.getRow(row);
		Cell c = r.getCell(cell);
		int type = c.getCellType();
		if (type == 1) {
			value = c.getStringCellValue();
		}
		if (type == 0) {

			if (DateUtil.isCellInternalDateFormatted(c)) {
				Date cellvalue = c.getDateCellValue();
				SimpleDateFormat sim = new SimpleDateFormat("dd-mm-yyy");
				value = sim.format(cellvalue);

			} else {

				double d = c.getNumericCellValue();
				long l = (long) d;
				value = String.valueOf(l);
			}
		}
		return value;


	}}
