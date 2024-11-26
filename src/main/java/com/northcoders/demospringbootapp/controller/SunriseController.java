package com.northcoders.demospringbootapp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.SunriseTimes;
import org.apache.catalina.loader.WebappClassLoader;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/sunrise")
public class SunriseController {

    private static final String BASE_URL = "https://api.sunrisesunset.io";
    private static WebClient webClient = WebClient.builder().baseUrl(BASE_URL).build();
    private static ObjectMapper sunriseMapper = new ObjectMapper();

    @GetMapping("/info")
    @ResponseBody
    public List<SunriseTimes> getSunriseTimes(@RequestParam(name = "latitude") double latitude, @RequestParam(name = "longitude") double longitude) {
        List<SunriseTimes> sunriseInfo = new ArrayList<>();

        System.out.println(latitude);
        System.out.println(longitude);

        String sunriseInfoStr = webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/json")
                        .queryParam("lat", latitude)
                        .queryParam("lng", longitude)
                        .build()
                )
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        System.out.println(sunriseInfoStr);

        return null;
    }
}

