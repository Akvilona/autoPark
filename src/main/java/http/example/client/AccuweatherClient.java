/**
 * Создал Андрей Антонов 22.08.2023 15:45
 * 59:30
 **/
package http.example.client;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import http.com.model.CurrentCondition;
import http.com.model.TopCitiesCount;
import http.example.model.LocationRoot;
import lombok.RequiredArgsConstructor;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

@RequiredArgsConstructor
public class AccuweatherClient {

    private static final String BASE_URL = "http://dataservice.accuweather.com";
    private final OkHttpClient okHttpClient;
    private final ObjectMapper objectMapper;
    private final String getApiKey;

    public LocationRoot[] getTopCities(final TopCitiesCount citiesCount) {
        String httpUrl = HttpUrl.parse(BASE_URL)
                .newBuilder()
                .addPathSegment("currentconditions")
                .addPathSegment("v1")
                .addPathSegment("topcities")
                .addPathSegment(String.valueOf(citiesCount.getValue()))
                .addQueryParameter("apikey", getApiKey)
                .build()
                .toString();

        var request = new Request.Builder()
                .url(httpUrl)
                .build();

        TypeReference<LocationRoot[]> localRootTypeReference = new TypeReference<>() {
        };

        return sendRequestAndRequestResponse(request, localRootTypeReference);
    }

    public CurrentCondition[] getCurrentConditionByLocationKiy(final String locationKey) {

        String httpUrl = HttpUrl.parse(BASE_URL)
                .newBuilder()
                .addPathSegment("currentconditions")
                .addPathSegment("v1")
                .addPathSegment(locationKey)
                .addQueryParameter("apikey", getApiKey)
                .build()
                .toString();

        var request = new Request.Builder()
                .url(httpUrl)
                .build();

        TypeReference<CurrentCondition[]> currentConditionsTypeReference = new TypeReference<>() {
        };

        return sendRequestAndRequestResponse(request, currentConditionsTypeReference);
    }

    private <T> T sendRequestAndRequestResponse(final Request request, final TypeReference<T> typeReference) {
        try {

            System.out.println("Sending rq... " + request);
            Response response = okHttpClient.newCall(request).execute();
            System.out.println("Received rs... " + response);
            String responseString = response.body().string();
            System.out.println("Received json... " + responseString);

            return objectMapper.readValue(responseString, typeReference);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
