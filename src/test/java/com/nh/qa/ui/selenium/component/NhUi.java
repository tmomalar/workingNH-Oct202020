package com.nh.qa.ui.selenium.component;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;
import java.util.List;
import java.util.Properties;
import java.util.Set;
//My additions for chromeoptions on May 3 2020


/**
 * Wrapper component that simplifies the calling of Selenium driver commands
 * <p>
 * @Author mprakash on 12/17/2019.
 */
@Component
public class NhUi {

    @Autowired
    private WebDriver driver;

    @Autowired
    private WebDriverWait webDriverWait;

    @Autowired
    @Qualifier("seleniumTestProperties")
    private Properties properties;

    public void clickTab(final String tabLabel) {
//        final By by = By.xpath("//li[a[text()='" + tabLabel + "']]");
        final By by = By.linkText(tabLabel);
        if (!driver.findElement(by).getAttribute("class").equalsIgnoreCase("current")) {
            clickWhenReady(by);
            webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("AppBusyScreen")));
        }
    }

    /**
     * Wait until element is clickable before clicking
     *
     * @param by {@link By}
     */
    public void clickWhenReady(final By by) {
        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".AppBusyScreen")));
        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#pageContent > img")));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(by)).click();
    }

    public void performwhenReady(final By by) {
//        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".AppBusyScreen")));

        WebElement element = driver.findElement(by);
        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#pageContent > img")));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by));

        Point p = element.getLocation();

        Actions actions = new Actions(driver);

        actions.moveToElement(element).moveByOffset(p.x, p.y).click().perform();
        //webDriverWait.until(ExpectedConditions.elementToBeClickable(by)).click();
    }

    /**
     * Waits until the element is clickable
     *
     * @param by
     * @param timeout
     */
    public void clickWhenReady(final By by, final long timeout) {
        new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(by));
    }

    /**
     * Expand a node, do nothing if it is already expanded
     *
     * @param nodeLabel the node label
     */
    public void expandNode(final String nodeLabel) {
        final By by = By.xpath("//li[span[text()='" + nodeLabel + "']]/img[@src='public-resources/img/icons/plus.png']");
        if (isElementExists(by)) {
            driver.findElement(by).click();
        }
    }


    public void clickNode(final String nodeLabel) {
        clickWhenReady(By.xpath("//li[span[text()='" + nodeLabel + "']]/span"));
    }

    @Deprecated
    public WebElement clickTreeItemExpandCollapseIcon(final String itemLabel) {
        final WebElement webElement =
                driver.findElement(By.xpath("//li[span[text()='" + itemLabel + "']]/img[contains(@class, 'expand-collapse-padding')]"));
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(webElement));
        webElement.click();
        return webElement;
    }

    @Deprecated
    public WebElement clickTreeItemExpandCollapseIcon(final WebElement parentNode, final String itemLabel) {
        final WebElement webElement =
                parentNode.findElement(By.xpath("//li[span[text()='" + itemLabel + "']]/img[contains(@class, 'expand-collapse-padding')]"));
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(webElement));
        webElement.click();
        return webElement;
    }

    public String getBaseUrl() {
        return properties.getProperty("base.url");
    }

    public void rightClick(final By by) {
        final Actions action = new Actions(driver).contextClick(driver.findElement(by));
        action.build().perform();
    }

    public boolean isElementExists(final By by) {
        try {
            driver.findElement(by);
        } catch (final NoSuchElementException e) {
            return false;
        }
        return true;
    }

    // Manick Added in october 22
//    public boolean isElementNotExists(final By by, String searchFor) {
//        try {
//            Assert.assertNull(driver.findElement(by));
//        } catch (final NoSuchElementException e) {
//            return false;
//        }
//        return true;
//    }
    public boolean isElementNotExists(String searchingFor) {
        try {
            WebElement element = driver.findElement(By.xpath(".//*[contains(text(), searchingFor)]"));
//            Assert.assertNull(driver.findElement(By.xpath(".//*[contains(text(), searchingFor)]")));
            Assert.assertNull(element);
        } catch (final NoSuchElementException e) {
            return false;
        }
        return true;
    }

    /**
     * Check if an element exists
     *
     * @param by      locates the element
     * @param timeout timeout in seconds
     * @return true if element exists
     */
    public boolean isElementExists(final By by, final long timeout) {
        try {
            waitUntilElementIsVisible(by, timeout);
        } catch (final TimeoutException e) {
            return false;
        }
        return true;
    }

    public void sendKeys(final CharSequence val) {
        driver.switchTo().activeElement().sendKeys(val);
    }

    public void sendKeysAndClick(final By by, final CharSequence val) {
        driver.findElement(by).sendKeys(val);
        driver.findElement(by).sendKeys(Keys.ENTER);
    }

    public void sendKeys(final By by, final CharSequence val) {
        driver.findElement(by).sendKeys(val);
    }


    public void click(final By by) {
        driver.findElement(by).click();
    }

    public void mouseHover(final By by) {
        Actions action = new Actions(driver);
        WebElement menuOption = driver.findElement(by);
        action.moveToElement(menuOption).click().build().perform();
    }

    public void selectFromDropDown(final By by, String str) {
        Select dropdown = new Select(driver.findElement(by));
        dropdown.selectByVisibleText(str);
//        Actions action = new Actions(driver);
//        WebElement menuOption = driver.findElement(by);
//        action.moveToElement(menuOption).click().build().perform();
    }
//public void dropdown(By by) {
//        click(by);
//    Select dropdown = new Select(driver.findElement(by));
//    //click(by);
//    dropdown.selectByIndex(1);
////        Actions action = new Actions(driver);
////        WebElement menuOption = driver.findElement(by);
////        action.moveToElement(menuOption).click().build().perform();
//}

    public void dropdown(By by) {
        driver.findElement(by).click();
        //driver.findElement(by).click();
        //Select dropdown = new Select(driver.findElement(by));
        //click(by);
        //dropdown.selectByIndex(1);
//        Actions action = new Actions(driver);
//        WebElement menuOption = driver.findElement(by);
//        action.moveToElement(menuOption).click().build().perform();
    }

    public void dropdown1(By by, By by2) {
        Actions actions = new Actions(driver);
        driver.findElement(by).click();
        actions.moveToElement(driver.findElement(by2)).click().build().perform();

        //driver.findElement(By.linkText(str)).click();
    }

    // manick added on aug 21 2020
    public void dropdown1modified() {
        WebElement countryUL = driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_PatientEligibility1_ddlPayers_DropDown\"]/div/ul"));
        List<WebElement> countriesList = countryUL.findElements(By.tagName("li"));
        for (WebElement li : countriesList)
            if (li.getText().equals("mp-payer")) {
                li.click();
            }
    }

    // manick added on aug 21 2020
    public void dropdownfromlist(By by, String str) {
        WebElement dropDownElementsUL = driver.findElement(by);
        List<WebElement> dropDownList = dropDownElementsUL.findElements(By.tagName("li"));
        for (WebElement li : dropDownList)
            if (li.getText().equals(str)) {
                li.click();
            }
    }

    public void dropdown2(By by, String str) {
        WebElement payerUL = driver.findElement(by);
        payerUL.click();
        List<WebElement> countriesList = payerUL.findElements(By.tagName("li"));
        for (WebElement li : countriesList) {
            if (li.getText().equals(str)) {
                li.click();
            }
        }
    }

    public void dropdown3old(By by, By by2) {
        WebElement payerUL = driver.findElement(by);
        waitUntilElementIsVisible(by);
        payerUL.click();
        waitUntilElementIsVisible(by2);
        //waitUntilElementIsVisible(by2, 5);
        payerUL.findElement(by2).click();
        //driver.findElement(by2).click();
    }

    public void dropdown3(By by, By by2) {
        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#pageContent > img")));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(by)).click();

        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#pageContent > img")));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by2));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(by2)).click();
    }


    public void mouseHoverNoClick(final By by) {
        Actions action = new Actions(driver);
        WebElement menuOption = driver.findElement(by);
        action.moveToElement(menuOption).perform();
    }

    public void waitUntilElementIsVisible(final By by) {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public boolean isCheckBoxChecked(final By by) {
        return driver.findElement(by).isSelected();
    }


    /**
     * Wait until an element is visible
     *
     * @param by      {@link By}
     * @param timeout timeout in seconds
     */
    public void waitUntilElementIsVisible(final By by, final long timeout) {
        new WebDriverWait(driver, timeout).until(ExpectedConditions.numberOfElementsToBe(by, 1));
    }

    /**
     * Wait until an element is no longer visible
     *
     * @param by      {@link By}
     * @param timeout timeout in seconds
     */
    public void waitUntilElementIsNotVisible(final By by, final long timeout) {
        new WebDriverWait(driver, timeout).until(ExpectedConditions.numberOfElementsToBe(by, 0));
    }

    public void waitForElementToClick(final By by) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", driver.findElement(by));
    }

    public void loadPath(final String path) {
        driver.get(getBaseUrl() + path);
    }

    public Properties getProperties() {
        return properties;
    }

    /**
     * Web driver waits until an element or several elements (as indicated by the numberOfElements parameter)
     * located by the "by" parameter is/are existing
     *
     * @param by               element locator
     * @param numberOfElements the number of elements to satisfy the "to be" condition
     */
    public void waitUntilNumberOfElementsToBe(final By by, final int numberOfElements) {
        webDriverWait.until(ExpectedConditions.numberOfElementsToBe(by, 1));
    }

    public void selectItem(final By by, final String itemName) {
        final Select select = new Select(driver.findElement(by));
        select.selectByVisibleText(itemName);
    }

    public void selectItemByIdAndValue(final By by, final String itemId) {
        final Select select = new Select(driver.findElement(by));
        select.selectByValue(itemId);
    }

    public void clickComponentForUpload(String component) {
        final WebElement webElement =
                driver.findElement(By.xpath("//li[span[text()='" + component + "']]/span"));
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(webElement));
        webElement.click();
    }

    public void clickAddResource() {
        final WebElement webElement =
                driver.findElement(By.xpath("//span[contains(@class, 'ui-icon-plusthick')]"));
        new WebDriverWait(driver, 100).until(ExpectedConditions.visibilityOf(webElement));
        webElement.click();
    }

    /**
     * This method is used to freeze a step to see what's going on and is not meant to be used in the finished test
     * steps!!!
     */
    public void sleep() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void sleep5() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void sleep3() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void sleep2() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void sleep(int timeInmsecs) {
        try {
            Thread.sleep(timeInmsecs);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public WebDriver getWebDriver() {
        return driver;
    }

    @PreDestroy
    public void destroy() {
        driver.close();
        driver.quit();
    }

    public WebElement getWebElement(By by) {
        return driver.findElement(by);
    }

    /**
     * Go to another browser tab/window
     *
     * @param currentTabHandle the current browser tab/winow handle
     */
    public void switchToOtherTab(final String currentTabHandle) {
        final Set<String> windowHandles = driver.getWindowHandles();
        for (final String windowHandle : windowHandles) {
            if (!windowHandle.equals(currentTabHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }

    /**
     * Looks for an element
     *
     * @param by describes the element to look for
     * @return the underlying web element
     * throws NoSuchElementException if element was not found
     */
    public WebElement find(final By by) {
        return driver.findElement(by);
    }

    public void verifyLogout() {
        //driver.findElement(By.className("loginView"));
        waitUntilElementIsVisible(By.className("LoginView"));
    }

    public void clickBackButton() {
        driver.navigate().back();
    }

    public void refreshPage() {
        driver.navigate().refresh();
    }

    public void clear(By by) {
        driver.findElement(by).clear();
    }

    /**
     * Looks for an element
     *
     * @param by1, by2, by3 describes the element to look for
     *             str is the string that will be verified in the web page
     */

    public void mouseHoverItems(By by1, By by2, By by3, String str) {
        mouseHover(by1);
        sleep();
        mouseHover(by2);
        sleep();
        mouseHover(by3);
        sleep();
        waitUntilElementIsVisible(By.xpath("//*[contains(text(), str)]"));
    }

    public void mouseHoverItems(By by1, By by2, By by3, By by4, String str) {
        mouseHover(by1);
        sleep();
        mouseHover(by2);
        sleep();
        mouseHover(by3);
        sleep();
        mouseHover(by4);
        sleep();
        waitUntilElementIsVisible(By.xpath("//*[contains(text(), str)]"));
    }

    public void mouseHoverItems(By by1, By by2, String str) {
        mouseHover(by1);
        sleep();
        mouseHover(by2);
        sleep();
        waitUntilElementIsVisible(By.xpath("//*[contains(text(), str)]"));
    }

    public void mouseHoverItemsNoClick(By by1, By by2) {
        mouseHoverNoClick(by1);
        sleep();
        //click(by2);
        mouseHoverNoClick(by2);
        sleep();
    }

    public void mouseHoverItems(By by1, By by2) {
        mouseHoverNoClick(by1);
        sleep();
        mouseHover(by2);
        sleep();
    }

    public void mouseHoverItem(By by1, By by2, By by3) {
        mouseHover(by1);
        sleep();
        mouseHover(by2);
        sleep();
        mouseHover(by3);
        sleep();
    }

//    public boolean isTextPresent(String text) {
//        try {
//            boolean b = driver.getPageSource().contains(text);
//            return b;
//        } catch (Exception e) {
//            final boolean b = false;
//            return b;
//        }
//    }
//    public boolean isTextPresent(String text) throws Exception {
//        boolean b = driver.getPageSource().contains(text);
//        sleep(3);
//        if (!b){
//            throw new Exception();
//        }
//        return true;
//    }
public boolean isTextPresent(String text){
//        waitUntilElementIsVisible(By.xpath(".//*[contains(text(), text)]"));
    boolean b = driver.getPageSource().contains(text);
//    sleep(3);
    return b;
}

//    public boolean isTextNotPresent(String text){
////        waitUntilElementIsVisible(By.xpath(".//*[contains(text(), text)]"));
//        boolean b = driver.getPageSource().contains(text);
////    sleep(3);
//        return b;
//    }

//    public void isTextNotPresent(String text) throws Exception {
////        boolean b = driver.getPageSource().contains(text);
//        System.out.println("value of the text not present:" + text);
//        waitUntilElementIsNotVisible(By.xpath(".//*[contains(text(), text)]"), 5);
//        sleep(3);
//    }
public void isTextNotPresent(String text){
//        boolean b = driver.getPageSource().contains(text);

    System.out.println("value of the text not present:" + text);
    waitUntilElementIsNotVisible(By.xpath(".//*[contains(text(), text)]"), 5);
//    sleep(3);
//    int element = driver.findElements(By.xpath(".//*[contains(text(), text)]")).size();
//    System.out.println("value of the element:" + element);
//    return element;
}

    public int waitFindingElements(final By by){
//        new WebDriverWait(driver, timeout).until(ExpectedConditions.numberOfElementsToBe(by, 0));
//        new WebDriver(driver.findElements(by));
        int element = driver.findElements(by).size();
        return element;
    }

}