package com.shoesizeme.sa.ui.kidstester.shop1_penlandkickers;
import com.shoesizeme.sa.ui.testerPo.PoComponentKids;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

/**
 @author: ssmlong
 @className: Penlandkickers_kids_Test
 @description: this is the testing class for One shop. All the testing scripts will be called and running through this class.
 @version: v1.0
 */

public class Penlandkickers_kids_Test {
    WebDriver driver;
    /**
     * setUp : Invoke the brower after cleaning cookies; Resize viewport in the brower for fetching web element easily.
     * @param
     * @return null
     * @version 1.0
     */
    @BeforeMethod
    public void setUp() throws Exception {
        System.setProperty("webdriver.gecko.driver","tools/geckodriver");
        driver=new FirefoxDriver();
        driver.manage().deleteAllCookies();
        //driver.manage().window().maximize();// seems not working well.

        Dimension d = new Dimension(2000,1200);
        driver.manage().window().setSize(d); //Resize current window to the set dimension

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
    }

    /**
     * test1 : this test merges three test sets together. All the testing steps indicated clearly by the methods names.
     *         Set 1 - It will simulate a kids user(boy) to go through SA UI to get a recommendation by one time.
     *         Set 2 - In the middle, there are several steps to test if some certain buttons r working well(like exit,close...).
     *         Set 3 - The first recommendation not very credible, restart the process after getting the first reco.
     * @param
     * @return null
     * @version 1.0
     */

    @Test
    public void test1() throws InterruptedException {

        // Initialize test product data
        //https://www.kickers.co.uk/girls-c282/kick-hi-angelic-infant-p6715
        PoComponentKids pck=new PoComponentKids(driver,"http://shoesize.me/plugin_v3");
        pck.resetSizeChart("5,6,7,8,9,10");
        pck.inputShopId("14617462");
        pck.inputShoeId("6715");
        pck.selectLang("en");
        pck.selectScale("uk");
        pck.generateSaButton();
        pck.clickSA();

        // ---------------set 1---------------
        pck.switchInto360();
        pck.inputShoeLength("150");
        pck.clickContinue();
        pck.inputAge("15");
        pck.clickContinue();
        pck.selectBoyGenderOfKids();

        // ---------------Set 2---------------
        pck.clickCloseBtn();
        pck.switchOutOf360();
        pck.clickSA();
        pck.switchInto360();
        pck.clickExitBtn();

        pck.switchOutOf360();
        pck.clickSA();
        pck.switchInto360();
        pck.clickContinue();

        // ---------------Set 3---------------
        pck.switchOutOf360();
        pck.clickSA();
        pck.switchInto360();
        pck.clickStartAgain();

        pck.inputShoeLength("120");
        pck.clickContinue();
        pck.inputAge("12");
        pck.clickContinue();
        pck.selectBoyGenderOfKids();
    }

    /**
     * test1 : this test merges three test sets together. All the testing steps indicated clearly by the methods names.
     *         Set 1 - It will simulate a kids user(girl) to go through SA UI to get a recommendation by one time.
     *         Set 2 - In the middle, there are several more steps to test if some certain buttons r working well(like exit,close...).
     *         Set 3 - The first recommendation not very credible, restart the process after getting the first reco.
     * @param
     * @return null
     * @version 1.0
     */

    @Test
    public void test2() throws InterruptedException {
        // Initialize test product data
        //https://www.kickers.co.uk/girls-c282/kick-hi-angelic-infant-p6715
        PoComponentKids pck=new PoComponentKids(driver,"http://shoesize.me/plugin_v3");
        pck.resetSizeChart("5,6,7,8,9,10");
        pck.inputShopId("14617462");
        pck.inputShoeId("6715");
        pck.selectLang("en");
        pck.selectScale("uk");
        pck.generateSaButton();
        pck.clickSA();

        // ---------------Set 1---------------
        pck.switchInto360();
        pck.inputShoeLength("150");
        pck.clickContinue();
        pck.inputAge("15");
        pck.clickContinue();
        pck.selectGirlGenderOfKids();

        // ---------------Set 2---------------
        pck.clickCloseBtn();
        pck.switchOutOf360();
        pck.clickSA();
        pck.switchInto360();
        pck.clickExitBtn();

        pck.switchOutOf360();
        pck.clickSA();
        pck.switchInto360();
        pck.clickContinue();

        // ---------------Set 3---------------
        pck.switchOutOf360();
        pck.clickSA();
        pck.switchInto360();
        pck.clickStartAgain();

        pck.inputShoeLength("120");
        pck.clickContinue();
        pck.inputAge("12");
        pck.clickContinue();
        pck.selectGirlGenderOfKids();

    }


    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
        System.out.println("testA1 finished");
    }
}