package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.GooglePage;
import utilities.Driver;

public class GoogleStepDefinitions {
    GooglePage googlePage=new GooglePage();

    @And("cookies kabul eder")
    public void cookiesKabulEder() {
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        googlePage.cookiesKabulButonu.click();
    }
    @Then("googlede {string} icin arama yapar")
    public void googlede_icin_arama_yapar(String istenenKelime) {

        googlePage.googleSearchBox.click();
        googlePage.googleSearchBox.sendKeys(istenenKelime + Keys.ENTER);
    }
    @Then("arama sonuclarinin {string} icerdigini tes edin")
    public void arama_sonuclarinin_icerdigini_tes_edin(String istenenKelime) {
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertTrue(actualTitle.contains(istenenKelime));

    }


}
