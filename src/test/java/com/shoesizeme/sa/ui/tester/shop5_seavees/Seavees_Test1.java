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
 @update: 2021.01.12
 @className: Seavees_Test1
 @description: This class contains 8 operation flows of normal user without account.
 All the testing scripts will be called and running through this class.
 @version: v1.0
 */
public class Seavees_Test1 {
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
     * test1-test8 : This test will simulate a adult  user going through a normal user flow to get a recommendation by one time.
     *               All the testing steps indicated clearly by the methods names.
     *               In order to save time and test more element, Plused several more steps in each test(1-8) is to test some certain buttons r working well(like exit,close...).
     * @param
     * @return null
     * @version 1.0
     */

    /*--------------------------------------test1-test4 male-------------------------------------------------------------*/

    @Test
    public void test1() throws InterruptedException {

        PoComponentAdult pc=new PoComponentAdult(driver,"http://shoesize.me/plugin_v3");
        pc.inputShopId("25461170");
        pc.inputShoeId("4645100781642");
        pc.selectLang("en");
        pc.selectScale("us");
        pc.generateSaButton();

        // ---landing page
        pc.clickSA();
        pc.switchInto360();
        pc.clickGetStart();
        // ---profile page
        pc.selectMale();
        pc.clickNext();
        // ---brands pages
        pc.selectFromTopBrands();
        // ---models pages
        //if(pc.hasModels()==true){
        pc.selectAmodel();
        //};
        // ---size table pages
        pc.selectASize();
        // ---recommendation pages
        pc.closeSaButton();
    }

    @Test
    public void test2() throws InterruptedException {

        PoComponentAdult pc=new PoComponentAdult(driver,"http://shoesize.me/plugin_v3");
        pc.inputShopId("25461170");
        pc.inputShoeId("4645100781642");
        pc.selectLang("en");
        pc.selectScale("us");
        pc.generateSaButton();
        // ---landing page
        pc.clickSA();
        pc.switchInto360();
        pc.clickGetStart();
        // ---profile page
        pc.selectMale();
        pc.clickNext();
        // ---brands pages
        pc.searchBrand("ad");
        pc.selectABrand();
        // ---models pages
        pc.selectAmodel();
        // ---size table pages
        pc.selectASize();
        // ---recommendation pages
        pc.clickGetStartAgainButton();
        // ---extra test page
        pc.closeSaButton();
    }


    @Test
    public void test3() throws InterruptedException {

        PoComponentAdult pc=new PoComponentAdult(driver,"http://shoesize.me/plugin_v3");
        pc.inputShopId("25461170");
        pc.inputShoeId("4645100781642");
        pc.selectLang("en");
        pc.selectScale("us");
        pc.generateSaButton();
        // ---landing page
        pc.clickSA();
        pc.switchInto360();
        pc.clickGetStart();
        // ---profile page
        pc.selectMale();
        pc.clickNext();
        // ---brands pages
        pc.switchToAllBrand();
        pc.selectABrand();
        // ---models pages
        pc.selectAmodel();
        // ---size table pages
        pc.selectASize();
        // ---recommendation pages
        pc.closeSaButton();
    }

    @Test
    public void test4() throws InterruptedException {

        PoComponentAdult pc=new PoComponentAdult(driver,"http://shoesize.me/plugin_v3");
        pc.inputShopId("25461170");
        pc.inputShoeId("4645100781642");
        pc.selectLang("en");
        pc.selectScale("us");
        pc.generateSaButton();
        // ---landing page
        pc.clickSA();
        pc.switchInto360();
        pc.clickGetStart();
        // ---profile page
        pc.selectMale();
        pc.clickNext();
        // ---brands pages
        pc.selectFromTopBrands();
        // ---categories pages
        pc.switchToCategories();
        pc.selectFromCategories();
        // ---size table pages
        pc.selectASize();
        // ---recommendation pages
        pc.clickGetStartAgainButton();
        // ---extra test page
        pc.closeSaButton();
    }

    /*--------------------------------------test5-test8 female-------------------------------------------------------------*/

    @Test
    public void test5() throws InterruptedException {

        PoComponentAdult pc=new PoComponentAdult(driver,"http://shoesize.me/plugin_v3");
        pc.inputShopId("25461170");
        pc.inputShoeId("4645100781642");
        pc.selectLang("en");
        pc.selectScale("us");
        pc.generateSaButton();
        // ---landing page
        pc.clickSA();
        pc.switchInto360();
        pc.clickGetStart();
        // ---profile page
        pc.selectFemale();
        pc.clickNext();
        // ---brands pages
        pc.selectFromTopBrands();
        // ---models pages
        pc.selectAmodel();
        // ---size table pages
        pc.selectASize();
        // ---recommendation pages
        pc.closeSaButton();
    }

    @Test
    public void test6() throws InterruptedException {

        PoComponentAdult pc=new PoComponentAdult(driver,"http://shoesize.me/plugin_v3");
        pc.inputShopId("25461170");
        pc.inputShoeId("4645100781642");
        pc.selectLang("en");
        pc.selectScale("us");
        pc.generateSaButton();
        // ---landing page
        pc.clickSA();
        pc.switchInto360();
        pc.clickGetStart();
        // ---profile page
        pc.selectFemale();
        pc.clickNext();
        // ---brands pages
        pc.searchBrand("ad");
        pc.selectABrand();
        // ---models pages
        pc.selectAmodel();
        // ---size table pages
        pc.selectASize();
        // ---recommendation pages
        pc.clickGetStartAgainButton();
        // ---extra test page
        pc.closeSaButton();
    }

    @Test
    public void test7() throws InterruptedException {

        PoComponentAdult pc=new PoComponentAdult(driver,"http://shoesize.me/plugin_v3");
        pc.inputShopId("25461170");
        pc.inputShoeId("4645100781642");
        pc.selectLang("en");
        pc.selectScale("us");
        pc.generateSaButton();
        // ---landing page
        pc.clickSA();
        pc.switchInto360();
        pc.clickGetStart();
        // ---profile page
        pc.selectFemale();
        pc.clickNext();
        // ---brands pages
        pc.switchToAllBrand();
        pc.selectABrand();
        // ---models pages
        pc.selectAmodel();
        // ---size table pages
        pc.selectASize();
        // ---recommendation pages
        pc.closeSaButton();
    }

    @Test
    public void test8() throws InterruptedException {

        PoComponentAdult pc=new PoComponentAdult(driver,"http://shoesize.me/plugin_v3");
        pc.inputShopId("25461170");
        pc.inputShoeId("4645100781642");
        pc.selectLang("en");
        pc.selectScale("us");
        pc.generateSaButton();
        // ---landing page
        pc.clickSA();
        pc.switchInto360();
        pc.clickGetStart();
        // ---profile page
        pc.selectFemale();
        pc.clickNext();
        // ---brands pages
        pc.selectFromTopBrands();
        // ---categories pages
        pc.switchToCategories();
        pc.selectFromCategories();
        // ---size table pages
        pc.selectASize();
        // ---recommendation pages
        pc.clickGetStartAgainButton();
        // ---extra test page
        pc.closeSaButton();
    }


    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
        System.out.println("testA1 finished");
    }
}