package com.demoqa.properties;

public class SystemProperties {

    public static String browser() {
        return System.getProperty("browser", "chrome");
    }

    public static String browserVersion() {
        return System.getProperty("browserVersion", "106");
    }

    public static String browserSize() {
        return System.getProperty("browserSize", "1920x1080");
    }

    public static String remoteUrl() {
        return System.getProperty("remoteUrl", "http://192.168.31.197:4444/wd/hub"); //http://test:test-password@192.168.31.197:5555/wd/hub
    }
}
