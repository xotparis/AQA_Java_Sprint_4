package edu.praktikum.sprint4.pom;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.Instant;

public class MainPage {


    //Проверка вопросов о важном
    public static final By firstQuestion = By.xpath(".//div[@class='accordion__item'][1]");
    public static final By secondQuestion = By.xpath(".//div[@class='accordion__item'][2]");
    public static final By thirdQuestion = By.xpath(".//div[@class='accordion__item'][3]");
    public static final By fourthQuestion = By.xpath(".//div[@class='accordion__item'][4]");
    public static final By fifthQuestion = By.xpath(".//div[@class='accordion__item'][5]");
    public static final By sixthQuestion = By.xpath(".//div[@class='accordion__item'][6]");
    public static final By seventhQuestion = By.xpath(".//div[@class='accordion__item'][7]");
    public static final By eighthQuestion = By.xpath(".//div[@class='accordion__item'][8]");

    public static final By firstAnswer = By.xpath("//*[@id='accordion__panel-0']");
    public static final By secondAnswer = By.xpath("//*[@id='accordion__panel-1']");
    public static final By thirdAnswer = By.xpath("//*[@id='accordion__panel-2']");
    public static final By fourthAnswer = By.xpath("//*[@id='accordion__panel-3']");
    public static final By fifthAnswer = By.xpath("//*[@id='accordion__panel-4']");
    public static final By sixthAnswer = By.xpath("//*[@id='accordion__panel-5']");
    public static final By seventhAnswer = By.xpath("//*[@id='accordion__panel-6']");
    public static final By eighthAnswer = By.xpath("//*[@id='accordion__panel-7']");

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
