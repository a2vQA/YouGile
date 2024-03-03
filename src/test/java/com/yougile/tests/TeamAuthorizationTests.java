package com.yougile.tests;

import com.yougile.pages.MainPage;
import com.yougile.pages.TeamAuthorizationPage;
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
@TmsLink("HOMEWORK-1131")
@Tags({@Tag("Authorization"), @Tag("smoke")})
@Owner("vvartemenko")
public class TeamAuthorizationTests extends BaseTest {

    private final MainPage mainPage = new MainPage();

    @Test
    @DisplayName("Отображение окна авторизации Team при переходе по кнопке 'DesktopApp' с футера")
    void checkForTeamAuthorizationWindowWithDesktopAppBtnInFooter() {
        mainPage
                .openMainPage(Footer.class)
                .clickDesktopApp()
                .clickWebStartBtn(TeamAuthorizationPage.class)
                .checkForTeamLoginWindow();
    }

    @Test
    @DisplayName("Отображение окна авторизации Team при переходе по кнопке 'Скачать приложение' с футера")
    void checkForTeamAuthorizationWindowWithInformationDownloadInFooter() {
        mainPage
                .openMainPage(Footer.class)
                .clickDownloadApp()
                .clickWebStartBtn(TeamAuthorizationPage.class)
                .checkForTeamLoginWindow();
    }

    @Test
    @DisplayName("Отображение окна авторизации Team при переходе по кнопке 'DesktopApp' с середины главной страницы")
    void checkForTeamAuthorizationWindowWithMiddlePageDesktopAppBtn() {
        mainPage
                .openMainPage(MainPage.class)
                .clickDesktopApp()
                .clickWebStartBtn(TeamAuthorizationPage.class)
                .checkForTeamLoginWindow();
    }
}
