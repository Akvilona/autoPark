package http.com.service;

import http.com.client.AccuweatherClient;
import http.com.model.CurrentCondition;
import http.com.model.LocationRoot;
import http.com.model.TopCitiesCount;
import lombok.RequiredArgsConstructor;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.stream.Stream;

@RequiredArgsConstructor
public class AccuweatherService {
    private final AccuweatherClient accuweatherClient;

    private static LocationRoot getCityLocationByName(LocationRoot[] cityLocations, String choosenCity) {
        return Stream.of(cityLocations)
                .filter(locationRoot -> locationRoot.getEnglishName().equals(choosenCity))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Cant find location by name:  " + choosenCity));
    }

    public void run() {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        String shouldRetry;
        do {
            shouldRetry = selectCityAndDisplayWeather(scanner);
        } while ("Y".equals(shouldRetry));
    }

    private String selectCityAndDisplayWeather(final Scanner scanner) {
        System.out.println("Select the number of cities: ");
        for (TopCitiesCount topCitiesCount : TopCitiesCount.values()) {
            System.out.println(topCitiesCount.getValue());
        }
        int userInput = scanner.nextInt();
        LocationRoot[] cityLocations = accuweatherClient.getTopcities(TopCitiesCount.findByValue(userInput));

        System.out.println("Select the city by entering its name: ");
        for (LocationRoot locationRoot : cityLocations) {
            System.out.println(locationRoot);
        }

        String choosenCity = scanner.next();
        LocationRoot foundLocation = getCityLocationByName(cityLocations, choosenCity);

        CurrentCondition[] weatherConditions = accuweatherClient.getCurrentConditionsByLocationKey(foundLocation.getKey());
        System.out.println("Temperature: " + weatherConditions[0].getTemperature().getMetric().getValue());

        System.out.println("Do you want to continue? Enter Y for Yes, or any other key for No");
        return scanner.next();
    }
}
