package com.nh.qa.ui.selenium.steps;

import com.nh.qa.ui.selenium.component.NhUi;
import com.nh.qa.ui.selenium.steps.operation.NavigationRunSteps;
import com.nh.qa.ui.selenium.TestConfig;
import com.nh.qa.ui.selenium.steps.LoginRunSteps;
import io.cucumber.java.en.Given;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Properties;

/**
 * @project examplecucumberjvmdependencyinjection
 * @Author mprakash on 12/19/2019.
 */
public class CommonRunSteps {
    @Autowired
    @Qualifier("parameterProperties")
    private Properties paramProp;

    @Autowired
    private NavigationRunSteps navigationRunSteps;

    @Autowired
    private LoginRunSteps loginRunSteps;

    @Autowired
    private NhUi nhUi;

    @Given("I logged in$")
    public void login() {
        loginRunSteps.loadLoginPage();
        loginRunSteps.iClickOnLogTab();
        loginRunSteps.iFillInTheUsernameField();
        loginRunSteps.iFillInThePassordField();
        loginRunSteps.iClickTheLoginButton();
        loginRunSteps.iAmLoggedIn();
//        loginRunSteps.iClickOnLogout();
    }
}