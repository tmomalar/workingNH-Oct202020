package com.nh.qa.ui.selenium.operation;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/**
 * @project examplecucumberjvmdependencyinjection
 * @Author mprakash on 09/03/2020.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        features = { "classpath:com/nh/qa/ui/selenium/operations/initlogin.feature" },
        plugin = {"pretty", "html:target/cucumber-reports","json:target/cucumber.json","junit:target/cucumber.xml","rerun:target/rerun.txt"},
        //plugin = {"pretty", "html:target/cucumber-html-report","json:target/cucumber.json"},
        monochrome = true,
        glue = {"com.nh.qa.ui.selenium.steps" }, strict = true)

/**
 * @project examplecucumberjvmdependencyinjection
 * @Author mprakash on 09/03/2020.
 */
public class InitLoginTest {
}
