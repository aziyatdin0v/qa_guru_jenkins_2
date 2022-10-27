package com.demoqa.properties;

public class SystemProperties {

    public static String browser() {
        return System.getProperty("browser", "opera");
    }

    public static String browserVersion() {
        return System.getProperty("browserVersion", "100");
    }

    public static String browserSize() {
        return System.getProperty("browserSize", "1920x1080");
    }

    public static String remoteUrl() {
        return System.getProperty("remoteUrl", "https://user1:1234@selenoid.autotests.cloud/wd/hub");
    }
}
