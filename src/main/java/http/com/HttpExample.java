/**
 * Создал Андрей Антонов 17.08.2023 12:16
 * 1:40:20
 **/
package http.com;

import com.fasterxml.jackson.databind.ObjectMapper;
import http.com.client.AccuweatherClient;
import http.com.service.AccuweatherService;
import http.com.utils.PropertiesReaderUtils;
import okhttp3.OkHttpClient;

public class HttpExample {

    public static void main(final String[] args) {
        OkHttpClient okHttpClient = new OkHttpClient();
        ObjectMapper objectMapper = new ObjectMapper();
        String apiKey = PropertiesReaderUtils.getProperty("apiKey");

        AccuweatherClient accuweatherClient = new AccuweatherClient(okHttpClient, objectMapper, apiKey);
        AccuweatherService accuweatherService = new AccuweatherService(accuweatherClient);

        accuweatherService.run();
    }
}
