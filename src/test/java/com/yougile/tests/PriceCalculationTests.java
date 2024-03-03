package com.yougile.tests;

import com.yougile.pages.PricePage;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.TmsLink;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@Epic("Цены")
@Feature("Калькуляторы цены")
@DisplayName("Калькуляторы цены")
@TmsLink("HOMEWORK-1133")
@Tags({@Tag("About"), @Tag("smoke")})
@Owner("vvartemenko")
public class PriceCalculationTests extends BaseTest {

    private final PricePage pricePage = new PricePage();

    @Test
    @DisplayName("Проверка работы слайдера Расчёт стоимости")
    void sliderPriceChangeTest() {
        String firstPrice = pricePage
                .openPricePage()
                .getSliderBoxPrice();

        String secondPrice = pricePage
                .openPricePage()
                .moveSlider(300)
                .getSliderBoxPrice();

        step("Сравнение цен после изменений в слайдере", () -> assertNotEquals(firstPrice, secondPrice,
                "Цена до движения слайдера " + firstPrice + " цена после " + secondPrice));
    }

    @MethodSource
    @DisplayName("Проверка работы калькулятора Расчёт окупаемости")
    @ParameterizedTest()
    void paybackCalculatorTest(String tariff, String roi, String licensePeriod, String expenses, String quantity) {
        String licenseAmountBefore = pricePage
                .openPricePage()
                .getLicenceAmount();
        String profitAmountBefore = pricePage
                .getProfitAmount();
        String paybackDaysBefore = pricePage
                .getPaybackDays();

        pricePage
                .setTariffOption(tariff)
                .setRoiIncOption(roi)
                .setLicensePeriodOption(licensePeriod)
                .setEmployeeExpensesOption(expenses)
                .setEmployeeQuantity(quantity);

        String licenseAmountAfter = pricePage
                .getLicenceAmount();
        String profitAmountAfter = pricePage
                .getProfitAmount();
        String paybackDaysAfter = pricePage
                .getPaybackDays();

        step("Проверка изменения сумм в калькуляторе после выставления новых параметров", () -> assertAll(
                () -> assertNotEquals(licenseAmountBefore, licenseAmountAfter,
                        "Стоимость лицензии была " + licenseAmountBefore + ", а стала " + licenseAmountAfter),
                () -> assertNotEquals(profitAmountBefore, profitAmountAfter,
                        "Стоимость лицензии была " + profitAmountBefore + ", а стала " + profitAmountAfter),
                () -> assertNotEquals(paybackDaysBefore, paybackDaysAfter,
                        "Стоимость лицензии была " + paybackDaysBefore + ", а стала " + paybackDaysAfter)));
    }

    static Stream<Arguments> paybackCalculatorTest() {
        return Stream.of(
                Arguments.of("Коробочная версия", "200%", "1 месяц", "250 000", "800"),
                Arguments.of("Коробочная версия", "1%", "2 года", "15 000", "300"),
                Arguments.of("Облачная версия", "25%", "6 месяцев", "120 000", "150")
        );
    }
}
