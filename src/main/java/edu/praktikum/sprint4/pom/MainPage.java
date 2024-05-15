package edu.praktikum.sprint4.pom;

import static edu.praktikum.sprint4.CONSTANTS.ConstantsMainPage.*;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {


    //Проверка вопросов о важном
    public static By firstQuestion = By.xpath(".//div[@class='accordion__item'][1]");
    public static By secondQuestion = By.xpath(".//div[@class='accordion__item'][2]");
    public static By thirdQuestion = By.xpath(".//div[@class='accordion__item'][3]");
    public static By fourthQuestion = By.xpath(".//div[@class='accordion__item'][4]");
    public static By fifthQuestion = By.xpath(".//div[@class='accordion__item'][5]");
    public static By sixthQuestion = By.xpath(".//div[@class='accordion__item'][6]");
    public static By seventhQuestion = By.xpath(".//div[@class='accordion__item'][7]");
    public static By eighthQuestion = By.xpath(".//div[@class='accordion__item'][8]");

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

    public OrderPage clickOnOrderButton(By orderButton) {
        new WebDriverWait(webDriver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOfElementLocated(orderButton));
        webDriver.findElement(orderButton).click();
        return new OrderPage(webDriver);
    }
}
