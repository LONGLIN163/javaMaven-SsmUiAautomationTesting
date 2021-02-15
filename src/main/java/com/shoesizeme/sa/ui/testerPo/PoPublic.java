package com.shoesizeme.sa.ui.testerPo;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.util.concurrent.TimeUnit;

public class PoPublic  implements PoMouseActions {
    public WebDriver driver;
    public static int timeout=10;
    /**
     * This is a function which will search an single element packed into a "By" instance obj.
     * It can wait maximum 10s to get an element
     * @param by
     * @return element
     * @version 1.0
     */
    public WebElement Findelement(By by) {
        WebElement element=null;
        try {
            element = new WebDriverWait(driver, timeout).until(ExpectedConditions.presenceOfElementLocated(by));
        }
        catch(Exception e)
        {
            System.out.println(" | "+by.toString()+" | Element access failed");
        }
        finally {
            return element;
        }
    }
    /**
     * Search and click SA button.
     * @param
     * @return null
     * @version 1.0
     */
    public static By searchSaButton=By.className("ShoeSizeMe");
    public void clickSA() throws InterruptedException {
        Thread.sleep(2000);
        WebElement saBtn = this.Findelement(searchSaButton);
        scrollTo(saBtn);
        Actions clickSA = new Actions(driver);
        clickSA.moveToElement(saBtn).click().perform();
    }

    /**
     * This function will help access SA 360 UI element.
     * @param
     * @return null
     * @version 1.0
     */
    public static By searchframeBox=By.xpath("//*[@id=\"ShoeSizeMe_advisor-wrapper\"]");
    public void switchInto360() throws InterruptedException {
        Thread.sleep(3000);
        WebElement frameBox = this.Findelement(searchframeBox);
        boolean frameBoxOn;
        frameBoxOn = (frameBox==null)?false:true;
        Assert.assertEquals(frameBoxOn,true,"switchInto360()----Can not switch into iframe!");
        driver.switchTo().frame(frameBox);
    }

    /**
     * This function will help to leave SA 360 iframe.
     * we can click SA button again after this function.
     * @param
     * @return null
     * @version 1.0
     */
    public void switchOutOf360()  {
        driver.switchTo().defaultContent();
    }

    /**
     * Delete default shopId, then input a new one.
     * It can wait maximum 10s to get an element
     * @param shopId
     * @return null
     * @version 1.0
     */
    public static By searchShopInput=By.xpath("//*[@id=\"shopID\"]");
    public void inputShopId(String shopId) {
        WebElement shopIdInput = this.Findelement(searchShopInput);
        shopIdInput.clear();
        shopIdInput.sendKeys(shopId);
    }

    /**
     * Delete default shoeId, then input a new one.
     * It can wait maximum 10s to get an element
     * @param shoeId
     * @return null
     * @version 1.0
     */
    public static By searchShoeInput=By.xpath("//*[@id=\"shoeID\"]");
    public void inputShoeId(String shoeId) {
        WebElement shoeIdInput = this.Findelement(searchShoeInput);
        shoeIdInput.clear();
        shoeIdInput.sendKeys(shoeId);
    }
    /**
     * select a button language translation
     * It can wait maximum 20s to wait untill get all plugin v3 elements loaded.XXX
     * @param alang
     * @return null
     * @version 1.0
     */
    public void selectLang(String alang) {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Select drpCountry = new Select(driver.findElement(By.xpath("//*[@id=\"language\"]")));
        drpCountry.selectByVisibleText(alang);
    }
    /**
     * select a recommendation scale
     * It can wait maximum 20s to wait untill get all plugin v3 elements loaded.XXX
     * @param aScale
     * @return null
     * @version 1.0
     */
    public void selectScale(String aScale)
    {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Select drpCountry = new Select(driver.findElement(By.xpath("//*[@id=\"scale\"]")));
        drpCountry.selectByVisibleText(aScale);
    }

    /**
     * generate a button as a normal user.
     * @param aScale
     * @return null
     * @version 1.0
     */
    public static By searchNormalUser=By.xpath("//*[@id=\"plugin-form\"]/input[3]");
    public void generateSaButton()
    {
        this.Findelement(searchNormalUser).click();
    }

    @Override
    public void scrollTo(Object o) {
        // Create instance of Javascript executor
        JavascriptExecutor je = (JavascriptExecutor) driver;
        // now execute query which actually will scroll until that element is not appeared on page.
        je.executeScript("arguments[0].scrollIntoView(true);",o);
    }
}
