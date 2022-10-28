package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.demoqa.helpers.Attach;
import com.demoqa.properties.SystemProperties;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BaseTest {

    @BeforeAll
    static void configure() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);

        //Configuration.holdBrowserOpen = true;
        Configuration.browserCapabilities = capabilities;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browser = SystemProperties.browser();
        Configuration.browserVersion = SystemProperties.browserVersion();
        Configuration.browserSize = SystemProperties.browserSize();
        if (!SystemProperties.remoteUrl().equals("")) {
            Configuration.remote = SystemProperties.remoteUrl();
        }
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        if (!SystemProperties.browser().equals("firefox")) {
            Attach.browserConsoleLogs();
            Attach.addVideo();
        }
    }
}
