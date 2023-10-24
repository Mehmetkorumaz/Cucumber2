package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import pages.AutomationExercisePage;
import utilities.ConfigReader;
import utilities.Driver;

public class AutomationExerciseStepdefinitions {
    AutomationExercisePage automationExercisePage=new AutomationExercisePage();
    @Given("kullanici automatUrl anasayfaya gider")
    public void kullaniciAutomatUrlAnasayfayaGider() {
        Driver.getDriver().get(ConfigReader.getProperty("automatUrl"));
    }

    @Then("kullanici login linkine tiklar")
    public void kullaniciLoginLinkineTiklar() {

        automationExercisePage.loginButtonu.click();
    }

    @And("dogru Email ve Password u girer")
    public void dogruEmailVePasswordUGirer() {
        automationExercisePage.eMail.sendKeys(ConfigReader.getProperty("aeUsername"));
        automationExercisePage.password.sendKeys(ConfigReader.getProperty("aePassword"));
        automationExercisePage.login2.click();
    }

    @And("dogru giris yapildigini test eder")
    public void dogruGirisYapildiginiTestEder() {
        String expectedVerif="Logged";


    }
}
