package com.shoesizeme.sa.ui.tester.shop13_goertz;

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
 @className: Goertz_Test2
 @description: This class contains 3 operation flows of normal user with account.
 All the testing scripts will be called and running through this class.
 @version: v1.0
 */

public class Goertz_Test2 {
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
     * test1-test3 : This test will simulate a adult user with account going through a normal user flow to get a recommendation by one time or trying to modify account information.
     *               All the testing steps indicated clearly by the methods names.
     *               In order to save time and test more element, Plused several more steps in each test(1-3) is to test some certain buttons r working well(like exit,close...).
     * @param
     * @return null
     * @version 1.0
     */

    @Test
    public void test1() throws InterruptedException {

        PoComponentAdult pc=new PoComponentAdult(driver,"http://shoesize.me/plugin_v3");
        pc.inputShopId("3069572");
        pc.inputShoeId("48844401");
        pc.selectLang("de");
        pc.selectScale("eu");
        pc.generateSaButton();
        // ---user landing page
        pc.clickSA();
        pc.switchInto360();
        pc.clickLoginHere();
        // ---login page
        pc.loginWithEmail("long.lin@shoesize.me","SSMLONG2019");
        // ---reco page
        pc.checkRecoPage();
        pc.closeSaButton();
        /*
         * After getting reco through user landing, we can close SA button as an normal user behaviour.
         * Then open the SA again, the user landing reco page is still being presented.Sometimes this page will be blank after close SA and restart.
         * So we can come next to check if "Not yours?Get start again" button.
         * */
        pc.switchOutOf360();
        pc.clickSA();
        pc.switchInto360();
        pc.closeSaButton();
    }


    @Test
    public void test2() throws InterruptedException {

        PoComponentAdult pc=new PoComponentAdult(driver,"http://shoesize.me/plugin_v3");
        pc.inputShopId("3069572");
        pc.inputShoeId("48844401");
        pc.selectLang("de");
        pc.selectScale("eu");
        pc.generateSaButton();
        // ---user landing page
        pc.clickSA();
        pc.switchInto360();
        pc.clickLoginHere();
        // ---login page
        pc.loginWithEmail("long.lin@shoesize.me","SSMLONG2019");
        /*
         * Due to new ui updated new feature. We just need to go to shoe shelf to modify shoe items when the size is not produced.
         * There r two options to update shoe shelf items.
         * option 1: Add a new shoe---current test
         *           Right After add a new shoe, we need to remove one of them for keep shoe item 3 shoes all the time.By the way test remove function.
         * option 2: Modify a shoe
         * */
        // ---reco page in account
        pc.user_OpenShoeshelf();
        // ---shoe shelf items page
        pc.user_addShoesProcessAndCheck();
        pc.user_removeShoesProcessAndCheck();
    }

    @Test
    public void test3() throws InterruptedException {

        PoComponentAdult pc=new PoComponentAdult(driver,"http://shoesize.me/plugin_v3");
        pc.inputShopId("3069572");
        pc.inputShoeId("48844401");
        pc.selectLang("de");
        pc.selectScale("eu");
        pc.generateSaButton();
        // ---user landing page
        pc.clickSA();
        pc.switchInto360();
        pc.clickLoginHere();
        // ---login page
        pc.loginWithEmail("long.lin@shoesize.me","SSMLONG2019");
        /*
         * Due to new ui updated new feature. We just need to go to shoe shelf to modify shoe items when the size is not produced.
         * There r two option to update shoe shelf items.
         * option 1: Add a new shoe
         *           Right After add a new shoe, we need to remove one of them for keep shoe item 3 shoes all the time.By the way test remove function.
         * option 2: Modify a shoe---current test
         * */

        // ---reco page in account
        pc.user_OpenShoeshelf();
        // ---shoe shelf items/meBtn page
        pc.user_modifyProfile();
        // ---account profile page
        pc.user_selectAgender();
        pc.inputYearOfBirth("2005");
        pc.selectFootArch();
        pc.selectFootWidth();
        pc.user_saveProfileAndCheck();
        pc.user_clickAccountCred();
        // ---account credencial page
        pc.user_changePwdAndCheck("SSMLONG2019","SSMLONG2019","SSMLONG2019");
        pc.user_exitAccount();
        // ---landing page
        pc.closeSaButton();

    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
        System.out.println("testA2 finished");
    }
}
