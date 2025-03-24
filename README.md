## Özellikler
- Java kullanılarak yazılmıştır.
- Selenium ile Trendyol web otomasyon testi.
- TestNG entegrasyonu ile test yönetimi.
- TestRail Raporlama desteği.
- Jenkins sürekli entegrasyon süreci.
- Commons Email ile hata alınan sayfaların ekran görüntülerini e-posta ile gönderme.

## Gereksinimler
Projeyi çalıştırabilmek için aşağıdaki araçlara ihtiyacınız var:
- Java 17
- Maven 3.6+
- IDE (IntelliJ IDEA, Eclipse vb.)

### Maven Kurulumu
1. Maven indirin.
2. Dosyaları açın ve sistem değişkenlerine MAVEN_HOME ekleyin.
3. PATH değişkenine MAVEN_HOME/bin yolunu ekleyin.
4. Maven'ın doğru kurulduğunu kontrol etmek için terminale şu komutu yazın:
    ```bash
    mvn -version

## Nasıl Çalıştırılır?
1. Projeyi klonlayın:
    ```bash
    git clone https://github.com/eneskaynakk/trendyol-test-automation.git
    cd projeadi
    
2. Maven bağımlılıklarını yükleyin:
    ```bash
    mvn clean install
    
3. Testleri çalıştırın:
    ```bash
    mvn test
    
## Config Dosyası
Test çalıştırmadan önce aşağıdaki adımları takip edin:  
1. resources klasörünün altında qa.properties adında dosya oluşturun.
2. Dosyanın içerisine aşağıdaki değişkenlerin değerlerini kendi değerlerinize göre uyarlayın:
   ```bash
    url = https://www.trendyol.com/
    browser = chrome

    email = trendyol_email
    password = trendyol_password

    testRailEmail = email
    testRailPassword = password
    testRailEngineUrl = url

    your_email = your_email
    send_email = send_email
    app_passwords = app_passwords
