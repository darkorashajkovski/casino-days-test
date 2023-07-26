package com.casinoDaysTest.casinoDaysTest;

import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;

// page_url = https://www.jetbrains.com/
public class MainPage {

    private final String registerModal = "//div[contains(@class, 'register-modal')]";

    public SelenideElement signUpButton = $(".signUpButton");

    public SelenideElement signUpModal = $x(registerModal);

    public List<SelenideElement> registerModalInputs = $$x(registerModal +
            "//input[@type='text' or @type='email' or @type='password' or @type='tel']");

    public SelenideElement selectCountry = $x(registerModal + "//div[@id='mui-component-select-country']");

    public SelenideElement selectListBox = $x("//ul[@role='listbox']" +
            "//li[@data-value='AQ' or @data-value='7' or @data-value='1994' or @data-value='M']");

    public SelenideElement birthDayField = $x(registerModal + "//div[@id='mui-component-select-bDay']");
    public SelenideElement birthMonthField = $x(registerModal + "//div[@id='mui-component-select-bMonth']");
    public SelenideElement birthYearField = $x(registerModal + "//div[@id='mui-component-select-bYear']");

    public SelenideElement registerModalSubmitBtn = $x(registerModal + "//button[contains(@class, 'submit-btn')]");

    public SelenideElement genderSelectButton = $x(registerModal + "//div[@id='mui-component-select-gender']");

    public SelenideElement dashboardContainer = $x("//body//div[contains(@class, 'dashboardContainer')]");
}
