package Utility;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static io.restassured.RestAssured.given;

public class utils {

   static Response response;
    public static WebDriver driver;
    public static String getJsonPath(Response response, String jspath){

        String resp = response.asString();
        JsonPath js = new JsonPath(resp);
        return js.getString(jspath);
    }
    public static void getData(String api){

        response = given().
                when().get(api);
    }
    public static String getDetails(String jspath) {
        return getJsonPath(response, jspath);

    }

    public static void setup() {
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
         driver = new ChromeDriver();
         driver.manage().window().maximize();
    }

    public static void tearDown(){
        driver.close();
    }
    public static void clickOnElement(String xpath){
        explicitwaits(5,xpath);
        driver.findElement(By.xpath(xpath)).click();
    }
    public static void enterValue(String xpath, String value){
        explicitwaits(5,xpath);
        driver.findElement(By.xpath(xpath)).sendKeys(value);
    }

    public static void navigeteToUrl(String url){
        setup();
        driver.get(url);

    }
public static void implicitwaits(int duration){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(duration));
}
    public static void explicitwaits(int duration, String xpath){

        WebDriverWait wt = new WebDriverWait(driver,Duration.ofSeconds(duration));
        wt.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(xpath))));
    }


    public static void selectDropdownIndex(String xpath, int index){
        WebElement dropdown=driver.findElement(By.xpath(xpath));
        Select dp=new Select(dropdown);
        dp.selectByIndex(index);
    }
    public static void selectDropdownValue(String xpath, String value){
        WebElement  dropdown=driver.findElement(By.xpath(xpath));
        Select dp=new Select(dropdown);
        dp.selectByValue(value);
    }
    public static boolean isElemetVisible(String xpath){
        return driver.findElement(By.xpath(xpath)).isDisplayed();
    }

}


