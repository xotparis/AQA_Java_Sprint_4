package edu.praktikum.sprint4;

import edu.praktikum.sprint4.pom.MainPage;
import edu.praktikum.sprint4.pom.OrderPage;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

import static java.time.temporal.ChronoUnit.SECONDS;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class OrderPageTest {

    private WebDriver webDriver;

    @Before
    public void setup() {
        //Запуск через Firefox
        System.setProperty("webdriver.gecko.driver","/Users/ilyarua/geckodriver-mac-arm64/geckodriver");
        FirefoxOptions options = new FirefoxOptions();
        webDriver = new FirefoxDriver(options);

        //Запуск через chrome
        //webDriver = new ChromeDriver();

        webDriver.manage().timeouts().implicitlyWait(Duration.of(3, SECONDS));
        webDriver.get("https://qa-scooter.praktikum-services.ru/");
    }

    @Test
    public void orderSuccessful() {
        OrderPage orderPage = new OrderPage(webDriver);

        orderPage.clickOrderButton();

        //Переход на первую вкладку заказа
        orderPage.inputFirstNameForOrderInput();
        orderPage.inputSurnameForOrderInput();
        orderPage.inputAddressForOrderInput("Сахарова");
        orderPage.clickMetroForOrderInput();
        orderPage.clickMetroForOrderChoice();
        orderPage.inputPhoneForOrderInput();
        orderPage.clickNextButton();

        //Переход на вторую страницу заказа
        orderPage.enterDataForOrderInput();
        orderPage.clickAmountOfDaysForOrderInput();
        orderPage.clickAmountOfDaysForOrderChoice();
        orderPage.clickColourForOrderChoice();
        orderPage.clickOrderButtonForOrder();

        //Подтверждение заказа
        orderPage.clickConfirmationForOrder();

        //Проверка, что заказ совершен
        orderPage.assertEqualsExpectedOrder();

    }


    @After
    public void tearDown() {
        webDriver.quit();
    }
}
