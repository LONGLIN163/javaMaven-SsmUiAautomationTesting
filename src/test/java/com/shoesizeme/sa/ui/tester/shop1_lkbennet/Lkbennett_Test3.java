package com.shoesizeme.sa.ui.tester.shop1_lkbennet;

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
 @className: Lkbennett_Test3
 @description: This class contains 4 operation flows of normal user with account.
 All the testing scripts will be called and running through this class.
 @version: v1.0
 */

public class Lkbennett_Test3 {
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
     * test1-test2 : These test is an unusual user flow desinged for testing some key emelemts combination and avoiding some funny behavior in 360.
     *               All the testing steps indicated clearly by the methods names.
     * @param
     * @return null
     * @version 1.0
     */

    @Test
    public void test1() throws InterruptedException {
        /**
         * Test 1---Test elements of the profile page exept age.
         * Details: If it can jump to next page in profile by just clicking next;
         *          If it can jump to next page just with yearOfBirth value in the profile;
         *          If it can jump to next page just with a gender selected in the profile;
         *          If it can jump to next page just with a foot width selected in the profile;
         *          If it can jump to next page just with a foot arch selected in the profile;
         *          If it can jump to next page with one gender selected and a correct yearOfBirth in the profile.
         */

        PoComponentAdult pc=new PoComponentAdult(driver,"http://shoesize.me/plugin_v3");
        pc.inputShopId("18763603");
        pc.inputShoeId("SCSONIAROPELUREXGoldSoft Gold");
        pc.selectLang("en");
        pc.selectScale("eu");
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
         *  In put a valid "YearOfBirth", Click "Next" button, then check if it works(if there is warning info).
         *  A-Yes:correct---continue
         *  B-No: incorrect---test break
         * */
        pc.inputYearOfBirth("2000");
        pc.clickNext();
        pc.checkErrorInTempProfile();
        /*
         *  Clear everything and only select a foot width, Click "Next" button, then check if it works(if there is warning info).
         *  A-success jumping to next page:correct---continue
         *  B-fail jumping to next page: incorrect---test break
         * */
        pc.clearYearOfBirth();
        pc.selectFootWidth();
        pc.clickNext();
        pc.checkErrorInTempProfile();
        /*
         *  Clear everything and only select a foot arch, Click "Next" button, then check if it works(if there is warning info).
         *  A-success jumping to next page:correct---continue
         *  B-fail jumping to next page: incorrect---test break
         * */
        pc.selectFootArch();
        pc.clickNext();
        pc.checkErrorInTempProfile();
        /*
         *  Clear everything and only select male, Click "Next" button, then check if it works(if there is warning info).
         *  A-success jumping to next page:correct---go back and restart this process with female
         *  B-fail jumping to next page: incorrect---test break
         * */
        pc.clearYearOfBirth();
        pc.selectMale();
        pc.clickNext();
        pc.clickBack();
        /*
         *  Clear everything and only select female, Click "Next" button, then check if it works(if there is warning info).
         *  A-success jumping to next page:correct---close SA
         *  B-fail jumping to next page: incorrect---test break
         * */
        pc.clearYearOfBirth();
        pc.selectFemale();
        pc.clickNext();
        pc.closeSaButton();
    }


    @Test
    public void test2() throws InterruptedException {
        /**
         * Test 2---Test YearOfAge elements in the profile page, save profile page.
         * Details: If can input invalid number(nagtive number, notations, the number out of the scale between today and 90 years ago!)  into age page;
         *          Check if save your profile page is blank;
         *          If it can jump to next page with one gender selected and a correct yearOfBirth in profile.
         */

        PoComponentAdult pc=new PoComponentAdult(driver,"http://shoesize.me/plugin_v3");
        pc.inputShopId("18763603");
        pc.inputShoeId("SCSONIAROPELUREXGoldSoft Gold");
        pc.selectLang("en");
        pc.selectScale("eu");
        pc.generateSaButton();
        // ---landing page
        pc.clickSA();
        pc.switchInto360();
        pc.clickGetStart();
        // ---profile page
        pc.selectMale();
        /*
         *  Clear age field and input invalid ages, then check if it works(if there is warning info).
         *  If there is warning info.
         *           Yes: correct---containue
         *           No: incorrect---test break
         * */
        pc.inputYearOfBirth("-10");
        pc.checkErrorInTempProfile();
        pc.clearYearOfBirth();
        pc.inputYearOfBirth("1900");
        pc.checkErrorInTempProfile();
        pc.clearYearOfBirth();
        pc.inputYearOfBirth("2022");
        pc.checkErrorInTempProfile();
        pc.clearYearOfBirth();
        // ---input normal age and rest of info,the go through reco process to the reco page
        pc.selectFootWidth();
        pc.selectFootArch();
        pc.clickNext();
        pc.selectFromTopBrands();
        pc.selectAmodel();
        pc.selectASize();
        // ---recommendation pages
        pc.clickSaveProfile();
        // ---register pages
        pc.clickBack();
        pc.clickBack();
        pc.clickBack();
        pc.clickBack();
        pc.clickBack();
        pc.clickBack();
        // ---landing page
        pc.clickLoginIconBtn();
        // ---login page
        pc.closeSaButton();
    }


    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
        System.out.println("testA3 finished");
    }
}
