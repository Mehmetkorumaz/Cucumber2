package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.FacebookPage;
import utilities.ReusableMethods;

public class FacebookStepdefinitions {
    FacebookPage facebookPage=new FacebookPage();
    @Then("Faker class’ini kullanarak email ve sifre degerlerini yazdirip, giris butonuna basin")
    public void fakerClassIniKullanarakEmailVeSifreDegerleriniYazdiripGirisButonunaBasin() {
        ReusableMethods.bekle(1);
        facebookPage.cookiesKabulButonu.click();
        Faker faker=new Faker();

        facebookPage.emailKutusu.sendKeys(faker.internet().emailAddress());
        facebookPage.passwordKutusu.sendKeys(faker.internet().password());
        facebookPage.loginButonu.click();

    }

    @And("Basarili giris yapilamadigini test edin")
    public void basariliGirisYapilamadiginiTestEdin() {
        Assert.assertTrue(facebookPage.girisYapilamadiYaziElementi.isDisplayed());

    }
}
