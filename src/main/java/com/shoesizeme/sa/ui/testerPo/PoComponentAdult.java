package com.shoesizeme.sa.ui.testerPo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class PoComponentAdult extends PoPublic{



    public static By searchOpenShoeShelfBtn=By.xpath("/html/body/div[2]/app-root/app-user-landing/div/div[2]/div[2]/div/button");
    public static By searchOpenShoeShelfBtnIcon=By.xpath("//*[@id=\"ssm_root\"]/app-user-landing/app-header/div/div[1]/div[2]/button[1]");


    public PoComponentAdult(WebDriver driver, String url)
    {
        this.driver=driver;
        driver.get(url);
    }

    /**
     * This method is used to get and click boy botton.
     * @param
     * @return null
     * @version 1.0
     */
    public static By searchGetStartButton=By.cssSelector("#ssm_root > app-landing > div > div:nth-child(2) > button.ssm_btn.mt-b.btn-extend.btn_primary");
    public void clickGetStart() throws InterruptedException {

        WebElement getStartBtn = this.Findelement(searchGetStartButton);
        boolean getGetStartBtn;
        getGetStartBtn = (getStartBtn == null) ? false : true;
        Assert.assertEquals(getGetStartBtn,true,"clickGetStart()----Can not find 'get start' button!");

        Actions clickGetStartBtn = new Actions(driver);
        clickGetStartBtn.moveToElement(getStartBtn).click().perform();
    }

    /**
     * This method is used to lead to login page.
     * @param
     * @return null
     * @version 1.0
     */
    public static By searchLoginHereBtn=By.xpath("//*[@id=\"ssm_root\"]/app-landing/div/div[2]/button[2]");
    public void clickLoginHere() throws InterruptedException {
        WebElement loginHereBtn = this.Findelement(searchLoginHereBtn);
        Actions clickLoginHereBtn = new Actions(driver);
        clickLoginHereBtn.moveToElement(loginHereBtn);
        Thread.sleep(2000);
        clickLoginHereBtn.click().perform();
    }
    /**
     * This fountion need two parameter, using for login with emal and password.
     * @param email,pwd
     * @return null
     * @version 1.0
     */
    public static By searchLoginIconBtn=By.cssSelector("button.ssm_btn__header:nth-child(1)");
    public void clickLoginIconBtn() throws InterruptedException {
        Thread.sleep(500);
        WebElement loginHereBtn = this.Findelement(searchLoginIconBtn);
        Actions clickLoginHereBtn = new Actions(driver);
        clickLoginHereBtn.moveToElement(loginHereBtn);
        Thread.sleep(2000);
        clickLoginHereBtn.click().perform();
    }
    /**
     * This fountion need two parameter, using for login with emal and password.
     * @param email,pwd
     * @return null
     * @version 1.0
     */
    public static By searchEmailInput=By.xpath("/html/body/div[2]/app-root/app-login/div/div[2]/div[2]/input");
    public static By searchPwdInput=By.xpath("/html/body/div[2]/app-root/app-login/div/div[2]/div[3]/input");
    public static By searchLoginBtn=By.xpath("/html/body/div[2]/app-root/app-login/div/div[2]/div[4]/button");
    public void loginWithEmail(String email, String pwd) throws InterruptedException {

        WebElement emailInput = this.Findelement(searchEmailInput);
        emailInput.clear();
        emailInput.sendKeys(email);

        WebElement pwdInput = this.Findelement(searchPwdInput);
        pwdInput.clear();
        pwdInput.sendKeys(pwd);

        WebElement loginBtn = this.Findelement(searchLoginBtn);
        Actions clickLoginBtn = new Actions(driver);
        clickLoginBtn.moveToElement(loginBtn);
        Thread.sleep(2000);
        clickLoginBtn.click().perform();

    }

    /**
     * This function is used to get and click Male botton.
     * @param
     * @return null
     * @version 1.0
     */
    public static By searchMaleOpt=By.xpath("//*[@id=\"ssm_gender\"]/button[1]");
    public void selectMale(){
        WebElement genderMaleSelect = this.Findelement(searchMaleOpt);
        boolean getGenderMale;
        getGenderMale = (genderMaleSelect==null)?false:true;
        Assert.assertEquals(getGenderMale,true,"selectMale()----Can not find male btn!!!");
        Actions TargetGender = new Actions(driver);
        TargetGender.moveToElement(genderMaleSelect).click().perform();
    }
    public void selectFemale() {
        List<WebElement> femaleSelect = driver.findElements(By.xpath("//*[@id=\"ssm_gender\"]/button[2]"));
        int fmLength;
        fmLength=femaleSelect.size();
        Assert.assertEquals(fmLength,1,"selectFemale()----Can not find out male element!!!");
        WebElement Get_male = femaleSelect.get(0);
        Actions TargetGender = new Actions(driver);
        TargetGender.moveToElement(Get_male).click().perform();
    }

    /**
     * This is a function which which can input a year.
     * The year number has to be between today and 90 years ago without any illegal character.
     * @param year
     * @return
     * @version 1.0
     */
    public static By searchBirthDate=By.xpath("//*[@id=\"ssm_birthYear\"]");
    public void inputYearOfBirth(String year) {
        WebElement shoeIdInput = this.Findelement(searchBirthDate);
        shoeIdInput.clear();
        shoeIdInput.sendKeys(year);
    }
    /**
     * This is a function input field of year of birth.
     * @param
     * @return
     * @version 1.0
     */
    public void clearYearOfBirth()
    {
        WebElement shoeIdInput = this.Findelement(searchBirthDate);
        shoeIdInput.clear();
    }
    /**
     * This is a function can click one of width btns randomly.
     * @param
     * @return
     * @version 1.0
     */
    public void selectFootWidth() {
        List<WebElement> widthOpts = driver.findElements(By.xpath("//*[@id=\"ssm_footWidth\"]/button"));
        boolean getAllWidths;
        getAllWidths = (widthOpts.size()==0)?false:true;
        Assert.assertEquals(getAllWidths,true,"selectFootWidth()----Can not find out a width element!!!");

        Random b=new Random();
        int upTo=3;
        int Get_AwidthIndex=b.nextInt(upTo);
        System.out.println("selectFootWidth()----Get_AwidthIndex----"+Get_AwidthIndex);

        WebElement Get_Awidth = widthOpts.get(Get_AwidthIndex);
        Actions Click_Awidth = new Actions(driver);
        Click_Awidth.moveToElement(Get_Awidth).click().perform();
    }

    /**
     * This is a function can click one of Arch btns randomly.
     * @param
     * @return
     * @version 1.0
     */
    public void selectFootArch() throws InterruptedException {
        Thread.sleep(500);
        List<WebElement> archOpts = driver.findElements(By.xpath("//*[@id=\"ssm_footArch\"]/button"));
        boolean getAllArchs;
        getAllArchs = (archOpts.size()==0)?false:true;
        Assert.assertEquals(getAllArchs,true,"selectFootArch()----Can not find out a arch element!!!");

        Random b=new Random();
        int upTo=3;
        int Get_AarchIndex=b.nextInt(upTo);
        System.out.println("selectFootArch()----Get_AarchIndex----"+Get_AarchIndex);
        WebElement Get_Aarch = archOpts.get(Get_AarchIndex);
        scrollTo(Get_Aarch);
        Thread.sleep(500);
        Actions Click_Aarch = new Actions(driver);
        Click_Aarch.moveToElement(Get_Aarch).click().perform();
    }

    /**
     * This function is for trigger next on profile page.
     * @param
     * @return
     * @version 1.0
     */
    public static By searchNextButton=By.xpath("//*[@id=\"ssm_submit_profile\"]");
    public void clickNext() throws InterruptedException {
        Thread.sleep(1000);
        WebElement Get_Next = this.Findelement(searchNextButton);
        System.out.println("Get_Next--------------"+Get_Next.getText());

        boolean getNextButton;
        getNextButton = (Get_Next==null)?false:true;
        Assert.assertEquals(getNextButton,true,"clickNext()----Can not find 'next' button!!!");

        scrollTo(Get_Next);
        Actions clickGet_Next = new Actions(driver);
        clickGet_Next.moveToElement(Get_Next).click().perform();
    }

    /**
     * This function is for cliking the backward button.
     * @param
     * @return
     * @version 1.0
     */
    //public static By searchBackButton=By.xpath("/html/body/div[2]/app-root/app-brand-selection/app-header/div/div/div[1]/button");
    public static By searchBackButton=By.cssSelector(".ssm_header-nav > div:nth-child(1)");
    public void clickBack() throws InterruptedException {
        Thread.sleep(500);
        WebElement backBtn = this.Findelement(searchBackButton);
        System.out.println("clickBack()----"+backBtn.getText());

        boolean getBackButton;
        getBackButton = (backBtn==null)?false:true;
        Assert.assertEquals(getBackButton,true,"clickBack()----Can not find 'next' button!!!");

        scrollTo(backBtn);
        Actions clickGet_Next = new Actions(driver);
        clickGet_Next.moveToElement(backBtn).click().perform();
    }

    /**
     * This function detect if error text generated if there is some illegal action.
     * If there is warning text appearing,it means the function working well.
     * @param
     * @return
     * @version 1.0
     */
    public static By searchErrorText=By.className("ssm_warning_box");
    public void checkErrorInTempProfile()
    {
        WebElement errorText = this.Findelement(searchErrorText);
        System.out.println("checkErrorInTempProfile----errorText----"+errorText.getAttribute("class"));
        boolean getErrorText;
        getErrorText = (errorText==null)?false:true;
        Assert.assertEquals(getErrorText,true,"checkErrorInTempProfile()----Error expected!!!");
    }

    /**
     * This function can select a brand from featured brands randomly.
     * @param
     * @return
     * @version 1.0
     */
    public void selectFromTopBrands()
    {
        List<WebElement> TopBrands = driver.findElements(By.className("list_item"));
        System.out.println("selectFromTopBrands--------------"+TopBrands.size());
        boolean getAllTopBrands;
        getAllTopBrands = (TopBrands.size()==0)?false:true;
        Assert.assertEquals(getAllTopBrands,true,"selectFromTopBrands()----Can not find out class - ssm_btn__transparent!!!");

        Random b=new Random();
        int upTo=11;
        int Get_AtopBrandIdex=b.nextInt(upTo);
        System.out.println("selectFromTopBrands-----target top brand index------"+Get_AtopBrandIdex);

        WebElement Get_AtopBrand = TopBrands.get(Get_AtopBrandIdex);
        Actions Click_AtopBrand = new Actions(driver);
        Click_AtopBrand.moveToElement(Get_AtopBrand).click().perform();

    }

    /**
     * This function can search a brand by name.
     * @param
     * @return
     * @version 1.0
     */
    public static By searchAbrand=By.xpath("//*[@id=\"ssm_search_brand\"]");
    public void searchBrand(String aBrand) {
        WebElement brandsSearchInput = this.Findelement(searchAbrand);
        brandsSearchInput.clear();
        brandsSearchInput.sendKeys(aBrand);
    }

    /**
     * If the brand field is not empty, this function can select a brand randomly.
     * @param
     * @return
     * @version 1.0
     */
    public void selectABrand() {
        List<WebElement> brands = driver.findElements(By.className("list_item"));
        System.out.println("selectABrand----brands----"+brands.size());
        Random b=new Random();
        int upTo=brands.size()-1;
        int Get_AbrandIndex=1;
        System.out.println("selectABrand----"+Get_AbrandIndex);

        WebElement abrand = brands.get(Get_AbrandIndex);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Actions Click_Abrand = new Actions(driver);
        Click_Abrand.moveToElement(abrand).click().perform();
    }

    public void selectFromSearchedBrands(String aBrand) throws InterruptedException {
        WebElement brandsSearchInput = this.Findelement(searchAbrand);
        brandsSearchInput.clear();
        brandsSearchInput.sendKeys(aBrand);

        List<WebElement> searchedBrands = driver.findElements(By.className("list_item"));
        System.out.println("searchedBrands--------------"+searchedBrands.size());
        boolean getSearchedBrands;
        getSearchedBrands = (searchedBrands.size()==0)?false:true;
        Assert.assertEquals(getSearchedBrands,true,"selectFromSearchedBrands()----Can not find the list of brands!");

        Random b=new Random();
        int upTo=searchedBrands.size()-1;
        int Get_AsearchedBrandIndex=0;

        System.out.println("Get_AsearchedBrandIndex--------------"+Get_AsearchedBrandIndex);

        WebElement Get_AsearchedBrand = searchedBrands.get(Get_AsearchedBrandIndex);
        Actions Click_ASearchBrand = new Actions(driver);
        Click_ASearchBrand.moveToElement(Get_AsearchedBrand).click().perform();
        System.out.println("Click_ASearchBrand--------------"+Click_ASearchBrand);
    }

    public static By searchAllBrandsBtn=By.xpath("/html/body/div[2]/app-root/app-brand-selection/div/div[2]/div/div[1]/div/div[2]");
    public void switchToAllBrand() {
        WebElement allBrandsBtn = this.Findelement(searchAllBrandsBtn);
        Actions Click_ABrandFromAll = new Actions(driver);
        Click_ABrandFromAll.moveToElement(allBrandsBtn).click().perform();
    }

    public void selectFromAllBrands() throws InterruptedException {
        WebElement allBrandsBtn = this.Findelement(searchAllBrandsBtn);
        Actions Click_ABrandFromAll = new Actions(driver);
        Click_ABrandFromAll.moveToElement(allBrandsBtn).click().perform();

        Thread.sleep(500);
        List<WebElement> allBrands = driver.findElements(By.xpath("//*[@id=\"ssm_root\"]/app-brand-selection/div/div[3]/ul/li"));
        System.out.println("allBrands--------------"+allBrands.size());

        boolean getAllBrands;
        getAllBrands = (allBrands.size()==0)?false:true;
        Assert.assertEquals(getAllBrands,true,"selectFromAllBrands()----Can not find out 'all brands button'!!!");

        Random b=new Random();
        int upTo=allBrands.size()-1;
        int Get_AbrandFromAllIndex=0;

        WebElement Get_AbrandFromAll = allBrands.get(Get_AbrandFromAllIndex);
        Actions Click_AbrandFromAll = new Actions(driver);
        Click_AbrandFromAll.moveToElement(Get_AbrandFromAll).click().perform();
    }

    /**
     * This function can select a model from models randomly if there is some models in this page.
     * @param
     * @return
     * @version 1.0
     */
    public void selectAmodel() throws InterruptedException {
        List<WebElement> modelsInBrand = driver.findElements(By.cssSelector("li.ssm_btn"));
        Random m=new Random();
        int upTo=modelsInBrand.size()-1;
        int Get_AmodelIndex=m.nextInt(1);
        System.out.println("selectAmodel()---Get_AtargetModelIndex---"+Get_AmodelIndex);
        WebElement Get_Amodel = modelsInBrand.get(Get_AmodelIndex);
        Actions Click_Amodel = new Actions(driver);
        Click_Amodel.moveToElement(Get_Amodel).click().perform();
    }

    /**
     * This function is for judage if there is some in the models page.
     * @param
     * @return hasModels
     * @version 1.0
     */
      public boolean hasModels() throws InterruptedException {
          Thread.sleep(5000);
          List<WebElement> models = driver.findElements(By.cssSelector("li.ssm_btn"));
          System.out.println("checkModelsPage()----"+models.size());
          boolean hasModels;
          hasModels = (models.size()==0)?false:true;
          return hasModels;
      }



    public static By searchAmodel=By.xpath("//*[@id=\"ssm_search_brand\"]");

    public void selectFromSearchedModels(String aSearchModel) throws InterruptedException {
        WebElement modelsSearchInput = this.Findelement(searchAmodel);
        modelsSearchInput.clear();
        Thread.sleep(2000);
        modelsSearchInput.sendKeys(aSearchModel);
        Thread.sleep(2000);
        List<WebElement> searchedModels = driver.findElements(By.cssSelector("li.ssm_btn"));
        System.out.println("searchedModes--------------"+searchedModels.size());
        int searchedModelsSize=searchedModels.size();

        if(searchedModelsSize!=0){
            WebElement ModelNotFoundEle = driver.findElement(By.xpath("//*[@id=\"ssm_root\"]/app-shoe-model/div/div[5]/div[2]/div/ul/li"));
            Thread.sleep(500);
            System.out.println("ModelNotFoundEle-------------"+ModelNotFoundEle.getAttribute("class"));
            String getModelNotFoundClassName;
            getModelNotFoundClassName=ModelNotFoundEle.getAttribute("class");
            System.out.println("getModelNotFoundClassName-------------"+getModelNotFoundClassName);
            if(getModelNotFoundClassName.contains("ssm_flexLayoutWithContent")){
                System.out.println("selectFromSearchedModels()-----------No models found!");

                WebElement getSearchCategoriesBtn = driver.findElement(By.xpath("//*[@id=\"ssm_root\"]/app-shoe-model/div/div[5]/div[2]/div/ul/div"));
                Actions Click_SearchCategoriesBtn = new Actions(driver);
                Click_SearchCategoriesBtn.moveToElement(getSearchCategoriesBtn).click().perform();
                Thread.sleep(500);

                List<WebElement> getAllSearchCategories = driver.findElements(By.xpath("//*[@id=\"ssm_root\"]/app-shoe-model/div/div[5]/div[2]/div/ul/li"));
                System.out.println("getAllSearchCategories-------------"+getAllSearchCategories.size());
                Random a=new Random();
                int upToa=getAllSearchCategories.size()-1;
                int Get_ASearchedCategoryIndex=a.nextInt(1);
                System.out.println("Get_ASearchedCategoryIndex--------------"+Get_ASearchedCategoryIndex);
                WebElement Get_ASearchedCategory = getAllSearchCategories.get(Get_ASearchedCategoryIndex);
                Actions Click_ASearchedCategory = new Actions(driver);
                Click_ASearchedCategory.moveToElement(Get_ASearchedCategory).click().perform();

            }else {
                System.out.println("selectFromSearchedModels()-----------Find some models!");
                Random b=new Random();
                int upTo=searchedModels.size()-1;
                int Get_AsearchedModelIndex=b.nextInt(1);
                System.out.println("Get_AsearchedModelIndex--------------"+Get_AsearchedModelIndex);
                //------------------bug:out of bounds------------------
                WebElement Get_AsearchedModel = searchedModels.get(Get_AsearchedModelIndex);
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

                Actions Click_ASearchBrand = new Actions(driver);
                Click_ASearchBrand.moveToElement(Get_AsearchedModel).click().perform();
            }
        }
        if(searchedModelsSize==0){
            System.out.println("Get_AsearchedModelIndex--------------Maybe page get blank!");
        }

    }

    /**
     * This function will help to get into categories page if there is no reference model for a user.
     * @param
     * @return
     * @version 1.0
     */
    public static By searchCategoriesBtn=By.xpath("/html/body/div[2]/app-root/app-shoe-model/div[2]/button");
    public void switchToCategories() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("switchToCategories-------------"+123);
        WebElement categoriesBtn = this.Findelement(searchCategoriesBtn);
        System.out.println("switchToCategories-------------"+categoriesBtn);
        Actions Click_categoriesBtn = new Actions(driver);
        Click_categoriesBtn.moveToElement(categoriesBtn).click().perform();
        System.out.println("switchToCategories-------------"+456);
    }
    /**
     * This function is used for select a category.
     * @param
     * @return
     * @version 1.0
     */
    public void selectFromCategories() throws InterruptedException {
        List<WebElement> getAllSearchCategories = driver.findElements(By.xpath("//*[@id=\"ssm_root\"]/app-shoe-model/div[1]/div[2]/div/ul/li"));
        System.out.println("selectFromCategories()----getAllSearchCategories----"+getAllSearchCategories.size());
        boolean getAllCategories;
        getAllCategories = (getAllSearchCategories.size()==0)?false:true;
        Assert.assertEquals(getAllCategories,true,"selectFromCategories()----Can not find the list of categories!");

        Random a=new Random();
        int upToa=getAllSearchCategories.size()-1;
        int Get_ASearchedCategoryIndex;
        if(upToa==0){
            Get_ASearchedCategoryIndex=0;
        }else {
            Get_ASearchedCategoryIndex=a.nextInt(upToa);
        }
        System.out.println("selectFromCategories()---Get_ASearchedCategoryIndex----"+Get_ASearchedCategoryIndex);
        WebElement Get_ASearchedCategory = getAllSearchCategories.get(Get_ASearchedCategoryIndex);
        Actions Click_ASearchedCategory = new Actions(driver);
        Click_ASearchedCategory.moveToElement(Get_ASearchedCategory);
        //Thread.sleep(3000);
        Click_ASearchedCategory.click().perform();
    }

    /**
     * This function is used for select a size in the size option page.
     * @param
     * @return
     * @version 1.0
     */
    public void selectASize() throws InterruptedException {
        Thread.sleep(5000);
        List<WebElement> sizes = driver.findElements(By.className("sizes_size"));
        System.out.println("selectASize()----size table----"+sizes.size());

        boolean getAsizes;
        getAsizes = (sizes.size()==0)?false:true;
        Assert.assertEquals(getAsizes,true,"selectASize()----Can not find size table!");

        System.out.println(sizes.toString());
        System.out.println(sizes.size());
        Random s=new Random();
        int upTo3=sizes.size()-1;
        int Get_AsizeIndex=s.nextInt(upTo3);
        System.out.println("selectASize()----Get_AsizeIndex----"+Get_AsizeIndex);

        WebElement Get_Asize = sizes.get(Get_AsizeIndex);
        scrollTo(Get_Asize);
        Actions Click_Asize = new Actions(driver);
        Click_Asize.moveToElement(Get_Asize).click().perform();
    }

    /**
     * This function is used for checking if reco page is not been rendered well.
     * @param
     * @return
     * @version 1.0
     */
    public void checkRecoPage() throws InterruptedException {
        Thread.sleep(2000);
        WebElement startAgainButton = this.Findelement(searchOpenShoeShelfBtn);
        System.out.println("startAgainButton---------------"+startAgainButton);

        boolean getStartAgainButton;
        getStartAgainButton = (startAgainButton==null)?false:true;
        Assert.assertEquals(getStartAgainButton,true,"checkRecoPage()----Maybe page get blank!");
    }

    /**
     * This function is for judage if there is some in the models page.
     * @param
     * @return
     * @version 1.0
     */
    public static By searchGetStartAgainButton=By.xpath("/html/body/div[2]/app-root/app-shoe-recommendation/div/div[2]/div[2]/button[2]");
    public void clickGetStartAgainButton(){
        WebElement startAgainButton = this.Findelement(searchGetStartAgainButton);
        Actions clickGetStartAgainButton = new Actions(driver);
        clickGetStartAgainButton.moveToElement(startAgainButton).click().perform();
    }
    /**
     * This function is for judage if there is some in the models page.
     * @param
     * @return
     * @version 1.0
     */
    public static By searchSaveProfileBtnNoAccount=By.xpath("/html/body/div[2]/app-root/app-shoe-recommendation/div/div[2]/div[2]/button[1]");
    public void clickSaveProfile(){
        WebElement startAgainButton = this.Findelement(searchSaveProfileBtnNoAccount);
        Actions clickGetStartAgainButton = new Actions(driver);
        clickGetStartAgainButton.moveToElement(startAgainButton).click().perform();
    }
    /**
     * Close SA at any page.
     * @param
     * @return
     * @version 1.0
     */
    public static By searchSaCloseButton=By.className("ssm_close-button");
    public void closeSaButton() throws InterruptedException {
        Thread.sleep(2000);
        WebElement closeButton = this.Findelement(searchSaCloseButton);
        Actions clickCloseButton = new Actions(driver);
        clickCloseButton.moveToElement(closeButton).click().perform();
    }

    public void searchSaAfterRec(){
        driver.findElement(By.className("ShoeSizeMe ShoeSizeMe_button_0")).click();
    }

    /*-------------------------------------------------shoe shelf-------------------------------------------------------*/

    public void user_OpenShoeshelf(){
        WebElement openShoeshelf = this.Findelement(searchOpenShoeShelfBtn);
        Actions clickOpenShoeshelf = new Actions(driver);
        clickOpenShoeshelf.moveToElement(openShoeshelf);
        clickOpenShoeshelf.click().perform();
    }

    public void user_OpenShoeshelfWithIcon(){
        WebElement openShoeshelfIcon = this.Findelement(searchOpenShoeShelfBtnIcon);
        Actions clickOpenShoeshelfIcon = new Actions(driver);
        clickOpenShoeshelfIcon.moveToElement(openShoeshelfIcon);
        clickOpenShoeshelfIcon.click().perform();
    }

    /**
     * This is a function which will click the add shoe button,start add shoe process.
     * It is called in side "user_addShoesProcessAndCheck()".
     * @param
     * @return
     * @version 1.0
     */
    public static By searchAddShoesBtn=By.xpath("/html/body/div[2]/app-root/app-profile/div[2]/div/button");
    public void user_clickAddShoes(){
        WebElement user_addShoesBtn = this.Findelement(searchAddShoesBtn);
        Actions clickUser_addShoesBtn = new Actions(driver);
        clickUser_addShoesBtn.moveToElement(user_addShoesBtn).click().perform();
    }
    /**
     * This is a function which will add a shoe into shoe shelf.
     * Determine the success by the difference of before and after add action.If it is 1, it is success, else add shoe failed.
     * @param
     * @return
     * @version 1.0
     */
    public static By searchMeBtn=By.xpath("/html/body/div[2]/app-root/app-profile/div[2]/div/div[1]/div/div[1]");
    public void user_addShoesProcessAndCheck() throws InterruptedException {
        Thread.sleep(500);
        //First assert if current page is blank.
        WebElement meBtn = this.Findelement(searchMeBtn);
        boolean getMeBtn;
        getMeBtn = (meBtn.getAttribute("class")=="tab_item")?false:true;
        Assert.assertEquals(getMeBtn,true,"user_addShoesProcessAndCheck()----This page maybe blank !");

        int itemLenBeforeAdd;
        List<WebElement> itemsBeforeAdd = driver.findElements(By.xpath("/html/body/div[2]/app-root/app-profile/div[2]/div/div[2]/ul/li"));
        itemLenBeforeAdd=itemsBeforeAdd.size();
        System.out.println("user_addShoesProcessAndCheck()---itemLenBeforeAdd---"+itemLenBeforeAdd);

        //Add a new reference shoe here.
        user_clickAddShoes();
        selectFromTopBrands();
        selectAmodel();
        selectASize();

        //After a new shoe added, we need to check the shoeshelf item again to confirm if add a shoe successfully.
        Thread.sleep(3000);
        int itemLenAfterAdd;
        List<WebElement> itemsAfterAdd = driver.findElements(By.xpath("/html/body/div[2]/app-root/app-profile/div[2]/div/div[2]/ul/li"));
        itemLenAfterAdd=itemsAfterAdd.size();
        System.out.println("user_addShoesProcessAndCheck()---itemLenAfterAdd---"+itemLenAfterAdd);

        //Assert if add shoes successfully
        boolean shoeAdded;
        shoeAdded=((itemLenAfterAdd-itemLenBeforeAdd)!=1)?false:true;
        System.out.println("user_addShoesProcessAndCheck()---shoeAdded---"+shoeAdded);
        Assert.assertEquals(shoeAdded,true,"user_addShoesProcessAndCheck()----Add shoes failed!");
    }


    public int user_checkShoeshelf() throws InterruptedException {
        Thread.sleep(500);
        //First assert if current page is blank.
        WebElement meBtn = this.Findelement(searchMeBtn);
        boolean getMeBtn;
        getMeBtn = (meBtn.getAttribute("class")=="tab_item")?false:true;
        Assert.assertEquals(getMeBtn,true,"user_checkShoeshelf()----This page maybe blank !");

        int allItemsNum;
        List<WebElement> allItems = driver.findElements(By.xpath("//*[@id=\"ssm_root\"]/app-profile/div/div[2]/ul/li"));
        allItemsNum=allItems.size();
        System.out.println("user_checkShoeshelf()---total items in shoeshelf---"+allItemsNum);
        return allItemsNum;
    }

    /**
     * This is a function which will remove a shoe from shoe shelf.
     * Determine the success by the difference of before and after add action.If it is 1, it is success, else removed shoe failed.
     * @param
     * @return
     * @version 1.0
     */
    public void user_removeShoesProcessAndCheck() throws InterruptedException {
        Thread.sleep(500);
        //First assert if current page is blank.
        WebElement meBtn = this.Findelement(searchMeBtn);
        boolean getMeBtn;
        getMeBtn = (meBtn.getAttribute("class")=="tab_item")?false:true;
        Assert.assertEquals(getMeBtn,true,"user_removeShoesProcessAndCheck()----This page maybe blank !");

        int itemLenBeforeRemove;
        List<WebElement> itemsBeforeRemove = driver.findElements(By.xpath("/html/body/div[2]/app-root/app-profile/div[2]/div/div[2]/ul/li"));
        itemLenBeforeRemove=itemsBeforeRemove.size();
        System.out.println("user_removeShoesProcessAndCheck()---itemLenBeforeRemove---"+itemLenBeforeRemove);
        //Assert if there is no any shoe in the shoe shelf..................

        //Ramdomly remove a shoe.
        Random s=new Random();
        int upTo=itemLenBeforeRemove-1;
        int Get_AitemIndex=s.nextInt(upTo);
        System.out.println("user_removeShoesProcessAndCheck()---Get_AitemIndex---"+Get_AitemIndex);
        WebElement Get_Aitem = itemsBeforeRemove.get(Get_AitemIndex);
        Actions Click_Aitem = new Actions(driver);
        Click_Aitem.moveToElement(Get_Aitem).click().perform();

        WebElement Get_delBtn = driver.findElement(By.xpath("/html/body/div[2]/app-root/app-edit-shoe/div/div[2]/div[2]/button"));
        System.out.println("user_removeShoesProcessAndCheck()---Get_delBtn---"+Get_delBtn);

        Thread.sleep(1000);
        scrollTo(Get_delBtn);
        Actions Click_delBtn = new Actions(driver);
        Click_delBtn.moveToElement(Get_delBtn).click().perform();

        //After a new shoe removed, we need to check the shoeshelf item again to confirm if remove a shoe successfully.
        Thread.sleep(3000);
        int itemLenAfterRemove;
        List<WebElement> itemsAfterRemove = driver.findElements(By.xpath("/html/body/div[2]/app-root/app-profile/div[2]/div/div[2]/ul/li"));
        itemLenAfterRemove=itemsAfterRemove.size();
        System.out.println("user_removeShoesProcessAndCheck()---itemLenAfterRemove---"+itemLenAfterRemove);

        //Assert if remove shoes successfully
        boolean shoeRemoved;
        shoeRemoved=((itemLenBeforeRemove-itemLenAfterRemove)!=1)?false:true;
        System.out.println("user_removeShoesProcessAndCheck()---shoeRemoved---"+shoeRemoved);
        Assert.assertEquals(shoeRemoved,true,"user_removeShoesProcessAndCheck()---Remove shoes failed!");
    }

    /**
     * This is a function which will go to account profile.
     * @param
     * @return
     * @version 1.0
     */
    public void user_modifyProfile() throws InterruptedException {
        Thread.sleep(500);
        //First assert if current page is blank.
        WebElement meBtn = this.Findelement(searchMeBtn);
        System.out.println("meBtn-------------"+meBtn.getAttribute("class"));
        boolean getMeBtn;
        getMeBtn = (meBtn.getAttribute("class")=="tab_item")?false:true;
        Assert.assertEquals(getMeBtn,true,"user_modifyProfile()----This page maybe blank !");

        Actions Click_meBtn = new Actions(driver);
        Click_meBtn.moveToElement(meBtn);
        Thread.sleep(1000);
        Click_meBtn.click().perform();
    }
    /**
     * This is a function which will save updated info in account profile.
     * @param
     * @return
     * @version 1.0
     */
    public static By searchSaveProfileBtn=By.xpath("/html/body/div[2]/app-root/app-profile/div[2]/div/app-profile-form/div/div[5]/button");
    public static By searchUpdateSucceedBtn=By.xpath("/html/body/div[2]/app-root/app-profile/div[2]/div/app-profile-form/div/div[5]");
    public void user_saveProfileAndCheck() throws InterruptedException {
        Thread.sleep(500);
        //First assert if current page is blank.
        WebElement saveProfileBtn = this.Findelement(searchSaveProfileBtn);
        System.out.println("saveProfileBtn----------------"+saveProfileBtn);

        boolean getSaveProfileBtn;
        getSaveProfileBtn = (saveProfileBtn==null)?false:true;
        Assert.assertEquals(getSaveProfileBtn,true,"user_saveProfileAndCheck()----This page maybe blank!");

        scrollTo(saveProfileBtn);
        Actions Click_saveProfileBtn = new Actions(driver);
        Click_saveProfileBtn.moveToElement(saveProfileBtn);
        Thread.sleep(1000);
        Click_saveProfileBtn.click().perform();

        Thread.sleep(1000);
        WebElement updateSucceedBtn = this.Findelement(searchUpdateSucceedBtn);
        boolean getUpdateSucceedBtn;
        getUpdateSucceedBtn = (updateSucceedBtn==null)?false:true;
        Assert.assertEquals(getUpdateSucceedBtn,true,"user_saveProfileAndCheck()----profile update failed!");

        System.out.println("user_saveProfileAndCheck()----profile update succeed!");

    }
    /**
     * This is a function will click credencial button,then go to credencial page.
     * @param
     * @return
     * @version 1.0
     */
    public static By searchAccountCredBtn=By.xpath("/html/body/div[2]/app-root/app-profile/div[1]/div/button");
    public void user_clickAccountCred(){
        WebElement user_accountCredBtn = this.Findelement(searchAccountCredBtn);
        scrollTo(user_accountCredBtn);
        Actions clickUser_accountCredBtn = new Actions(driver);
        clickUser_accountCredBtn.moveToElement(user_accountCredBtn).click().perform();
    }
    /**
     * This is a function will exist the current account.
     * @param
     * @return,
     * @version 1.0
     */
    public static By searchUserAccountExitBtn=By.xpath("/html/body/div[2]/app-root/app-profile-credentials/app-header/div/div/div[2]/button[1]");
    public void user_exitAccount(){
        WebElement user_accountExitBtn = this.Findelement(searchUserAccountExitBtn);
        Actions clickUser_accountExitBtn = new Actions(driver);
        clickUser_accountExitBtn.moveToElement(user_accountExitBtn).click().perform();
    }

    /**
     * This is a function will updated password in the credencial page.
     * @param oldPwd,enPwd,cnPwd
     * @return,
     * @version 1.0
     */

    public static By searchUserOldPwdInput=By.xpath("//*[@id=\"ssm_password\"]");
    public static By searchUserEnPwdInput=By.xpath("//*[@id=\"ssm_new_password\"]");
    public static By searchUserCnPwdInput=By.xpath("//*[@id=\"ssm_confirm_password\"]");
    public static By searchUserChangePwdBtn=By.xpath("/html/body/div[2]/app-root/app-profile-credentials/div/div[2]/button[2]");
    public static By searchPwdUpdateSucceedNotice=By.xpath("/html/body/div[2]/app-root/app-profile-credentials/div/div[2]/div[5]");
    public void user_changePwdAndCheck(String oldPwd,String enPwd,String cnPwd) throws InterruptedException {
        Thread.sleep(500);

        WebElement user_oldPwdInput = this.Findelement(searchUserOldPwdInput);
        user_oldPwdInput.clear();
        user_oldPwdInput.sendKeys(oldPwd);

        WebElement user_enPwdInput = this.Findelement(searchUserEnPwdInput);
        user_enPwdInput.clear();
        user_enPwdInput.sendKeys(enPwd);

        WebElement user_cnPwdInput = this.Findelement(searchUserCnPwdInput);
        user_cnPwdInput.clear();
        user_cnPwdInput.sendKeys(cnPwd);

        WebElement user_changePwdBtn = this.Findelement(searchUserChangePwdBtn);
        Actions Click_changePwdBtn = new Actions(driver);
        Click_changePwdBtn.moveToElement(user_changePwdBtn);
        Click_changePwdBtn.click().perform();

        Thread.sleep(1000);
        WebElement pwdUpdatedNotice = this.Findelement(searchPwdUpdateSucceedNotice);
        boolean getPwdUpdatedNotice;
        getPwdUpdatedNotice = (pwdUpdatedNotice==null)?false:true;
        Assert.assertEquals(getPwdUpdatedNotice,true,"user_changePwdAndCheck()----Pwd updated failed!");
    }

    /**
     * This is a function will randomly pick up a gender.
     * @param
     * @return
     * @version 1.0
     */
    public void user_selectAgender() throws InterruptedException {
        Thread.sleep(500);
        int genderInShoeshelfLen;
        List<WebElement> gendersInShoeshelf = driver.findElements(By.xpath("/html/body/div[2]/app-root/app-profile/div[2]/div/app-profile-form/div/div[1]/div[3]/button"));
        genderInShoeshelfLen=gendersInShoeshelf.size();
        System.out.println("genderInShoeshelfLen---------------"+genderInShoeshelfLen);
        boolean getGenderBtn;
        getGenderBtn = (genderInShoeshelfLen!=2)?false:true;
        Assert.assertEquals(getGenderBtn,true,"user_selectAgender()----This page maybe blank !");

        //Randomly click a gender button.
        Random s=new Random();
        int upTo=genderInShoeshelfLen-1;
        int Get_AgenderIndex=s.nextInt(upTo);
        System.out.println("Get_AgenderIndex------------"+Get_AgenderIndex);

        WebElement Get_AgenderBtn = gendersInShoeshelf.get(Get_AgenderIndex);
        Actions Click_AgenderBtn = new Actions(driver);
        Click_AgenderBtn.moveToElement(Get_AgenderBtn);
        Thread.sleep(1000);
        Click_AgenderBtn.click().perform();
        System.out.println("user_selectAgender()----Gender selected in user account succeed!");
    }


}
