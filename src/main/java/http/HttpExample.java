package http;

import com.fasterxml.jackson.databind.ObjectMapper;
import http.model.CurrentConditionRoot;
import http.model.LocationRoot;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Arrays;

public class HttpExample {
    private static final String BASE_URL = "http://dataservice.accuweather.com";
    private static final String API_KEY = "kRK8UAPHaOphrB82Ida62hMIdFnt36yB";

    public static void main(String[] args) {
        OkHttpClient okHttpClient = new OkHttpClient();
        ObjectMapper objectMapper = new ObjectMapper();
        int cityCount = 50;

        var request = new Request.Builder()
                .url(BASE_URL + "/locations/v1/topcities/" + cityCount + "?apikey=" + API_KEY)
                .build();

        try {
            System.out.println("Sending rq... " + request);
            Response response = okHttpClient.newCall(request).execute();
            System.out.println("Received rs... " + response);

            String responseString = response.body().string();

            LocationRoot[] locationRoots = objectMapper.readValue(responseString, LocationRoot[].class);

            String key = "";
            for (LocationRoot locationRoot : locationRoots) {
                if (locationRoot.getEnglishName().equals("Moscow")) {
                    key = locationRoot.getKey();
                    break;
                }
            }

            request = new Request.Builder()
                    .url(BASE_URL + "/currentconditions/v1/" + key + "?apikey=" + API_KEY)
                    .build();

            System.out.println("Sending rq... " + request);
            response = okHttpClient.newCall(request).execute();
            System.out.println("Received rs... " + response);

            responseString = response.body().string();

            CurrentConditionRoot[] currentConditionRoot = objectMapper.readValue(responseString,
                    CurrentConditionRoot[].class);
            System.out.println(Arrays.toString(currentConditionRoot));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
