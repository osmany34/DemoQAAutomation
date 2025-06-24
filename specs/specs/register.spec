#Register

Senaryo 1: Kişisel Bilgi Alanları Doğrulaması
---
* Kayıt formu görüntülenir.
* Ad ve soyad alanlarına geçerli karakterlerle giriş yapılır.
* Boş bırakıldığında sistemin uyarı verdiği doğrulanır.
* Sayısal ve özel karakter içeren girdilerin reddedildiği kontrol edilir.

Senaryo 2: E-posta Format Kontrolleri
---
* E-posta alanına geçerli formatta veri girilir ve form gönderilir.
* Geçersiz formatta e-posta girildiğinde sistemin hata mesajı verdiği doğrulanır.
* Boş bırakıldığında sistemin zorunlu alan uyarısı gösterdiği kontrol edilir.

Senaryo 3: Cinsiyet Seçimi
---
* Kullanıcı, cinsiyet seçeneklerinden birini seçer.
* Seçim yapıldığında doğru radio button’ın aktif olduğu doğrulanır.
* Yanlış veri girişleri engellenmeli ve uyarı verilmelidir.

Senaryo 4: Telefon Numarası Alanı Kontrolleri
---
* Kullanıcı, geçerli formatta numara girer ve formu gönderir.
* Harf içeren ve eksik haneli numaraların reddedildiği kontrol edilir.
* Boş bırakıldığında sistemin uyarı gösterdiği doğrulanır.

Senaryo 5: Yaş Doğrulama ve Doğum Tarihi Alanı
---
* Kullanıcı, geçerli tarih değerlerini girer.
* Yaş sınırının altındaki kullanıcılar için sistemin uyarı verdiği doğrulanır.
* Geçmiş tarih seçiminin doğru yansıdığı kontrol edilir.

Senaryo 6: Ders Alanı Geçerliliği
---
* Ders alanına alfabetik giriş yapılır.
* Boş bırakıldığında sistemin hata mesajı gösterdiği doğrulanır.
* Geçersiz karakter girişlerinde (örn: !!!) sistemin uyarı verdiği kontrol edilir.

Senaryo 7: Hobi Seçimi Zorunluluğu
---
* Kullanıcı bir veya birden fazla hobi seçer.
* Hiçbir seçim yapılmadan gönderme işlemi denenir.
* Sistem zorunlu seçim uyarısı verir.

Senaryo 8: Dosya Yükleme Kontrolleri
---
* Geçerli formatta dosya seçilip yüklenir.
* Geçersiz formatta dosya yüklenmeye çalışıldığında hata mesajı doğrulanır.
* Dosya yüklenmeden form gönderildiğinde sistemin uyarı verdiği kontrol edilir.

Senaryo 9: Adres Alanı Doğrulama
---
* Kullanıcı geçerli bir adres bilgisi girer.
* Boş veya anlamsız karakterlerle yapılan girişlerin reddedildiği doğrulanır.

Senaryo 10: İl Seçimi
---
* Kullanıcı listeden il seçimi yapar.
* İl seçilmeden gönderim yapılmaya çalışıldığında sistem uyarı verir.

Senaryo 11: İlçe Seçimi
---
* İlçeler listelenir ve bir ilçe seçilir.
* Seçim yapılmadığında sistem uyarı verir.

Senaryo 12: Başarılı Form Gönderimi
---
* Tüm alanlar eksiksiz ve geçerli şekilde doldurulur.
* Modal başlığının doğru olduğu ve içerikteki bilgilerin form verisiyle eşleştiği doğrulanır.

Senaryo 13: Eksik Form Gönderimi
---
* Hiçbir alan doldurulmadan form gönderilmeye çalışılır.
* Form gönderilemez, zorunlu alanlar sistem tarafından işaretlenir.
* Modalın açılmadığı doğrulanır.

Senaryo 14: Sayfa Yenileme
---
* Sayfa yenilenir.
* Tüm giriş alanlarının sıfırlandığı doğrulanır.
* Form tekrar doldurularak başarıyla gönderildiği kontrol edilir.

Senaryo 15: Art arda Gönderim Testi
---
* Form 3 kez art arda geçerli verilerle doldurulup gönderilir.

Senaryo 16: Modal Tekrar Açma Denemesi
---
* Modal kapatıldıktan sonra dış müdahale ile tekrar açılmaya çalışılır.


