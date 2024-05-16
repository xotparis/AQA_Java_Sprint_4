package edu.praktikum.sprint4.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;

import static java.time.temporal.ChronoUnit.SECONDS;
import static org.junit.Assert.assertEquals;


public class OrderPage {

    private final WebDriver webDriver;
    //Кнопки заказать
    public static final By orderButtonTop = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    public static final By orderButtonBottom = By.xpath(".//button[@class='Button_Button__ra12g']");
    //Принять куки
    public static final By cookieButton = By.xpath("//*[@id='rcc-confirm-button']");
    //Первая вкладка заказа
    private final By firstNameForOrderInput = By.xpath(".//input[@placeholder='* Имя']");
    private final By surnameForOrderInput = By.xpath(".//input[@placeholder='* Фамилия']");
    private final By addressForOrderInput = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    private final By metroForOrderInput = By.xpath(".//input[@placeholder='* Станция метро']");
    private final By metroForOrderChoice = By.xpath(".//button/div[text()='Сокольники']");
    private final By phoneForOrderInput = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    private static final By NEXT_BUTTON = By.xpath(".//button[text()='Далее']");
    //Вторая вкладка заказа
    private final By dataForOrderInput = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    private final By amountOfDaysForOrderInput = By.xpath(".//div[text()='* Срок аренды']");
    private final By amountOfDaysForOrderChoice = By.xpath(".//div[text()='сутки']");
    private final By colourForOrderChoice = By.xpath(".//input[@id='black']");
    //Подтверждение заказа
    private final By confirmationForOrder = By.xpath(".//button[text()='Да']");
    //Проверка выполнения заказа
    String expectedOrder = "Посмотреть статус";
    private final By actualOrder = By.xpath(".//button[contains(text(),'Посмотреть статус')]");

    public OrderPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void clickOrderButton(By locator) {
        webDriver.findElement(locator).click();
    }

    public void setFieldValue(By fieldLocator, String text) {
        new WebDriverWait(webDriver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(fieldLocator));
        webDriver.findElement(fieldLocator).sendKeys(text);
    }

    public void setData(String name, String surname, String address, String phone) {
        setFieldValue(firstNameForOrderInput, name);
        setFieldValue(surnameForOrderInput, surname);
        setFieldValue(addressForOrderInput, address);
        setFieldValue(phoneForOrderInput, phone);
        setMetroField();
    }

    public void setMetroField() {
        new WebDriverWait(webDriver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(metroForOrderInput));
        webDriver.findElement(metroForOrderInput).click();
        new WebDriverWait(webDriver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(metroForOrderChoice));
        webDriver.findElement(metroForOrderChoice).click();
    }

    //2 тест, первая вкладка

    public void clickNextButton() {
        webDriver.findElement(NEXT_BUTTON).click();
    }

    //2 тест, вторая вкладка
    public void enterDataForOrderInput(String date) {
        webDriver.findElement(dataForOrderInput).sendKeys(date);
        webDriver.findElement(dataForOrderInput).sendKeys(Keys.ENTER);
    }

    public static String nextDayDate() {

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        String tomorrowDate = sdf.format(calendar.getTime());

        return tomorrowDate;
    }

    public void clickAmountOfDaysForOrderInput() {
        webDriver.findElement(amountOfDaysForOrderInput).click();
    }

    public void clickAmountOfDaysForOrderChoice() {
        webDriver.findElement(amountOfDaysForOrderChoice).click();
    }

    public void clickColourForOrderChoice() {
        webDriver.findElement(colourForOrderChoice).click();
    }

    public void clickOrderButtonForOrder() {
        webDriver.findElement(orderButtonTop).click();
    }

    public void clickConfirmationForOrder() {
        webDriver.findElement(confirmationForOrder).click();
    }

    public void assertEqualsExpectedOrder() {
        WebElement element = webDriver.findElement(actualOrder);
        assertEquals("Элемент не найден или не отображается", expectedOrder, element.getText());
    }

}
