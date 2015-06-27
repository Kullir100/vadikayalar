package io.github.dnivra26.kulirandroid.rest;

import io.github.dnivra26.kulirandroid.Alarm;
import retrofit.ResponseCallback;
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

    public void createAlarm(Alarm alarm, ResponseCallback responseCallback) {
        cloudApi.createEvent(alarm, responseCallback);
    }
}
