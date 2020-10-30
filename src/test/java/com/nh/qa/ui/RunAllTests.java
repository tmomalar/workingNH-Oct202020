package com.nh.qa.ui;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/**
 * @project nhqaautomation
 * @Author mprakash on 12/17/2019.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        features = { "classpath:com/nh/qa/ui/selenium"},
        plugin = {"pretty", "html:target/cucumber-reports","json:target/cucumber.json","junit:target/cucumber.xml","rerun:target/rerun.txt"},
        //plugin = {"pretty", "html:target/cucumber-html-report","json:target/cucumber.json"},
        monochrome = true,
        glue = {"com.nh.qa.ui.selenium.steps"})
public class RunAllTests {}
