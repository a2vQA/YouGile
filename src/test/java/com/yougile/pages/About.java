package com.yougile.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class About {

    private final SelenideElement content = $x("//h1[text()='О компании']/following-sibling::h4[text()='YouGile — российский сервис для управления проектами.']"),
            registrySection = $("#section-registry"),
            ogrn = $x("(//div[@class='h6 pt-0d125'])[1]"),
            inn = $x("(//div[@class='h6 pt-0d125'])[2]"),
            kpp = $x("(//div[@class='h6 pt-0d125'])[3]"),
            email = $x("(//div[@class='h6 pt-0d125'])[4]"),
            address = $x("(//div[@class='h6 pt-0d125'])[5]");

    @Step("Открыть страницу 'О нас'")
    public <T> T openContactPage(Class<T> page){
        open("/about");

        content.shouldBe(visible);

        return page(page);
    }

    @Step("Секция реестра имеет верный ОГРН")
    public About checkOgrn(){
        registrySection.shouldBe(visible);
        ogrn.shouldHave(text("1177746958311"));

        return this;
    }

    @Step("Секция реестра имеет верный ОГРН")
    public About checkInn(){
        registrySection.shouldBe(visible);
        inn.shouldHave(text("7725393915"));

        return this;
    }

    @Step("Секция реестра имеет верный ОГРН")
    public About checkKpp(){
        registrySection.shouldBe(visible);
        kpp.shouldHave(text("773601001"));

        return this;
    }

    @Step("Секция реестра имеет верный ОГРН")
    public About checkEmail(){
        registrySection.shouldBe(visible);
        email.shouldHave(text("op@yougile.com"));

        return this;
    }

    @Step("Секция реестра имеет верный юридический адрес")
    public About checkAddress(){
        registrySection.shouldBe(visible);
        address.shouldHave(text("119331, город Москва, пр-кт Вернадского, д. 29, этаж 5 ком./офис 20/б3т"));

        return this;
    }
}
