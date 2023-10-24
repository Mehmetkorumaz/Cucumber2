Feature:
  @wap
  Scenario:
    Given kullanici amazonUrl anasayfaya gider
    Then amazon ana sayfaya gittiginizi test eder
    And  kulanici “Nutella” aramasi yapar
    And  arama sonuclarinin Nutella icerdigini test eder
    And  "Nutella" ilk urunu tiklayin ve fiyatinin $15.62 oldugunu test edin
    And sayfayi kapatir