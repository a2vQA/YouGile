package com.yougile.tests;

import com.yougile.pages.MainPage;
import com.yougile.pages.TeamAuthorization;
import com.yougile.pages.components.Footer;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.TmsLink;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

@Epic("Авторизация Team")
@Feature("Проверка отображения окна авторизации Team")
@DisplayName("Проверка отображения окна авторизации Team")
public class TeamAuthorizationTests extends BaseTest {

    private final MainPage mainPage = new MainPage();

    @Test
    @Tags({@Tag("Authorization"), @Tag("smoke")})
    @TmsLink("HOMEWORK-1131")
    @Owner("vvartemenko")
    @DisplayName("Отображение окна авторизации Team при переходе по кнопке 'DesktopApp' с футера")
    void checkForTeamAuthorizationWindowWithDesktopAppBtnInFooter() {
        mainPage
                .openMainPage(Footer.class)
                .clickDesktopApp()
                .clickWebStartBtn(TeamAuthorization.class)
                .checkForTeamLoginWindow();
    }

    @Test
    @Tags({@Tag("Authorization"), @Tag("smoke")})
    @TmsLink("HOMEWORK-1131")
    @Owner("vvartemenko")
    @DisplayName("Отображение окна авторизации Team при переходе по кнопке 'Скачать приложение' с футера")
    void checkForTeamAuthorizationWindowWithInformationDownloadInFooter() {
        mainPage
                .openMainPage(Footer.class)
                .clickDownloadApp()
                .clickWebStartBtn(TeamAuthorization.class)
                .checkForTeamLoginWindow();
    }

    @Test
    @Tags({@Tag("Authorization"), @Tag("smoke")})
    @TmsLink("HOMEWORK-1131")
    @Owner("vvartemenko")
    @DisplayName("Отображение окна авторизации Team при переходе по кнопке 'DesktopApp' с середины главной страницы")
    void checkForTeamAuthorizationWindowWithMiddlePageDesktopAppBtn() {
        mainPage
                .openMainPage(MainPage.class)
                .clickDesktopApp()
                .clickWebStartBtn(TeamAuthorization.class)
                .checkForTeamLoginWindow();
    }
}
