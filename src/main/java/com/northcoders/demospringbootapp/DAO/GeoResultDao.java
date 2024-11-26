package com.northcoders.demospringbootapp.DAO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record GeoResultDao(

        List<CityDao> results
) {
}
