package com.yougile.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.yougile.config.DriverConfig;
import com.yougile.helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;
import java.util.Objects;

public class BaseTest {

    @BeforeAll
    static void browserSettings() {
        DriverConfig driverConfig = ConfigFactory.create(DriverConfig.class);

        Configuration.baseUrl = "https://ru.yougile.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.browser = System.getProperty("browser", driverConfig.browserName());
        Configuration.browserVersion = System.getProperty("browserVersion", driverConfig.browserVersion());
        Configuration.browserSize = System.getProperty("browserSize", driverConfig.browserSize());
        Configuration.remote = System.getProperty("browserRemoteUrl", driverConfig.browserRemoteUrl());

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));

        Configuration.browserCapabilities = capabilities;
    }

    @BeforeEach
    void addLogger() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last Screenshot");
        Attach.pageSource();
        if (!Objects.equals(Configuration.browser, "firefox")) {
            Attach.browserConsoleLogs();
        }
        Attach.addVideo();
        Selenide.closeWebDriver();
    }
}
