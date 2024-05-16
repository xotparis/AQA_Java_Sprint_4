package edu.praktikum.sprint4;


import static edu.praktikum.sprint4.CONSTANTS.ConstantsMainPage.*;
import static edu.praktikum.sprint4.CONSTANTS.ConstantsMainPage.URL;
import edu.praktikum.sprint4.pom.MainPage;

import edu.praktikum.sprint4.pom.OrderPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
public class MainPageTest {

    private WebDriver webDriver;
    private final By question;
    private final By textInQuestion;
    private final String expectedTextInQuestion;


    public MainPageTest(By question, By textInQuestion, String expectedTextInQuestion) {
        this.question = question;
        this.textInQuestion = textInQuestion;
        this.expectedTextInQuestion = expectedTextInQuestion;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][] {
                {MainPage.FIRST_QUESTION, MainPage.FIRST_ANSWER, EXPECTED_TEXT_IN_FIRST_QUESTION},
                {MainPage.SECOND_QUESTION, MainPage.SECOND_ANSWER, EXPECTED_TEXT_IN_SECOND_QUESTION},
                {MainPage.THIRD_QUESTION, MainPage.THIRD_ANSWER, EXPECTED_TEXT_IN_THIRD_QUESTION},
                {MainPage.FOURTH_QUESTION, MainPage.FOURTH_ANSWER, EXPECTED_TEXT_IN_FOURTH_QUESTION},
                {MainPage.FIFTH_QUESTION, MainPage.FIFTH_ANSWER, EXPECTED_TEXT_IN_FIFTH_QUESTION},
                {MainPage.SIXTH_QUESTION, MainPage.SIXTH_ANSWER, EXPECTED_TEXT_IN_SIXTH_QUESTION},
                {MainPage.SEVENTH_QUESTION, MainPage.SEVENTH_ANSWER, EXPECTED_TEXT_IN_SEVENTH_QUESTION},
                {MainPage.EIGHTH_QUESTION, MainPage.EIGHTH_ANSWER, EXPECTED_TEXT_IN_EIGHTH_QUESTION}
        };
    }

    @Before
    public void setup() {
        //Запуск через Firefox
        FirefoxOptions options = new FirefoxOptions();
        webDriver = new FirefoxDriver(options);

        //Запуск через chrome
        //webDriver = new ChromeDriver();

        webDriver.get(URL);
        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions
                        .visibilityOfElementLocated(OrderPage.COOKIE_BUTTON));
        webDriver.findElement(OrderPage.COOKIE_BUTTON).click();
        webDriver.manage().timeouts().implicitlyWait(Duration.of(10, SECONDS));

    }

    @Test
    public void questionsAboutImportantThings() {

        MainPage homePage = new MainPage(webDriver);
        homePage.clickOnQuestion(question);
        homePage.checkTextInQuestion(textInQuestion, expectedTextInQuestion);

    }

    @After
    public void tearDown() {
        webDriver.quit();
    }
}
