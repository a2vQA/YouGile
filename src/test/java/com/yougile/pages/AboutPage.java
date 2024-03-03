package com.yougile.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class AboutPage {

    private final SelenideElement content = $x("//h1[text()='О компании']/following-sibling::h4[text()='YouGile — российский сервис для управления проектами.']"),
            registrySection = $("#section-registry"),
            companyInfoBlock = $("#section-registry [class='d-flex justify-content-center']");

    @Step("Открыть страницу 'О нас'")
    public <T> T openContactPage(Class<T> page){
        open("/about");

        content.shouldBe(visible);

        return page(page);
    }

    @Step("Секция информации о компании имеет данные {0}")
    public AboutPage checkDataInInfoBlock(String value){
        registrySection.shouldBe(visible).scrollIntoView(true);
        companyInfoBlock.shouldHave(text(value));

        return this;
    }
}
