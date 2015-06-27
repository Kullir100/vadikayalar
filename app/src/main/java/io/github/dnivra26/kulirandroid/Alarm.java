package io.github.dnivra26.kulirandroid;

import lombok.AllArgsConstructor;
import lombok.Setter;

@Setter
@AllArgsConstructor(suppressConstructorProperties = true)
public class Alarm {
    int temperature;
    int hour;
    int minute;
}
