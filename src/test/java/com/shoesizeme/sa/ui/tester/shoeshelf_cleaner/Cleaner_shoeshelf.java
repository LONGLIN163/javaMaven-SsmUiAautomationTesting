package com.shoesizeme.sa.ui.tester.shoeshelf_cleaner;

import com.shoesizeme.sa.ui.testerPo.PoComponentAdult;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * active this script, clean all shoes, only keep three shoes in the item
 */
public class Cleaner_shoeshelf {
    WebDriver driver;

    @BeforeMethod
    public void setUp() throws Exception {
        System.setProperty("webdriver.gecko.driver", "tools/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().deleteAllCookies();
        //driver.manage().window().maximize();

        Dimension d = new Dimension(2000, 1200);
        //Resize current window to the set dimension
        driver.manage().window().setSize(d);

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
    }

    @Test
    public void checkShoeshelf() throws InterruptedException {

        PoComponentAdult pc = new PoComponentAdult(driver, "http://shoesize.me/plugin_v3");
        pc.inputShopId("29207773");
        pc.inputShoeId("2505569140794");
        pc.selectLang("en");
        pc.selectScale("us");
        pc.generateSaButton();

        pc.clickSA();
        pc.switchInto360();
        pc.clickLoginHere();
        pc.loginWithEmail("long.lin@shoesize.me", "SSMLONG2019");
        pc.user_OpenShoeshelf();

        while (true) {

            int checkItemsResult = pc.user_checkShoeshelf();
            System.out.println("checkItemsResult********" + checkItemsResult);
            if (checkItemsResult > 3) {
                System.out.println("checkItemsResult----Overflow, removing shoes from your shoe shelf!");
                pc.user_removeShoesProcessAndCheck();
            } else {
                System.out.println("checkItemsResult----Safe, you have 3 items in your shoe shelf!");
                break;
            }
        }
    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
        System.out.println("testA2 finished");
    }
}
