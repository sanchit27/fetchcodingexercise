import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class SDETChallengeTest {
    private static WebDriver driver;
    private static List<WebElement> balanceScale;
    private static int[] coins = {0, 1, 2, 3, 4, 5, 6, 7, 8};
    private static List<String> weighings = new ArrayList<>();
    private static String popupDialogue;

    private static WebElement fakeElementValue;

    public static WebElement getFakeElementValue() {
        return fakeElementValue;
    }

    public static void setFakeElementValue(WebElement fakeElementValue) {
        SDETChallengeTest.fakeElementValue = fakeElementValue;
    }



    public String fetchIndexData(int index) {
        WebElement olElement = driver.findElement(By.cssSelector(".game-info ol"));
        WebElement indexDataElement = olElement.findElement(By.cssSelector("li:nth-child(" + index + ")"));
        return indexDataElement.getText();
    }

    //Update url if you are using other port
    private static final String GRID_HUB_URL = "http://localhost:4444/wd/hub";

    //If you are using pc other than MAC with arm64, download docker and follow the steps given in README
    // You can use this code also for MAC with arm 64

//    @BeforeAll
//    public static void browserStart() {
//        FirefoxOptions options = new FirefoxOptions();
//        try {
//            driver = new RemoteWebDriver(new URL(GRID_HUB_URL), options);
//            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
//    }

 //If you are using MAC os with arm64, just uncomment this code and use gradle run
    @BeforeAll
    public static void browserStart() {
        String projectDirectory = System.getProperty("user.dir");

        System.setProperty("webdriver.gecko.driver", "/Applications/geckodriver");
        System.setProperty("webdriver.firefox.bin", "/Applications/Firefox.app/Contents/MacOS/firefox");

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }



    @AfterAll
    public static void browserClose() {
        driver.quit();
    }

    @Test
    @Order(1)
    public void testStep1() {
        driver.get("http://sdetchallenge.fetch.com/");
        String title = driver.getTitle();
        assert title.equals("React App");

        balanceScale = driver.findElements(By.cssSelector(".game-board"));
        assert balanceScale.size() == 2;
        assert balanceScale.get(0).getText().equals("left bowl");
        assert balanceScale.get(1).getText().equals("right bowl");
    }

    @Test
    @Order(2)
    public void testStep2() {
        try {
            // Fill left pans with gold coin values
            for (int i = 0; i < 3; i++) {
                driver.findElement(By.id("left_" + i)).sendKeys(String.valueOf(coins[i]));
            }

            // Fill right pans with gold coin values
            for (int i = 0; i < 3; i++) {
                driver.findElement(By.id("right_" + i)).sendKeys(String.valueOf(coins[i + 3]));
            }
            WebElement resultFirst = driver.findElement(By.cssSelector(".result .button"));

            // Click on the Weigh button
            driver.findElement(By.id("weigh")).click();

            // Get the result details using getNthResult method
            String resultDetails = fetchIndexData(1);
            System.out.println("Result First Operation:"+resultFirst.getText());
            assert !resultFirst.getText().equals(" ?");
            // Assertion for result details containing the result operator
            assert resultDetails.contains(resultFirst.getText());

            // Add the result details to weighings
            weighings.add(resultDetails);


            // Assertion for the size of weighings
            assert weighings.size() == 1;

            // Update goldCoins array based on the result operator
            if (resultFirst.getText().equals("=")) {
                coins = Arrays.copyOfRange(coins, 6, coins.length);
            } else if (resultFirst.getText().equals("<")) {
                coins = Arrays.copyOfRange(coins, 0, 3);
            } else if (resultFirst.getText().equals(">")) {
                coins = Arrays.copyOfRange(coins, 3, 6);
            }


            driver.findElement(By.id("reset")).click();
            driver.findElement(By.id("left_0")).clear();
            driver.findElement(By.id("left_1")).clear();
            driver.findElement(By.id("left_2")).clear();
            driver.findElement(By.id("right_0")).clear();
            driver.findElement(By.id("right_1")).clear();
            driver.findElement(By.id("right_2")).clear();

        } catch (Exception e) {
            e.printStackTrace();
            assert false; // Fail the test
        }
    }


    @Test
    @Order(3)
    public void testStep3() {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));


        driver.findElement(By.id("left_0")).sendKeys(String.valueOf(coins[0]));
        driver.findElement(By.id("right_0")).sendKeys(String.valueOf(coins[1]));
        WebElement resultSecond = driver.findElement(By.cssSelector(".result .button"));

        // Click on the Weigh button
        driver.findElement(By.id("weigh")).click();
        // Click on the Reset button
        driver.findElement(By.id("reset")).click();

        // Get the result details using fetchIndexData method
        String resultDetailsSecond = fetchIndexData(2);

        // Assertion for the result button not containing "?"
        assert !resultSecond.getText().equals(" ?");

        System.out.println("Result Second Operation:"+resultSecond.getText());


        // Assertion for result details containing the result operator
        assert resultDetailsSecond.contains(resultSecond.getText());

        // Add the result details to weighings
        weighings.add(resultDetailsSecond);

        assert weighings.size() == 2;

        if (resultSecond.getText().equals("=")) {
            fakeElementValue = driver.findElement(By.id("coin_" + coins[2]));
        } else if (resultSecond.getText().equals("<")) {
            fakeElementValue = driver.findElement(By.id("coin_" + coins[0]));
        } else if (resultSecond.getText().equals(">")) {
            fakeElementValue = driver.findElement(By.id("coin_" + coins[1]));
        }
        setFakeElementValue(fakeElementValue);
    }

    @Test()
    @Order(4)
    public void testStep4() {
        // Test step 3 code here...

        driver.findElement(By.id("coin_" + getFakeElementValue().getText())).click();
        popupDialogue = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        System.out.println("Weighings List:");
        for (String weighing : weighings) {
            System.out.println(weighing);
        }

        assert popupDialogue.equals("Yay! You find it!");

        System.out.println("Fake Coin Value : " + fakeElementValue.getText());
        System.out.println("Final Result:" + popupDialogue);
    }
}

