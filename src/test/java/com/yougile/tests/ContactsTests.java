package com.yougile.tests;

import com.yougile.pages.AboutPage;
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
@TmsLink("HOMEWORK-1131")
@Tags({@Tag("About"), @Tag("smoke")})
@Owner("vvartemenko")
public class ContactsTests extends BaseTest {

    private final AboutPage aboutPage = new AboutPage();

    @Test
    @DisplayName("Проверить отображение информации в Росреестре на странице 'О нас'")
    void checkRusRegistryInfoTest() {
        aboutPage
                .openContactPage(AboutPage.class)
                .checkDataInInfoBlock("1177746958311")
                .checkDataInInfoBlock("7725393915")
                .checkDataInInfoBlock("773601001")
                .checkDataInInfoBlock("op@yougile.com")
                .checkDataInInfoBlock("119331, город Москва, пр-кт Вернадского, д. 29, этаж 5 ком./офис 20/б3т");
    }

    @Test
    @DisplayName("Проверить отображение электронных почт отделов продаж, бухгалтерии, поддержки в футере")
    void checkContactEmailsInFooterTest() {
        aboutPage
                .openContactPage(Footer.class)
                .checkEmails();
    }
}
