package com.yougile.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.actions;
import static com.codeborne.selenide.Selenide.open;

public class PricePage {

    private final SelenideElement costCalculatorContent = $("#section-cost-calculator-v2"),
            paybackCalculatorContent = $("#section-payback-calculator-v2"),
            boxSliderPrice = $x("//h2[text()='Коробочная версия']/..//h4//span"),
            sliderKnob = $(".knob"),
            licenseAmount = $(".price-roi__tot"),
            profitAmount = $(".price-roi__profit"),
            paybackDays = $(".price-roi__days-to-profit"),
            calculatorTariffDropdown = $("[class^='nice-select price-roi__tariff']"),
            calculatorRoiIncDropdown = $("[class^='nice-select price-roi__inc']"),
            calculatorLicensePeriodDropdown = $("[class^='nice-select price-roi__months']"),
            calculatorEmployeeExpenseDropdown = $("[class^='nice-select price-roi__salary']"),
            calculatorEmployeeQuantity = $("[class='input-group input-group-stepper'] input");

    @Step("Открыть страницу Цены")
    public PricePage openPricePage() {
        open("/prices");

        costCalculatorContent.shouldBe(visible);
        paybackCalculatorContent.shouldBe(visible);

        return this;
    }

    @Step("Получить цену из Коробочная версия под слайдером")
    public String getSliderBoxPrice() {
        $("[class='row s-price__calc-cols']")
                .scrollIntoView("{behavior: \"instant\", block: \"center\", inline: \"center\"}");

        return boxSliderPrice.shouldBe(visible).getText();
    }

    @Step("Получить цену из Коробочная версия под слайдером")
    public PricePage moveSlider(int offset) {
        actions().moveToElement(sliderKnob).clickAndHold().moveByOffset(offset, 0).release().perform();

        return this;
    }

    @Step("Получить цену Суммы за лицензию под калькулятором")
    public String getLicenceAmount() {
        paybackCalculatorContent.shouldBe(visible).scrollIntoView(true);

        return licenseAmount.getText();
    }

    @Step("Получить сумму Прирост эффективности под калькулятором")
    public String getProfitAmount() {
        paybackCalculatorContent.shouldBe(visible).scrollIntoView(true);

        return profitAmount.getText();
    }

    @Step("Получить кол-во дней Окупаемости затрат под калькулятором")
    public String getPaybackDays() {
        paybackCalculatorContent.shouldBe(visible).scrollIntoView(true);

        return paybackDays.getText();
    }

    @Step("Выставить значение дропдауна Тариф на \"{0}\"")
    public PricePage setTariffOption(String value) {
        calculatorTariffDropdown.shouldBe(visible).click();
        $x("//div[@class='nice-select price-roi__tariff open']//li[text()='" + value + "']").click();

        return this;
    }

    @Step("Выставить значение дропдауна Предполагаемое повышение эффективности на \"{0}\"")
    public PricePage setRoiIncOption(String value) {
        calculatorRoiIncDropdown.shouldBe(visible).click();
        $x("//div[@class='nice-select price-roi__inc open']//li[text()='" + value + "']").click();

        return this;
    }

    @Step("Выставить значение дропдауна Срок лицензии на \"{0}\"")
    public PricePage setLicensePeriodOption(String value) {
        calculatorLicensePeriodDropdown.shouldBe(visible).click();
        $x("//div[@class='nice-select price-roi__months open']//li[text()='" + value + "']").click();

        return this;
    }

    @Step("Выставить значение дропдауна Предполагаемое повышение эффективности на \"{0}\"")
    public PricePage setEmployeeExpensesOption(String value) {
        calculatorEmployeeExpenseDropdown.shouldBe(visible).click();
        $x("//div[@class='nice-select price-roi__salary open']//li[text()='" + value + "']").click();

        return this;
    }

    @Step("Выставить значение инпута Кол-во сотрудников на \"{0}\"")
    public PricePage setEmployeeQuantity(String value) {
        calculatorEmployeeQuantity.shouldBe(visible).setValue(value);

        return this;
    }
}
