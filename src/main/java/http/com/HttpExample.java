/**
 * Создал Андрей Антонов 17.08.2023 12:16
 * 1:40:20
 **/
package http.com;

import com.fasterxml.jackson.databind.ObjectMapper;
import http.com.model.CurrentCondition;
import http.com.model.LocationRoot;
import http.com.model.TopCitiesCount;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Scanner;
import java.util.stream.Stream;

public class HttpExample {

    private static final String APYKEY = "feSbo2gUicXaHd2tIZa1gIqyVqUSbsyh";
    private static final String BASE_URL = "http://dataservice.accuweather.com";

    //Console application
    //1) Пользователь выбирает сколько topcities хочет запросить (50/100/150)
    //2) Кидаем запрос, полуае ответ от accuweather [topcities] и выводим пользователю города на выбор
    //3) Пользователь выбирает город для получения прогноза погоды из списка по наименованию
    //4) Кидаем запрос, полуае ответ от accuweather [currentconditions]
    // и выводим пользователю прогноз погоды в данном городе
    //5) Спрашиваем, хотите продолжить? Если да, то в п.2, если нет, то на выход

    public static void main(final String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        OkHttpClient okHttpClient = new OkHttpClient();

        System.out.println("Select the number of cities: ");
        TopCitiesCount[] values = TopCitiesCount.values();
        for (TopCitiesCount topCitiesCount: TopCitiesCount.values()) {
            System.out.println(topCitiesCount.getValue());
        }

        Scanner scanner = new Scanner(System.in);
        int chusenCount = scanner.nextInt();


        int cityCount = 50;

        Request request = new Request.Builder()
                .url(BASE_URL + "/currentconditions/v1/topcities/" + chusenCount + "?apikey=" + APYKEY)
                .build();


        try {
//            System.out.println("Sending rq... " + request);
            Response response = okHttpClient.newCall(request).execute();
//            System.out.println("Receive rq... " + response);

            String responseString = response.body().string();
//            System.out.println("Receive rq... " + responseString);

            LocationRoot[] locationRoots = objectMapper.readValue(responseString, LocationRoot[].class);

            String shouldRetry = "";
            do {
                for (LocationRoot locationRoot : locationRoots) {
                      System.out.println(locationRoot);
                }
                System.out.println("Select the city in which you want to view the weather forecast by the name of the city: ");

                String choosenCity = scanner.next();

                LocationRoot foundLocation =  Stream.of(locationRoots)
                        .filter(locationRoot -> locationRoot.getEnglishName().equals(choosenCity))
                        .findFirst()
                        .orElseThrow(() -> new IllegalArgumentException("Cant find location by name:  " + choosenCity));



                request = new Request.Builder()
                        .url(BASE_URL + "/currentconditions/v1/" + foundLocation.getKey() + "?apikey=" + APYKEY)
                        .build();

                response = okHttpClient.newCall(request).execute();
                responseString = response.body().string();
                CurrentCondition[] currentConditions = objectMapper.readValue(responseString, CurrentCondition[].class);
                System.out.println(currentConditions[0].getTemperature().getMetric().getValue());
                System.out.println("Do you want to continue? Enter 1 - Yes / 2 - No");
                shouldRetry = scanner.next();
            } while (shouldRetry.equals("1"));

//            for (int i = 0; i < currentConditions.length; i++) {
//                currentConditions[i].getTemperature();
//
//
//            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
