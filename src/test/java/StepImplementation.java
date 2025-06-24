import com.thoughtworks.gauge.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.time.Duration;
import java.time.Month;
import java.util.Map;

public class StepImplementation {

    private static Map<String, Map<String, String>> elements;
    private static Map<String, String> values;

    static {
        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream valueStream = StepImplementation.class.getClassLoader().getResourceAsStream("value-infos/values.json");
            InputStream elementStream = StepImplementation.class.getClassLoader().getResourceAsStream("element-infos/elements.json");
            values = mapper.readValue(valueStream, Map.class);
            elements = mapper.readValue(elementStream, Map.class);
        } catch (Exception e) {
            throw new RuntimeException("JSON dosyaları okunamadı", e);
        }
    }

    private By getLocator(String key) {
        Map<String, String> locatorData = elements.get(key);
        String type = locatorData.get("type");
        String value = locatorData.get("value");

        return switch (type.toLowerCase()) {
            case "id" -> By.id(value);
            case "xpath" -> By.xpath(value);
            case "class" -> By.className(value);
            case "css" -> By.cssSelector(value);
            default -> throw new IllegalArgumentException("Desteklenmeyen locator türü: " + type);
        };
    }

    private WebElement find(String key) {
        return DriverFactory.driver.findElement(getLocator(key));
    }

    private void wait(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @Step("<key> input alan var mı?")
    public void isInputFieldPresent(String key) {
        assert find(key).isDisplayed();
    }

    @Step("<seconds> sn bekle")
    public void waitSeconds(int seconds) {
        wait(seconds);
    }

    @Step("<key> input alanına <value> yaz")
    public void inputText(String key, String value) {
        WebElement element = find(key);
        element.clear();
        element.sendKeys(value);
    }

    @Step("<key> alanı boş bırak")
    public void leaveInputBlank(String key) {
        WebElement element = find(key);
        element.clear();
    }

    @Step("<key> elemente tıkla")
    public void clickElement(String key) {
        find(key).click();
    }

    @Step("<key> element var mı?")
    public void isElementVisible(String key) {
        assert find(key).isDisplayed();
    }

    @Step("Doğum tarihi <date> gir")
    public void enterBirthDate(String date) {
        WebElement input = find("birthDateInput");
        input.click();

        String[] parts = date.split(" ");
        String day = parts[0];
        String monthName = parts[1];
        String year = parts[2];

        Select yearSelect = new Select(find("yearSelect"));
        yearSelect.selectByVisibleText(year);

        Select monthSelect = new Select(find("monthSelect"));
        int monthIndex = Month.valueOf(monthName.toUpperCase()).getValue() - 1;
        monthSelect.selectByIndex(monthIndex);

        String dayXpath = "//div[contains(@class, 'react-datepicker__day') and not(contains(@class, 'outside-month')) and text()='" + day + "']";
        WebElement dayElement = new WebDriverWait(DriverFactory.driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(dayXpath)));
        dayElement.click();
    }

    @Step("Cinsiyeti <gender> seç")
    public void selectGender(String gender) {
        find(gender).click();
    }

    @Step("Cinsiyet seçiminin \"<gender>\" olduğunu doğrula")
    public void verifyGenderSelection(String gender) {
        assert find(gender).isSelected();
    }

    @Step("Hobbies alanında <hobbie> seç")
    public void selectHobby(String hobbie) {
        WebElement checkbox = find(hobbie);
        if (!checkbox.isSelected()) {
            checkbox.click();
        }
    }

    @Step("Picture alanında Dosya Seç butonuna tıkla ve <picture> görselini yükle")
    public void uploadPicture(String picture) {
        WebElement fileInput = find("uploadPicture");
        String fullPath = System.getProperty("user.dir") + "/resources/uploads/" + picture;
        fileInput.sendKeys(fullPath);
    }

    @Step("State and City alanında Select State'den <state> değerini seç")
    public void selectState(String state) {
        clickElement("stateDropdown");
        WebElement option = new WebDriverWait(DriverFactory.driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='" + state + "']")));
        option.click();
    }

    @Step("State and City alanında Select City'den <city> değerini seç")
    public void selectCity(String city) {
        clickElement("cityDropdown");
        WebElement option = new WebDriverWait(DriverFactory.driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='" + city + "']")));
        option.click();
    }

    @Step("Formu gönder")
    public void submitForm() {
        clickElement("submit");
    }

    @Step("Modal başlığı <expected> olmalı")
    public void verifyModalTitle(String expected) {
        String actual = find("modalTitle").getText();
        assert actual.equals(expected);
    }

    @Step("Modal <key> alanı <expectedValue> içermeli")
    public void modalShouldContain(String key, String expectedValue) {
        String text = find("modalTable").getText();
        assert text.contains(key);
        assert text.contains(expectedValue);
    }

    @Step("Sayfayı yenile")
    public void refresh() {
        DriverFactory.driver.navigate().refresh();
        wait(1);
    }

    @Step("Tüm alanları doldur ve gönder")
    public void fillAllAndSubmit() {
        inputText("firstName", values.get("Data_ad"));
        inputText("lastName", values.get("Data_soyad"));
        inputText("email", values.get("Data_email"));
        inputText("mobile", values.get("Data_telefon"));
        enterBirthDate(values.get("Data_dogum"));
        inputText("subjectInput", values.get("Data_ders"));
        clickElement("subjectConfirm");
        selectGender("genderMale");
        selectHobby("hobbyReading");
        uploadPicture(values.get("Data_dosya"));
        inputText("address", values.get("Data_adres"));
        selectState(values.get("Data_sehir"));
        selectCity(values.get("Data_ilce"));
        clickElement("submit");
    }

    @Step("Form tüm geçerli verilerle tekrar doldur")
    public void fillFormAgain() {
        fillAllAndSubmit();
    }

    @Step("Formu 3 kez doldur ve gönder")
    public void fillAndSubmitThreeTimes() {
        for (int i = 0; i < 3; i++) {
            fillAllAndSubmit();
            wait(1);
            clickElement("closeModal");
            wait(1);
        }
    }

    @Step("Modal penceresinin açıldığını doğrula")
    public void verifyModalIsVisible() {
        assert find("modalTitle").isDisplayed();
    }

    @Step("Modal penceresinin açılmadığını doğrula")
    public void verifyModalIsNotVisible() {
        boolean notVisible = DriverFactory.driver.findElements(getLocator("modalTitle")).isEmpty();
        assert notVisible;
    }

    @Step("Modal içeriğinde girilen verileri doğrula")
    public void verifyModalContent() {
        String modalText = find("modalTable").getText();
        assert modalText.contains(values.get("Data_ad"));
        assert modalText.contains(values.get("Data_soyad"));
        assert modalText.contains(values.get("Data_email"));
        assert modalText.contains(values.get("Data_telefon"));
        assert modalText.contains(values.get("Data_ders"));
        assert modalText.contains(values.get("Data_adres"));
    }

    @Step("First Name'e <name> değerini gir")
    public void enterFirstName(String name) {
        inputText("firstName", name);
    }

    @Step("Last Name'e <surname> değerini gir")
    public void enterLastName(String surname) {
        inputText("lastName", surname);
    }

    @Step("Email'e <email> değerini gir")
    public void enterEmail(String email) {
        inputText("email", email);
    }

    @Step("Mobile'a <mobile> değerini gir")
    public void enterMobile(String mobile) {
        inputText("mobile", mobile);
    }

    @Step("Current Address alanına \"<address>\" değerini gir")
    public void enterAddress(String address) {
        inputText("address", address);
    }

    @Step("<url> URL'ini aç")
    public void openUrl(String url) {
        DriverFactory.driver.get(url);
    }
    @Step("Date of Birth alanındaki kutucuğa tıkla")
    public void clickDateInput() {
        clickElement("birthDateInput");
    }

    @Step("Tarihi \"<date>\" seç")
    public void selectDate(String date) {
        enterBirthDate(date);
    }


    @Step("Subjects alanındaki kutucuğa tıkla")
    public void clickSubjects() {
        clickElement("subjectInput");
    }

    @Step("\"<subject>\" değerini gir ve Enter'a basarak seç")
    public void enterSubjectAndConfirm(String subject) {
        WebElement input = find("subjectInput");
        input.sendKeys(subject);
        input.sendKeys(Keys.ENTER);
    }

}
