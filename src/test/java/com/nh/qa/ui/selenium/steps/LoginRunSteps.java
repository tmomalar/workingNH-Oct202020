package com.nh.qa.ui.selenium.steps;

import com.nh.qa.ui.selenium.TestConfig;
import com.nh.qa.ui.selenium.component.NhUi;
//import cucumber.api.java.en.And;
//import cucumber.api.java.en.Given;
//import cucumber.api.java.en.Then;
//import cucumber.api.java.en.When;
import gherkin.ast.Examples;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

import org.openqa.selenium.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author mprakash on 12/17/2019.
 */
@ContextConfiguration(classes = TestConfig.class)
public class LoginRunSteps {

    @Autowired
    private NhUi NhUi;

    @Given("^I am on the AutoImmune Home Page$")
    public void loadLoginPage() {
        NhUi.loadPath("/");
        NhUi.sleep5();
    }

    @Then("I exit the page")
    public void exitPage() {
        NhUi.destroy();
        NhUi.sleep();
    }

    @When("I click on login tab")
    public void iClickOnLogTab() {
        NhUi.click(By.cssSelector("#ctl00_KBMenu_RadMenu1 > ul > li.rmItem.rmLast > a > span"));
        // NhUi.click(By.cssSelector("#hptl > a:nth-child(1)"));
        // NhUi.isElementExists(By.linkText("Our mission"));
        // System.out.println("I am done here");
        NhUi.sleep();
    }

    @When("I fill in the username field")
    public void iFillInTheUsernameField() {
        NhUi.sendKeys(By.id("Username"), NhUi.getProperties().getProperty("kb.user.name"));
        // NhUi.sendKeys(By.id("username"), "example@gmail.com");
        // NhUi.sendKeys(By.id("password"), "password");
        // NhUi.click(By.xpath("//button[text()='Sign in']"));
        // NhUi.sendKeys(By.xpath("Username"), NhUi.getProperties().getProperty("kb.user.name"));
        NhUi.sleep();
    }

    @And("I fill in the password field")
    public void iFillInThePassordField() {
        NhUi.sendKeys(By.id("Password"), NhUi.getProperties().getProperty("kb.user.password"));
        NhUi.sleep();
    }

    @And("I click the login button")
    public void iClickTheLoginButton() {
        NhUi.click(By.xpath("//*[@id=\"pageContent\"]/div[1]/div[3]/div/div/div[2]/form/fieldset/div[3]/button[1]"));
        NhUi.sleep();
    }

    @Then("I am logged in")
    public void iAmLoggedIn() {
        NhUi.sleep();
    }

    @Then("I click on logout")
    public void iClickOnLogout() {
//        NhUi.mouseHover(By.xpath("//*[@id=\"ctl00_ctl00_KBMenu_RadMenu1\"]/ul/li[8]/a/span"));
//        NhUi.click(By.xpath("//*[@id=\"ctl00_ctl00_KBMenu_RadMenu1\"]/ul/li[8]/div/ul/li[1]/a/span"));
        NhUi.mouseHover(By.linkText("My Account"));
        NhUi.click(By.linkText("Logout"));
        NhUi.sleep();
    }

    @And("I fill in password by copying password string")
    public void iFillInPasswordByCopyingPasswordString() {
        NhUi.sendKeys(By.id("Password"), NhUi.getProperties().getProperty("kb.user.password"));
        NhUi.sendKeys(Keys.CONTROL + "a");
        NhUi.sleep();
        NhUi.sendKeys(Keys.CONTROL + "c");
        NhUi.sleep();
        NhUi.clear(By.id("Password"));
        NhUi.sleep();
        //NhUi.sendKeys(Keys.CONTROL + "DELETE");
        //NhUi.sleep();
        NhUi.sendKeys(Keys.CONTROL + "v");
        NhUi.click(By.xpath("//*[@id=\"pageContent\"]/div[1]/div[3]/div/div/div[2]/form/fieldset/div[3]/button[1]"));
        NhUi.sleep();
        NhUi.waitUntilElementIsVisible(By.className("alert"));
        NhUi.sleep();
    }

    @Then("I click on cancel button")
    public void iClickOnCancelButton() {
        //NhUi.click(By.cssSelector("#pageContent > div.login-page > div.row > div > div > div.panel-body > form > fieldset > div:nth-child(3) > button.btn.btn-default"));
        //NhUi.click(By.className("cancel"));
        NhUi.click(By.xpath("//*[@id=\"pageContent\"]/div[1]/div[3]/div/div/div[2]/form/fieldset/div[3]/button[2]"));
        NhUi.sleep();
    }

    @Then("I click on back button on the browser")
    public void iClickOnBackButtonOnTheBrowser() {
        NhUi.clickBackButton();
    }

    @Then("I click on Template Management Tab")
    public void iClickOnTemplateManagementTab() {
        NhUi.waitUntilElementIsVisible(By.linkText("Template Management"));
        NhUi.click(By.linkText("Template Management"));
    }

    @Then("I add drugs to Drug Name Field")
    public void iAddDrugsToDrugNameField() {
//        NhUi.waitUntilElementIsVisible(By.id("Drug"));
//        NhUi.sendKeysAndClick(By.id("drugName"), "Anastrozole");
//        NhUi.click(By.xpath("//*[@data-ref-id='feather-form-element-label’ and @label[text()=’Name’]]"));
//        NhUi.sendKeysAndClick(By.xpath("//*[@data-ref-id=’feather-form-element-label’ and @label[text()=’Name’]]"), "Anastrozole");
//        NhUi.clickWhenReady(By.xpath("/html/body/div/div/div[1]/div/div[1]/div/div[1]/div/div/div[3]"));
//        NhUi.sendKeysAndClick(By.xpath(".//*[contains(text(),'Enter 3 characters or more to search')]"), "Anastrozole");
//        NhUi.click(By.className("center-content"));
        NhUi.clickWhenReady(By.xpath(".//*[@data-ref-id='feather-form-element-label' and text()='Name']"));
        NhUi.sendKeys("Anastrozole");
        NhUi.sendKeys(Keys.RETURN);
//        NhUi.sendKeysAndClick(By.xpath(".//*[@data-ref-id='feather-form-element-label' and text()='Name']"), "Anastrozole");
//        NhUi.click(By.xpath("//*[@data-ref-id=’feather-form-element-label’ and @text()=’Name’]"));
        NhUi.sendKeys(Keys.TAB);
        NhUi.sleep5();
    }

    @Then("I add Rheumatoid arthritis to Disease Field")
    public void iAddDiseaseToDiseaseField() {
//        NhUi.click(By.id("disease"));
//        NhUi.clickWhenReady(By.name("disease"));
//        NhUi.selectFromDropDown(By.name("disease"),"Rheumatoid arthritis");
//        NhUi.sleep5();
//        NhUi.clickWhenReady(By.xpath(".//*[contains(text(),'Autoimmune Disease')]"));
//        NhUi.clickWhenReady(By.xpath(".//*[@data-ref-id='feather-form-element-label' and text()='Name']"));
//        NhUi.sleep();
        NhUi.clickWhenReady(By.xpath(".//*[@data-ref-id='feather-form-element-label' and text()='Autoimmune Disease']"));
//        NhUi.selectFromDropDown(By.xpath(".//*[@data-ref-id='feather-form-element-label' and text()='Autoimmune Disease']"), "Rheumatoid arthritis");
        NhUi.clickWhenReady(By.xpath(".//*[contains(text(),'Rheumatoid arthritis')]"));
        NhUi.sleep();
    }

    @Then("I add FirstLineOfTreatment")
    public void iAddFirstLineOfTreatment() {
//        NhUi.clickWhenReady(By.name("lineOfTreatment"));
//        NhUi.selectFromDropDown(By.name("lineOfTreatment"),"Second line treatment");
        NhUi.clickWhenReady(By.xpath(".//*[@data-ref-id='feather-form-element-label' and text()='Line of Treatment']"));
//        NhUi.selectFromDropDown(By.name("Line of Treatment"),"New LoT");
        NhUi.clickWhenReady(By.xpath(".//*[contains(text(),'First Line')]"));
//        NhUi.sleep5();
    }

    @Then("I add WellPoint Central as Entity")
    public void iAddWellPointCentralAsEntity() {
//        NhUi.waitUntilElementIsVisible(By.name("Entity"));
//        NhUi.selectFromDropDown(By.name("Entity"), "WellPoint Central");
//        NhUi.sleep5();
        NhUi.clickWhenReady(By.xpath(".//*[@data-ref-id='feather-form-element-label' and text()='Entity']"));
        NhUi.clickWhenReady(By.xpath(".//*[contains(text(),'WellPoint Central')]"));
    }

    @Then("I click on Search Button")
    public void iClickOnSearchButton() {
//        NhUi.waitUntilElementIsVisible(By.xpath("//*[@id=\"mainApp\"]/div[1]/div/button"));
//        NhUi.click(By.className("searchRegimenButton"));
        NhUi.clickWhenReady(By.cssSelector("div.searchRegimenButton > button"));
//        NhUi.clickWhenReady(By.xpath(".//*[@class='searchRegimenButton']/button"));
//        NhUi.sleep5();
    }

    @And("I click Back Button to go back to home page")
    public void iClickBackButtonToGoBackToHomePage() {
        NhUi.clickBackButton();
//        NhUi.sleep(3000);
    }

    @And("I click Management Tab and select SubDisease Management")
    public void iClickManagementTabAndSelectSubDiseaseManagement() {
//        NhUi.clickWhenReady(By.xpath("//*[@id=\"mainApp\"]/div[1]/header/div/header/div/nav/div/button/span"));
        NhUi.clickWhenReady(By.className("mega-menu"));
//        NhUi.sleep();
        NhUi.clickWhenReady(By.linkText("SubDisease Management"));

//        NhUi.dropdownfromlist(By.xpath("//*[@id=\"mainApp\"]/div[1]/header/div/header/div/nav/div/button/span"), "SubDisease Management");
//        NhUi.clickWhenReady(By.xpath("//*[@id=\"mainApp\"]/div[1]/header/div/header/div/nav/div/div/div[1]/div[2]/li[1]/a/span/text()"));
//        NhUi.sleep();
//        NhUi.clickWhenReady(By.xpath("//*[@id=\"mainApp\"]/div[1]/header/div/header/div/nav/div/button/span"));
//        NhUi.sleep();
//        NhUi.clickWhenReady(By.xpath("//*[@id=\"mainApp\"]/div[1]/header/div/header/div/nav/div/div/div[1]/div[2]/li[2]/a/span/text()"));
//        NhUi.sleep();
//        NhUi.dropdownfromlist(By.xpath("//*[@id=\"mainApp\"]/div[1]/header/div/header/div/nav/div/button/span"), "Line of Treatment Management");
//       NhUi.sleep5();
    }

    @Given("I click Management Tab and select Line of Treatment Management")
    public void iClickManagementTabAndSelectLineOfTreatmentManagement() {
        NhUi.clickWhenReady(By.xpath("//*[@id=\"mainApp\"]/div[1]/header/div/header/div/nav/div/button/span"));
//        NhUi.sleep3();
        NhUi.clickWhenReady(By.linkText("Line of Treatment Management"));
//        NhUi.sleep3();
    }

    @When("I am in Management Home Page")
    public void i_am_in_Management_Home_Page() {
        NhUi.clickWhenReady(By.xpath("//*[@id=\"mainApp\"]/div[1]/header/div/header/div/nav/a/img"));
//        NhUi.sleep5();
    }

    @Then("I add Autoimmune Disease")
    public void i_add_Autoimmune_Disease() {
//        NhUi.waitUntilElementIsVisible(By.name("Autoimmune Disease"));
//        NhUi.selectFromDropDown(By.linkText("Autoimmune Disease"),"Rheumatoid arthritis");
//        NhUi.selectFromDropDown(By.xpath(".//*[contains(text(),'Autoimmune Disease')]"), "Rheumatoid arthritis");
//        NhUi.sleep();
//        NhUi.clickWhenReady(By.xpath(".//*[contains(text(),'Autoimmune Disease')]"));
        NhUi.clickWhenReady(By.xpath(".//*[@data-ref-id='feather-form-element-label' and text()='Autoimmune Disease']"));
        NhUi.clickWhenReady(By.xpath(".//*[contains(text(),'Rheumatoid arthritis')]"));
        NhUi.sleep2();
    }

    @Then("I click on Search Page")
    public void i_click_on_Search_Page() {
//        NhUi.clickWhenReady(By.xpath("//*[@id=\"mainApp\"]/div[1]/div/button"));
        NhUi.clickWhenReady(By.xpath(".//*[contains(text(),'search')]"));
//        NhUi.sleep2();
//        NhUi.clickWhenReady(By.xpath("//*[@id=\"mainApp\"]/div[1]/div/div[5]/button"));
    }

//    @Then("I get a list of search results")
//    public void i_get_a_list_of_search_results() throws Exception {
//        if(NhUi.isTextPresent("Awesome Cotton Pizza")){
//            System.out.println("passed");
//        } else throw new Exception();
//        NhUi.sleep();
//    }
//@Then("I get a list of search results")
//public void i_get_a_list_of_search_results() throws Exception {
//    if(NhUi.isTextPresent("Awesome Cotton Pizza")){
//        System.out.println("passed");
//    } else throw new Exception();
//    NhUi.sleep();
//}

    // Manick changed on oct 21
//    @Then("I get a list of search results")
//    public void i_get_a_list_of_search_results() throws Exception {
//        if (NhUi.isTextPresent("Awesome Plastic Ball")) {
//            ;
//            NhUi.sleep();
//        } else {
//            throw new Exception();
//        }
//    }

    @Then("I get a list of search results")
    public void i_get_a_list_of_search_results(){
//        NhUi.waitUntilElementIsNotVisible(By.className("feather-wait-dialog"), 10);
        NhUi.clickWhenReady(By.xpath(".//*[contains(text(),'Awesome Plastic Ball')]"));
    }
//@Then("I get a list of search results")
//public void i_get_a_list_of_search_results() throws Exception {
////        NhUi.isTextPresent("Licensed Rubber Pizza");
//    NhUi.isTextPresent("Awesome Cotton Pizza");
//    NhUi.sleep5();
//}

    @Then("I click on properties button")
    public void iClickOnPropertiesButton() {
        NhUi.clickWhenReady(By.xpath("/html/body/div/div/div[1]/div/div/table/tbody/tr[1]/td[3]/div/button"));
//        NhUi.sleep3();
    }

    @Then("I select View Template")
    public void iSelectViewTemplate() {
        NhUi.clickWhenReady(By.linkText("View Template"));
//        NhUi.sleep5();
    }

    @Then("I click on Template Information")
    public void iClickOnTemplateInformation() {
//        NhUi.clickWhenReady(By.xpath("//*[@id=\"mainApp\"]/div[1]/span/div/div/div[1]/div/div[1]/button"));
//        NhUi.sleep();
        NhUi.clickWhenReady(By.xpath("//*[contains(text(),'Template Information')]"));
    }

    @Then("I click on Diseases")
    public void iClickOnDiseases() {
//        NhUi.clickWhenReady(By.xpath("//*[@id=\"mainApp\"]/div[1]/span/div/div/div[1]/div/div[2]/button"));
//        NhUi.sleep();
        NhUi.clickWhenReady(By.xpath("//*[contains(text(),'Diseases')]"));
    }

    @Then("I click on Justifications")
    public void iClickOnJustifications() {
//        NhUi.clickWhenReady(By.xpath("//*[@id=\"mainApp\"]/div[1]/span/div/div/div[1]/div/div[3]/button"));
//        NhUi.sleep();
        NhUi.clickWhenReady(By.xpath("//*[contains(text(),'Justifications')]"));
    }

    @Then("I click on Supportive Groups")
    public void iClickOnSupportiveGroups() {
        NhUi.clickWhenReady(By.xpath("//*[@id=\"mainApp\"]/div[1]/span/div/div/div[1]/div/div[4]/button"));
//        NhUi.sleep();
    }

    @Then("I click on Sources")
    public void iClickOnSources() {
        NhUi.clickWhenReady(By.xpath("//*[@id=\"mainApp\"]/div[1]/span/div/div/div[1]/div/div[5]/button"));
//        NhUi.sleep();
    }

    @Then("I click on Add New Button")
    public void iClickOnAddNewButton() {
//        NhUi.clickWhenReady(By.cssSelector("#mainApp > div.mainLayoutContent > div > div.content-grid-search > button"));
        NhUi.clickWhenReady(By.xpath(".//*[contains(text(),'Add New')]"));
//        NhUi.sleep();
    }

    @Then("I add Sub Disease Data")
    public void iAddSubDiseaseDataAndSave() {
        NhUi.clickWhenReady(By.xpath("/html/body/div/div/div[1]/div/span/form/div[1]/div/span[1]/div/div/div/div/input"));
//        NhUi.sleep();
//        NhUi.sendKeys(By.xpath("/html/body/div/div/div[1]/div/span/form/div[1]/div/span[1]/div/div/div/div/input"), "TestSubDisease");
        NhUi.sendKeys("TestSubDisease");
//        NhUi.sleep();
        NhUi.clickWhenReady(By.xpath("/html/body/div/div/div[1]/div/span/form/div[1]/div/span[2]/div/div/div"));
//        NhUi.sleep();
        NhUi.sendKeys("222");
        //NhUi.sendKeys(By.cssSelector("/html/body/div/div/div[1]/div/span/form/div[1]/div/span[2]/div/div/div/div/input"), "1");
//        NhUi.sleep();
        NhUi.clickWhenReady(By.xpath("//*[contains(text(),'Parent Disease')]"));
//        NhUi.clickWhenReady(By.cssSelector("div:contains('Parent Disease')"));
//        NhUi.sleep2();
        NhUi.clickWhenReady(By.xpath("//*[contains(text(),'Hidradenitis')]"));
//        NhUi.selectFromDropDown(By.xpath("//*[contains(text(),'Parent Disease')]"), "Hidradenitis");
//        NhUi.sleep();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date()); // Now use today date.
        String currentDate = sdf.format(c.getTime());
        System.out.println(currentDate);
        c.add(Calendar.DATE, 5); // Adding 5 days
        String currentDatePlus5 = sdf.format(c.getTime());
        System.out.println(currentDatePlus5);
        NhUi.sendKeys(By.id("activationDate"), currentDate);
        NhUi.sendKeys(By.id("terminationDate"), currentDatePlus5);
//        NhUi.sleep3();
//        NhUi.clickWhenReady(By.cssSelector("#mainApp > div.mainLayoutContent > div > span > form > div.horizontal-right.cardButtons > button.btn.btn-primary"));
        NhUi.clickWhenReady(By.xpath("//*[contains(text(),'Save')]"));
//        NhUi.sleep2();
    }

    @Given("I click on edit button")
    public void iClickOnEditButton() {
        NhUi.clickWhenReady(By.xpath(".//*[contains(text(),'Edit')]"));
//        NhUi.clickWhenReady(By.xpath("/html/body/div/div/div[1]/div/span/form/div[1]/button[0]"));
//        NhUi.clickWhenReady(By.cssSelector("div:contains('Edit')"));
//        NhUi.sleep2();
    }

    @Then("I edit Name")
    public void iEditName() {
//        NhUi.clickWhenReady(By.xpath("/html/body/div/div/div[1]/div/span/form/div[1]/div/span[1]/div/div/div/div/input"));
//        NhUi.clear(By.xpath(".//*[contains(text(),'Enter name here')]"));
        NhUi.clickWhenReady(By.xpath(".//*[@data-ref-id='feather-form-element-label' and text()='Enter name here.']"));
//        NhUi.sleep3();
        NhUi.sendKeys(Keys.CONTROL + "a");
        NhUi.sendKeys("SubDiseaseTestEdited");
//        NhUi.sleep3();
    }

    @Then("I edit SCTID")
    public void iEditSCTID() {
//        NhUi.clickWhenReady(By.xpath("/html/body/div/div/div[1]/div/span/form/div[1]/div/span[2]/div/div/div"));
//        NhUi.clickWhenReady(By.xpath(".//*[contains(text(),'Enter SCTID here')]"));
        NhUi.clickWhenReady(By.xpath(".//*[@data-ref-id='feather-form-element-label' and text()='Enter SCTID here.']"));
        NhUi.sendKeys(Keys.CONTROL + "a");
//        NhUi.sleep();
        NhUi.sendKeys("333");
    }

    @Then("I edit Parent Disease")
    public void iEditParentDisease() {
//        NhUi.clickWhenReady(By.xpath("//*[contains(text(),'Parent Disease')]"));
        NhUi.clickWhenReady(By.xpath(".//*[@data-ref-id='feather-form-element-label' and text()='Parent Disease']"));
//        NhUi.sleep2();
        NhUi.clickWhenReady(By.xpath("//*[contains(text(),'Rheumatoid arthritis')]"));

    }

    @Then("I change the Termination Date further by five days")
    public void iChangeTheTerminationDateFurtherByFiveDays() {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date()); // Now use today date.
        String currentDate = sdf.format(c.getTime());
        System.out.println(currentDate);
        c.add(Calendar.DATE, 10); // Adding 5 days
        String currentDatePlus10 = sdf.format(c.getTime());
        System.out.println(currentDatePlus10);
        NhUi.clickWhenReady(By.id("activationDate"));
        NhUi.sendKeys(Keys.CONTROL + "a");
//        NhUi.sleep2();
        NhUi.sendKeys(By.id("activationDate"), currentDate);
//        NhUi.sleep2();
        NhUi.clickWhenReady(By.id("terminationDate"));
        NhUi.sendKeys(Keys.CONTROL + "a");
//        NhUi.sleep2();
        NhUi.sendKeys(By.id("terminationDate"), currentDatePlus10);
//        NhUi.sleep3();
//        NhUi.clickWhenReady(By.cssSelector("#mainApp > div.mainLayoutContent > div > span > form > div.horizontal-right.cardButtons > button.btn.btn-primary"));
    }

    @Then("I change the Activation Date and Termination date by minus ten days")
    public void iChangeTheActivationDateAndTerminationDateByMinusTenDays() {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date()); // Now use today date.
        c.add(Calendar.DATE, -10); // go back by 10 days
        String currentDate = sdf.format(c.getTime());
        System.out.println(currentDate);
        c.add(Calendar.DATE, 2); // Adding -5 days
        String currentDatePlus10 = sdf.format(c.getTime());
        System.out.println(currentDatePlus10);
        NhUi.clickWhenReady(By.id("activationDate"));
        NhUi.sendKeys(Keys.CONTROL + "a");
//        NhUi.sleep2();
        NhUi.sendKeys(By.id("activationDate"), currentDate);
//        NhUi.sleep2();
        NhUi.clickWhenReady(By.id("terminationDate"));
        NhUi.sendKeys(Keys.CONTROL + "a");
//        NhUi.sleep2();
        NhUi.sendKeys(By.id("terminationDate"), currentDatePlus10);
//        NhUi.sleep3();
//        NhUi.clickWhenReady(By.cssSelector("#mainApp > div.mainLayoutContent > div > span > form > div.horizontal-right.cardButtons > button.btn.btn-primary"));
//        NhUi.clickWhenReady(By.xpath("//*[contains(text(),'Save')]"));
        NhUi.sleep3();
    }

    @Then("I click on Save button")
    public void iClickOnSaveButton() {
        NhUi.clickWhenReady(By.xpath("//*[contains(text(),'Save')]"));
        NhUi.sleep();
        NhUi.refreshPage();
//        NhUi.sleep2();
    }

    @When("I click on SubDisease")
    public void iClickOnSubDisease() {
        NhUi.clickWhenReady(By.xpath("//*[contains(text(),'TestSubDisease')]"));
//        NhUi.sleep2();
    }

    @When("I click on SubDiseaseEdited")
    public void iClickOnSubDiseaseEdited() {
        NhUi.clickWhenReady(By.xpath("//*[contains(text(),'TestSubDiseaseEdited')]"));
//        NhUi.sleep2();
    }

    @Then("I add LOTTest")
    public void iAddLOTTest() {
//        NhUi.clickWhenReady(By.xpath("//*[contains(text(),'Enter name here')]"));
        NhUi.clickWhenReady(By.xpath(".//*[@data-ref-id='feather-form-element-label' and text()='Enter name here.']"));
        NhUi.sendKeys("LOTTest");
    }

    @Then("I select clinical condition as Autoimmune Disease")
    public void iSelectClinicalConditionAsAutoimmuneDisease() {
//        NhUi.clickWhenReady(By.xpath("//*[contains(text(),'Clinical Condition')]"));
        NhUi.clickWhenReady(By.xpath(".//*[@data-ref-id='feather-form-element-label' and text()='Clinical Condition']"));
        NhUi.clickWhenReady(By.xpath("//*[contains(text(),'Autoimmune disease')]"));
    }

    @Then("I add Activation Date and Termination Date")
    public void iAddActivationDateAndTeminationDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date()); // Now use today date.
        String currentDate = sdf.format(c.getTime());
        System.out.println(currentDate);
        c.add(Calendar.DATE, 5); // Adding 5 days
        String currentDatePlus5 = sdf.format(c.getTime());
        System.out.println(currentDatePlus5);
        NhUi.clickWhenReady(By.id("activationDate"));
        NhUi.sendKeys(Keys.CONTROL + "a");
//        NhUi.sleep2();
        NhUi.sendKeys(By.id("activationDate"), currentDate);
//        NhUi.sleep2();
        NhUi.clickWhenReady(By.id("terminationDate"));
        NhUi.sendKeys(Keys.CONTROL + "a");
//        NhUi.sleep2();
        NhUi.sendKeys(By.id("terminationDate"), currentDatePlus5);
//        NhUi.sleep3();
//        NhUi.clickWhenReady(By.cssSelector("#mainApp > div.mainLayoutContent > div > span > form > div.horizontal-right.cardButtons > button.btn.btn-primary"));
//        NhUi.clickWhenReady(By.xpath("//*[contains(text(),'Save')]"));
//        NhUi.sleep2();
    }

    @Given("I click on the LOTTest")
    public void iClickOnTheLOTTest() {
        NhUi.clickWhenReady(By.xpath(".//*[contains(text(),'LOTTest')]"));
//        NhUi.sleep3();
//        NhUi.sendKeys(Keys.CONTROL + "a");
//        NhUi.sendKeys("TestSubDiseaseEdited");
//        NhUi.sleep3();
    }

    @Then("I click on DiseaseTest")
    public void iClickOnDiseaseTest() {
        NhUi.clickWhenReady(By.xpath(".//*[contains(text(),'DiseaseTest')]"));
    }

    @And("I verify it is cleared")
    public void iVerifyItIsCleared(){
        NhUi.waitUntilElementIsNotVisible(By.xpath(".//*[contains(text(), 'New Test')]"), 5);
        //NhUi.isElementNotExists("LOTTest");
//        //public void i_get_a_list_of_search_results() throws Exception {
//        if (NhUi.isTextNotPresent("Awesome Plastic Ball")) {
//            throw new Exception();
//        } else {
//            ;
//            NhUi.sleep();
//        }
//    }
    }

    @And("I verify {string} it is cleared")
    public void iVerifyStringItIsCleared(String arg0) {
        NhUi.waitUntilElementIsNotVisible(By.xpath(".//*[contains(text(), {string}]"), 5);
    }

//    @And("I verify myvalue {string} it is cleared")
//    public void iVerifyMyvalueItIsCleared(String somevalue) {
////        NhUi.clickWhenReady(By.xpath(".//*[contains(text(), arg0]"), 5);
//        //NhUi.clickWhenReady(By.xpath(".//*[contains(text(), arg0)]"));
//       // NhUi.clickWhenReady(By.xpath(".//*[contains(text(), 'New LoT')]"));
//        NhUi.waitUntilElementIsNotVisible((By.xpath(".//*[contains(text(), somevalue)]")), 5);
//        NhUi.sleep(10000);
//        System.out.println(somevalue);
//        //NhUi.waitUntilElementIsNotVisible((By.xpath(".//*[contains(text(), arg0)]")), 5);
//    }
    @And("^I am on Home Page of \"([^\"]*)\"$")
    public void i_am_on_Home_Page_of(String arg1) throws Throwable {
        NhUi.waitUntilElementIsNotVisible((By.xpath(".//*[contains(text(), arg1)]")), 5);
        NhUi.sleep5();
        System.out.println(arg1);
    }

    @And("I am in verify step")
    public void iAmInVerifyStep() {
        NhUi.waitUntilElementIsNotVisible(By.xpath(".//*[contains(text(), 'New Test')]"), 4);
        }

    @And("I am in verify {string}")
    public void iAmInVerify(String arg0) {
        NhUi.waitUntilElementIsNotVisible(By.xpath(".//*[contains(text(), arg0)]"), 4);
    }

    @And("I am in find elements")
    public void iAmInFindElements() throws  Exception{
        if (NhUi.waitFindingElements(By.xpath(".//*[contains(text(), 'asdfasdfsd')]"))>0 ){
            throw new Exception();
        } else {
            ;
            NhUi.sleep();
        }
    }

    @And("I am not seeing {string}")
    public void iAmNotSeeing(String arg0) throws  Exception{
        NhUi.isTextNotPresent(arg0);
//        if (NhUi.waitFindingElements(By.xpath(".//*[contains(text(), arg0)]"))>0 ){
//        if (NhUi.isTextNotPresent(arg0)){
//            throw new Exception();
//        } else {
//            ;
//            NhUi.sleep();
//        }
    }

    @And("I am not seeing LOTTest")
    public void iAmNotSeeingLOTTest() throws  Exception{
        if (NhUi.waitFindingElements(By.xpath(".//*[contains(text(), 'LOTTest')]"))>0 )
            throw new Exception("The elements are visible");
        else {
            ;
            NhUi.sleep();
        }
    }

    @Given("I click Management Tab and select Disease Management")
    public void iClickManagementTabAndSelectDiseaseManagement() {
//        NhUi.clickWhenReady(By.xpath("//*[@id=\"mainApp\"]/div[1]/header/div/header/div/nav/div/button/span"));
        NhUi.clickWhenReady(By.className("mega-menu"));
        NhUi.clickWhenReady(By.linkText("Disease Management"));
    }

    @Then("I edit Name as LOTTestEdited")
    public void iEditNameAsLOTTestEdited() {
//        NhUi.clickWhenReady(By.xpath("/html/body/div/div/div[1]/div/span/form/div[1]/div/span[1]/div/div/div/div/input"));
        NhUi.clickWhenReady(By.xpath(".//*[@data-ref-id='feather-form-element-label' and text()='Enter name here.']"));
        NhUi.sendKeys(Keys.CONTROL + "a");
        NhUi.sendKeys("LOTTestEdited");
    }

    @Given("I click on the LOTTestEdited")
    public void iClickOnTheLOTTestEdited() {
        NhUi.clickWhenReady(By.xpath(".//*[contains(text(),'LOTTestEdited')]"));
    }

    @And("I am not seeing LOTTestEdited")
    public void iAmNotSeeingLOTTestEdited() throws  Exception{
        if (NhUi.waitFindingElements(By.xpath(".//*[contains(text(), 'LOTTestEdited')]"))>0 )
            throw new Exception("The elements are visible");
        else {
            ;
            NhUi.sleep();
        }
    }

    @Then("I add DiseaseTest")
    public void iAddDiseaseTest() {
//        NhUi.clickWhenReady(By.xpath("//*[contains(text(),'Enter name here')]"));
        NhUi.clickWhenReady(By.xpath(".//*[@data-ref-id='feather-form-element-label' and text()='Enter name here.']"));
        NhUi.sendKeys("DiseaseTest");
    }

    @Then("I edit Name as DiseaseTestEdited")
    public void iEditNameAsDiseaseTestEdited() {
//        NhUi.clickWhenReady(By.xpath("/html/body/div/div/div[1]/div/span/form/div[1]/div/span[1]/div/div/div/div/input"));
        NhUi.clickWhenReady(By.xpath(".//*[@data-ref-id='feather-form-element-label' and text()='Enter name here.']"));
        NhUi.sendKeys(Keys.CONTROL + "a");
        NhUi.sendKeys("DiseaseTestEdited");
    }

    @Given("I click on the DiseaseTestEdited")
    public void iClickOnTheDiseaseTestEdited() {
        NhUi.clickWhenReady(By.xpath(".//*[contains(text(),'DiseaseTestEdited')]"));
    }

    @And("I am not seeing DiseaseTestEdited")
    public void iAmNotSeeingDiseaseTestEdited() throws  Exception{
        if (NhUi.waitFindingElements(By.xpath(".//*[contains(text(), 'DiseaseTestEdited')]"))>0 )
            throw new Exception("The elements are visible");
        else {
            ;
            NhUi.sleep();
        }
    }

    @Then("I click on {string}")
    public void iClickOn(String arg0) {
        NhUi.clickWhenReady(By.xpath(".//*[contains(text(), arg0)]"));
        NhUi.sleep();
    }

    @Then("I refresh the Page")
    public void iRefreshTheScreen() {
        NhUi.refreshPage();
    }

    @Then("I add SubDiseaseTest")
    public void iAddSubDiseaseTest() {
        NhUi.clickWhenReady(By.xpath(".//*[@data-ref-id='feather-form-element-label' and text()='Enter name here.']"));
        NhUi.sendKeys("SubDiseaseTest");
    }

    @Then("I click on the SubDiseaseTest")
    public void iClickOnTheSubDiseaseTest() {
        NhUi.clickWhenReady(By.xpath(".//*[contains(text(),'SubDiseaseTest')]"));
    }

    @Then("I click on the SubDiseaseTestEdited")
    public void iClickOnTheSubDiseaseTestEdited() {
        NhUi.clickWhenReady(By.xpath(".//*[contains(text(),'SubDiseaseTestEdited')]"));
    }

    @Then("I click on LOTTest")
    public void iClickOnLOTTest() {
        NhUi.clickWhenReady(By.xpath(".//*[contains(text(),'LOTTest')]"));
    }

//    @Then("I verify the login screen")
//    public void iVerifyTheLoginScreen() {
//        NhUi.waitUntilElementIsVisible(By.className("LOGIN"));
//    }
}