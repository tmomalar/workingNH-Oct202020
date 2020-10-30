package com.nh.qa.ui.selenium;

/**
 * @project examplecucumberjvmdependencyinjection
 * @Author mprakash on 12/17/2019.
 */
public class SeleniumTestCaseException extends RuntimeException {

    private static final String FAILURE_TO_SETUP_SELENIUM_DRIVERS = "Failure to setup Selenium drivers!";

    public SeleniumTestCaseException(final Throwable e) {
        super(FAILURE_TO_SETUP_SELENIUM_DRIVERS, e);
    }

    public SeleniumTestCaseException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public SeleniumTestCaseException(String message) {
        super(message);
    }

}
