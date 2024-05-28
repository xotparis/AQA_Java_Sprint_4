package edu.praktikum.sprint4.pom;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {


    //Проверка вопросов о важном
    public static final By FIRST_QUESTION = By.xpath(".//div[@class='accordion__item'][1]");
    public static final By SECOND_QUESTION = By.xpath(".//div[@class='accordion__item'][2]");
    public static final By THIRD_QUESTION = By.xpath(".//div[@class='accordion__item'][3]");
    public static final By FOURTH_QUESTION = By.xpath(".//div[@class='accordion__item'][4]");
    public static final By FIFTH_QUESTION = By.xpath(".//div[@class='accordion__item'][5]");
    public static final By SIXTH_QUESTION = By.xpath(".//div[@class='accordion__item'][6]");
    public static final By SEVENTH_QUESTION = By.xpath(".//div[@class='accordion__item'][7]");
    public static final By EIGHTH_QUESTION = By.xpath(".//div[@class='accordion__item'][8]");

    public static final By FIRST_ANSWER = By.xpath("//*[@id='accordion__panel-0']");
    public static final By SECOND_ANSWER = By.xpath("//*[@id='accordion__panel-1']");
    public static final By THIRD_ANSWER = By.xpath("//*[@id='accordion__panel-2']");
    public static final By FOURTH_ANSWER = By.xpath("//*[@id='accordion__panel-3']");
    public static final By FIFTH_ANSWER = By.xpath("//*[@id='accordion__panel-4']");
    public static final By SIXTH_ANSWER = By.xpath("//*[@id='accordion__panel-5']");
    public static final By SEVENTH_ANSWER = By.xpath("//*[@id='accordion__panel-6']");
    public static final By EIGHTH_ANSWER = By.xpath("//*[@id='accordion__panel-7']");

    private final WebDriver webDriver;
    JavascriptExecutor js;

    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        js = (JavascriptExecutor) webDriver;
    }

    public void clickOnQuestion(By question) {
        js.executeScript("arguments[0].scrollIntoView(true);", webDriver.findElement(question));
        webDriver.findElement(question).click();
    }

    public void checkTextInQuestion(By textInQuestion, String text) {
        new WebDriverWait(webDriver, Duration.ofSeconds(3))
                .until(ExpectedConditions
                        .visibilityOfElementLocated(textInQuestion));
        MatcherAssert.assertThat(webDriver.findElement(textInQuestion).getText(), CoreMatchers.is(text));
    }

}
