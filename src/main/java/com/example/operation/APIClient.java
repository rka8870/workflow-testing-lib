package com.example.operation;

import com.example.exception.APIClientException;
import com.example.request.APIRequest;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class APIClient {

    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    private final OkHttpClient okHttpClient = getOkHttpClient();

    public String postQuery(APIRequest apiRequest) throws APIClientException {
        RequestBody requestBody = RequestBody.create(JSON, apiRequest.getRequestBody());
        Request request = new Request.Builder()
                .url(apiRequest.getUrl())
                .addHeader("tid", apiRequest.getHeader().getTid())
                .addHeader("source", apiRequest.getHeader().getSource())
                .addHeader("authHeader", apiRequest.getHeader().getAuthHeader())
                .post(requestBody)
                .build();
        try (Response response = okHttpClient.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new APIClientException("Unexpected code " + response);
            }
            return response.body().string();
        } catch (IOException e) {
            throw new APIClientException("Error occurred while making API call", e);
        }
    }

    private OkHttpClient getOkHttpClient() {
        final long defaultTimeout = 15;
        return new OkHttpClient.Builder()
                .connectTimeout(defaultTimeout, TimeUnit.SECONDS)
                .writeTimeout(defaultTimeout, TimeUnit.SECONDS)
                .readTimeout(defaultTimeout, TimeUnit.SECONDS)
                .build();
    }


}
