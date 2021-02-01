package basicframe;

import constants.Drivers;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public abstract class BasicTestFrame {

    protected WebDriver driver;
    public static Logger logger;

    @BeforeClass
    public void runDriver() {
        runLogger();
        // Add path to chrome driver
        if(System.getProperty("os.name").toLowerCase().contains("linux")){
            System.setProperty("webdriver.chrome.driver", Drivers.PATH_TO_LINUX_CHROME_DRIVER);
        }
        else {
            System.setProperty("webdriver.chrome.driver", Drivers.PATH_TO_WINDOWS_CHROME_DRIVER);
        }

        if(driver == null){
            driver = new ChromeDriver();
        }
        driver.manage().timeouts().
                implicitlyWait(Long.parseLong(
                        ConfigProperties.getProperty("implicit.waiter")), TimeUnit.SECONDS);
        driver.manage().window().setSize(new Dimension(500, 1000));
        driver.get(ConfigProperties.getProperty("base.url"));
        logger.info(" Browser chrome is running.");
    }

    private void runLogger(){
        logger = Logger.getLogger(BasicTestFrame.class.getName());
        logger.info("Logger is running.");
    }

    @AfterClass
    public void quiteDriver(){

        if(driver != null){
            driver.quit();
            logger.info("Driver stopped.");
        }
    }
}
