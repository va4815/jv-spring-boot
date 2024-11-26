package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record City(
    int id,
    String name,
    double latitude,
    double longitude,
    String country
) {
}
