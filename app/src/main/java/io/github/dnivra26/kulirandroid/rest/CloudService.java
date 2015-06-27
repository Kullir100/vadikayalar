package io.github.dnivra26.kulirandroid.rest;

import retrofit.RestAdapter;

public class CloudService {

    private static final String BASE_URL = "";
    private final RestAdapter restAdapter;
    private final CloudApi cloudApi;

    public CloudService() {
        restAdapter = new RestAdapter.Builder()
                .setEndpoint(BASE_URL)
                .build();
        cloudApi = restAdapter.create(CloudApi.class);
    }

    public void createAlarm() {
        cloudApi.createEvent();
    }
}
