package edu.praktikum.sprint4.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class MainPage {
    private final WebDriver webDriver;
    JavascriptExecutor js;

    String expectedTextInFirstQuestion = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
    String expectedTextInSecondQuestion = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
    String expectedTextInThirdQuestion = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
    String expectedTextInFourthQuestion = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
    String expectedTextInFifthQuestion = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
    String expectedTextInSixthQuestion = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
    String expectedTextInSeventhQuestion = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
    String expectedTextInEighthQuestion = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";


    //Проверка вопросов о важном
    private final By firstQuestion = By.xpath(".//div[@class='accordion__item'][1]");
    private final By secondQuestion = By.xpath(".//div[@class='accordion__item'][2]");
    private final By thirdQuestion = By.xpath(".//div[@class='accordion__item'][3]");
    private final By fourthQuestion = By.xpath(".//div[@class='accordion__item'][4]");
    private final By fifthQuestion = By.xpath(".//div[@class='accordion__item'][5]");
    private final By sixthQuestion = By.xpath(".//div[@class='accordion__item'][6]");
    private final By seventhQuestion = By.xpath(".//div[@class='accordion__item'][7]");
    private final By eighthQuestion = By.xpath(".//div[@class='accordion__item'][8]");


    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        js = (JavascriptExecutor) webDriver;
    }

    //1 тест
    public void clickFirstQuestion() {
        js.executeScript("arguments[0].scrollIntoView(true);", webDriver.findElement(firstQuestion));
        webDriver.findElement(firstQuestion).click();
    }

    public void checkTextInFirstQuestionInDropdownList() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@id='accordion__panel-0']")));
        WebElement element = webDriver.findElement(By.xpath(".//div[@id='accordion__panel-0']"));
        assertEquals("Сообщение 1 не совпадает", expectedTextInFirstQuestion, element.getText());
    }

    //Тест 2
    public void clickSecondQuestion() {
        js.executeScript("arguments[0].scrollIntoView(true);", webDriver.findElement(secondQuestion));
        webDriver.findElement(secondQuestion).click();
    }

    public void checkTextInSecondQuestionInDropdownList() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@id='accordion__panel-1']")));
        WebElement element = webDriver.findElement(By.xpath(".//div[@id='accordion__panel-1']"));
        assertEquals("Сообщение 2 не совпадает", expectedTextInSecondQuestion, element.getText());
    }

    //Тест 3
    public void clickThirdQuestion() {
        js.executeScript("arguments[0].scrollIntoView(true);", webDriver.findElement(thirdQuestion));
        webDriver.findElement(thirdQuestion).click();
    }

    public void checkTextInThirdQuestionInDropdownList() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@id='accordion__panel-2']")));
        WebElement element = webDriver.findElement(By.xpath(".//div[@id='accordion__panel-2']"));
        assertEquals("Сообщение 3 не совпадает", expectedTextInThirdQuestion, element.getText());
    }

    //Тест 4
    public void clickFourthQuestion() {
        js.executeScript("arguments[0].scrollIntoView(true);", webDriver.findElement(fourthQuestion));
        webDriver.findElement(fourthQuestion).click();
    }

    public void checkTextInFourthQuestionInDropdownList() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@id='accordion__panel-3']")));
        WebElement element = webDriver.findElement(By.xpath(".//div[@id='accordion__panel-3']"));
        assertEquals("Сообщение 4 не совпадает", expectedTextInFourthQuestion, element.getText());
    }
    //Тест 5
    public void clickFifthQuestion() {
        js.executeScript("arguments[0].scrollIntoView(true);", webDriver.findElement(fifthQuestion));
        webDriver.findElement(fifthQuestion).click();
    }

    public void checkTextInFifthQuestionInDropdownList() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@id='accordion__panel-4']")));
        WebElement element = webDriver.findElement(By.xpath(".//div[@id='accordion__panel-4']"));
        assertEquals("Сообщение 5 не совпадает", expectedTextInFifthQuestion, element.getText());
    }
    //Тест 6
    public void clickSixthQuestion() {
        js.executeScript("arguments[0].scrollIntoView(true);", webDriver.findElement(sixthQuestion));
        webDriver.findElement(sixthQuestion).click();
    }

    public void checkTextInSixthQuestionInDropdownList() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@id='accordion__panel-5']")));
        WebElement element = webDriver.findElement(By.xpath(".//div[@id='accordion__panel-5']"));
        assertEquals("Сообщение 6 не совпадает", expectedTextInSixthQuestion, element.getText());
    }
    //Тест 7
    public void clickSeventhQuestion() {
        js.executeScript("arguments[0].scrollIntoView(true);", webDriver.findElement(seventhQuestion));
        webDriver.findElement(seventhQuestion).click();
    }

    public void checkTextInSeventhQuestionInDropdownList() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@id='accordion__panel-6']")));
        WebElement element = webDriver.findElement(By.xpath(".//div[@id='accordion__panel-6']"));
        assertEquals("Сообщение 7 не совпадает", expectedTextInSeventhQuestion, element.getText());
    }
    //Тест 8
    public void clickEighthQuestion() {
        js.executeScript("arguments[0].scrollIntoView(true);", webDriver.findElement(eighthQuestion));
        webDriver.findElement(eighthQuestion).click();
    }

    public void checkTextInEighthQuestionInDropdownList() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@id='accordion__panel-7']")));
        WebElement element = webDriver.findElement(By.xpath(".//div[@id='accordion__panel-7']"));
        assertEquals("Сообщение 8 не совпадает", expectedTextInEighthQuestion, element.getText());
    }

}
