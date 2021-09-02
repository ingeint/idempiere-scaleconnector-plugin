package com.ingeint.scaleconnector.client;

import okhttp3.*;

import java.io.IOException;

public class RestClient {

    public String sendRequest(String url, String json) throws IOException {
        MediaType JSON = MediaType.get("application/json; charset=utf-8");
        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(json, JSON);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }
}
