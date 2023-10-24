Feature: AutomationExercise Sitesi login olma testi
  Scenario: TC001 AE pozitif login olma testi
    Given kullanici automatUrl anasayfaya gider
    Then kullanici login linkine tiklar
    And  dogru Email ve Password u girer
    And dogru giris yapildigini test eder
    And sayfayi kapatir