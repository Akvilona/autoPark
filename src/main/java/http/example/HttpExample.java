/**
 * 01:13:45
 */
package http.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import http.com.model.CurrentCondition;
import http.com.model.LocationRoot;
import http.com.model.TopCitiesCount;
import http.example.client.AccuweatherClient;
import http.example.utils.PropertiesReaderUtils;
import okhttp3.OkHttpClient;

public class HttpExample {
    private static final String BASE_URL = "http://dataservice.accuweather.com";
    private static final String API_KEY = "kRK8UAPHaOphrB82Ida62hMIdFnt36yB";

    //Console application
    //1) Пользователь выбирает сколько topcities хочет запросить (50/100/150)
    //2) Кидаем запрос, полуае ответ от accuweather [topcities] и выводим пользователю города на выбор
    //3) Пользователь выбирает город для получения прогноза погоды из списка по наименованию
    //4) Кидаем запрос, полуае ответ от accuweather [currentconditions]
    // и выводим пользователю прогноз погоды в данном городе
    //5) Спрашиваем, хотите продолжить? Если да, то в п.2, если нет, то на выход

    public static void main(final String[] args) {

//        OkHttpClient okHttpClient = new OkHttpClient();
//        ObjectMapper objectMapper = new ObjectMapper();
//
//        //1
//        System.out.println("Выберите кол-во городов: ");
//        for (TopCitiesCount topCitiesCount: TopCitiesCount.values()) {
//            System.out.println(topCitiesCount.getValue());
//        }
//
//        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
//        int choosenCount = scanner.nextInt();
//        //============
//
//        String shouldRetry;
//        do {
//            var request = new Request.Builder()
//                    .url(BASE_URL + "/locations/v1/topcities/" + choosenCount + "?apikey=" + API_KEY)
//                    .build();
//
//            try {
//                System.out.println("Sending rq... " + request);
//                Response response = okHttpClient.newCall(request).execute();
//                System.out.println("Received rs... " + response);
//
//                String responseString = response.body().string();
//                LocationRoot[] locationRoots = objectMapper.readValue(responseString, LocationRoot[].class);
//
//                for (LocationRoot locationRoot : locationRoots) {
//                    System.out.println(locationRoot);
//                }
//
//                System.out.println();
//                System.out.println("Выберите город в котором хотите посмотреть прогноз погоды по EnglishName: ");
//                String choosenCity = scanner.next();
//
////            Optional<LocationRoot> foundLocation = Optional.empty();
////            for (LocationRoot locationRoot: locationRoots) {
////                if (locationRoot.getEnglishName().equals(choosenCity)) {
////                    foundLocation = Optional.of(locationRoot);
////                }
////            }
//
//                LocationRoot foundLocation = Stream.of(locationRoots)
//                        .filter(locationRoot -> locationRoot.getEnglishName().equals(choosenCity))
//                        .findFirst()
//                        .orElseThrow(() -> new IllegalArgumentException("Can't find location by name: " + choosenCity));
//
//                request = new Request.Builder()
//                        .url(BASE_URL + "/currentconditions/v1/" + foundLocation.getKey() + "?apikey=" + API_KEY)
//                        .build();
//
//                System.out.println("Sending rq... " + request);
//                response = okHttpClient.newCall(request).execute();
//                System.out.println("Received rs... " + response);
//
//                responseString = response.body().string();
//
//                CurrentConditionRoot[] currentConditionRoot = objectMapper.readValue(responseString, CurrentConditionRoot[].class);
//                System.out.println(currentConditionRoot[0].getTemperature().getMetric().getValue());
//
//                System.out.println("Хотите продолжить? 'Y' - да, 'N' - нет");
//                shouldRetry = scanner.next();
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        } while (shouldRetry.equals("Y"));
//
//
//    }

        OkHttpClient okHttpClient = new OkHttpClient();
        ObjectMapper objectMapper = new ObjectMapper();
        String apiKey = PropertiesReaderUtils.getProperty("apiKey");
        AccuweatherClient accuweatherClient = new AccuweatherClient(okHttpClient, objectMapper, apiKey);

        http.example.model.LocationRoot[] cityLocation = accuweatherClient.getTopCities(TopCitiesCount.FIFTY);
        CurrentCondition[] weatherConditions = accuweatherClient.getCurrentConditionByLocationKiy(cityLocation[0].getKey());

        System.out.println(weatherConditions);
    }
}
