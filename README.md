# 🚀 DemoQA Automation Testings

![Automation Banner](https://images.unsplash.com/photo-1519389950473-47ba0277781c?auto=format&fit=crop&w=1280&q=80)

---

## 🎯 Proje Hakkında

Bu proje, web uygulamalarının fonksiyonel testlerini **Selenium**, **Gauge** ve **Java** kullanarak otomatikleştirmek amacıyla hazırlanmıştır. Test senaryoları kolayca anlaşılır, sürdürülebilir ve genişletilebilir şekilde tasarlanmıştır.

---

## 🛠️ Teknolojiler ve Araçlar

| Teknoloji         | Versiyon | Açıklama                       |
|-------------------|----------|-------------------------------|
| Java              | 17+      | Programlama dili               |
| Selenium WebDriver | 4.x      | Web otomasyon kütüphanesi      |
| Gauge             | 1.x      | BDD test framework             |
| Maven             | 3.x      | Proje bağımlılık yönetimi      |
| IntelliJ IDEA     | 24       | IDE                           |
| Jackson           | -        | JSON işleme kütüphanesi        |
| JUnit / TestNG    | -        | Test koşucu                   |

---

## 🧩 Proje Yapısı

- /src
- /main/java # Java kaynak kodları
- /test/java # Test sınıfları ve step implementasyonları
- /resources
- /specs # Gauge senaryo dosyaları (.spec, .cpt)
- /value-infos # Test verisi JSON dosyaları
- /element-infos # Locator bilgileri JSON dosyaları



## 🚦 Test Senaryoları

- Kayıt formu doğrulamaları
- Zorunlu alan kontrolleri
- Geçerli ve geçersiz veri girişleri
- Modal doğrulama ve form gönderimi
- Tekrarlayan form doldurma ve sayfa yenileme testleri

---

## ⚙️ Kurulum ve Çalıştırma

1. Projeyi klonlayın:

   ```bash
   git clone https://github.com/username/automation-testing-project.git
   cd automation-testing-project

2. Bağımlılıkları yükleyin:
   ```bash
   mvn clean install

3. Testleri çalıştırın:
   ```bash
   mvn gauge:execute

## 📝 Kullanım

- Test adımları specs/ klasöründe .spec ve .cpt dosyaları olarak yer almaktadır.
- Locator ve test verileri JSON dosyaları ile yönetilmektedir.
- Step implementasyonları Java sınıflarında @Step annotation ile tanımlıdır.

## 📊 Test Raporları
- Testler başarılı veya başarısız durumlarda detaylı HTML raporları reports/ klasöründe oluşturulur.
- Raporlar, test sonuçları, ekran görüntüleri ve logları içerir.



## ❤️ Teşekkürler
Bu projeye katkıda bulunan tüm arkadaşlarıma teşekkür ederim! 🚀