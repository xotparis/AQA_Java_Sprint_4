package edu.praktikum.sprint4.pom;

import edu.praktikum.sprint4.utils.RandomValuesForOrder;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.Assert.assertEquals;


public class OrderPage {

    private final WebDriver webDriver;
    //Первая вкладка заказа
    private final By orderButton = By.xpath(".//div[@style='transform: translateY(0px);']//button[text()='Заказать']");
    private final By firstNameForOrderInput = By.xpath(".//input[@placeholder='* Имя']");
    private final By surnameForOrderInput = By.xpath(".//input[@placeholder='* Фамилия']");
    private final By addressForOrderInput = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    private final By metroForOrderInput = By.xpath(".//input[@placeholder='* Станция метро']");
    private final By metroForOrderChoice = By.xpath(".//button/div[text()='Сокольники']");
    private final By phoneForOrderInput = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    private final By nextButton = By.xpath(".//button[text()='Далее']");
    //Вторая вкладка заказа
    private final By dataForOrderInput = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    private final By amountOfDaysForOrderInput = By.xpath(".//div[text()='* Срок аренды']");
    private final By amountOfDaysForOrderChoice = By.xpath(".//div[text()='сутки']");
    private final By colourForOrderChoice = By.xpath(".//input[@id='black']");
    private final By orderButtonForOrder = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    private final By confirmationForOrder = By.xpath(".//button[text()='Да']");

    //Проверка выполнения заказа
    String expectedOrder = "Посмотреть статус";
    private final By actualOrder = By.xpath(".//button[contains(text(),'Посмотреть статус')]");

    public OrderPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    //2 тест, первая вкладка
    public void clickOrderButton() {
        webDriver.findElement(orderButton).click();
    }

    public void inputFirstNameForOrderInput() {
        webDriver.findElement(firstNameForOrderInput).sendKeys(RandomValuesForOrder.randomFirstNames());
    }

    public void inputSurnameForOrderInput() {
        webDriver.findElement(surnameForOrderInput).sendKeys(RandomValuesForOrder.randomSurname());
    }

    public void inputAddressForOrderInput(String textAddress) {
        webDriver.findElement(addressForOrderInput).sendKeys(textAddress);
    }

    public void clickMetroForOrderInput() {
        webDriver.findElement(metroForOrderInput).click();
    }

    public void clickMetroForOrderChoice() {
        webDriver.findElement(metroForOrderChoice).click();
    }

    public void inputPhoneForOrderInput() {
        webDriver.findElement(phoneForOrderInput).sendKeys("+7" + RandomValuesForOrder.phoneNumber());
    }

    public void clickNextButton() {
        webDriver.findElement(nextButton).click();
    }

    //2 тест, вторая вкладка
    public void enterDataForOrderInput() {
        //webDriver.findElement(dataForOrderInput).click();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String date = LocalDate.now().plusDays(1).format(formatter);
        webDriver.findElement(dataForOrderInput).sendKeys(date);
        webDriver.findElement(dataForOrderInput).sendKeys(Keys.ENTER);
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
        webDriver.findElement(orderButtonForOrder).click();
    }

    public void clickConfirmationForOrder() {
        webDriver.findElement(confirmationForOrder).click();
    }

    public void assertEqualsExpectedOrder() {
        WebElement element = webDriver.findElement(actualOrder);
        assertEquals("Элемент не найден или не отображается", expectedOrder, element.getText());
    }

}
