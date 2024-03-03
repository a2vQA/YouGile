package com.yougile.pages.components;

import com.codeborne.selenide.SelenideElement;
import com.yougile.pages.DownloadPage;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;

public class Footer {

    private final SelenideElement footer = $("footer"),
            desktopAppBig = $("footer div[class~='d-xl-flex'] [href='/download']"),
            desktopAppSmall = $("footer div[class~='d-xl-none'] [href='/download']"),
            downloadApp = $("a[href='/download'][class='text-decoration-none']"),
            salesEmail = $x("//p[text()='Отдел продаж:']/following-sibling::ul/li/a[text()='op@yougile.com']"),
            accountingEmail = $x("//p[text()='Бухгалтерия:']/following-sibling::ul/li/a[text()='buh@yougile.com']"),
            supportEmail = $x("//p[text()='Поддержка:']/following-sibling::ul/li/a[text()='support@yougile.com']");

    @Step("Нажать на 'Desktop app' в футере")
    public DownloadPage clickDesktopApp() {
        footer.shouldBe(visible).scrollIntoView(true);
        if (desktopAppBig.isDisplayed()) {
            desktopAppBig.click();
        } else {
            desktopAppSmall.click();
        }

        return page(DownloadPage.class);
    }

    @Step("Нажать на 'Скачать приложение' в футере")
    public DownloadPage clickDownloadApp() {
        footer.scrollIntoView(true).shouldBe(visible);
        downloadApp.shouldBe(visible).click();

        return page(DownloadPage.class);
    }

    @Step("Проверить наличие электронных почт отделов в футере")
    public Footer checkEmails() {
        footer.shouldBe(visible);
        salesEmail.shouldBe(visible);
        accountingEmail.shouldBe(visible);
        supportEmail.shouldBe(visible);

        return this;
    }
}
