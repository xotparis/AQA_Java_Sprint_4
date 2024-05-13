package edu.praktikum.sprint4;

import edu.praktikum.sprint4.pom.MainPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;
import static java.time.temporal.ChronoUnit.SECONDS;

public class MainPageTest {

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
    public void questionsAboutImportantThings() {
        MainPage mainPage = new MainPage(webDriver);
        //Проверка 1 вопроса
        mainPage.clickFirstQuestion();
        mainPage.checkTextInFirstQuestionInDropdownList();
        //Проверка 2 вопроса
        mainPage.clickSecondQuestion();
        mainPage.checkTextInSecondQuestionInDropdownList();
        //Проверка 3 вопроса
        mainPage.clickThirdQuestion();
        mainPage.checkTextInThirdQuestionInDropdownList();
        //Проверка 4 вопроса
        mainPage.clickFourthQuestion();
        mainPage.checkTextInFourthQuestionInDropdownList();
        //Проверка 5 вопроса
        mainPage.clickFifthQuestion();
        mainPage.checkTextInFifthQuestionInDropdownList();
        //Проверка 6 вопроса
        mainPage.clickSixthQuestion();
        mainPage.checkTextInSixthQuestionInDropdownList();
        //Проверка 7 вопроса
        mainPage.clickSeventhQuestion();
        mainPage.checkTextInSeventhQuestionInDropdownList();
        //Проверка 8 вопроса
        mainPage.clickEighthQuestion();
        mainPage.checkTextInEighthQuestionInDropdownList();


    }

    @After
    public void tearDown() {
        webDriver.quit();
    }
}
