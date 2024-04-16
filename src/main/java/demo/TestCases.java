package demo;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import java.util.logging.Level;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCases {
    ChromeDriver driver;

    public TestCases() {
        System.out.println("Constructor: TestCases");

        WebDriverManager.chromedriver().timeout(30).setup();
        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        // Set log level and type
        logs.enable(LogType.BROWSER, Level.INFO);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);

        // Connect to the chrome-window running on debugging port
        options.setExperimentalOption("debuggerAddress", "127.0.0.1:9222");

        // Set path for log file
        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "chromedriver.log");

        driver = new ChromeDriver(options);

        // Set browser to maximize and wait
        driver.manage().window().maximize();
    }

    public void endTest() {
        System.out.println("End Test: TestCases");
        // driver.close();
        // driver.quit();

    }

    public void testCase01() {
        System.out.println("Start Test case: testCase01");
        // driver.get("https://www.google.com");
        driver.get("https://calendar.google.com/ ");
        String url = driver.getCurrentUrl();
        if (url.contains("calendar")) {
            System.out.println("Sucessfully Navigated to Calendar");
        }
        System.out.println("end Test case: testCase01");

    }

    public void testCase02() throws InterruptedException {
        System.out.println("Start Test case: testCase02");
        driver.findElement(By.xpath("//div[@class='XyKLOd']")).click();
        List<WebElement> menuDropDown = driver.findElements(By.xpath("//ul[@jsname='rymPhb']/li/span"));
        for (WebElement el : menuDropDown) {
            if (el.getText().contains("Month")) {
                System.out.println(el.getText());
                el.click();
                break;
            }
        }
        Thread.sleep(4000);
        // driver.findElement(By.xpath("//div[@class='fimTmc']")).click();
        List<WebElement> dateSelection = driver.findElements(By.xpath("//div[@class='kbf0gd']/div/div[2]/div/h2"));
        // Date d = new Date();

        for (WebElement date : dateSelection) {
            if (date.getText().equals("10")) {
                date.click();
                break;
            }
        }

        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='fimTmc']")).click();
        //// input[@placeholder='Add title and time']
        // textarea[@placeholder='Add description']
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@id='tabTask']")).click();

        driver.findElement(By.xpath("//input[@placeholder='Add title and time']"))
                .sendKeys("Crio INTV Task Automation");
        driver.findElement(By.xpath("//textarea[@placeholder='Add description']"))
                .sendKeys("Crio INTV Calendar Task Automation");
        Thread.sleep(2000);
        List<WebElement> btnList = driver.findElements(By.xpath("//button[@jscontroller='soHxf']"));

        for (WebElement date : btnList) {
            if (date.getText().equalsIgnoreCase("save")) {
                date.click();
                break;
            }
        }
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='XyKLOd']")).click();
        // List<WebElement> menuDropDown=
        // driver.findElements(By.xpath("//ul[@jsname='rymPhb']/li/span"));

        // for (WebElement el : menuDropDown) {
        //     if (el.getText().contains("Month")) {
        //         System.out.print("[[[[[]]]]]" + el.getText());
        //         System.out.println(el.getText());
        //         el.click();
        //         break;
        //     }
        // }
        System.out.println("end Test case: testCase02");

    }

    public void testCase03() throws InterruptedException {
        System.out.println("Start Test case: testCase03");
        driver.findElement(By.xpath("//div[@class='XyKLOd']")).click();
        List<WebElement> menuDropDown = driver.findElements(By.xpath("//ul[@jsname='rymPhb']/li/span"));
        for (WebElement el : menuDropDown) {
            if (el.getText().contains("Month")) {
                el.click();
                break;
            }
        }
        Thread.sleep(4000);

        List<WebElement> dateSelection = driver.findElements(By.xpath("//div[@class='kbf0gd']/div/div[2]/div/h2"));
        // Date d = new Date();

        for (WebElement date : dateSelection) {
            if (date.getText().equals("10")) {
                date.click();
                break;
            }
        }

        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[text()='Crio INTV Task Automation']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@aria-label='Edit task']")).click();

        driver.findElement(By.xpath("//textarea[@placeholder='Add description']"))
                .sendKeys(
                        "Crio INTV Task Automation is a test suite designed for automating various tasks on the Google Calendar web application");

                        Thread.sleep(2000);
        List<WebElement> btnList = driver.findElements(By.xpath("//button[@jscontroller='soHxf']"));

        for (WebElement date : btnList) {
            if (date.getText().equalsIgnoreCase("save")) {
                date.click();
                break;
            }
        }
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[text()='Crio INTV Task Automation']")).click();
        Thread.sleep(2000);
        String str = driver.findElement(By.xpath("//div[@class='toUqff D29CYb']")).getText();
        System.out.println(str);
       // if(str.contains("Crio INTV Calendar Task AutomationCrio INTV Task Automation is a test suite designed for automating various tasks on the Google Calendar web applicationCrio INTV Task Automation is a test suite designed for automating various tasks on the Google Calendar web application"));

       driver.findElement(By.xpath("//button[@id='xDetDlgCloseBu']")).click();

    }

    public void testCase04() throws InterruptedException {
        System.out.println("Start Test case: testCase04");
        driver.findElement(By.xpath("//div[@class='XyKLOd']")).click();
        List<WebElement> menuDropDown = driver.findElements(By.xpath("//ul[@jsname='rymPhb']/li/span"));
        for (WebElement el : menuDropDown) {
            if (el.getText().contains("Month")) {
                el.click();
                break;
            }
        }
        Thread.sleep(4000);

        List<WebElement> dateSelection = driver.findElements(By.xpath("//div[@class='kbf0gd']/div/div[2]/div/h2"));
        // Date d = new Date();

        for (WebElement date : dateSelection) {
            if (date.getText().equals("10")) {
                date.click();
                break;
            }
        }

        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[text()='Crio INTV Task Automation']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@aria-label='Delete task']")).click();
      //  Thread.sleep(1500);
        WebElement ele = driver.findElement(By.xpath("//div[text()='Task deleted']"));
        if(ele.getText().contains("Task deleted")) {
            System.out.println(ele.getText());
        }
        System.out.println("end Test case: testCase04");
       Thread.sleep(4000);
    }
}
