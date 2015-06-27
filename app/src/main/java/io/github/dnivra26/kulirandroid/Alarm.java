package io.github.dnivra26.kulirandroid;

import lombok.Getter;
import lombok.Setter;


public class Alarm {
    int temperature;
    int hour;
    int minute;
    String device_id;

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public String getDevice_id() {
        return device_id;
    }

    public void setDevice_id(String device_id) {
        this.device_id = device_id;
    }

    public Alarm(int temperature, int hour, int minute, String device_id) {
        this.temperature = temperature;
        this.hour = hour;
        this.minute = minute;
        this.device_id = device_id;
    }
}
