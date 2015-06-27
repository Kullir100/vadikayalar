package io.github.dnivra26.kulirandroid.rest;

import retrofit.http.POST;

public interface CloudApi {

    @POST("/createEvent")
    void createEvent();

}
