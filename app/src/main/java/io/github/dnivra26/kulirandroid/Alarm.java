package io.github.dnivra26.kulirandroid;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Alarm {
    int temperature;
    int hour;
    int minute;

    public Alarm(int temperature, int hour, int minute) {
        this.temperature = temperature;
        this.hour = hour;
        this.minute = minute;
    }
}
