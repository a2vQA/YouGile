package com.yougile.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class DownloadPage {

    private final SelenideElement startWebVersion = $(byTagAndText("a", "Запустить"));
    @Step("Нажать кнопку 'Запустить' у Web-версии")
    public <T> T clickWebStartBtn(Class<T> page){
        startWebVersion.shouldBe(visible).click();

        return page(page);
    }
}
