/**
 * Создал Андрей Антонов 17.08.2023 17:02
 **/
package accuweather.com.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Date;

public class LocationRoot {
    @JsonProperty("Version")
    public int version;
    @JsonProperty("Key")
    public String key;
    @JsonProperty("Type")
    public String type;
    @JsonProperty("Rank")
    public int rank;
    @JsonProperty("LocalizedName")
    public String localizedName;
    @JsonProperty("EnglishName")
    public String englishName;
    @JsonProperty("PrimaryPostalCode")
    public String primaryPostalCode;
    @JsonProperty("Region")
    public Region region;
    @JsonProperty("Country")
    public Country country;
    @JsonProperty("AdministrativeArea")
    public AdministrativeArea administrativeArea;
    @JsonProperty("TimeZone")
    public TimeZone timeZone;
    @JsonProperty("GeoPosition")
    public GeoPosition geoPosition;
    @JsonProperty("IsAlias")
    public boolean isAlias;
    @JsonProperty("SupplementalAdminAreas")
    public ArrayList<SupplementalAdminArea> supplementalAdminAreas;
    @JsonProperty("DataSets")
    public ArrayList<String> dataSets;
}

class AdministrativeArea{
    @JsonProperty("ID")
    public String iD;
    @JsonProperty("LocalizedName")
    public String localizedName;
    @JsonProperty("EnglishName")
    public String englishName;
    @JsonProperty("Level")
    public int level;
    @JsonProperty("LocalizedType")
    public String localizedType;
    @JsonProperty("EnglishType")
    public String englishType;
    @JsonProperty("CountryID")
    public String countryID;
}

class Country{
    @JsonProperty("ID")
    public String iD;
    @JsonProperty("LocalizedName")
    public String localizedName;
    @JsonProperty("EnglishName")
    public String englishName;
}

class Elevation{
    @JsonProperty("Metric")
    public Metric metric;
    @JsonProperty("Imperial")
    public Imperial imperial;
}

class GeoPosition{
    @JsonProperty("Latitude")
    public double latitude;
    @JsonProperty("Longitude")
    public double longitude;
    @JsonProperty("Elevation")
    public Elevation elevation;
}

class Imperial{
    @JsonProperty("Value")
    public int value;
    @JsonProperty("Unit")
    public String unit;
    @JsonProperty("UnitType")
    public int unitType;
}

class Metric{
    @JsonProperty("Value")
    public int value;
    @JsonProperty("Unit")
    public String unit;
    @JsonProperty("UnitType")
    public int unitType;
}

class Region{
    @JsonProperty("ID")
    public String iD;
    @JsonProperty("LocalizedName")
    public String localizedName;
    @JsonProperty("EnglishName")
    public String englishName;
}

class SupplementalAdminArea{
    @JsonProperty("Level")
    public int level;
    @JsonProperty("LocalizedName")
    public String localizedName;
    @JsonProperty("EnglishName")
    public String englishName;
}

class TimeZone{
    @JsonProperty("Code")
    public String code;
    @JsonProperty("Name")
    public String name;
    @JsonProperty("GmtOffset")
    public double gmtOffset;
    @JsonProperty("IsDaylightSaving")
    public boolean isDaylightSaving;
    @JsonProperty("NextOffsetChange")
    public Date nextOffsetChange;
}
