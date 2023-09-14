package tests;

import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import jdk.jfr.Description;
import models.Suite;
import org.testng.Assert;
import org.testng.annotations.*;
import utils.TestDataGenerator;

public class CreateNewSuiteTest extends BaseTest {
    @BeforeMethod(alwaysRun = true)
    public void logIn() {
        loginPage.openPage()
                .isPageOpened()
                .logIn(EMAIL, PASSWORD);
    }

    @Test(groups = {"regression"})
    @Description("Create new suite")
    @Link(name = "Create suite page")
    @Severity(SeverityLevel.CRITICAL)
    public void createNewSuiteTest() {
        Suite suite = TestDataGenerator.addSuiteGeneration();
        projectsPage.isPageOpened();
        projectsPage.clickOnProjectTitle(PROJECT_TITLE);
        createSuitePage.clickCreateSuiteButton();
        createSuitePage.fillingOutSuiteForm(suite);
        createSuitePage.clickCreateNewSuiteButton();
        Assert.assertTrue(createSuitePage.getSuccessfullyCreatedSuiteMessageIsDisplayed());
        Assert.assertTrue(createSuitePage.isSuiteExistAndDisplayed(TestDataGenerator.addSuiteGeneration().getSuiteTitle()));
    }

    @Test(groups = {"regression"})
    @Description("Edit suite")
    @Link(name = "Create suite page")
    @Severity(SeverityLevel.CRITICAL)
    public void editSuiteTest() {
        Suite suite = TestDataGenerator.addSuiteGeneration();
        projectsPage.isPageOpened();
        projectsPage.clickOnProjectTitle(PROJECT_TITLE);
        createSuitePage.clickCreateSuiteButton();
        createSuitePage.fillingOutSuiteForm(suite);
        createSuitePage.clickCreateNewSuiteButton();
        createSuitePage.clickEditSuiteButtonIcon();
        createSuitePage.fillingOutSuiteForm(suite);
        createSuitePage.clickSaveChangesSuiteButton();
        Assert.assertTrue(createSuitePage.editedTitleIsDisplayed());
    }

    @Test(groups = {"regression"})
    @Description("Delete suite")
    @Link(name = "Create suite page")
    @Severity(SeverityLevel.CRITICAL)
    public void deleteSuiteTest() {
        projectsPage.isPageOpened();
        projectsPage.clickOnProjectTitle(PROJECT_TITLE);
        createSuitePage.clickDeleteSuiteButtonIcon();
        createSuitePage.clickDeleteSuiteButton();
        Assert.assertTrue(createSuitePage.successfullyDeletedMessageTextIsDisplayed());
        Assert.assertTrue(createSuitePage.isSuiteExistAndDisplayed(TestDataGenerator.addSuiteGeneration().getSuiteTitle()));
    }
}