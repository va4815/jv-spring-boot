package com.northcoders.demospringbootapp.DAO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CityDao(long id, String name, double latitude, double longitude, String country) {
}
