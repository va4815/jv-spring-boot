package com.northcoders.demospringbootapp.controller;

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

    @GetMapping("/info")
    @ResponseBody
    public List<City> getCityInfo(@RequestParam(name = "name") String name, @RequestParam(name = "count") Integer count) {

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

        // convert the WebClient objects to our City model

        // return back to the client

        return new ArrayList<>();
    }

}
