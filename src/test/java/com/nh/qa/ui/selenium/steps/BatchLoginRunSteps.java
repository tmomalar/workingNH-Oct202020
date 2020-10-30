package com.nh.qa.ui.selenium.steps;

import com.nh.qa.ui.selenium.component.NhUi;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.Assert.fail;

/**
 * @project examplecucumberjvmdependencyinjection
 * @Author mprakash on 12/17/2019.
 */
public class BatchLoginRunSteps {
    private final List<String[]> userAccounts = new ArrayList<>();
    private final List<String> results = new ArrayList<>();
    private static final String TEST_PROPERTIES = "data.source.dir";

    @Autowired
    private NhUi NhUi;

    @Given("^I load predefined user accounts$")
    public void loadUserAccounts() throws IOException {
        try (final Stream<String> stream = Files.lines(Paths.get(NhUi.getProperties().getProperty(TEST_PROPERTIES) + "/user-accounts.csv"))) {
            stream.skip(1).forEach(item -> userAccounts.add(item.split(",")));
        }
    }

    @Then("^I use those accounts to login successfully and unsuccessfully$")
    public void loginWithDifferentUserAccounts() {
        NhUi.loadPath("/");
        for (String [] userAccount : userAccounts) {
//            NhUi.loadPath("/");
            NhUi.click(By.cssSelector("#ctl00_KBMenu_RadMenu1 > ul > li.rmItem.rmLast > a > span"));
            NhUi.sendKeys(By.id("Username"), userAccount[0]);
            NhUi.sendKeys(By.id("Password"), userAccount[1]);
//            NhUi.click(By.xpath("//*[@id=\"pageContent\"]/div[1]/div[3]/div/div/div[2]/form/fieldset/div[3]/button[1]"));
            NhUi.click(By.xpath("//*[@id=\"pageContent\"]/div[1]/div[3]/div/div/div[2]/form/fieldset/div[3]/button[1]"));

//            NhUi.sendKeys(By.id("userName"), userAccount[0]);
//            NhUi.sendKeys(By.id("password"), userAccount[1]);
//            NhUi.click(By.cssSelector("input[type=\"button\"]"));

            if (userAccount[2].equalsIgnoreCase("mainPage")) {
                NhUi.waitUntilElementIsVisible(By.className("rmText"));
                NhUi.sleep();
                NhUi.mouseHover(By.linkText("My Account"));
                NhUi.sleep();
                NhUi.click(By.linkText("Logout"));
                NhUi.verifyLogout();
                NhUi.sleep();
                //NhUi.waitUntilElementIsNotVisible(By.xpath("//*[@id=\"ctl00_ctl00_MainContent_MainContent_lblTitle\"]"));
                //NhUi.waitUntilElementIsVisible(By.cssSelector("#ctl00_ctl00_MainContent_MainContent_lblTitle"));
            } else if (userAccount[2].equalsIgnoreCase("loginErrorMessage")) {
                //NhUi.waitUntilElementIsVisible(By.className("login-error-msg"));
                //NhUi.waitUntilElementIsVisible(By.xpath("//*[@id=\"pageContent\"]/div[1]/div[2]/div/div/ul/li/text()");
                //NhUi.waitUntilElementIsVisible(By.cssSelector("#pageContent > div.login-page > div:nth-child(2) > div > div > ul > li"));
                NhUi.waitUntilElementIsVisible(By.className("alert"));
                NhUi.click(By.cssSelector("#pageContent > div.login-page > div.row > div > div > div.panel-body > form > fieldset > div:nth-child(3) > button.btn.btn-default"));
                NhUi.sleep();
            } else {
                fail("Unexpected result = " + userAccount[2]);
            }
        }
    }
}
