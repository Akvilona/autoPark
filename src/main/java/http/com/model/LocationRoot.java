package http.com.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class LocationRoot {
    @JsonProperty("Key")
    private String key;
    @JsonProperty("EnglishName")
    private String englishName;

    protected Object cloneMy() throws CloneNotSupportedException {
        return super.clone();
    }
}

