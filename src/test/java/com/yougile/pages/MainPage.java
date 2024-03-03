package com.yougile.pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class MainPage {

    private final SelenideElement content = $("sections"),
            desktopApp = $("img[alt='get-via-desktop']");


    @Step("Открыть главную страницу")
    public <T> T openMainPage(Class<T> page) {
        open("");

        content.shouldBe(visible);

        return page(page);
    }

    @Step("Нажать на 'Desktop app' на главной странице")
    public DownloadPage clickDesktopApp() {
        desktopApp.shouldBe(visible).click();

        return page(DownloadPage.class);
    }
}
