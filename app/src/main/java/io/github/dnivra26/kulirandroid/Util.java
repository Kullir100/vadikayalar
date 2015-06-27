package io.github.dnivra26.kulirandroid;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.util.UUID;

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


    public static String getDeviceId(Context context) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        String deviceId = sharedPreferences.getString("device_id", null);
        if (deviceId == null) {
            deviceId = UUID.randomUUID().toString();
            saveDeviceId(context, deviceId);
        }

        return deviceId;
    }

    private static void saveDeviceId(Context context, String deviceId) {
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("device_id", deviceId);
        editor.commit();
    }
}
