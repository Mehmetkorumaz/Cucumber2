Feature:
  @sss
    Scenario:
    Given kullanici "facebookUrl" anasayfaya gider
    Then Faker class’ini kullanarak email ve sifre degerlerini yazdirip, giris butonuna basin
     And Basarili giris yapilamadigini test edin
    And sayfayi kapatir