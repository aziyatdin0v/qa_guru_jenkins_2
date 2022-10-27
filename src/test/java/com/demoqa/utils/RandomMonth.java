package com.demoqa.utils;

import java.time.Month;
import java.util.Random;

public enum RandomMonth {
    January, February, March, April, May, June, July, August, September, October, November, December;

    public static RandomMonth getRandomMonth() {
        int pick = new Random().nextInt(Month.values().length);
        return RandomMonth.values()[pick];
    }
}
