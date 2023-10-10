package http.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import http.com.model.CurrentCondition;
import http.com.model.TopCitiesCount;
import http.com.utils.PropertiesReaderUtils;
import http.example.client.AccuweatherClient;
import okhttp3.OkHttpClient;

public class HttpExample {

    public static void main(final String[] args) {
        OkHttpClient okHttpClient = new OkHttpClient();
        ObjectMapper objectMapper = new ObjectMapper();
        String apiKey = PropertiesReaderUtils.getProperty("apiKey");
        AccuweatherClient accuweatherClient = new AccuweatherClient(okHttpClient, objectMapper, apiKey);

        http.example.model.LocationRoot[] cityLocation = accuweatherClient.getTopCities(TopCitiesCount.FIFTY);
        CurrentCondition[] weatherConditions = accuweatherClient.getCurrentConditionByLocationKiy(cityLocation[0].getKey());

        System.out.println(weatherConditions);
    }
}
