package io.github.dnivra26.kulirandroid.rest;

import io.github.dnivra26.kulirandroid.Alarm;
import retrofit.ResponseCallback;
import retrofit.http.POST;

public interface CloudApi {

    @POST("/save")
    void createEvent(Alarm alarm, ResponseCallback responseCallback);

}
