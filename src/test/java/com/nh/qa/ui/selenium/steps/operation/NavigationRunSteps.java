package com.nh.qa.ui.selenium.steps.operation;

import com.nh.qa.ui.selenium.TestConfig;
import com.nh.qa.ui.selenium.component.NhUi;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

/**
 * @project examplecucumberjvmdependencyinjection
 * @Author mprakash on 12/19/2019.
 */

//@ContextConfiguration(classes = TestConfig.class)
public class NavigationRunSteps {
    @Autowired
    private NhUi nhUi;

    @Given("I am in Management Pages tab")
    public void iAmInManagementPagesTab() {
        nhUi.clickTab("Management Pages");}

    @Given("I am in Template Management tab")
    public void iAmInTemplateManagementTab() {
        nhUi.clickTab("Template Management");
    }

    @Given("I am Drug Replacement Management tab")
    public void iAmDrugReplacementManagementTab() {
        nhUi.clickTab("Drug Replacement Management");
    }

    @Given("I am in Report tab")
    public void iAmInReportTab() {
        nhUi.clickTab("Report");
    }

    @Given("I am in Workflow Management tab")
    public void iAmInWorkflowManagementTab() {
        nhUi.clickTab("Workflow Management");
    }

    @Given("I am in Omics Management tab")
    public void iAmInOmicsManagementTab() {
        nhUi.clickTab("Omics Management");
    }

    @Given("I am in Create New tab")
    public void iAmInCreateNewTab() {
        nhUi.clickTab("Create New");
    }
}
