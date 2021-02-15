package com.shoesizeme.sa.ui.tester.shop5_seavees;

import com.shoesizeme.sa.ui.testerPo.PoComponentAdult;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 @author: ssmlong
 @className: Zumnorde_Test3
 @description: This class contains 4 operation flows of normal user with account.
 All the testing scripts will be called and running through this class.
 @version: v1.0
 */

public class Seavees_Test3 {
    /**
     * setUp : Invoke the brower after cleaning cookies; Resize viewport in the brower for fetching web element easily.
     * @param
     * @return null
     * @version 1.0
     */
    WebDriver driver;
    @BeforeMethod
    public void setUp() throws Exception {
        System.setProperty("webdriver.gecko.driver","tools/geckodriver");
        driver=new FirefoxDriver();
        driver.manage().deleteAllCookies();
        //driver.manage().window().maximize();

        Dimension d = new Dimension(2000,1200);
        //Resize current window to the set dimension
        driver.manage().window().setSize(d);

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
    }

    /**
     * test1: This test is an unusual user flow desinged for testing some key emelemts combination and avoiding some funny behavior in 360.
     *               All the testing steps indicated clearly by the methods names.
     * @param
     * @return null
     * @version 1.0
     */

    @Test
    public void test1() throws InterruptedException {

        PoComponentAdult pc=new PoComponentAdult(driver,"http://shoesize.me/plugin_v3");
        pc.inputShopId("25461170");
        pc.inputShoeId("4645100781642");
        pc.selectLang("en");
        pc.selectScale("us");
        pc.generateSaButton();
        // ---user landing page
        pc.clickSA();
        pc.switchInto360();
        pc.clickGetStart();

        // ---profile page
        /*
         *  Click "Next" button directly, then check if it works(if there is warning info)
         *  A-Yes:correct---continue
         *  B-No: incorrect---test break
         * */
        pc.clickNext();
        pc.checkErrorInTempProfile();
        /*
         *  Clear everything and only select male, Click "Next" button, then check if it works(if there is warning info).
         *  A-success jumping to next page:correct---go back and restart this process with female
         *  B-fail jumping to next page: incorrect---test break
         * */
        pc.selectMale();
        pc.clickNext();
        pc.clickBack();
        pc.closeSaButton();
    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
        System.out.println("testA3 finished");
    }
}
