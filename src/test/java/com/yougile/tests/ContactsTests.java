package com.yougile.tests;

import com.yougile.pages.About;
import com.yougile.pages.components.Footer;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.TmsLink;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

@Epic("О нас")
@Feature("Проверка отображения данных на странице 'О нас'")
@DisplayName("Проверка отображения данных на странице 'О нас'")
public class ContactsTests extends BaseTest {

    private final About about = new About();

    @Test
    @Tags({@Tag("About"), @Tag("smoke")})
    @TmsLink("1131")
    @Owner("vvartemenko")
    @DisplayName("Проверить отображение информации в Росреестре на странице 'О нас'")
    void checkRusRegistryInfoTest() {
        about
                .openContactPage(About.class)
                .checkOgrn()
                .checkInn()
                .checkKpp()
                .checkEmail()
                .checkAddress();
    }

    @Test
    @Tags({@Tag("About"), @Tag("smoke")})
    @TmsLink("1131")
    @Owner("vvartemenko")
    @DisplayName("Проверить отображение электронных почт отделов продаж, бухгалтерии, поддержки в футере")
    void checkContactEmailsInFooterTest() {
        about
                .openContactPage(Footer.class)
                .checkEmails();
    }
}
