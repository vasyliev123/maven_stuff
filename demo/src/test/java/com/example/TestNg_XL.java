// package com.example;

// import java.io.FileInputStream;
// import java.io.IOException;

// import org.apache.poi.hssf.record.chart.CatLabRecord;
// import org.apache.poi.ss.usermodel.Cell;
// import org.apache.poi.xssf.usermodel.XSSFRow;
// import org.apache.poi.xssf.usermodel.XSSFSheet;
// import org.apache.poi.xssf.usermodel.XSSFWorkbook;

// import java.time.Duration;
// import java.util.concurrent.TimeUnit;
// import org.openqa.selenium.By;
// import org.openqa.selenium.Keys;
// import org.openqa.selenium.WebElement;
// import org.openqa.selenium.WebDriver;
// import org.openqa.selenium.chrome.ChromeDriver;
// import org.openqa.selenium.chrome.ChromeOptions;
// import org.openqa.selenium.support.ui.ExpectedConditions;
// import org.openqa.selenium.support.ui.WebDriverWait;
// import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTAnchorClientData;
// import org.testng.Assert;
// import org.testng.annotations.Test;
// import org.testng.annotations.Parameters;
// import org.testng.annotations.Test;
// import org.testng.annotations.Optional;
// import org.testng.Reporter;
// import org.testng.annotations.AfterMethod;
// import org.testng.annotations.BeforeMethod;
// import org.testng.annotations.DataProvider;

// public class TestingMethodTtest {
//     WebDriver driver;

//     @BeforeMethod
//     public void setup() {
//         System.out.println("Start Test");

//         // Initialize ChromeDriver
//         System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\SeleniumWebDriver\\chromedriver.exe");
//         driver = new ChromeDriver();

//         String url = "https://www.google.com";
//         driver.get(url);
//         driver.manage().window().maximize();
//         driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
//     }

//     @DataProvider(name = "excel-data")
//     public Object[][] excelDP() throws IOException {

//         // creating an object from the excel file by calling a method that reads Data
//         // from the Excel file storred locally in the computer
//         Object[][] arrObjects = getExcelData("docs\\TestData.xls", "Sheet1");

//         return arrObjects;

//     }

//     public String[][] getExcelData(String filename, String sheetname) {
//         String[][] data = null;

//         FileInputStream fis = null;
//         XSSFWorkbook wb = null;

//         try {
//             fis = new FileInputStream(filename);
//             wb = new XSSFWorkbook(fis);
//             XSSFSheet sh = wb.getSheet(sheetname);
//             XSSFRow row = sh.getRow(0);
//             int getNumberOfRows = sh.getPhysicalNumberOfRows();
//             int getNumberOfCols = row.getLastCellNum();
//             Cell cell;
//             data = new String[getNumberOfRows - 1][getNumberOfCols];
//             for (int i = 0; i < getNumberOfRows; i++) {
//                 for (int j = 0; j < getNumberOfCols; j++) {
//                     row = sh.getRow(i + 1);
//                     cell = row.getCell(j);
//                     data[i][j] = cell.getStringCellValue();
//                 }
//             }
//             wb.close();
//         } catch (IOException e) {
//             System.out.println("The exception that was generated is : " + e.getMessage());
//         } finally {
//             try {
//                 if (wb != null) {
//                     wb.close();
//                 }
//                 if (fis != null) {
//                     fis.close();
//                 }
//             } catch (IOException e) {
//                 System.out.println("There was an error closing the workbook" + e.getMessage());
//             }
//             return data;
//         }
//     }

//     @Test(dataProvider = "excel-data")
//     public void search(String keyword1, String keyword2) {
//         System.out.println("Data that we have received from keyword1 = " + keyword1 + " " + "Keyword2= " + keyword2);
//         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//         wait.until(ExpectedConditions.urlContains("https//www.google.com"));
//         WebElement txtBox = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("q")));
//         txtBox.sendKeys(Keyword1, "", keyword2);
//         Reporter.log("keywords entered are: " + keyword1 + keyword2);
//         txtBox.sendKeys(Keys.ENTER);
//         Reporter.log("Search results are displayed");
//     }

// }