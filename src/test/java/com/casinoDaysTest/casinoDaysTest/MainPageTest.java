package com.casinoDaysTest.casinoDaysTest;

import com.codeborne.selenide.Configuration;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.chrome.ChromeOptions;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;

import java.util.Objects;
import java.util.Random;

import static com.codeborne.selenide.Condition.*;
import static org.junit.jupiter.api.Assertions.*;

import static com.codeborne.selenide.Selenide.*;

@Slf4j
public class MainPageTest {
    MainPage mainPage = new MainPage();

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1440x1092";
        Configuration.fastSetValue = false;
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void setUp() {
        // Fix the issue https://github.com/SeleniumHQ/selenium/issues/11750
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
        open("https://casinodays.com/en/");
    }

    @Test
    public void shouldRegisterWithValidCredentials() {
        Random random = new Random();


        assertNotNull(mainPage.signUpButton);

        mainPage.signUpButton.click();

        assertNotNull(mainPage.signUpModal);

        mainPage.signUpModal.shouldBe(visible);

//        assertEquals(4, mainPage.stepOneInputs.size());

        mainPage.registerModalInputs.forEach(Assertions::assertNotNull);

        mainPage.registerModalInputs.forEach(input -> {
            switch (Objects.requireNonNull(input.getAttribute("type"))) {
                case "text" -> input.setValue("Test");
                case "email" -> input.setValue("test@test" + random.nextInt() + ".com");
                case "password" -> input.setValue("Test@1234");
            }
        });

        mainPage.selectCountry.click();
        mainPage.selectListBox.click();

        mainPage.registerModalSubmitBtn.click();

        mainPage.birthDayField.click();
        mainPage.selectListBox.click();

        mainPage.birthMonthField.click();
        mainPage.selectListBox.click();

        mainPage.birthYearField.click();
        mainPage.selectListBox.click();

        mainPage.genderSelectButton.click();
        mainPage.selectListBox.click();

        mainPage.registerModalInputs.forEach(input -> {
            switch (Objects.requireNonNull(input.getAttribute("type"))) {
                case "text" -> input.setValue("Test");
                case "tel" -> input.setValue(String.valueOf(random.nextInt(10000000, 99999999)));
            }
        });

        mainPage.registerModalSubmitBtn.click();

    }

}
