package com.shoesizeme.sa.ui.testerPo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class PoComponentKids extends PoPublic {

    public PoComponentKids(WebDriver driver, String url) {
        this.driver=driver;
        driver.get(url);
    }

    public static By searchSizeChartField=By.xpath("//*[@id=\"sizes\"]");
    public void resetSizeChart(String sizeChartArr) {
        WebElement sizeChartField = this.Findelement(searchSizeChartField);
        sizeChartField.clear();
        sizeChartField.sendKeys(sizeChartArr);
    }


    public static By searchShoeLengthField=By.xpath("/html/body/div[2]/app-root/app-kids-size/div/div[1]/div/div[2]/input");
    public void inputShoeLength(String length) {
        WebElement shoeLengthField = this.Findelement(searchShoeLengthField);
        shoeLengthField.clear();
        shoeLengthField.sendKeys(length);
    }

    public static By searchContinueBtn=By.className("btn-extend");
    public void clickContinue() throws InterruptedException {
        WebElement continueBtn = this.Findelement(searchContinueBtn);
        Actions clickContinue = new Actions(driver);
        clickContinue.moveToElement(continueBtn);
        Thread.sleep(2000);
        clickContinue.click().perform();
    }

    public static By searchAgeInputField=By.xpath("/html/body/div[2]/app-root/app-kids-age/div/div/div/input");
    public void inputAge(String year) {
        WebElement ageInput = this.Findelement(searchAgeInputField);
        ageInput.clear();
        ageInput.sendKeys(year);
    }

    /**
     * This function is used to get and click boy botton.
     * @param
     * @return null
     * @version 1.0
     */
    public static By searchBoyOpt=By.xpath("/html/body/div[2]/app-root/app-kids-gender/div/div/div/div[2]/button[1]");
    public void selectBoyGenderOfKids() {
        WebElement genderBoySelect = this.Findelement(searchBoyOpt);
        System.out.println("selectBoyGenderOfKids--------------"+genderBoySelect.getText());

        boolean getGenderBoy;
        getGenderBoy = (genderBoySelect==null)?false:true;
        Assert.assertEquals(getGenderBoy,true,"selectGenderOfKids()----Can not find out kids boy element!!!");

        Actions TargetGender = new Actions(driver);
        TargetGender.moveToElement(genderBoySelect).click().perform();
    }

    /**
     * This function is used to get and click boy botton.
     * @param
     * @return null
     * @version 1.0
     */
    public static By searchGirlOpt=By.xpath("/html/body/div[2]/app-root/app-kids-gender/div/div/div/div[2]/button[2]");
    public void selectGirlGenderOfKids() {
        WebElement genderGirlSelect = this.Findelement(searchGirlOpt);
        //System.out.println("selectGirlGenderOfKids--------------"+genderGirlSelect.getText());
        boolean getGenderGirl;
        getGenderGirl = (genderGirlSelect==null)?false:true;
        Assert.assertEquals(getGenderGirl,true,"selectGirlGenderOfKids()----Can not find out kids girl element!!!");

        Actions TargetGender = new Actions(driver);
        TargetGender.moveToElement(genderGirlSelect).click().perform();
    }




    public static By searchCloseOpt=By.className("ssm_close-button");
    public void clickCloseBtn() throws InterruptedException {
        WebElement closeBtn = this.Findelement(searchCloseOpt);
        Actions clickCloseBtn = new Actions(driver);
        clickCloseBtn.moveToElement(closeBtn);
        Thread.sleep(2000);
        clickCloseBtn.click().perform();
    }

    public static By searchExitBtn=By.xpath("/html/body/div[2]/app-root/app-kids-recommendation/app-kids-header/div/div/div[3]/button");
    public void clickExitBtn() throws InterruptedException {
        WebElement exitBtn = this.Findelement(searchExitBtn);
        Actions clickExitBtn = new Actions(driver);
        clickExitBtn.moveToElement(exitBtn);
        Thread.sleep(2000);
        clickExitBtn.click().perform();
    }

    public static By searchStartAgainBtn=By.xpath("/html/body/div[2]/app-root/app-kids-recommendation/div/div[2]/button[2]");
    public void clickStartAgain() throws InterruptedException {
        WebElement startAgainBtn = this.Findelement(searchStartAgainBtn);
        Actions clickStartAgainBtn = new Actions(driver);
        clickStartAgainBtn.moveToElement(startAgainBtn);
        Thread.sleep(2000);
        clickStartAgainBtn.click().perform();
    }
}
