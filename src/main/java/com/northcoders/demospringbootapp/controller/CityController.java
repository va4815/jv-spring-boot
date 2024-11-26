package com.northcoders.demospringbootapp.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.northcoders.demospringbootapp.DAO.CityDao;
import com.northcoders.demospringbootapp.DAO.GeoResultDao;
import model.City;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/city")
public class CityController {

    private static final String BASE_URL = "https://geocoding-api.open-meteo.com";
    private static WebClient webClient = WebClient.builder().baseUrl(BASE_URL).build();
    private static ObjectMapper mapper = new ObjectMapper();

    @GetMapping("/info")
    @ResponseBody
    public List<City> getCityInfo(@RequestParam(name = "name") String name, @RequestParam(name = "count") Integer count) {
        List<City> cityList = new ArrayList<>();

        // receive the city name & count from the user
        System.out.println(name);
        System.out.println(count);

        // use WebClient to get info from GeoLocation
        String cityInfoStr = webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/v1/search")
                        .queryParam("name", name)
                        .queryParam("count", count)
                        .queryParam("language", "en")
                        .queryParam("format", "json")
                        .build()
                )
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        System.out.println(cityInfoStr);

        try {
            // convert the WebClient string to CityDao
            GeoResultDao resultDao = mapper.readValue(cityInfoStr, GeoResultDao.class);
            System.out.println(resultDao);

            // convert the CityDao to our City model
            for (CityDao dao : resultDao.results()) {
                City city = new City(dao);
                cityList.add(city);
            }

        } catch (JsonProcessingException e) {
            System.err.println(e);
        }

        // return back to the client
        return cityList;
    }

}
