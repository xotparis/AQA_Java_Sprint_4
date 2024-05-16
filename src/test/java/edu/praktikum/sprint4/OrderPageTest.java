package edu.praktikum.sprint4;

import static edu.praktikum.sprint4.CONSTANTS.ConstantsMainPage.URL;
import edu.praktikum.sprint4.utils.RandomValuesForOrder;
import edu.praktikum.sprint4.pom.OrderPage;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import static java.time.temporal.ChronoUnit.SECONDS;


@RunWith(Parameterized.class)
public class OrderPageTest {

    private WebDriver webDriver;
    private final String name;
    private final String surname;
    private final String address;
    private final String phone;

    private final By orderButton;
    private final String dateOfOrder;

    public OrderPageTest(String name, String surname, String address, String phone, By orderButton, String dateOfOrder) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phone = phone;
        this.orderButton = orderButton;
        this.dateOfOrder = dateOfOrder;
    }

    @Parameterized.Parameters
    public static Object[][] getOrder() {
        return new Object[][] {
                {RandomValuesForOrder.randomFirstNames(), RandomValuesForOrder.randomSurname(), "Сахарова 9", RandomValuesForOrder.phoneNumber(), OrderPage.ORDER_BUTTON_TOP, OrderPage.nextDayDate()},
                {RandomValuesForOrder.randomFirstNames(), RandomValuesForOrder.randomSurname(), "Пушкина 109", RandomValuesForOrder.phoneNumber(), OrderPage.ORDER_BUTTON_BOTTOM, OrderPage.nextDayDate()},
        };
    }

    @Before
    public void setup() {
        //Запуск через Firefox
        FirefoxOptions options = new FirefoxOptions();
        webDriver = new FirefoxDriver(options);

        //Запуск через chrome
//        webDriver = new ChromeDriver();

        webDriver.manage().timeouts().implicitlyWait(Duration.of(10, SECONDS));
        webDriver.get(URL);
        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions
                        .visibilityOfElementLocated(OrderPage.COOKIE_BUTTON));
        webDriver.findElement(OrderPage.COOKIE_BUTTON).click();
    }

    @Test
    public void orderSuccessful() {
        OrderPage orderPage = new OrderPage(webDriver);

        orderPage.clickOrderButton(orderButton);

        //Переход на первую вкладку заказа
        orderPage.setData(name, surname, address, phone);
        orderPage.setMetroField();
        orderPage.clickNextButton();

        //Переход на вторую страницу заказа
        orderPage.enterDataForOrderInput(dateOfOrder);
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
