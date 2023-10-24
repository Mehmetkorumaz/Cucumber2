package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class AmazonStepdefinitions {
    AmazonPage amazonPage = new AmazonPage();
    @Given("kullanici amazonUrl anasayfaya gider")
    public void kullanici_amazon_url_anasayfaya_gider() {
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
    }
    @Given("arama kutusuna Nutella yazip aratir")
    public void arama_kutusuna_nutella_yazip_aratir() {amazonPage.aramaKutusu.sendKeys("Nutella" + Keys.ENTER);
    }
    @Then("arama sonuclarinin Nutella icerdigini test eder")
    public void arama_sonuclarinin_nutella_icerdigini_test_eder() {
        String expectedIcerik = "Nutella";
        String actualAramaSonucu = amazonPage.sonucYaziElementi.getText();
        Assert.assertTrue(actualAramaSonucu.contains(expectedIcerik));
    }
    @Then("sayfayi kapatir")
    public void sayfayi_kapatir() {
        Driver.closeDriver();
    }

    @Given("arama kutusuna java yazip aratir")
    public void arama_kutusuna_java_yazip_aratir() {
        amazonPage.aramaKutusu.sendKeys("java" + Keys.ENTER);

    }
    @Then("arama sonuclairni Java icerdigini test eder")
    public void arama_sonuclairni_java_icerdigini_test_eder() {
        String expectedIcerik = "java";
        String actualAramaSonucu = amazonPage.sonucYaziElementi.getText();
        Assert.assertTrue(actualAramaSonucu.contains(expectedIcerik));
    }

    @And("{int} saniye bekler")
    public void saniyeBekler(int saniye) {
        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Given("kullanici {string} anasayfaya gider")
    public void kullaniciAnasayfayaGider(String istenenUrl) {
        Driver.getDriver().get(ConfigReader.getProperty(istenenUrl));
    }

    @Then("arama kutusuna {string} yazip aratir")
    public void aramaKutusunaYazipAratir(String arananUrun) {
        amazonPage.aramaKutusu.sendKeys(arananUrun+Keys.ENTER);

    }

    @And("arama sonuclarinin {string} icerdigini test eder")
    public void aramaSonuclairniIcerdiginiTestEder(String arananUrun) {
        String actualSonucYazisi=amazonPage.sonucYaziElementi.getText();
        Assert.assertTrue(actualSonucYazisi.contains(arananUrun));
    }


    @Then("ilk urunu tiklar")
    public void ilkUrunuTiklar() {
        amazonPage.ilkUrunElementi.click();
    }

    @And("urun isminin {string} icerdigini test eder")
    public void urunIsmininIcerdiginiTestEder(String arananUrun) {
        String actualisimElementi=amazonPage.ilkUrunIsimElementi.getText();

        Assert.assertTrue(actualisimElementi.contains(arananUrun));
    }

    @Then("arama kutusuna Iphone {int} Pro yazip aratir")
    public void aramaKutusunaIphoneProYazipAratir(int arg0) {
        amazonPage.aramaKutusu.sendKeys(ConfigReader.getProperty("amazonAranacakKelime3")+Keys.ENTER);
    }

    @And("arama sonuclarinin sonuc sayisini yadirir")
    public void aramaSonuclarininSonucSayisiniYadirir() {
       String sonucDegeri= amazonPage.sonucYaziElementi.getText();
        System.out.println(sonucDegeri);
    }
    @Then("amazon ana sayfaya gittiginizi test eder")
    public void amazon_ana_sayfaya_gittiginizi_test_eder() {
        String expectedUrl= "https://www.amazon.com/";
        String actualUrl=Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);
    }
    @Then("kulanici “Nutella” aramasi yapar")
    public void kulanici_nutella_aramasi_yapar() {
      amazonPage.aramaKutusu.sendKeys(ConfigReader.getProperty("amazonAranacakKelime")+Keys.ENTER);
    }

    @And("{string} ilk urunu tiklayin ve fiyatinin ${double} oldugunu test edin")
    public void ilkUrunuTiklayinVeFiyatinin$OldugunuTestEdin(String arg0, Double double1) {
        amazonPage.ilkUrunElementi.click();
        String expectedFiyat= "$"+ Double.toString(double1);
        String actualFiyat=amazonPage.fiyat.getText();
        System.out.println(expectedFiyat);
        System.out.println(actualFiyat);
        Assert.assertEquals(expectedFiyat,actualFiyat);
    }
}
