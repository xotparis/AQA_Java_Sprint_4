package edu.praktikum.sprint4;


import static edu.praktikum.sprint4.CONSTANTS.ConstantsMainPage.*;
import static edu.praktikum.sprint4.CONSTANTS.ConstantsMainPage.URL;
import edu.praktikum.sprint4.pom.MainPage;

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
                {MainPage.firstQuestion, By.xpath("//*[@id='accordion__panel-0']"), EXPECTED_TEXT_IN_FIRST_QUESTION},
                {MainPage.secondQuestion, By.xpath("//*[@id='accordion__panel-1']"), EXPECTED_TEXT_IN_SECOND_QUESTION},
                {MainPage.thirdQuestion, By.xpath("//*[@id='accordion__panel-2']"), EXPECTED_TEXT_IN_THIRD_QUESTION},
                {MainPage.fourthQuestion, By.xpath("//*[@id='accordion__panel-3']"), EXPECTED_TEXT_IN_FOURTH_QUESTION},
                {MainPage.fifthQuestion, By.xpath("//*[@id='accordion__panel-4']"), EXPECTED_TEXT_IN_FIFTH_QUESTION},
                {MainPage.sixthQuestion, By.xpath("//*[@id='accordion__panel-5']"), EXPECTED_TEXT_IN_SIXTH_QUESTION},
                {MainPage.seventhQuestion, By.xpath("//*[@id='accordion__panel-6']"), EXPECTED_TEXT_IN_SEVENTH_QUESTION},
                {MainPage.eighthQuestion, By.xpath("//*[@id='accordion__panel-7']"), EXPECTED_TEXT_IN_EIGHTH_QUESTION}
        };
    }

    @Before
    public void setup() {
        //Запуск через Firefox
//        FirefoxOptions options = new FirefoxOptions();
//        webDriver = new FirefoxDriver(options);

        //Запуск через chrome
        webDriver = new ChromeDriver();

        webDriver.manage().timeouts().implicitlyWait(Duration.of(10, SECONDS));
        webDriver.get(URL);
        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions
                        .visibilityOfElementLocated(By
                                .xpath("//*[@id=\"rcc-confirm-button\"]")));
        webDriver.findElement(By.xpath("//*[@id=\"rcc-confirm-button\"]")).click();

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
