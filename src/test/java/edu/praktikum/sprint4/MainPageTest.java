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
import org.openqa.selenium.chrome.ChromeDriver;
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
                {MainPage.firstQuestion, MainPage.firstAnswer, EXPECTED_TEXT_IN_FIRST_QUESTION},
                {MainPage.secondQuestion, MainPage.secondAnswer, EXPECTED_TEXT_IN_SECOND_QUESTION},
                {MainPage.thirdQuestion, MainPage.thirdAnswer, EXPECTED_TEXT_IN_THIRD_QUESTION},
                {MainPage.fourthQuestion, MainPage.fourthAnswer, EXPECTED_TEXT_IN_FOURTH_QUESTION},
                {MainPage.fifthQuestion, MainPage.fifthAnswer, EXPECTED_TEXT_IN_FIFTH_QUESTION},
                {MainPage.sixthQuestion, MainPage.sixthAnswer, EXPECTED_TEXT_IN_SIXTH_QUESTION},
                {MainPage.seventhQuestion, MainPage.seventhAnswer, EXPECTED_TEXT_IN_SEVENTH_QUESTION},
                {MainPage.eighthQuestion, MainPage.eighthAnswer, EXPECTED_TEXT_IN_EIGHTH_QUESTION}
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
                        .visibilityOfElementLocated(OrderPage.cookieButton));
        webDriver.findElement(OrderPage.cookieButton).click();
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
