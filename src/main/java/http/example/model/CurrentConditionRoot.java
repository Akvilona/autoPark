package http.example.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrentConditionRoot {
    @JsonProperty("LocalObservationDateTime")
    private Date localObservationDateTime;
    @JsonProperty("EpochTime")
    private int epochTime;
    @JsonProperty("WeatherText")
    private String weatherText;
    @JsonProperty("WeatherIcon")
    private int weatherIcon;
    @JsonProperty("HasPrecipitation")
    private boolean hasPrecipitation;
    @JsonProperty("PrecipitationType")
    private Object precipitationType;
    @JsonProperty("IsDayTime")
    private boolean isDayTime;
    @JsonProperty("Temperature")
    private Temperature temperature;
    @JsonProperty("MobileLink")
    private String mobileLink;
    @JsonProperty("Link")
    private String link;

    @Data
    public static class Imperial {
        @JsonProperty("Value")
        private int value;
        @JsonProperty("Unit")
        private String unit;
        @JsonProperty("UnitType")
        private int unitType;
    }

    @Data
    public static class Metric {
        @JsonProperty("Value")
        private double value;
        @JsonProperty("Unit")
        private String unit;
        @JsonProperty("UnitType")
        private int unitType;
    }

    @Data
    public static class Temperature {
        @JsonProperty("Metric")
        private Metric metric;
        @JsonProperty("Imperial")
        private Imperial imperial;
    }
}


