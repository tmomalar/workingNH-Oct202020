Feature: Autoimmune

# Scenario: User logs in using different user accounts

#     Given I load predefined user accounts
#     Then I use those accounts to login successfully and unsuccessfully

@smoke @regression @testrun
Scenario: User is in the Main Page
    Given I am on the AutoImmune Home Page

@smoke @regression
Scenario: User is in the Management Page Disease Management
    Given I click Management Tab and select Disease Management
    When I am in Management Home Page

@smoke @regression
Scenario: User is in the Management Page Line of Treatment Management
    Given I click Management Tab and select Line of Treatment Management
    When I am in Management Home Page

@smoke @regression
Scenario: User is in the Management Page SubDisease Management
    Given I click Management Tab and select SubDisease Management
    When I am in Management Home Page

@smoke @regression @testrun
Scenario: User searches based on AutoImmuneDisease
    When I am in Management Home Page
    Given I add Autoimmune Disease
    And I click on Search Button
    Then I get a list of search results

@smoke @regression
Scenario: User is opening the Searched Autoimmune Disease items
    Then I click on properties button
    Then I select View Template
    Then I click on Template Information
    Then I click on Diseases
    Then I click on Justifications
#    Then I click on Supportive Groups
#    Then I click on Sources

@smoke @regression
Scenario: User is in the Management Page and adds Drugs, Disease, LOT and Provider
    Given I am in Management Home Page
    Then I add drugs to Drug Name Field
    Then I add Rheumatoid arthritis to Disease Field
    Then I add FirstLineOfTreatment
#    Then I add WellPoint Central as Entity
    Then I click on Search Button
    When I am in Management Home Page

@regression
Scenario: User is adding NewDisease in Disease Management Page
    Given I click Management Tab and select Disease Management
    Then I click on Add New Button
#    Then I click on "Add New"
    Then I add DiseaseTest
    Then I edit SCTID
    Then I select clinical condition as Autoimmune Disease
    Then I add Activation Date and Termination Date
    Then I click on Save button
#    Then I click on DiseaseTest
#    Then I click on "Save"
#    Then I refresh the Page
    Then I click on DiseaseTest

@regression
Scenario: User is in the Management Page Disease Management Page editing new Disease
    Given I click on edit button
#    Given I click on "Edit"
    Then I edit Name as DiseaseTestEdited
    Then I edit SCTID
    Then I select clinical condition as Autoimmune Disease
    Then I change the Termination Date further by five days
    Then I click on Save button
#    Then I click on "Save"
#    Then I refresh the Page
    Then I click on the DiseaseTestEdited

@regression
Scenario: I clear the DiseaseTestEdited
    Given I click on the DiseaseTestEdited
#    Given I click on "DiseaseTestEdited"
    Then I click on edit button
#    Then I click on "Edit"
    Then I change the Activation Date and Termination date by minus ten days
    Then I click on Save button
#    Then I refresh the Page
    And I am not seeing DiseaseTestEdited

@regression
Scenario: User is in the Management Page SubDisease Management to Save new item
    Given I click Management Tab and select SubDisease Management
    Then I click on Add New Button
    Then I add SubDiseaseTest
    Then I edit SCTID
    Then I edit Parent Disease
#    Then I add Sub Disease Data
    Then I add Activation Date and Termination Date
    Then I click on Save button
#    Then I click Back Button to go back to home page
    Then I click on the SubDiseaseTest

@regression
Scenario: User is in the Management Page SubDisease Management and edits Saved item
    Given I click on the SubDiseaseTest
    Given I click on edit button
    Then I edit Name
    Then I edit SCTID
    Then I edit Parent Disease
    Then I change the Termination Date further by five days
    Then I click on Save button
    Then I click on the SubDiseaseTestEdited
#    Then I refresh the Page

#@regression
#Scenario: User clears the SubDisease Created
#    When I click on SubDisease
#    Then I click on edit button
#    Then I change the Activation Date and Termination date by minus ten days
#    Then I click on Save button

@regression
Scenario: User clears the SubDisease that was Edited
    When I click on the SubDiseaseTestEdited
    Then I click on edit button
    Then I change the Activation Date and Termination date by minus ten days
    Then I click on Save button

@regression
Scenario: User is adding NewLOT in Line of Treatment Management Page
    Given I click Management Tab and select Line of Treatment Management
    Then I click on Add New Button
    Then I add LOTTest
    Then I edit SCTID
    Then I select clinical condition as Autoimmune Disease
    Then I add Activation Date and Termination Date
    Then I click on Save button
#    Then I refresh the Page
    Then I click on LOTTest

@regression
Scenario: User is in the Management Page Line of Treatment Page editing new LOT
    Given I click on edit button
    Then I edit Name as LOTTestEdited
    Then I edit SCTID
    Then I select clinical condition as Autoimmune Disease
    Then I change the Termination Date further by five days
    Then I click on Save button
#    Then I refresh the Page

#@regression @testrun
#Scenario: I clear the LOTTest
#    Given I click on the LOTTest
#    Then I click on edit button
#    Then I change the Activation Date and Termination date by minus ten days
#    Then I click on Save button
##    And I verify myvalue 'hghjghj' it is cleared
##     And I am on Home Page of "ksdjflksdaf"
##      And I am in verify step
##      And I am in verify "somevalue"
##      And I am in find elements
#      And I am not seeing LOTTest

@regression
Scenario: I clear the LOTTestEdited
    Given I click on the LOTTestEdited
    Then I click on edit button
    Then I change the Activation Date and Termination date by minus ten days
    Then I click on Save button
    Then I refresh the Page
    And I am not seeing LOTTestEdited

    # Then I exit the page
#     When I click on login tab
#     When I fill in the username field
#     And I fill in the password field
#     And I click the login button
#     Then I am logged in
#     Then I click on logout

# Scenario: User copies and paste password
#     Given I am on the login page
#     When I click on login tab
#     When I fill in the username field
#     And I fill in password by copying password string
#     Then I click on cancel button
#     Then I click on login tab
#     When I fill in the username field
#     And I fill in the password field
#     And I click the login button
#     Then I am logged in
#     Then I click on logout

# Scenario: User clicks back button after logging out

#     Given I am on the login page
#     When I click on login tab
#     When I fill in the username field
#     And I fill in the password field
#     And I click the login button
#     Then I am logged in
#     Then I click on logout
#     # Then I click on back button on the browser
#     # Then I click on Template Management Tab
#     # Then I click on cancel button