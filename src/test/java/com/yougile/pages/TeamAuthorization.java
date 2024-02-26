package com.yougile.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class TeamAuthorization {

    private final SelenideElement loginWindow = $(".login-wnd");

    @Step("Проверить, что окно логина отображено")
    public TeamAuthorization checkForTeamLoginWindow(){
        switchTo().window(1);

        loginWindow.shouldBe(visible);

        return this;
    }
}
