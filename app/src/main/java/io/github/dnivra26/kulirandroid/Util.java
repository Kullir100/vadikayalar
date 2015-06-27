package io.github.dnivra26.kulirandroid;

public class Util {

    public static int getTemperatureInDegree(String temperature) {
        if (temperature.contains("Hot")) {
            return 90;
        } else if (temperature.contains("Warm")) {
            return 70;
        } else {
            return 50;
        }
    }
}
