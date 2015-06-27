package io.github.dnivra26.kulirandroid.rest;

import io.github.dnivra26.kulirandroid.Alarm;
import retrofit.Callback;
import retrofit.ResponseCallback;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;

public interface CloudApi {

    @POST("/temperature")
    void createEvent(@Body Alarm alarm, ResponseCallback responseCallback);

    @GET("/temperature/{device_id}")
    void getEvents(@Path("device_id") String deviceId, Callback<Alarm> callback);

}
