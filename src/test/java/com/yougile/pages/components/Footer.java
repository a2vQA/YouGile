package com.yougile.pages.components;

import com.codeborne.selenide.SelenideElement;
import com.yougile.pages.Download;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;

public class Footer {

    private final SelenideElement footer = $("footer"),
            desktopApp = $x("//footer//img[@src='/svg/get-via-desktop.svg']"),
            downloadApp = $("a[href='/download'][class='text-decoration-none']"),
            salesEmail = $x("//p[text()='Отдел продаж:']/following-sibling::ul/li/a[text()='op@yougile.com']"),
            accountingEmail = $x("//p[text()='Бухгалтерия:']/following-sibling::ul/li/a[text()='buh@yougile.com']"),
            supportEmail = $x("//p[text()='Поддержка:']/following-sibling::ul/li/a[text()='support@yougile.com']");

    @Step("Нажать на 'Desktop app' в футере")
    public Download clickDesktopApp() {
        footer.shouldBe(visible);
        desktopApp.shouldBe(visible).scrollIntoView(true).click();

        return page(Download.class);
    }

    @Step("Нажать на 'Скачать приложение' в футере")
    public Download clickDownloadApp() {
        footer.shouldBe(visible);
        downloadApp.shouldBe(visible).scrollIntoView(true).click();

        return page(Download.class);
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
