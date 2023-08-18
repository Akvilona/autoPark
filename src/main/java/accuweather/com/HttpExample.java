/**
 * Создал Андрей Антонов 17.08.2023 12:16
 **/
package accuweather.com;

import accuweather.com.model.LocationRoot;
import com.fasterxml.jackson.databind.ObjectMapper;
import http.model.CurrentConditionRoot;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Arrays;

public class HttpExample {

    private final static String  APYKEY = "feSbo2gUicXaHd2tIZa1gIqyVqUSbsyh";
    private static final String BASE_URL = "http://dataservice.accuweather.com";


    public static void main(String[] args) throws IOException {
        OkHttpClient okHttpClient = new OkHttpClient();
        int cityCount = 50;
        private final ObjectMapper objectMapper = new ObjectMapper();

        Request request = new Request.Builder()
                .url(BASE_URL + "/currentconditions/v1/topcities/" + cityCount + "?apikey=" + APYKEY)
                .build();

        System.out.println("Sending rq... " + request);

        try {
            Response response = okHttpClient.newCall(request).execute();
            System.out.println("Receive rq... " + response);

            String responseString = response.body().string();
            System.out.println("Receive rq... " + responseString);

            LocationRoot locationRoot = objectMapper.readValue(responseString, LocationRoot.class);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
/*
        responseString = response.body().string();

        CurrentConditionRoot[] currentConditionRoot = objectMapper.readValue(responseString,
                CurrentConditionRoot[].class);
        System.out.println(Arrays.toString(currentConditionRoot));
*/
    }
}
