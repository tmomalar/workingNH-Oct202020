package com.nh.qa.ui.selenium;

import org.apache.commons.codec.net.URLCodec;
//import com.nh.qa.commandprocessor.jsch.impl.KeyedPooledJschChannelFactory;
//import com.nh.qa.common.scrubber.ScrubberService;
//import com.jcraft.jsch.JSch;
//import com.jcraft.jsch.JSchException;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.openqa.selenium.By;
//import org.apache.commons.pool2.impl.GenericKeyedObjectPool;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;

import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @project examplecucumberjvmdependencyinjection
 * @Author mprakash on 12/17/2019.
 */
@Configuration
@ComponentScan({"com.nh.qa.ui.selenium.component", "com.nh.qa.common.jsch"})
public class TestConfig {

    private static final String WEB_DRIVER_CLASS = "webdriver.class";
    private static final String ELEMENT_SEARCH_RENDER_WAIT_TIME = "element.search.render.wait.time";
    private static final String TEST_PROPERTY_PATH = "test.property.path";
    private static final String PARAMETERS_PROPERTIES = "selenium/test.properties";

    public TestConfig() throws SQLException, IOException, ClassNotFoundException {
        // make sure the db is clean before running the tests
        //SeleniumTestHelper.runSqlScript(this.getClass().getClassLoader().getResource("./selenium/cleanup.sql").getPath());
        System.out.println("I am in Testconfig class");
    }

    @Bean(name = "seleniumTestProperties")
    public Properties getProperties() throws IOException {
        return SeleniumTestHelper.getProperties();
    }

    // You need to turn this comment on for using selenium Grid  - also check by searching for selenium grid in SeleniumTestHelper.java file
//    @Bean
//    public RemoteWebDriver getDriver(@Qualifier("seleniumTestProperties") final Properties properties)
//            throws MalformedURLException {
//        final RemoteWebDriver webDriver = SeleniumTestHelper.createWebDriver(System.getProperty(WEB_DRIVER_CLASS));
//        webDriver.manage().timeouts().implicitlyWait(Long.parseLong(properties.getProperty(ELEMENT_SEARCH_RENDER_WAIT_TIME)),
//                TimeUnit.SECONDS);
//        return webDriver;
//    }

    // The following class is required for running the tests in normal browser pop up mode. if you need to run in selenium grid check the previous class
    @Bean
    public WebDriver getDriver(@Qualifier("seleniumTestProperties") final Properties properties) {
        final WebDriver webDriver = SeleniumTestHelper.createWebDriver(System.getProperty(WEB_DRIVER_CLASS));
        webDriver.manage().timeouts().implicitlyWait(Long.parseLong(properties.getProperty(ELEMENT_SEARCH_RENDER_WAIT_TIME)),
                TimeUnit.SECONDS);
        return webDriver;
    }

    @Bean
    public WebDriverWait getWebDriverWait(final WebDriver driver) {
        return new WebDriverWait(driver, 15, 100);
    }

    @Bean(name = "parameterProperties")
    public Properties getParamaterProperties() throws IOException {
        final Properties prop = new Properties();
        final String propertyPath = System.getProperty(TEST_PROPERTY_PATH);
        if (StringUtils.isEmpty(propertyPath)) {
            prop.load(TestConfig.class.getClassLoader().getResourceAsStream(PARAMETERS_PROPERTIES));
        } else {
            prop.load(new FileInputStream(new File(propertyPath)));
        }
        return prop;
    }
}